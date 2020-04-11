package com.sandra.service;

import java.util.List;

import com.sandra.pojo.Books;
import org.apache.ibatis.annotations.Param;

/**
 * 业务层
 */
public interface BookService {

    /**
     * 增加一本书
     * @param books
     * @return
     */
    int addBook(Books books);

    /**
     * 删除一本书
     * @param id
     * @return
     */
    int deleteBookById(@Param("bookId") int id);

    /**
     * 修改一本书
     * @param books
     * @return
     */
    int updateBook(Books books);

    /**
     * 根据id查询一本书
     * @param id
     * @return
     */
    Books queryBookById(@Param("bookId") int id);

    /**
     * 查询全部的图书
     * @return
     */
    List<Books> queryAllBooks();

    /**
     * 根据名称查询书籍
     * @return
     */
    Books queryBookByName(@Param("bookName") String bookName);
}
