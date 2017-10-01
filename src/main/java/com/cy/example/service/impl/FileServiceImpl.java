package com.cy.example.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.entity.FileEntity;
import com.cy.example.mapper.FileMapper;
import com.cy.example.service.IFileService;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileEntity>
	implements IFileService{

}
