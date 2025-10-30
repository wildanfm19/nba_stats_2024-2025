package com.wildan.nba_stats_2025.controller;

import com.wildan.nba_stats_2025.dto.PlayerDTO;
import com.wildan.nba_stats_2025.entity.Player;
import com.wildan.nba_stats_2025.repository.PlayerRepository;
import com.wildan.nba_stats_2025.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/player/stats")
public class PlayerController {

    private final PlayerService playerService;


    // Endpoint fleksibel: bisa filter team, position, atau keduanya
    @GetMapping("/search")
    public ResponseEntity<List<PlayerDTO>> searchPlayersByTeamAndPosition(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String position
    ){
        List<PlayerDTO> players = playerService.findPlayersByTeamAndPosition(team, position);
        return ResponseEntity.ok(players);
    }

    // Optional: endpoint lain jika ingin tetap memisahkan
    @GetMapping("/all")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findAllPlayer());
    }

    @GetMapping("/search/player")
    public ResponseEntity<List<PlayerDTO>> searchByName(@RequestParam String name){
        return ResponseEntity.ok(playerService.findPlayerByName(name));
    }



}
