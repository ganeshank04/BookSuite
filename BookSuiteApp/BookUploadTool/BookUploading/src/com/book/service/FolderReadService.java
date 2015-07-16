package com.book.service;

import java.io.File;
import java.util.ArrayList;

public class FolderReadService {
	public ArrayList<String> getMedia() {

		File folder = new File("E:/Media");
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
