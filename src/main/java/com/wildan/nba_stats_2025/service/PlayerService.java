package com.wildan.nba_stats_2025.service;

import com.wildan.nba_stats_2025.dto.PlayerDTO;
import com.wildan.nba_stats_2025.entity.Player;

import java.util.List;

public interface PlayerService {

    List<PlayerDTO>findAllPlayer();

    List<PlayerDTO> findPlayerByName(String name);

    List<PlayerDTO> findPlayerByTeam(String teamName);
}
