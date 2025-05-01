package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * @author ankit 
 */

@Entity
@Table(name = "books")
public class Book {
	@NotEmpty(message = "Book name cannot be null")
	private String bookName;
	@Id
	@NotNull(message = "Book id cannot be null")
	private int bookId;
	@NotEmpty(message = "Book title cannot be null")
	private String title;
	@NotEmpty(message = "Author name can not be null")
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
