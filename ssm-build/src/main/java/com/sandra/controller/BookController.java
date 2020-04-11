package com.sandra.controller;

import java.util.ArrayList;
import java.util.List;

import com.sandra.pojo.Books;
import com.sandra.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 */
@Controller
@RequestMapping("/book")  //大的映射方便之后功能的扩展
public class BookController {

    /**
     * Controller层调Service层
     */
    @Autowired
    @Qualifier("bookServiceImpl")  //和Spring配置中的bean id一致
    private BookService bookService;

    /**
     * 查询全部书籍，并返回到一个书籍展示页面
     * @return
     */
    @RequestMapping("/allBook")
    public String list(Model model) {

        List<Books> books = bookService.queryAllBooks();

        model.addAttribute("list", books);

        return "allBook";
    }

    /**
     * 跳转到增加书籍页面
     * @return
     */
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    /**
     * 添加书籍
     * @param books
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(Books books) {

        System.out.println("addBook=>"+books);
        bookService.addBook(books);

        //重定向到allBook请求
        return "redirect:/book/allBook";
    }

    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id, Model model) {

        Books books = bookService.queryBookById(id);

        model.addAttribute("QBook", books);

        return "updateBook";
    }

    /**
     * 修改书籍；需要执行事务（Service层处理事务，增加aop横切）
     * @param books
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Books books){

        System.out.println("updateBook=>"+books);

        bookService.updateBook(books);

        //redirect重定向会重新查一遍数据库
        return "redirect:/book/allBook";
    }


    /**
     * 删除书籍；RESTFul风格
     * @param id
     * @return
     */
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    /**
     * 查询指定书籍
     * @param queryBookName
     * @return
     */
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = bookService.queryBookByName(queryBookName);

        System.err.println("queryBook==>"+books);

        List<Books> list = new ArrayList<Books>();
        list.add(books);

        //如果查询书籍为空，就返回全部数据，并返回给前端提示消息
        if (books == null) {
            list = bookService.queryAllBooks();
            model.addAttribute("error", "未查到");
        }

        model.addAttribute("list", list);
        return "allBook";
    }
}
