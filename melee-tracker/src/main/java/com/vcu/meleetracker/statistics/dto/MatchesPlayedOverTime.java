package com.vcu.meleetracker.statistics.dto;

import java.sql.Date;
import java.util.Objects;

public class MatchesPlayedOverTime {

    private Date day;
    private Integer count;

    public MatchesPlayedOverTime(){}

    public MatchesPlayedOverTime(Date day, Integer count) {
        this.day = day;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchesPlayedOverTime that = (MatchesPlayedOverTime) o;
        return Objects.equals(day, that.day) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, count);
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
