package com.wildan.nba_stats_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Long id;
    private Integer rk;
    private String player;
    private Integer age;
    private String team;
    private String pos;
    private Integer g;
    private Integer gs;
    private Double mp;
    private Double fg;
    private Double fga;
    private Double fgPercent;
    private Double threeP;
    private Double threePa;
    private Double threePPercent;
    private Double twoP;
    private Double twoPa;
    private Double twoPPercent;
    private Double efgPercent;
    private Double ft;
    private Double fta;
    private Double ftPercent;
    private Double orb;
    private Double drb;
    private Double trb;
    private Double ast;
    private Double stl;
    private Double blk;
    private Double tov;
    private Double pf;
    private Double pts;
    private String awards;
}
