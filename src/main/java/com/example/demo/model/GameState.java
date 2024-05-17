package com.example.demo.model;

public class GameState {
    private int[][] board;
    private boolean[][] filled;

    // 기존 생성자
    public GameState(int rows, int cols) {
        board = new int[rows][cols];
        filled = new boolean[rows][cols];
    }

    // 새로운 생성자
    public GameState(int[][] board) {
        this.board = board;
        this.filled = new boolean[board.length][board[0].length];
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public boolean[][] getFilled() {
        return filled;
    }

    public void setFilled(boolean[][] filled) {
        this.filled = filled;
    }
}
