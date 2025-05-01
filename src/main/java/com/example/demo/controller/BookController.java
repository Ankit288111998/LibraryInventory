package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.serviceImpl.BookServiceImpl;

/**
 * @author ankit 
 */

@RestController
public class BookController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@PostMapping("/books")
	public String saveBook(@RequestBody Book book) {

		bookServiceImpl.saveBook(book);
		return "Book saved";

	}
	
	@GetMapping("/books")
	public List<Book> getAllBook() {
		
		return bookServiceImpl.getAllBooks();
	}
	
	@GetMapping("/book/byname")
	public Book getBookByName(String name) {
		
		return bookServiceImpl.getBookByName(name);
	}
	
	@PutMapping("/updatebook/byname")
	public String updateBookByName(@RequestParam String name, @RequestBody Book book) {
		return bookServiceImpl.updateBookByName(name, book);
	}
	
	@DeleteMapping("/book/byname")
	public boolean deleteBookByName(String bookName) {
		return bookServiceImpl.deleteBookByName(bookName);
	}
	
	@DeleteMapping("/book/byid")
	public boolean deleteBookById(int id) {
		return bookServiceImpl.deleteBookById(id);
	}
}
