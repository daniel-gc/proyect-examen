package com.project.liverpool.webservices.response;

public class PlpState {
    private String categoryId;
    private String currentSortOption;
    private String currentFilters;
    private Integer firstRecNum;
    private Integer lastRecNum;
    private Integer recsPerPage;
    private Integer totalNumRecs;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCurrentSortOption() {
        return currentSortOption;
    }

    public void setCurrentSortOption(String currentSortOption) {
        this.currentSortOption = currentSortOption;
    }

    public String getCurrentFilters() {
        return currentFilters;
    }

    public void setCurrentFilters(String currentFilters) {
        this.currentFilters = currentFilters;
    }

    public Integer getFirstRecNum() {
        return firstRecNum;
    }

    public void setFirstRecNum(Integer firstRecNum) {
        this.firstRecNum = firstRecNum;
    }

    public Integer getLastRecNum() {
        return lastRecNum;
    }

    public void setLastRecNum(Integer lastRecNum) {
        this.lastRecNum = lastRecNum;
    }

    public Integer getRecsPerPage() {
        return recsPerPage;
    }

    public void setRecsPerPage(Integer recsPerPage) {
        this.recsPerPage = recsPerPage;
    }

    public Integer getTotalNumRecs() {
        return totalNumRecs;
    }

    public void setTotalNumRecs(Integer totalNumRecs) {
        this.totalNumRecs = totalNumRecs;
    }
}
