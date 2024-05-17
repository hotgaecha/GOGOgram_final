package com.example.demo.service;

import com.example.demo.model.GameState;
import com.example.demo.model.LeaderboardEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    private Map<Integer, GameState> puzzles = new HashMap<>();
    private List<LeaderboardEntry> leaderboard = new ArrayList<>();

    public GameService() {
        // 퍼즐 데이터 초기화
        initializePuzzles();
    }

    private void initializePuzzles() {
        // 각 퍼즐 데이터 생성
        puzzles.put(1, new GameState(new int[][] {
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1}
        }));

        puzzles.put(2, new GameState(new int[][] {
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1}
        }));

        // 나머지 퍼즐 데이터 추가
        // ...
    }

    public GameState getPuzzle(int number) {
        return puzzles.get(number);
    }

    public boolean checkAnswer(int number, boolean[][] userAnswer) {
        GameState puzzle = puzzles.get(number);
        if (puzzle == null) return false;

        int[][] solution = puzzle.getBoard();
        for (int row = 0; row < solution.length; row++) {
            for (int col = 0; col < solution[row].length; col++) {
                if ((solution[row][col] == 1 && !userAnswer[row][col]) || 
                    (solution[row][col] == 0 && userAnswer[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<LeaderboardEntry> getLeaderboard() {
        return leaderboard;
    }

    public void addLeaderboardEntry(String name, String time) {
        leaderboard.add(new LeaderboardEntry(name, time));
    }
}
