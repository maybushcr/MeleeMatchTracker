package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class WeightWinRate {

    private Integer weight;
    private Double winPercentage;

    public WeightWinRate(){}

    public WeightWinRate(Integer weight, Double winPercentage) {
        this.weight = weight;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightWinRate that = (WeightWinRate) o;
        return Objects.equals(weight, that.weight) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, winPercentage);
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
