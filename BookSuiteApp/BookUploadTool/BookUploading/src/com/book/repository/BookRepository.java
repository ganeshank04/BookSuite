package com.book.repository;

import java.util.ArrayList;

import com.book.vo.BookVo;

public interface BookRepository {

	// public void setBookDetail();
	// public void setLangauges();
	public void insertBookRecord(ArrayList<BookVo> bookList);

}
