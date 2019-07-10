package com.ketai.house.utils;

/**
 * @author naruto
 * @date 2018/10/20 16:03
 */
public class PageUtils {

    public static final Integer HOUSE_ROW_SIZE=1;

    private Integer currentPage;
    private Integer rowCount;
    private Integer pageCount;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        if (rowCount != null){
            this.rowCount = rowCount;
            this.pageCount = rowCount % HOUSE_ROW_SIZE==0 ?
                            rowCount/HOUSE_ROW_SIZE : rowCount/HOUSE_ROW_SIZE+1;
        }else{
            this.rowCount = rowCount;
        }
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
