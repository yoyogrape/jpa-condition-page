package com.ketai.house.repository;

import com.ketai.house.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author naruto
 * @date 2018/10/18 12:00
 */
public interface HouseRepository extends JpaRepository<House,Integer>,JpaSpecificationExecutor<House> {

}
