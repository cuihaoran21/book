package com.cuihaoran.controller;

import com.cuihaoran.pojo.Books;
import com.cuihaoran.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chr
 * @create 2021-12-07-9:01
 */

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";

    }

    @RequestMapping("/toAddBook")
    public String totAddBook(){
        return "addBook";

    }

    @RequestMapping("addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";

    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id ,Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "updateBook";

    }


    @RequestMapping("updateBook")
    public String updateBook(Books book ,Model model){
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }


    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}
