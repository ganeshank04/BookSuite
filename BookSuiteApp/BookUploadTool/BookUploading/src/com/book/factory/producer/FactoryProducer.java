package com.book.factory.producer;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.abstractfactory.impl.BookServiceAbstractFactoryImpl;
import com.book.abstractfactory.impl.FolderServiceAbstractFactoryImpl;

public class FactoryProducer {
	public static ServiceAbstractFactory getServiceFactory(String implementationClass){
		if(implementationClass.equalsIgnoreCase("BookService")){
	         return new BookServiceAbstractFactoryImpl();
	      }
		else if(implementationClass.equalsIgnoreCase("FolderService")){
			return new FolderServiceAbstractFactoryImpl();
		}
		else{
			return null;
		}
	}
}
