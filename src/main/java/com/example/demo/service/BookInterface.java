package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

/**
 * @author ankit 
 */

public interface BookInterface {
	
	List<Book> getAllBooks();
	Book getBookByName(String name);
	void saveBook(Book book);
	boolean deleteBookByName(String bookName);
	boolean deleteBookById(int id);
	String updateBookByName(String name, Book book);
}
