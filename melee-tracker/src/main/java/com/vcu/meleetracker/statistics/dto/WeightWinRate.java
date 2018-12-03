package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class WeightWinRate {

    private Integer weight;
    private Double win_percentage;

    public WeightWinRate(){}

    public WeightWinRate(Integer weight, Double win_percentage) {
        this.weight = weight;
        this.win_percentage = win_percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightWinRate that = (WeightWinRate) o;
        return Objects.equals(weight, that.weight) &&
                Objects.equals(win_percentage, that.win_percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, win_percentage);
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getWin_percentage() {
        return win_percentage;
    }

    public void setWin_percentage(Double win_percentage) {
        this.win_percentage = win_percentage;
    }
}
