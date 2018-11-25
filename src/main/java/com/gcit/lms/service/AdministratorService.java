package com.gcit.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

public class AdministratorService {
	
	@Autowired
	AuthorDAO aDAO;
	
	@Autowired
	BookDAO bDAO;
	
	@Transactional
	public void createAuthor(Author author) throws ClassNotFoundException, SQLException{
		aDAO.addAuthor(author);
	}
	
	@Transactional
	public Integer createAuthorWithID(Author author) throws ClassNotFoundException, SQLException{
		Integer authorId = null;
		//authorId = aDAO.addAuthorWithID(author);
		return authorId;
	}
	
	public List<Author> getAllAuthors(int pageNo) throws ClassNotFoundException, SQLException{
			List<Author> authors = aDAO.readAllAuthors(pageNo);
			for(Author a: authors){
				//bDAO.readBooksByID()
			}
		return null;
	}
	
	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException{
			return bDAO.readAllBooks();
	}

	public Author getAuthorByID(Integer authorId) throws ClassNotFoundException, SQLException {
		return aDAO.readAuthorsByID(authorId);
	}

	@Transactional
	public void deleteAuthor(Integer authorId) throws ClassNotFoundException, SQLException {
			aDAO.deleteAuthor(authorId);
	}
	
//	public Integer getAuthorCount() throws ClassNotFoundException, SQLException{
//			return aDAO.getCount();
//	}
	
	public List<Author> getAllAuthorsByName(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException{
			return aDAO.readAuthorsByName(searchString, pageNo);
	}
}
