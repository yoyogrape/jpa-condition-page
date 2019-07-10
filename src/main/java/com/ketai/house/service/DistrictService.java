package com.ketai.house.service;

import com.ketai.house.entity.District;

import java.util.List;

/**
 * @author naruto
 * @date 2018/10/19 19:54
 */
public interface DistrictService {
    /**
     * 查询所有区县信息
     * @return  区县集合
     */
    List<District> findAll();
}
