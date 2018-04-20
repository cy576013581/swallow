package com.cy.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    //    成功标记
    Boolean flag;

    //    返回信息
    String msg;

    //    返回记录数
    Integer total;

    //    返回数据
    T rows;

}
