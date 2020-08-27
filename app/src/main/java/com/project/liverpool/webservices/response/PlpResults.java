package com.project.liverpool.webservices.response;

import com.project.liverpool.data.model.Navigation;
import com.project.liverpool.data.model.Records;
import com.project.liverpool.data.model.RefinementGroups;
import com.project.liverpool.data.model.SortOptions;

import java.util.List;

public class PlpResults {

    private String label;
    private PlpState plpState;
    private List<SortOptions> sortOptions;
    private List<RefinementGroups> refinementGroups;
    private List<Records> records;
    private Navigation navigation;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public PlpState getPlpState() {
        return plpState;
    }

    public void setPlpState(PlpState plpState) {
        this.plpState = plpState;
    }

    public List<SortOptions> getSortOptions() {
        return sortOptions;
    }

    public void setSortOptions(List<SortOptions> sortOptions) {
        this.sortOptions = sortOptions;
    }

    public List<RefinementGroups> getRefinementGroups() {
        return refinementGroups;
    }

    public void setRefinementGroups(List<RefinementGroups> refinementGroups) {
        this.refinementGroups = refinementGroups;
    }

    public List<Records> getRecords() {
        return records;
    }

    public void setRecords(List<Records> records) {
        this.records = records;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}
