package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controller.BookController;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.GlobalExceptionHandler;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookInterface;

import jakarta.transaction.Transactional;

/**
 * @author ankit 
 */

@Service
public class BookServiceImpl implements BookInterface {

    private final GlobalExceptionHandler globalExceptionHandler;

	
	@Autowired
	private BookRepository bookRepository;

    BookServiceImpl(GlobalExceptionHandler globalExceptionHandler) {
        this.globalExceptionHandler = globalExceptionHandler;
    }

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookByName(String name) {
		
		return bookRepository.findByBookName(name);
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);

	}

	@Override
	@Transactional
	public boolean deleteBookByName(String bookName) {
		if (bookRepository.findByBookName(bookName)!=null) {
	        bookRepository.deleteByBookName(bookName);
	        return true;
	    } else {
	        return false;  // No book found to delete
	    }
	}

	@Override
	@Transactional
	public void deleteBookById(int id) {
		
		bookRepository.deleteByBookId(id);
	}

	@Override
	public Book updateBookByName(String name, Book updatedBook) {
	    Book existingBook = bookRepository.findByBookName(name);
	    if (existingBook == null) {
	        throw new BookNotFoundException("Book not found with name: " + name);
	    }

	    existingBook.setTitle(updatedBook.getTitle());
	    existingBook.setAuthor(updatedBook.getAuthor());
	    // update other fields

	    return bookRepository.save(existingBook);  // saves the updated entity
	}

}
