package model;

import java.util.Objects;

public class Film {
    private String filmName;
    private int studioNo;
    private String showTime;
    private String startDate;
    private String endDate;

    public Film() {
    }

    public Film(String filmName, int studioNo, String showTime, String startDate, String endDate) {
        this.setFilmName(filmName);
        this.setStudioNo(studioNo);
        this.setShowTime(showTime);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getStudioNo() {
        return studioNo;
    }

    public void setStudioNo(int studioNo) {
        this.studioNo = studioNo;
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

    @Override
    public String toString() {
        return "Film{" +
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
        Film film = (Film) o;
        return studioNo == film.studioNo && Objects.equals(filmName, film.filmName) && Objects.equals(showTime, film.showTime) && Objects.equals(startDate, film.startDate) && Objects.equals(endDate, film.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, studioNo, showTime, startDate, endDate);
    }
}