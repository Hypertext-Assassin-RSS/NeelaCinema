package view.TM;

import java.util.Objects;

public class FilmTM {
    private String filmName;
    private int studioNo;
    private String showTime;
    private String startDate;
    private String endDate;

    public FilmTM() {
    }

    public FilmTM(String filmName, int studioNo, String showTime, String startDate, String endDate) {
        this.filmName = filmName;
        this.studioNo = studioNo;
        this.showTime = showTime;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStudioNo() {
        return studioNo;
    }

    public void setStudioNo(int studioNo) {
        this.studioNo = studioNo;
    }
    @Override
    public String toString() {
        return "FilmTM{" +
                "filmName='" + filmName + '\'' +
                ", studioNo=" + studioNo +
                ", showTime='" + showTime + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTM filmTM = (FilmTM) o;
        return studioNo == filmTM.studioNo && Objects.equals(filmName, filmTM.filmName) && Objects.equals(showTime, filmTM.showTime) && Objects.equals(startDate, filmTM.startDate) && Objects.equals(endDate, filmTM.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, studioNo, showTime, startDate, endDate);
    }
}
