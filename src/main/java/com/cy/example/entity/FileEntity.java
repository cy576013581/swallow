package com.cy.example.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("files")
public class FileEntity extends SuperEntity<FileEntity> {

	private String c_newFileName;

	private String c_oldFileName;

	private String c_src;

	private String c_fileSize;
}
