package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class AverageStockDifference {

    private Integer averageStockDifference;

    public AverageStockDifference(){}

    public AverageStockDifference(Integer averageStockDifference) {
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

    public Integer getAverageStockDifference() {
        return averageStockDifference;
    }

    public void setAverageStockDifference(Integer averageStockDifference) {
        this.averageStockDifference = averageStockDifference;
    }
}
