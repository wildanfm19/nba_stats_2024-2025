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

    @Column(name = "rk")
    private Integer rk;

    @Column(name = "player")
    private String player;

    @Column(name = "age")
    private Integer age;

    @Column(name = "team")
    private String team;

    @Column(name = "pos")
    private String pos;

    @Column(name = "g")
    private Integer g;

    @Column(name = "gs")
    private Integer gs;

    @Column(name = "mp")
    private Double mp;

    @Column(name = "fg")
    private Double fg;

    @Column(name = "fga")
    private Double fga;

    @Column(name = "fg_percent")
    private Double fgPercent;

    @Column(name = "three_p")
    private Double threeP;

    @Column(name = "three_pa")
    private Double threePa;

    @Column(name = "three_p_percent")
    private Double threePPercent;

    @Column(name = "two_p")
    private Double twoP;

    @Column(name = "two_pa")
    private Double twoPa;

    @Column(name = "two_p_percent")
    private Double twoPPercent;

    @Column(name = "efg_percent")
    private Double efgPercent;

    @Column(name = "ft")
    private Double ft;

    @Column(name = "fta")
    private Double fta;

    @Column(name = "ft_percent")
    private Double ftPercent;

    @Column(name = "orb")
    private Double orb;

    @Column(name = "drb")
    private Double drb;

    @Column(name = "trb")
    private Double trb;

    @Column(name = "ast")
    private Double ast;

    @Column(name = "stl")
    private Double stl;

    @Column(name = "blk")
    private Double blk;

    @Column(name = "tov")
    private Double tov;

    @Column(name = "pf")
    private Double pf;

    @Column(name = "pts")
    private Double pts;

    @Column(name = "awards")
    private String awards;
}
