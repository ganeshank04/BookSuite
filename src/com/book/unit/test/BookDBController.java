package com.book.unit.test;

import java.io.IOException;
import java.util.ArrayList;

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enq.insertBookRecord(bookList);
	}

}
