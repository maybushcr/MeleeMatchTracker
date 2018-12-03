package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class AverageStockDifference {

    private Double averageStockDifference;

    public AverageStockDifference(){}

    public AverageStockDifference(Double averageStockDifference) {
        this.averageStockDifference = averageStockDifference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AverageStockDifference that = (AverageStockDifference) o;
        return Objects.equals(averageStockDifference, that.averageStockDifference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageStockDifference);
    }

    public Double getAverageStockDifference() {
        return averageStockDifference;
    }

    public void setAverageStockDifference(Double averageStockDifference) {
        this.averageStockDifference = averageStockDifference;
    }
}
