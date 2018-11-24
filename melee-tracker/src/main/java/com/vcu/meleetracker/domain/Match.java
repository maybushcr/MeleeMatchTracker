package com.vcu.meleetracker.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MATCHES")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private Integer matchId;

    @Column(name = "match_start")
    private Date matchStart;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set set;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player1_character_id")
    private Character player1Character;

    @Column(name = "player1_stocks")
    private Integer player1Stocks;

    @ManyToOne
    @JoinColumn(name = "player2_id")
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "player2_character_id")
    private Character player2Character;

    @Column(name = "player2_stocks")
    private Integer player2Stocks;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="match",cascade = CascadeType.ALL)
    private List<Strike> strikes = new ArrayList<>();

    public Match(){}

    public Match(Date matchStart, Set set, Stage stage, Player player1, Character player1Character, Integer player1Stocks, Player player2, Character player2Character, Integer player2Stocks) {
        this.matchStart = matchStart;
        this.set = set;
        this.stage = stage;
        this.player1 = player1;
        this.player1Character = player1Character;
        this.player1Stocks = player1Stocks;
        this.player2 = player2;
        this.player2Character = player2Character;
        this.player2Stocks = player2Stocks;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Date getMatchStart() {
        return matchStart;
    }

    public void setMatchStart(Date matchStart) {
        this.matchStart = matchStart;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Character getPlayer1Character() {
        return player1Character;
    }

    public void setPlayer1Character(Character player1Character) {
        this.player1Character = player1Character;
    }

    public Integer getPlayer1Stocks() {
        return player1Stocks;
    }

    public void setPlayer1Stocks(Integer player1Stocks) {
        this.player1Stocks = player1Stocks;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Character getPlayer2Character() {
        return player2Character;
    }

    public void setPlayer2Character(Character player2Character) {
        this.player2Character = player2Character;
    }

    public Integer getPlayer2Stocks() {
        return player2Stocks;
    }

    public void setPlayer2Stocks(Integer player2Stocks) {
        this.player2Stocks = player2Stocks;
    }
}
