package com.cy.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cy.example.entity.FileEntity;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileMapper extends SuperMapper<FileEntity> {

}
