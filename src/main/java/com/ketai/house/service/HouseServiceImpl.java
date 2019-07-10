package com.ketai.house.service;

import com.alibaba.fastjson.JSON;
import com.ketai.house.entity.*;
import com.ketai.house.repository.HouseRepository;
import com.ketai.house.utils.PageUtils;
import com.ketai.house.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author naruto
 * @date 2018/10/18 16:31
 */
@Service
public class HouseServiceImpl implements HouseService{

    @Autowired
    HouseRepository houseRepository;

    /**
     * 根据条件动态查询房源信息
     *
     * @param searchMap 查询结果
     * @return
     */
    @Override
    public Page<House> findSearch(Map<String,String> searchMap) {
        Assert.notNull(searchMap,"searchMap集合为Null");
        int indexPage = StringUtils.isNotBlank(searchMap,StringUtils.INDEX_PAGE) ?
                        Integer.valueOf(searchMap.get(StringUtils.INDEX_PAGE)):1;
        //分页条件
        Pageable pageable = PageRequest.of(indexPage-1, PageUtils.HOUSE_ROW_SIZE);
        //按条件查询
        return houseRepository.findAll(this.getSpecification(searchMap),pageable);
    }

    /**
     * 根据id删除房屋信息
     * @param hid 房屋信息
     * @return 删除结果
     */
    @Override
    public boolean deleteById(Integer hid) {
        try {
            houseRepository.deleteById(hid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取当前条件的总记录数
     *
     * @return 总记录数
     */
    @Override
    public Integer getRowCount(Map<String,String> searchMap) {
        return (int)houseRepository.count(this.getSpecification(searchMap));
    }
    /**
     * 根据参数拼接查询条件
     * @param searchMap 参数
     * @return  查询条件
     */
    private Specification<House> getSpecification(Map<String,String> searchMap){
        return (Specification<House>) (root, query, cb) -> {
            Join<House,Street> streetJoint = root.join("street", JoinType.INNER);
            Join<Street,District> districtJoint = streetJoint.join("district", JoinType.INNER);
            Join<House,Types> typesJoin = root.join("type",JoinType.INNER);
            List<Predicate> predicateList = new ArrayList<>();
            //标题模糊搜索
            if(StringUtils.isNotBlank(searchMap,StringUtils.TITLE)){
                predicateList.add(cb.like(root.get("title"),"%"+searchMap.get(StringUtils.TITLE)+"%"));
            }
            //价格区间
            if(StringUtils.isNotBlank(searchMap,StringUtils.BETWEEN_PRICE)){
                String [] minAndMaxPrice = searchMap.get(StringUtils.BETWEEN_PRICE).split("~");
                int min = Integer.valueOf(minAndMaxPrice[0]);
                int max = Integer.valueOf(minAndMaxPrice[1]);
                predicateList.add(cb.between(root.get("price"),min,max));
            }
            //房屋位置
            if(StringUtils.isNotBlank(searchMap,StringUtils.DISTRICT_NAME)){
                predicateList.add(cb.equal(districtJoint.get("dname"),searchMap.get(StringUtils.DISTRICT_NAME)));
            }
            //房型
            if(StringUtils.isNotBlank(searchMap,StringUtils.TYPE_ID)){
                predicateList.add(cb.equal(typesJoin.get("tid"),searchMap.get(StringUtils.TYPE_ID)));
            }
            //面积
            if(StringUtils.isNotBlank(searchMap,StringUtils.BETWEEN_SPACE)){
                String [] prices = searchMap.get(StringUtils.BETWEEN_SPACE).split("~");
                int minPrice = Integer.valueOf(prices[0]);
                int maxPrice = Integer.valueOf(prices[1]);
                predicateList.add(cb.between(root.get("floorage"),minPrice,maxPrice));
            }
            //更新时间
            if(StringUtils.isNotBlank(searchMap,StringUtils.BETWEEN_PUB_DATE)){
                String year = searchMap.get(StringUtils.BETWEEN_PUB_DATE);
                String start = year+"-01-01 00:00:00";
                String end = year+"-12-31 11:59:59";
                predicateList.add(cb.between(root.get("pubDate"), Date.valueOf(start),Date.valueOf(end)));
            }
            Predicate [] predicates = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(predicates));
        };
    }
}