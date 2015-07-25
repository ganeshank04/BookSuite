package com.book.abstractfactory;

import com.book.service.BookSevice;
import com.book.service.CopyFileService;
import com.book.service.FolderService;

public abstract class ServiceAbstractFactory {
	public abstract BookSevice getBookService();
	public abstract FolderService getFolderService();
	public abstract CopyFileService getCopyFileService();
}
