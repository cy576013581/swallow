package com.cy.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.entity.FileEntity;
import com.cy.example.mapper.FileMapper;
import com.cy.example.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileMapper fileMapper;

	public int add(FileEntity file) {
		// TODO Auto-generated method stub
		return fileMapper.add(file);
	}

	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FileEntity download(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
