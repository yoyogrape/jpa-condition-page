package com.ketai.house.service;

import com.ketai.house.entity.Types;

import java.util.List;

/**
 * @author naruto
 * @date 2018/10/19 19:52
 */
public interface TypesService {
    /**
     * 查询所有房屋类型
     * @return 房屋类型集合
     */
    List<Types> findAll();
}
