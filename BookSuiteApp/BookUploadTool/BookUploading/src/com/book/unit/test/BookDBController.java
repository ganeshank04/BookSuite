package com.book.unit.test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ListIterator;

import com.book.abstractfactory.ServiceAbstractFactory;
import com.book.dbconnection.DBConnectionFactory;
import com.book.factory.producer.FactoryProducer;
import com.book.repository.impl.FolderRepositoryImpl;
import com.book.service.BookSevice;
import com.book.service.impl.CopyFileServiceImpl;
import com.book.service.impl.FolderServiceImpl;

public class BookDBController {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		BookRepositoryImpl enq= new BookRepositoryImpl();
		enq.setCategory();*/
		
		/*ServiceAbstractFactory abstFact = FactoryProducer.getServiceFactory("BookService");
		BookSevice bookService = abstFact.getBookService();
		try {
			bookService.readBookDetails("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		
	/*	FolderServiceImpl obj = new FolderServiceImpl();
		ArrayList<String> list = obj.getMedia();
		ListIterator li = list.listIterator();
		while(li.hasNext()){
			String s= (String)li.next();
			System.out.println("Media Name : "+ ""+s);
		} */
		
		
		/*try {
			Connection con = DBConnectionFactory.getConnection();
			System.out.println(con.getCatalog());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */
                     
	/*	ArrayList<String> medialist = new ArrayList<>();
		medialist.add("abc_1.jpg");
		medialist.add("abc_2.jpg");
		FolderRepositoryImpl obj  = new FolderRepositoryImpl();
		obj.insertIntoMedia(medialist);
*/
		
		/*CopyFileServiceImpl c=new CopyFileServiceImpl();
	       File source = new File("C:\\Users\\SUJIT-123\\Desktop\\GitHub_Url.txt");

	        File dest = new File("F:\\Destination\\GitHub_Url.txt");
	        try {
				c.CopyFiles(source, dest);
				System.out.println("File Copied to the Destination");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/
		
		   
	
	}
}