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

    @GetMapping("/all")
    public ResponseEntity<List<PlayerDTO>> getAllPlayerStats(){
        List<PlayerDTO> listPlayer = playerService.findAllPlayer();
        return ResponseEntity.ok().body(listPlayer);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerDTO>> getPlayerStats(@RequestParam String name){
        List<PlayerDTO> playerDTOS = playerService.findPlayerByName(name);
        return ResponseEntity.ok().body(playerDTOS);
    }


}
