package com.project.liverpool.data.model;

import java.util.List;

public class Navigation {
    private List<Current> ancester;
    private List<Current> current;
    private List<Current> childs;

    public List<Current> getAncester() {
        return ancester;
    }

    public void setAncester(List<Current> ancester) {
        this.ancester = ancester;
    }

    public List<Current> getCurrent() {
        return current;
    }

    public void setCurrent(List<Current> current) {
        this.current = current;
    }

    public List<Current> getChilds() {
        return childs;
    }

    public void setChilds(List<Current> childs) {
        this.childs = childs;
    }
}
