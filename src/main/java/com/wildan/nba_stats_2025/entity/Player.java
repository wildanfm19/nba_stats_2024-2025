package com.wildan.nba_stats_2025.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "player_stats")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Rk")
    private int rk;

    @Column(name = "Player")
    private String player;

    @Column(name = "Age")
    private int age;

    @Column(name = "Team")
    private String team;

    @Column(name = "Pos")
    private String pos;

    @Column(name = "G")
    private int g;

    @Column(name = "GS")
    private int gs;

    @Column(name = "MP")
    private double mp;

    @Column(name = "FG")
    private double fg;

    @Column(name = "FGA")
    private double fga;

    @Column(name = "FG%")
    private double fgPercent;

    @Column(name = "3P")
    private double threeP;

    @Column(name = "3PA")
    private double threePA;

    @Column(name = "3P%")
    private double threePPercent;

    @Column(name = "2P")
    private double twoP;

    @Column(name = "2PA")
    private double twoPA;

    @Column(name = "2P%")
    private double twoPPercent;

    @Column(name = "eFG%")
    private double efgPercent;

    @Column(name = "FT")
    private double ft;

    @Column(name = "FTA")
    private double fta;

    @Column(name = "FT%")
    private double ftPercent;

    @Column(name = "ORB")
    private double orb;

    @Column(name = "DRB")
    private double drb;

    @Column(name = "TRB")
    private double trb;

    @Column(name = "AST")
    private double ast;

    @Column(name = "STL")
    private double stl;

    @Column(name = "BLK")
    private double blk;

    @Column(name = "TOV")
    private double tov;

    @Column(name = "PF")
    private double pf;

    @Column(name = "PTS")
    private double pts;

    @Column(name = "Awards")
    private String awards;
}
