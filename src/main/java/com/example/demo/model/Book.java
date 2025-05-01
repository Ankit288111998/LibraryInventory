package com.example.demo.model;

import jakarta.persistence.Entity;

/**
 * @author ankit 
 */

//@Entity -> use this annotation when works with database/jpa/crud repository
public class Book {
	private String bookName;
	private int bookId;
	private String title;
	private String author;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
