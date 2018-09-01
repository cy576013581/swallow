package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.entity.system.SysDepartmentEntity;
import com.cy.example.mapper.SuperMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper extends SuperMapper<SysDepartmentEntity> {

	int searchAllCount(@Param("depart") SysDepartmentEntity depart);

	List<SysDepartmentEntity> searchAll(
			@Param("depart") SysDepartmentEntity depart,
			@Param("page") Page page);
}
