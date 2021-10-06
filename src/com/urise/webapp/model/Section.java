package com.urise.webapp.model;

public class Section {
    private String sectionName;
    private String sectionContent;



    public Section(String sectionName, String sectionContent) {
        this.sectionName = sectionName;
        this.sectionContent = sectionContent;
    }

    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public Section(){}



    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }


}
