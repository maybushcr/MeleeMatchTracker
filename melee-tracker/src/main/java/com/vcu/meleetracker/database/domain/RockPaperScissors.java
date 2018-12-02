package com.vcu.meleetracker.database.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="ROCK_PAPER_SCISSORS")
public class RockPaperScissors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "throw_id")
    private Integer throwId;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set set;

    @Column(name = "throw_time")
    private Date throwTime;

    @Column(name = "player1_throw")
    private String player1Throw;

    @Column(name = "player2_throw")
    private String player2Throw;

    public RockPaperScissors(){}

    public RockPaperScissors(Set set, Date throwTime, String player1Throw, String player2Throw){
        this.set = set;
        this.throwTime = throwTime;
        this.player1Throw = player1Throw;
        this.player2Throw = player2Throw;
    }

    public Integer getThrowId() {
        return throwId;
    }

    public void setThrowId(Integer throwId) {
        this.throwId = throwId;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Date getThrowTime() {
        return throwTime;
    }

    public void setThrowTime(Date throwTime) {
        this.throwTime = throwTime;
    }

    public String getPlayer1Throw() {
        return player1Throw;
    }

    public void setPlayer1Throw(String player1Throw) {
        this.player1Throw = player1Throw;
    }

    public String getPlayer2Throw() {
        return player2Throw;
    }

    public void setPlayer2Throw(String player2Throw) {
        this.player2Throw = player2Throw;
    }
}
