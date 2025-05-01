package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.service.BookInterface;

/**
 * @author ankit 
 */

@Service
public class BookServiceImpl implements BookInterface {

	List<Book> list = new ArrayList<>();

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBook = new ArrayList<>();
		for (Book book : list) {
			allBook.add(book);
		}
		return allBook;
	}

	@Override
	public Book getBookByName(String name) {
		
		//Using java8 stream & lambda features
		//we can use below commented code also
		return list.stream().filter(book -> book != null && book.getBookName().equals(name))
				.findFirst()
	            .orElseThrow(() -> new BookNotFoundException("Book not found with name: " + name));
		
//		for (Book book : list) {
//			if (book != null && book.getBookName().equals(name)) {
//				return book;
//			}
//		}
		//return null;
	}

	@Override
	public void saveBook(Book book) {
		list.add(book);

	}

	@Override
	public boolean deleteBookByName(String bookName) {
		for (Book book : list) {
			if (book.getBookName().equals(bookName)) {
				list.remove(book);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteBookById(int id) {

		for (Book book : list) {
			if (book.getBookId() == id) {
				list.remove(book);
				return true;
			}
		}

		return false;
	}

	@Override
	public String updateBookByName(String name, Book book) {
		for (Book book1 : list) {
			if (book1 != null && book1.getBookName().equals(name)) {
				book1.setAuthor(book.getAuthor());
				book1.setTitle(book.getTitle());
				return "Book Updated";
			}
		}
		return "Book doesn't exist";
	}

}
