package com.project.liverpool.data.model;

import java.util.List;

public class RefinementGroups {

    private String name;
    private List<Refinement> refinement;
    private Boolean multiSelect;
    private String dimensionName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Refinement> getRefinement() {
        return refinement;
    }

    public void setRefinement(List<Refinement> refinement) {
        this.refinement = refinement;
    }

    public Boolean getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(Boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }
}
