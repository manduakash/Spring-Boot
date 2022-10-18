package com.springdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdb.dao.BookDAO;
import com.springdb.daoimpl.BookDaoImpl;
import com.springdb.entity.Book;

public class App 
{
    public static void main( String[] args )
    {
ApplicationContext c = new ClassPathXmlApplicationContext("spring-configuration.xml");
    	
    	Book b1 = new Book();
    	b1.setBname("Java");
    	b1.setBauthor("James Gosling");
    	b1.setBtype("Technical");
    	b1.setBprice(700);
    	
    	Book b2 = new Book();
    	b2.setBname("Secret");
    	b2.setBauthor("Rhonda Byrne");
    	b2.setBtype("Self-Help");
    	b2.setBprice(500);
    	
    	Book b3 = new Book();
    	b3.setBname("Rich Dad Poor Dad");
    	b3.setBauthor("Robert Kiyosaki");
    	b3.setBtype("Finance");
    	b3.setBprice(600);
    	
    	BookDAO dao = new BookDaoImpl();
    	dao.add(b1);
    	dao.add(b2);
    	dao.add(b3);
    }
}
