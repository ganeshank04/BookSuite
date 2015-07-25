package com.book.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.book.service.CopyFileService;

public class CopyFileServiceImpl implements CopyFileService{

	@Override
	public void CopyFiles(File source, File dest) throws IOException {
		// TODO Auto-generated method stub
		Files.copy(source.toPath(), dest.toPath());
	}
}


