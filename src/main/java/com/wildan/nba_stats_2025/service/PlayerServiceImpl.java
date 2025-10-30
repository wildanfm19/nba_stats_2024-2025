package com.wildan.nba_stats_2025.service;

import com.wildan.nba_stats_2025.entity.Player;
import com.wildan.nba_stats_2025.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl  implements  PlayerService{

    private final PlayerRepository playerRepository;

    @Override
    public List<Player> findAllPlayer() {
        List<Player> players = playerRepository.findAll();
        return players;
    }
}
