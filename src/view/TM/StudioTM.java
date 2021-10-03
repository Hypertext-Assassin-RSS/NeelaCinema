package view.TM;

import java.util.Objects;

public class StudioTM {
    private String studioName;
    private String studioNo;

    public StudioTM() {
    }

    public StudioTM(String studioName, String studioNo) {
        this.setStudioName(studioName);
        this.setStudioNo(studioNo);


    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getStudioNo() {
        return studioNo;
    }

    public void setStudioNo(String studioNo) {
        this.studioNo = studioNo;
    }

    @Override
    public String
    toString() {
        return "StudioTM{" +
                "studioName='" + studioName + '\'' +
                ", studioNo='" + studioNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudioTM studioTM = (StudioTM) o;
        return Objects.equals(studioName, studioTM.studioName) && Objects.equals(studioNo, studioTM.studioNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studioName, studioNo);
    }
}
