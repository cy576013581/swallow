package com.cy.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cy.example.entity.FileEntity;

@Mapper
public interface FileMapper {

	public int add(FileEntity file);

	public int delete(Long id);

	public FileEntity download(Long id);

}
