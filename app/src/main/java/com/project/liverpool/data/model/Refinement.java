package com.project.liverpool.data.model;

public class Refinement {

    private Integer count;
    private String label;
    private String refinementId;
    private Boolean selected;

    public void setCount(Integer count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }
    public void setRefinementId(String refinementId){
        this.refinementId = refinementId;
    }
    public String getRefinementId(){
        return this.refinementId;
    }
    public void setSelected(Boolean selected){
        this.selected = selected;
    }
    public boolean getSelected(){
        return this.selected;
    }

}
