package com.wildan.nba_stats_2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rk;
    private String player;
    private int age;
    private String team;
    private String pos;
    private int g;
    private int gs;
    private double mp;
    private double fg;
    private double fga;
    private double fgPercent;
    private double threeP;
    private double threePA;
    private double threePPercent;
    private double twoP;
    private double twoPA;
    private double twoPPercent;
    private double efgPercent;
    private double ft;
    private double fta;
    private double ftPercent;
    private double orb;
    private double drb;
    private double trb;
    private double ast;
    private double stl;
    private double blk;
    private double tov;
    private double pf;
    private double pts;
    private String awards;
}
