package com.cy.example.service;

import com.cy.example.entity.FileEntity;

public interface FileService {

	public int add(FileEntity file);
	
	public int delete(Long id);
	
	public FileEntity download(Long id);
}
