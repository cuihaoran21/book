package com.cuihaoran.dao;

import com.cuihaoran.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chr
 * @create 2021-12-06-15:43
 */
public interface BookMapper {

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(@Param("bookID") int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(@Param("bookID") int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();
}
