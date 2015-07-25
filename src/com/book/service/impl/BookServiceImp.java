package com.book.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.book.reader.PropertyReader;
import com.book.service.BookSevice;
import com.book.vo.BookVo;

public class BookServiceImp implements BookSevice {

	// for input file name
	private String inputFile;

	private ArrayList<BookVo> bookList = new ArrayList<BookVo>();

	// reading excel
	@Override
	public ArrayList<BookVo> readBookDetails(String inputFile)
			throws IOException {
		String auther = null;
		String description = null;
		String publisher = null;
		String category = null;
		Integer keyWord = null;
		String title = null;
		Boolean checkvalidity = true;
		Properties prop = PropertyReader.getPropertyInstance(inputFile);
		this.inputFile = prop.getProperty("book.excel.path");

		FileInputStream inputWorkbook = new FileInputStream(this.inputFile);
		Workbook w; // from jxlapi
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			// get the firts sheet
			Sheet sheet = w.getSheet(0);

			// loop for firt 5 column and lines

			int totalRows = sheet.getRows();
			int totalColmns = sheet.getColumns();
			
			if (totalColmns < 6 && totalRows <= 0) {
				checkvalidity = false;

			} else {

				for (int i = 1; (i < totalRows && checkvalidity); i++) {
					int j = 0;
					while (j < totalColmns && checkvalidity) {
						Cell cell = sheet.getCell(j, i);
						    
						if (j == 0) {
							title = cell.getContents();
							    if (title.trim().isEmpty())
								     checkvalidity = false;
						} else if (j == 1) {
							auther = cell.getContents();
							if (auther.trim().isEmpty())
								checkvalidity = false;
						} else if (j == 2) {
							publisher = cell.getContents();
							if (publisher.trim().isEmpty())
								checkvalidity = false;
						} else if (j == 3) {
							category = cell.getContents();
							if (category.trim().isEmpty())
								checkvalidity = false;
						} else if (j == 4) {
							description = cell.getContents();
							if (description.trim().isEmpty())
								checkvalidity = false;
						} else if (j == 5) {
							String nm= cell.getContents();
							if (nm.trim().isEmpty())
								checkvalidity = false;
							else
								keyWord = Integer.parseInt(nm);
							
							
						}
						j++;
					}

						if (checkvalidity == true)
							setBookInfo(title, auther, publisher, category,
									description, keyWord);

					}
				}
			

		} catch (BiffException e) {
			e.printStackTrace();
		}
    if(checkvalidity == true)
		return bookList;
    else
    	return null;
	}

	private void setBookInfo(String title, String auther, String publisher,
			String category, String Description, Integer keyWord) {
		BookVo b = new BookVo();
		b.title = title;
		b.auther = auther;
		b.publisher = publisher;
		b.category = category;
		b.Description = Description;
		b.bookNumber = keyWord;
		bookList.add(b);

	}
}
