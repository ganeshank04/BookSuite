package com.book.factory.producer;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.abstractfactory.impl.BookServiceAbstractFactoryImpl;

public class FactoryProducer {
	public static ServiceAbstractFactory getServiceFactory(String implementationClass){
		if(implementationClass.equalsIgnoreCase("BookService")){
	         return new BookServiceAbstractFactoryImpl();
	      }
		else{
			return null;
		}
	}
}
