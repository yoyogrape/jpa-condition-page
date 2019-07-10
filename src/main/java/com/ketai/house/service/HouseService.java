package com.ketai.house.service;

import com.ketai.house.entity.House;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author naruto
 * @date 2018/10/18 16:31
 */
public interface HouseService {


    /**
     * 根据条件动态查询房源信息
     * @param searchMap 查询结果
     * @return
     */
    Page<House> findSearch(Map<String,String> searchMap);

    /**
     * 根据id删除房屋信息
     * @param hid 房屋信息
     * @return  删除结果
     */
    boolean deleteById(Integer hid);

    /**
     *获取当前条件的总记录数
     * @return 总记录数
     */
    Integer getRowCount(Map<String,String> searchMap);
}
