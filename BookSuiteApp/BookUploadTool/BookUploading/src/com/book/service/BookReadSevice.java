package com.book.service;

import java.util.ArrayList;

import com.book.vo.BookVo;

public interface BookReadSevice {
	public void setBookInfo(String title, String auther, String publisher,
			String category, String Description, String keyWord);

	public ArrayList<BookVo> getBookInfo();

}
