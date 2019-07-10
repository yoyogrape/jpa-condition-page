package com.ketai.house.service;

import com.ketai.house.entity.District;
import com.ketai.house.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author naruto
 * @date 2018/10/19 19:55
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    /**
     * 查询所有区县信息
     * @return 区县集合
     */
    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }
}
