package com.example.demo.controller;

import com.example.demo.model.GameState;
import com.example.demo.model.LeaderboardEntry;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/game/{number}")
    public String game(@PathVariable int number, Model model) {
        model.addAttribute("number", number);
        return "game";
    }

    @GetMapping("/game/state")
    @ResponseBody
    public GameState getGameState(@RequestParam int number) {
        return gameService.getPuzzle(number);
    }

    @PostMapping("/game/check")
    @ResponseBody
    public Map<String, Boolean> checkAnswer(@RequestParam int number, @RequestBody boolean[][] userAnswer) {
        boolean isCorrect = gameService.checkAnswer(number, userAnswer);
        Map<String, Boolean> result = new HashMap<>();
        result.put("correct", isCorrect);
        return result;
    }

    @GetMapping("/leaderboard")
    @ResponseBody
    public List<LeaderboardEntry> getLeaderboard() {
        return gameService.getLeaderboard();
    }
}
