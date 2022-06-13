package com.gamescores.dao;

import com.gamescores.model.domain.UserGameScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGameScoreDao extends JpaRepository<UserGameScore, Integer> {
}
