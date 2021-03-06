package cn.sioo.pojo;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 基类
 */
public class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Transient
    private Integer pageIndex = Integer.valueOf(0);    //起始页索引

    @Transient
    protected Integer pageSize = Integer.valueOf(15);    //每页大小

    @Transient
    protected Integer currentPageIndex;

    @Transient
    protected Integer currentPage;    //当前页


    public String getOrderBy() {
        return "id";
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

}
