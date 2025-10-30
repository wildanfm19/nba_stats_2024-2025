package com.wildan.nba_stats_2025.repository;

import com.wildan.nba_stats_2025.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player , Long> {

    List<Player> findByPlayerContainingIgnoreCase(String namePart);

    List<Player> findByTeamContainingIgnoreCase(String teamName);

    List<Player> findByPos(String position);

    List<Player> findByPosContainingIgnoreCase(String pos);

    List<Player> findByTeamContainingIgnoreCaseAndPosContainingIgnoreCase(String team, String pos);

}
