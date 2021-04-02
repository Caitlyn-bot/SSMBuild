package org.zzw.dao;

import org.apache.ibatis.annotations.Param;
import org.zzw.domain.Books;

import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(@Param("bookId") int id);
    //修改一本书
    int updateBook(Books books);
    //根据id查询一本书
    Books queryBookById(int id);
    //查询全部的书
    List<Books> queryAllBook();
}
