package com.wildan.nba_stats_2025.repository;

import com.wildan.nba_stats_2025.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player , Long> {
}
