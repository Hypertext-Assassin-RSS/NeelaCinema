package model;

import java.util.Objects;

public class Studio {
    private String studioName;
    private String studionNo;

    public Studio() {
    }

    public Studio(String studioName, String studionNo) {
        this.setStudioName(studioName);
        this.setStudionNo(studionNo);
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getStudionNo() {
        return studionNo;
    }

    public void setStudionNo(String studionNo) {
        this.studionNo = studionNo;
    }

    @Override
    public String
    toString() {
        return "Studio{" +
                "studioName='" + studioName + '\'' +
                ", studionNo='" + studionNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studio studio = (Studio) o;
        return Objects.equals(studioName, studio.studioName) && Objects.equals(studionNo, studio.studionNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studioName, studionNo);
    }
}
