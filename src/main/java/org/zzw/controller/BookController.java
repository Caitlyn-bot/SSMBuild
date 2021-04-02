package org.zzw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzw.domain.Books;
import org.zzw.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    //查询全部的书籍，并且返回到书籍的展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    //跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>" + books);
        int i = bookService.addBook(books);
        if (i > 0){
            System.out.println("添加成功");
        }
        return "redirect:/book/allBook";//重定向到我们的allBook.jsp
    }
    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("uBook",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>" + books);
        int i = bookService.updateBook(books);
        if (i > 0){
            System.out.println("修改成功");
        }
        return "redirect:/book/allBook";
    }
    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        System.out.println("deleteBook=>" + id);
        int i = bookService.deleteBookById(id);
        if (i > 0){
            System.out.println("删除成功");
        }
        return "redirect:/book/allBook";
    }

}
