package com.project.liverpool.data.model;

import java.util.List;

public class Records {

    private String productId;
    private String skuRepositoryId;
    private String productDisplayName;
    private String productType;
    private Integer productRatingCount;
    private double productAvgRating;
    private Double listPrice;
    private Double minimumListPrice;
    private Double maximumListPrice;
    private Double promoPrice;
    private Double minimumPromoPrice;
    private Double maximumPromoPrice;
    private boolean isHybrid;
    private boolean isMarketPlace;
    private boolean isImportationProduct;
    private String brand;
    private String seller;
    private String category;
    private String smImage;
    private String lgImage;
    private String xlImage;
    private String groupType;
    private List<String> plpFlags;
    private List<VariantsColor> variantsColor;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuRepositoryId() {
        return skuRepositoryId;
    }

    public void setSkuRepositoryId(String skuRepositoryId) {
        this.skuRepositoryId = skuRepositoryId;
    }

    public String getProductDisplayName() {
        return productDisplayName;
    }

    public void setProductDisplayName(String productDisplayName) {
        this.productDisplayName = productDisplayName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductRatingCount() {
        return productRatingCount;
    }

    public void setProductRatingCount(Integer productRatingCount) {
        this.productRatingCount = productRatingCount;
    }

    public double getProductAvgRating() {
        return productAvgRating;
    }

    public void setProductAvgRating(double productAvgRating) {
        this.productAvgRating = productAvgRating;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getMinimumListPrice() {
        return minimumListPrice;
    }

    public void setMinimumListPrice(Double minimumListPrice) {
        this.minimumListPrice = minimumListPrice;
    }

    public Double getMaximumListPrice() {
        return maximumListPrice;
    }

    public void setMaximumListPrice(Double maximumListPrice) {
        this.maximumListPrice = maximumListPrice;
    }

    public double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public double getMinimumPromoPrice() {
        return minimumPromoPrice;
    }

    public void setMinimumPromoPrice(Double minimumPromoPrice) {
        this.minimumPromoPrice = minimumPromoPrice;
    }

    public double getMaximumPromoPrice() {
        return maximumPromoPrice;
    }

    public void setMaximumPromoPrice(Double maximumPromoPrice) {
        this.maximumPromoPrice = maximumPromoPrice;
    }

    public boolean isHybrid() {
        return isHybrid;
    }

    public void setHybrid(boolean hybrid) {
        isHybrid = hybrid;
    }

    public boolean isMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public boolean isImportationProduct() {
        return isImportationProduct;
    }

    public void setImportationProduct(boolean importationProduct) {
        isImportationProduct = importationProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSmImage() {
        return smImage;
    }

    public void setSmImage(String smImage) {
        this.smImage = smImage;
    }

    public String getLgImage() {
        return lgImage;
    }

    public void setLgImage(String lgImage) {
        this.lgImage = lgImage;
    }

    public String getXlImage() {
        return xlImage;
    }

    public void setXlImage(String xlImage) {
        this.xlImage = xlImage;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public List<String> getPlpFlags() {
        return plpFlags;
    }

    public void setPlpFlags(List<String> plpFlags) {
        this.plpFlags = plpFlags;
    }

    public List<VariantsColor> getVariantsColor() {
        return variantsColor;
    }

    public void setVariantsColor(List<VariantsColor> variantsColor) {
        this.variantsColor = variantsColor;
    }
}
