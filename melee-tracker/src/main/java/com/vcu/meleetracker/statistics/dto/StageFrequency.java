package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class StageFrequency {

    private Integer stageId;
    private Integer frequency;

    public StageFrequency(){}

    public StageFrequency(Integer stageId, Integer frequency) {
        this.stageId = stageId;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StageFrequency that = (StageFrequency) o;
        return Objects.equals(stageId, that.stageId) &&
                Objects.equals(frequency, that.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stageId, frequency);
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
