package com.ylf.spring.dao.mapper;

import com.ylf.spring.pojo.Books;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @date 2021/1/27 11:20
 */
@Mapper
public interface BookMapper {

    /**
     * 查询全部的书
     * @return :  返回查询的数值
     */
    List<Books> selectAllBooks();

    /**
     * 插入一本书
     * @param book:插入书籍的数据
     */
    void insertBook(Books book);

    /**
     * 删除一本书
     * @param bookName:删除书籍的名字
     */
    @Delete("delete from tb_book where bookName=#{bookName}")
    void deleteBookByName(String bookName);

    /**
     * 更新一本书
     * @param book :  返回查询的数值
     */
    void updateBook(Books book);

    /**
     * 查询一本书
     * @return :  返回查询的数值
     * @param bookId :书的ID
     */
    @Select("select * from tb_book where bookId=#{bookId}")
    Books selectBookById(int bookId);

    /**
     * 书名模糊查询一本书
     * @return :  返回查询的数值
     * @param bookName :书的名字
     */
    Books selectBookByNameVague(String bookName);
}
