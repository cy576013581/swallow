package com.cy.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 *  mapper 父类，注意这个类不要让 mp 扫描到！！
 */
public interface SuperMapper<T> extends BaseMapper<T> {

    // 这里可以放一些公共的方法
}