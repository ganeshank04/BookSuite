package com.book.abstractfactory.impl;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.service.BookSevice;
import com.book.service.CopyFileService;
import com.book.service.FolderService;
import com.book.service.impl.CopyFileServiceImpl;

public class CopyFileServiceAbtsractFactoryImpl extends ServiceAbstractFactory {
    public CopyFileService getCopyFileService()
    {
    	return new CopyFileServiceImpl();
    }

	@Override
	public BookSevice getBookService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FolderService getFolderService() {
		// TODO Auto-generated method stub
		return null;
	}
}
