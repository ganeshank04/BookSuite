package com.book.unit.test;

import java.io.IOException;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.factory.producer.FactoryProducer;
import com.book.service.BookSevice;

public class BookDBController {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		BookRepositoryImpl enq= new BookRepositoryImpl();
		enq.setCategory();*/
		
		ServiceAbstractFactory abstFact = FactoryProducer.getServiceFactory("BookService");
		BookSevice bookService = abstFact.getBookService();
		try {
			bookService.readBookDetails("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
