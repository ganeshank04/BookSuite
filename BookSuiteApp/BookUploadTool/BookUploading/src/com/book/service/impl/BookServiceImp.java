package com.book.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Properties;

import com.book.service.BookReadSevice;
import com.book.vo.BookVo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BookServiceImp implements BookReadSevice {

	// for input file name
	private String inputFile;

	private ArrayList<BookVo> bookList = new ArrayList<BookVo>();

	public void setInputFile(String inputFile) {
		try {

			FileInputStream file = new FileInputStream(inputFile);
			Properties prop = new Properties();
			prop.load(file);
			file.close();
			this.inputFile = prop.getProperty("src");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// reading excel

	public void read() throws IOException {

		String auther = null;
		String description = null;
		String publisher = null;
		String category = null;
		String keyWord = null;
		String title = null;

		File inputWorkbook = new File(inputFile);
		Workbook w; // from jxlapi
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			// get the firts sheet
			Sheet sheet = w.getSheet(0);

			// loop for firt 5 column and lines
			int columns = sheet.getColumns();
			int rows = sheet.getRows();
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					Cell cell = sheet.getCell(j, i);
					if (j == 0)
						title = cell.getContents();
					else if (j == 1)
						auther = cell.getContents();
					else if (j == 2)
						publisher = cell.getContents();
					else if (j == 3)
						category = cell.getContents();
					else if (j == 4)
						description = cell.getContents();
					else if (j == 5)
						keyWord = cell.getContents();
				}
				setBookInfo(title, auther, publisher, category, description,
						keyWord);
			}

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setBookInfo(String title, String auther, String publisher,
			String category, String Description, String keyWord) {
		BookVo b = new BookVo();
		b.title = title;
		b.auther = auther;
		b.publisher = publisher;
		b.category = category;
		b.Description = Description;
		b.keyWord = keyWord;
		bookList.add(b);

	}

	@Override
	public ArrayList<BookVo> getBookInfo() {
		// TODO Auto-generated method stub
		return bookList;
	}

	public void display(ArrayList<BookVo> b) {
		System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s\n", "Book Name",
				" Auther", " Publisher", "" + " category", " Description",
				" KeyWord");
		// ArrayList<Book> b= test.getBookInfo();
		ListIterator<BookVo> litr = b.listIterator();

		while (litr.hasNext()) {
			BookVo book = litr.next();
			System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s\n",
					book.getTitle(), book.getAuther(), book.getPublisher(),
					book.getCategory(), book.getDescription(),
					book.getKeyWord());

		}
	}
}
