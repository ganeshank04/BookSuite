package com.book.abstractfactory.impl;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.service.BookSevice;
import com.book.service.CopyFileService;
import com.book.service.FolderService;
import com.book.service.impl.FolderServiceImpl;

public class FolderServiceAbstractFactoryImpl extends ServiceAbstractFactory {

	@Override
	public BookSevice getBookService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FolderService getFolderService() {
		return new FolderServiceImpl();
	}

	@Override
	public CopyFileService getCopyFileService() {
		// TODO Auto-generated method stub
		return null;
	}
  
}
