package com.example.sunning.restauranthygienechecker.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    @JsonProperty("dataSource")
    private String dataSource;
    @JsonProperty("extractDate")
    private String extractDate;
    @JsonIgnore
    private String returncode = "";
    @JsonProperty("itemCount")
    private int itemCount;
    @JsonProperty("totalCount")
    private int totalCount;
    @JsonProperty("totalPages")
    private int totalPages;
    @JsonProperty("pageSize")
    private int pageSize;
    @JsonProperty("pageNumber")
    private int pageNumber;

    public Meta() {
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(String extractDate) {
        this.extractDate = extractDate;
    }

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
