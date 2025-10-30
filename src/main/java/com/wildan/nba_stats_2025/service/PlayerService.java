package com.wildan.nba_stats_2025.service;

import com.wildan.nba_stats_2025.dto.PlayerDTO;
import com.wildan.nba_stats_2025.entity.Player;

import java.util.List;

public interface PlayerService {

    // Ambil semua player
    List<PlayerDTO> findAllPlayer();

    // Cari player berdasarkan nama (partial match)
    List<PlayerDTO> findPlayerByName(String name);

    // Cari player berdasarkan team (partial/full name, abbreviation)
    List<PlayerDTO> findPlayerByTeam(String teamName);

    // Cari player berdasarkan kombinasi team dan/atau position
    List<PlayerDTO> findPlayersByTeamAndPosition(String teamName, String position);


}
