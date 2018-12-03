package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PopularThrows {
    private String throwName;
    private Integer count;

    public PopularThrows(){}

    public PopularThrows(String throwName, Integer count) {
        this.throwName = throwName;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopularThrows that = (PopularThrows) o;
        return count == that.count &&
                Objects.equals(throwName, that.throwName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(throwName, count);
    }

    public String getThrowName() {
        return throwName;
    }

    public void setThrowName(String throwName) {
        this.throwName = throwName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
