package com.ylf.spring.dao;

import com.ylf.spring.dao.mapper.BookMapper;
import com.ylf.spring.pojo.Books;
import com.ylf.spring.util.MyBatisUtil;
import com.ylf.spring.util.MyFunctions;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @date 2021/1/27 10:27
 */
@MapperScan({"com.ylf.spring.dao.mapper.BookMapper"})
public class SelectTest {
    static SqlSession sqlSession = MyBatisUtil.getSqlSession();

    private  static BookMapper bookMapper;

    public static void main(String[] args) {
        Reader reader = null;
        Books books = new Books(0,"pig",213,"for three pig");
        BookMapper mapper =  sqlSession.getMapper(BookMapper.class);
        Books selectBook = mapper.selectBookById(1);
        sqlSession.commit();
        sqlSession.close();
    }
}
