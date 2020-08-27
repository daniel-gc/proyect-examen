package com.project.liverpool.data.model;

public class SortOptions {
    private String sortBy;

    private String label;

    public void setSortBy(String sortBy){
        this.sortBy = sortBy;
    }
    public String getSortBy(){
        return this.sortBy;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }
}
