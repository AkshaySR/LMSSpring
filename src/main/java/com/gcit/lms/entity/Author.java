package com.gcit.lms.entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Author {
	
	private int authorId;
	private String authorName;
	private List<Book> books;
	
	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Author a = new Author();
		a.setAuthorName("John Doe");
		
		String className = "com.gcit.lms.Author";
		Class c = Class.forName(className);
		Object obj = c.newInstance();
		
		String attrib = "authorName";
		Method setter = c.getMethod("set"+attrib.substring(0,1).toUpperCase()+attrib.substring(1, attrib.length()), String.class);
		setter.invoke(obj, "John Doe");
	}
	
	
}
