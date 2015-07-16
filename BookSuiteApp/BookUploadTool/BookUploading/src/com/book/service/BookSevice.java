package com.book.service;

import java.io.IOException;
import java.util.ArrayList;

import com.book.vo.BookVo;

public interface BookSevice {
	public ArrayList<BookVo> readBookDetails(String inputFile)
			throws IOException;
}
