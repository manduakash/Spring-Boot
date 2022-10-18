package com.springdb.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.springdb.dao.BookDAO;
import com.springdb.entity.Book;

public class BookDaoImpl implements BookDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactoy) {
		this.hibernateTemplate=new HibernateTemplate(sessionFactoy);
	}

	@Override
	public void add(Book book) {
		hibernateTemplate.saveOrUpdate(book);
	}

}