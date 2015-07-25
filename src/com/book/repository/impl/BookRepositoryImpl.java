package com.book.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import com.book.dbconnection.DBConnectionFactory;
import com.book.repository.BookRepository;
import com.book.service.impl.BookServiceImp;
import com.book.vo.BookVo;

public class BookRepositoryImpl implements BookRepository {
	Connection con;

	BookServiceImp xl;
	ArrayList<BookVo> b;
	ListIterator<BookVo> list;

	{
		try {
			con = DBConnectionFactory.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertBookRecord(ArrayList<BookVo> bookList) {
		PreparedStatement ps = null;
		PreparedStatement insertBookDiscription = null;
		Statement st = null;
		ResultSet rs = null;

		String sql = "insert into BOOK(MEDIA_NUMBER, CREATED_BY, CREATED_DATE, ACTIVE) VALUES(?,?,?,?)";

		String sql2 = "insert into BOOK_DESCRIPTION (BOOK_ID, LANGUAGE_ID, BOOK_DESCRIPTION, AUTHOR_NAME, PUBLICATION,CATEGORY_ID,"
				+ "CREATED_BY, CREATED_DATE, ACTIVE, BOOK_NAME) values (?,?,?,?,?,?,?,?,?,?)";

		String sql3 = "insert into BOOK_MEDIA(BOOK_ID, MEDIA_ID,ACTIVE,CREATED_BY, CREATED_DATE) SELECT b.BOOK_ID,m.MEDIA_ID,M.ACTIVE,B.CREATED_BY, B.CREATED_DATE from  dbo.MEDIA m INNER JOIN dbo.BOOK b ON  m.MEDIA_NAME like b.MEDIA_NUMBER+'%'	LEFT JOIN BOOK_MEDIA BM ON b.BOOK_ID=BM.BOOK_ID WHERE BM.MEDIA_ID IS NULL;";

		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			insertBookDiscription = con.prepareStatement(sql2);
			st = con.createStatement();

			// set auto commit false
			con.setAutoCommit(false);

			ListIterator<BookVo> list = bookList.listIterator();
			java.sql.Timestamp timestamp = getCurrentJavaSqlTimestamp();
			while (list.hasNext()) {
				BookVo bookObj = list.next();

				// setting sql1
				ps.setInt(1, bookObj.getBookNumber());
				ps.setInt(2, 1);
				ps.setTimestamp(3, timestamp);
				ps.setInt(4, 1);

				// exexute
				ps.executeUpdate();

				// getting generated key from table book
				rs = ps.getGeneratedKeys();
				if (rs != null && rs.next()) {

					insertBookDiscription.setInt(1, rs.getInt(1));
				}
				insertBookDiscription.setInt(2, 1);
				insertBookDiscription.setString(3, bookObj.getDescription());
				insertBookDiscription.setString(4, bookObj.getAuther());
				insertBookDiscription.setString(5, bookObj.getPublisher());
				insertBookDiscription.setInt(6, 40);
				insertBookDiscription.setInt(7, 1);
				insertBookDiscription.setTimestamp(8, timestamp);
				insertBookDiscription.setInt(9, 1);
				insertBookDiscription.setString(10, bookObj.getTitle());

				insertBookDiscription.executeUpdate();

				// insertBookDiscription.setInt(2, );

			}

			st.executeUpdate(sql3);
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					DBConnectionFactory.closeConnection();
				}

			} catch (Exception e) {
			}
		}

	}

	public static java.sql.Timestamp getCurrentJavaSqlTimestamp() {
		java.util.Date date = new java.util.Date();
		return new java.sql.Timestamp(date.getTime());
	}

}
