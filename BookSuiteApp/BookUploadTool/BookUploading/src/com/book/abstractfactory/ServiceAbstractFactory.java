package com.book.abstractfactory;

import com.book.service.BookSevice;

public abstract class ServiceAbstractFactory {
	public abstract BookSevice getBookService();
}
