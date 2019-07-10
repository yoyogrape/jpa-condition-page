package com.ketai.house.utils;

import java.util.Map;

/**
 * @author naruto
 * @date 2018/10/17 22:46
 */
public class StringUtils {
    public static final String TITLE = "title";
    public static final String BETWEEN_PRICE = "betweenPrice";
    public static final String DISTRICT_NAME = "districtName";
    public static final String TYPE_ID = "typeId";
    public static final String BETWEEN_SPACE = "betweenSpace";
    public static final String BETWEEN_PUB_DATE = "betweenPubDate";
    public static final String INDEX_PAGE = "indexPage";


    public static boolean isNotBlank(Map<String,String> searchMap, String key){
        if(searchMap.containsKey(key)){
            String str = searchMap.get(key);
            if(str.trim().length()>0){
                return true;
            }
        }
        return false;
    }
}
