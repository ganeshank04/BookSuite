package com.book.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

import com.book.dbconnection.DBConnectionFactory;
import com.book.repository.FolderRepository;

public class FolderRepositoryImpl implements FolderRepository {

	Connection con;
	PreparedStatement ps;

	@Override
	public void insertIntoMedia(ArrayList<String> medialist) {
		// TODO Auto-generated method stub
		try {

			Connection con;
			PreparedStatement ps;
			con = DBConnectionFactory.getConnection();
			ps = con.prepareStatement("Insert into Media "
					+ "(media_name,web_path,media_type,created_by,created_date,active)"
					+ " values(?,?,?,?,?,?)");
			con.setAutoCommit(false);
			

			Date created_date = new Date(System.currentTimeMillis());
			ListIterator<String> list = medialist.listIterator();
			while (list.hasNext()) {
				String s = list.next();
				ps.setString(1, s);
				ps.setString(2, "Media/" + s);
				ps.setInt(3, 1);
				ps.setInt(4, 1);
				ps.setDate(5, created_date);
				ps.setInt(6, 1);

				ps.addBatch();
			}

			ps.executeBatch();
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
