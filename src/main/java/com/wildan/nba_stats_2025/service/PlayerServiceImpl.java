package com.wildan.nba_stats_2025.service;

import com.wildan.nba_stats_2025.PlayerNotFoundException;
import com.wildan.nba_stats_2025.dto.PlayerDTO;
import com.wildan.nba_stats_2025.entity.Player;
import com.wildan.nba_stats_2025.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl  implements  PlayerService{

    private final PlayerRepository playerRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PlayerDTO> findAllPlayer() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDTO> playersDTO = players.stream()
                .map(player -> modelMapper.map(player , PlayerDTO.class))
                .toList();
        return playersDTO;
    }

    @Override
    public List<PlayerDTO> findPlayerByName(String name) {
        List<Player> players = playerRepository.findByPlayerContainingIgnoreCase(name);
        List<PlayerDTO> playersDTO = players.stream()
                .map(player -> modelMapper.map(player , PlayerDTO.class))
                .toList();
        return playersDTO;
    }

}
