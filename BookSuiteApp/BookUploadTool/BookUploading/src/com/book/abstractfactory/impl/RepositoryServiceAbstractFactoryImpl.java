package com.book.abstractfactory.impl;

import com.book.abstractfactory.RepositoryAbstractFactory;
import com.book.repository.FolderRepository;
import com.book.repository.impl.FolderRepositoryImpl;

public abstract class RepositoryServiceAbstractFactoryImpl extends RepositoryAbstractFactory{

	@Override
	public FolderRepository getinsertIntoMedia()
	{
		return new FolderRepositoryImpl() ;
		
	}
	

}