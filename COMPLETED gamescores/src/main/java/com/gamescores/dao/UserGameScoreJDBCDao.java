package com.gamescores.dao;

import com.gamescores.model.dto.GameHighestScoreDTO;
import com.gamescores.model.dto.GameHighestScoreRQ;
import com.gamescores.model.dto.UserGameScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserGameScoreJDBCDao {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GameHighestScoreDTO getHighestGameScore(GameHighestScoreRQ scoreRQ) {
        GameHighestScoreDTO result = new GameHighestScoreDTO();
        result.setUserID(scoreRQ.getUserID());
        result.setGameID(scoreRQ.getGameID());

        Map<String, Object> params = new HashMap<>();
        params.put("userID", scoreRQ.getUserID());
        params.put("gameID", scoreRQ.getGameID());

        StringBuilder SQL = new StringBuilder();

        SQL.append("SELECT MAX(t.SCORE) AS HIGHEST_SCORE \n");
        SQL.append("FROM t_user_game_score t \n");
        SQL.append("WHERE t.USER_ID = :userID AND t.GAME_ID = :gameID \n");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<GameHighestScoreDTO>() {
            @Override
            public GameHighestScoreDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    result.setHeightScore(rs.getDouble("HIGHEST_SCORE"));
                }
                return result;
            }
        });
    }

    public List<UserGameScoreDTO> getTopTenScores(GameHighestScoreRQ scoreRQ) {
        List<UserGameScoreDTO> results = new ArrayList<>();

        Map<String, Object> params = new HashMap<>();
        params.put("userID", scoreRQ.getUserID());
        params.put("gameID", scoreRQ.getGameID());

        StringBuilder SQL = new StringBuilder();

        SQL.append("SELECT \n");
        SQL.append("  t.USER_GAME_SCORE_ID, \n");
        SQL.append("  t.USER_ID, \n");
        SQL.append("  t.GAME_ID, \n");
        SQL.append("  t.SCORE \n");
        SQL.append("FROM t_user_game_score t \n");
        SQL.append("WHERE t.USER_ID = :userID AND t.GAME_ID = :gameID \n");
        SQL.append("ORDER BY t.SCORE DESC \n");
        SQL.append("LIMIT 10 \n");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<UserGameScoreDTO>>() {
            @Override
            public List<UserGameScoreDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    UserGameScoreDTO scoreDTO = new UserGameScoreDTO();

                    scoreDTO.setUserGameScoreID(rs.getInt("USER_GAME_SCORE_ID"));
                    scoreDTO.setUserID(rs.getInt("USER_ID"));
                    scoreDTO.setGameID(rs.getInt("GAME_ID"));
                    scoreDTO.setScore(rs.getDouble("SCORE"));

                    results.add(scoreDTO);
                }
                return results;
            }
        });
    }
}
