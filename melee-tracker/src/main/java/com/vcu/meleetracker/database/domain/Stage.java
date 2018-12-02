package com.vcu.meleetracker.database.domain;

import javax.persistence.*;

@Entity
@Table(name="STAGES")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stage_id")
    private Integer stageId;

    @Column(name = "stage_name")
    private String name;

    public Stage(){}

    public Stage(String name){
        this.name = name;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
