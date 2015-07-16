package com.book.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

import com.book.dbconnection.DBConnectionFactory;
import com.book.repository.BookRepository;
import com.book.service.impl.BookServiceImp;
import com.book.vo.BookVo;

public class BookRepositoryImpl implements BookRepository {
	Connection con;
	Statement st;
	BookServiceImp xl;
	ArrayList<BookVo> b;
	ListIterator<BookVo> list;

	{
		try {
			Connection con = DBConnectionFactory.getConnection();
			st = con.createStatement();
			xl = new BookServiceImp();
			// xl.setInputFile("");
			//xl.setInputFile("src/bookexcel.properties");
			xl.read("src/com/book/properties/bookexcel.properties");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void setCategory() {
		// TODO Auto-generated method stub
		ArrayList<BookVo> b = xl.getBookInfo();
		ListIterator<BookVo> list = b.listIterator();
		while (list.hasNext()) {
			BookVo book = list.next();
			String sql = "insert into Category values(myBookSequence.nextval, '"
					+ book.getCategory() + "')";
			try {
				st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
