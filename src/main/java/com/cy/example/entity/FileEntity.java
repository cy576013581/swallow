package com.cy.example.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("files")
@SuppressWarnings("serial")
public class FileEntity extends SuperEntity<FileEntity> {

	private String c_newFileName;

	private String c_oldFileName;

	private String c_src;

	private String c_fileSize;

	public FileEntity(String c_newFileName, String c_oldFileName, String c_src,
			String c_fileSize) {
		super();
		this.c_newFileName = c_newFileName;
		this.c_oldFileName = c_oldFileName;
		this.c_src = c_src;
		this.c_fileSize = c_fileSize;
	}

	public FileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getC_newFileName() {
		return c_newFileName;
	}

	public void setC_newFileName(String c_newFileName) {
		this.c_newFileName = c_newFileName;
	}

	public String getC_oldFileName() {
		return c_oldFileName;
	}

	public void setC_oldFileName(String c_oldFileName) {
		this.c_oldFileName = c_oldFileName;
	}

	public String getC_src() {
		return c_src;
	}

	public void setC_src(String c_src) {
		this.c_src = c_src;
	}

	public String getC_fileSize() {
		return c_fileSize;
	}

	public void setC_fileSize(String c_fileSize) {
		this.c_fileSize = c_fileSize;
	}
}
