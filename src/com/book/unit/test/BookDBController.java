package com.book.unit.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.factory.producer.FactoryProducer;
import com.book.repository.impl.BookRepositoryImpl;
import com.book.service.BookSevice;
import com.book.vo.BookVo;

public class BookDBController {

	public static void main(String[] args) {

		BookRepositoryImpl enq = new BookRepositoryImpl();
		ArrayList<BookVo> bookList = null;

		ServiceAbstractFactory abstFact = FactoryProducer
				.getServiceFactory("BookService");
		BookSevice bookService = abstFact.getBookService();
		try {
			bookList = bookService
					.readBookDetails("src/com/book/properties/bookexcel.properties");
			System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s\n", "Book Name",
					" Auther", " Publisher", "" + " category", " Description",
					" book number");
			// ArrayList<Book> b= test.getBookInfo();
			ListIterator<BookVo> litr = bookList.listIterator();

			while (litr.hasNext()) {
				BookVo book = litr.next();
				System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s\n",
						book.getTitle(), book.getAuther(), book.getPublisher(),
						book.getCategory(), book.getDescription(),
						book.getBookNumber());

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// enq.insertBookRecord(bookList);
	}

}
