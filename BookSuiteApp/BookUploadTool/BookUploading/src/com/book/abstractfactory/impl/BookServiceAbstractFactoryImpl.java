package com.book.abstractfactory.impl;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.service.BookSevice;
import com.book.service.CopyFileService;
import com.book.service.FolderService;
import com.book.service.impl.BookServiceImp;

public class BookServiceAbstractFactoryImpl extends ServiceAbstractFactory {
	@Override
	public BookSevice getBookService() {
		return new BookServiceImp();
	}

	@Override
	public FolderService getFolderService() {
		return null;
	}

	@Override
	public CopyFileService getCopyFileService() {
		// TODO Auto-generated method stub
		return null;
	}
}
