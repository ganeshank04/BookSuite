package com.book.service.impl;
//import package com.book.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import com.book.reader.PropertyReader;
import com.book.service.FolderService;

public class FolderServiceImpl implements FolderService {
	public ArrayList<String> getMedia() {

	
		Properties prop= PropertyReader.getPropertyInstance("src/com/book/properties/bookexcel.properties");
		File folder = new File(prop.getProperty("folder.media.path"));
		File[] listOfFiles = folder.listFiles();

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile())

			{
				list.add(listOfFiles[i].getName());

			}
		}
		return (list);
	}
}
      

