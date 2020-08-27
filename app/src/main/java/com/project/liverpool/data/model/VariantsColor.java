package com.project.liverpool.data.model;

public class VariantsColor {
    private String colorName;
    private String colorHex;
    private String colorImageURL;

    public void setColorName(String colorName){
        this.colorName = colorName;
    }
    public String getColorName(){
        return this.colorName;
    }
    public void setColorHex(String colorHex){
        this.colorHex = colorHex;
    }
    public String getColorHex(){
        return this.colorHex;
    }
    public void setColorImageURL(String colorImageURL){
        this.colorImageURL = colorImageURL;
    }
    public String getColorImageURL(){
        return this.colorImageURL;
    }
}
