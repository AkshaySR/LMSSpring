package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Publisher;

public class BookDAO extends BaseDAO implements ResultSetExtractor<List<Book>>{
	
	public void addBookWithID(Book book) {
		final String title = book.getTitle();
		final String INSERT_SQL = "insert into tbl_book (title, pubId) values (?, ?) ";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, title);
				ps.setInt(2, 2);
				return ps;
			}
		}, keyHolder);
		int bookId = keyHolder.getKey().intValue();
		for(Author a: book.getAuthors()){
			//insert into book_authors table
		}
	}
	
	public void addBook(Book book) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_book (title, publisherId) values (?, ?)", new Object[] {book.getTitle(), book.getPublisher().getPublisherId()});
	}

	public List<Book> readAllBooks() throws ClassNotFoundException, SQLException{
		return (List<Book>) template.query("select * from tbl_book", this);
	}
	
	public List<Book> readBooksByID() throws ClassNotFoundException, SQLException{
		return (List<Book>) template.query("select * from tbl_book", this);
	}
	
	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			Publisher p = new Publisher();
			p.setPublisherId(rs.getInt("pubId"));
			b.setPublisher(p);
			books.add(b);
		}
		return books;
	}
}
