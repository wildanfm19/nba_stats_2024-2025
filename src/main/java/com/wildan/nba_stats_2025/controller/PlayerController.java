package com.wildan.nba_stats_2025.controller;

import com.wildan.nba_stats_2025.entity.Player;
import com.wildan.nba_stats_2025.repository.PlayerRepository;
import com.wildan.nba_stats_2025.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/stats")
    public ResponseEntity<List<Player>> getAllPlayer(){
        List<Player> listPlayer = playerService.findAllPlayer();
        return ResponseEntity.ok().body(listPlayer);
    }
}
