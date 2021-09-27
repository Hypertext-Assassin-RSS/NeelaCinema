package view.TM;

public class DayTM  {
    private String year;
    private String month;
    private String day;
    private String filmName;
    private String showTime;
    private String startDate;
    private String endDate;

    DayTM() {
    }

    public DayTM(String year, String month, String day, String filmName, String showTime, String startDate, String endDate) {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
        this.setFilmName(filmName);
        this.setShowTime(showTime);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    @Override
    public String toString() {
        return "DayTM{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", filmName='" + filmName + '\'' +
                ", showTime='" + showTime + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }



}
