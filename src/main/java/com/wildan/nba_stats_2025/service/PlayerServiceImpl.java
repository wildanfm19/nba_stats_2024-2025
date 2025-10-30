package com.wildan.nba_stats_2025.service;

import com.wildan.nba_stats_2025.PlayerNotFoundException;
import com.wildan.nba_stats_2025.dto.PlayerDTO;
import com.wildan.nba_stats_2025.entity.Player;
import com.wildan.nba_stats_2025.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl  implements  PlayerService{

    private final PlayerRepository playerRepository;

    private final ModelMapper modelMapper;

    // Bisa ditempatkan di service sebagai static final
    private static final Map<String, String> TEAM_MAP = Map.ofEntries(
            Map.entry("ATL", "Atlanta Hawks"),
            Map.entry("BOS", "Boston Celtics"),
            Map.entry("BRK", "Brooklyn Nets"),
            Map.entry("CHA", "Charlotte Hornets"),
            Map.entry("CHI", "Chicago Bulls"),
            Map.entry("CLE", "Cleveland Cavaliers"),
            Map.entry("DAL", "Dallas Mavericks"),
            Map.entry("DEN", "Denver Nuggets"),
            Map.entry("DET", "Detroit Pistons"),
            Map.entry("GSW", "Golden State Warriors"),
            Map.entry("HOU", "Houston Rockets"),
            Map.entry("IND", "Indiana Pacers"),
            Map.entry("LAC", "LA Clippers"),
            Map.entry("LAL", "Los Angeles Lakers"),
            Map.entry("MEM", "Memphis Grizzlies"),
            Map.entry("MIA", "Miami Heat"),
            Map.entry("MIL", "Milwaukee Bucks"),
            Map.entry("MIN", "Minnesota Timberwolves"),
            Map.entry("NOP", "New Orleans Pelicans"),
            Map.entry("NYK", "New York Knicks"),
            Map.entry("OKC", "Oklahoma City Thunder"),
            Map.entry("ORL", "Orlando Magic"),
            Map.entry("PHI", "Philadelphia 76ers"),
            Map.entry("PHX", "Phoenix Suns"),
            Map.entry("POR", "Portland Trail Blazers"),
            Map.entry("SAC", "Sacramento Kings"),
            Map.entry("SAS", "San Antonio Spurs"),
            Map.entry("TOR", "Toronto Raptors"),
            Map.entry("UTA", "Utah Jazz"),
            Map.entry("WAS", "Washington Wizards")
    );



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
    @Override
    public List<PlayerDTO> findPlayerByTeam(String teamName) {
        // Normalize input
        String input = teamName.trim().toLowerCase();

        // Find abbreviation if input is full name (contains space) or abbreviation itself
        String teamAbbr = TEAM_MAP.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(input) // check abbreviation
                        || entry.getValue().toLowerCase().contains(input)) // check full name partial match
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(input); // fallback: use input itself

        // Query repository using abbreviation
        List<Player> players = playerRepository.findByTeamContainingIgnoreCase(teamAbbr);

        // Map to DTO with full team name
        return players.stream()
                .map(player -> {
                    PlayerDTO dto = modelMapper.map(player, PlayerDTO.class);
                    dto.setTeam(TEAM_MAP.getOrDefault(player.getTeam(), player.getTeam()));
                    return dto;
                })
                .toList();
    }

    @Override
    public List<PlayerDTO> findPlayersByTeamAndPosition(String teamName, String position) {
        // --- Normalize team input ---
        String teamAbbr = null;
        if (teamName != null && !teamName.isBlank()) {
            String input = teamName.trim().toLowerCase();
            teamAbbr = TEAM_MAP.entrySet().stream()
                    .filter(entry -> entry.getKey().equalsIgnoreCase(input)
                            || entry.getValue().toLowerCase().contains(input))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(input);
        }

        // --- Query repository ---
        List<Player> players;

        if (teamAbbr != null && position != null && !position.isBlank()) {
            // Filter by both team and position
            players = playerRepository.findByTeamContainingIgnoreCaseAndPosContainingIgnoreCase(teamAbbr, position);
        } else if (teamAbbr != null) {
            // Filter only by team
            players = playerRepository.findByTeamContainingIgnoreCase(teamAbbr);
        } else if (position != null && !position.isBlank()) {
            // Filter only by position
            players = playerRepository.findByPosContainingIgnoreCase(position);
        } else {
            // No filter, return all
            players = playerRepository.findAll();
        }

        // --- Map to DTO and convert team abbreviation to full name ---
        return players.stream()
                .map(player -> {
                    PlayerDTO dto = modelMapper.map(player, PlayerDTO.class);
                    if (player.getTeam() != null) {
                        dto.setTeam(TEAM_MAP.getOrDefault(player.getTeam(), player.getTeam()));
                    }
                    return dto;
                })
                .toList();
    }




}
