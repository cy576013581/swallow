package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.cy.example.carrier.PageCar;
import com.cy.example.entity.FileEntity;
import com.cy.example.entity.UserEntity;

@Mapper
public interface FileMapper {

	public int add(FileEntity file);
	
	public int delete(Long id);
	
	public FileEntity download(Long id);
	
}
