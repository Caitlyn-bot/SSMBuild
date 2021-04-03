package org.zzw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zzw.domain.Books;
import org.zzw.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    //controller层调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    //查询全部的书籍，并且返回到书籍的展示页面
    @ResponseBody
    @RequestMapping("/allBook")
    public String list(Model model) throws JsonProcessingException {

        List<Books> list = bookService.queryAllBook();
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(list);
        System.out.println(str);
        return str;
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>" + books);
        int i = bookService.addBook(books);
        if (i > 0){
            System.out.println("添加成功");
        }
        return "redirect:/html/allBook.html";//重定向到我们的allBook.html
    }
    //获取要修改的书籍信息
    @ResponseBody
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id) throws JsonProcessingException {
        Books books = bookService.queryBookById(id);
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(books);
        System.out.println(str);
        return str;
    }
    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>" + books);
        int i = bookService.updateBook(books);
        if (i > 0){
            System.out.println("修改成功");
        }
        return "redirect:/html/allBook.html";//重定向到我们的allBook.html
    }
    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        System.out.println("deleteBook=>" + id);
        int i = bookService.deleteBookById(id);
        if (i > 0){
            System.out.println("删除成功");
        }
        return "redirect:/html/allBook.html";//重定向到我们的allBook.html
    }
    //查询书籍
    @ResponseBody
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName) throws JsonProcessingException {
        List<Books> books = bookService.queryBookByName(queryBookName);
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(books);
        System.out.println(str);
        return str;
    }
}
