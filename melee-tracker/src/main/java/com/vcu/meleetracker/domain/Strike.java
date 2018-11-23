package com.vcu.meleetracker.domain;

import javax.persistence.*;

@Entity
@Table(name="STRIKES")
public class Strike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "strike_id")
    private Integer strikeId;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @Column(name = "strike_order")
    private Integer strikeOrder;

    public Strike(){}

    public Strike(Match match, Stage stage, Integer strikeOrder){
        this.match = match;
        this.stage = stage;
        this.strikeOrder = strikeOrder;
    }

    public Integer getStrikeId() {
        return strikeId;
    }

    public void setStrikeId(Integer strikeId) {
        this.strikeId = strikeId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Integer getStrikeOrder() {
        return strikeOrder;
    }

    public void setStrikeOrder(Integer strikeOrder) {
        this.strikeOrder = strikeOrder;
    }
}
