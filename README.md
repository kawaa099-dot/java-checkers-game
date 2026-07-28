# Java Checkers Game
Console-based Checkers game in Java with full move validation, captures, king promotion, and two difficulty modes

# Overview

This project implements the classic board game of Checkers as a two-player, turn-based console application. Players take turns selecting and moving pieces via coordinate input, with the game enforcing standard Checkers rules including forced captures, diagonal movement, and king promotion upon reaching the opposite end of the board.

# How to Play

1. Compile and run the program
2. Choose a game mode:
   - **1 — Easy:** Standard piece movement and captures only (no kings)
   - **2 — Medium:** Adds king promotion and king-specific movement/capture rules
3. Players alternate turns (Black moves first)
4. On your turn:
   - Enter the **row, column** coordinates (0–7) of the piece you want to move
   - Enter the coordinates you want to move it to
   - Invalid moves are rejected and you'll be prompted again
5. The game ends automatically when one side has no pieces remaining

# Rules Implemented

- **Standard diagonal movement** for regular pieces (black moves down the board, white moves up)
- **Mandatory-style capture validation** — jumping over an opposing piece to an empty square, removing the captured piece
- **King promotion** — a piece reaching the far row is crowned (`b`→`B`, `w`→`W`)
- **King movement** — kings can move diagonally in any direction (including backward)
- **Multi-jump handling** for capture sequences
- **Win detection** — game ends when one color has zero pieces remaining
- **Input validation** — coordinates are checked to be within the 0–7 board range, with re-prompting on invalid entries

# Board Representation

The board is an 8×8 `char[][]` array:

| Symbol | Meaning |
|---|---|
| `b` | Black piece |
| `B` | Black king |
| `w` | White piece |
| `W` | White king |
| ` ` | Empty square |

# Contents

- [`Project_checkers.java`](./Project_checkers.java) — Full game implementation (board setup, move/capture validation for both regular pieces and kings, king promotion, win-condition checking, console I/O)

# Tech Stack

- **Language:** Java
- **Interface:** Console (`Scanner` for input)
- **Paradigm:** Procedural, static-method based

# Possible Improvements

- Refactor into object-oriented classes (`Board`, `Piece`, `Player`, `GameEngine`)
- Add a graphical interface (Java Swing/JavaFX)
- Implement true network multiplayer (client-server via sockets)
- Add an AI opponent (minimax algorithm)
- Enforce mandatory captures (standard Checkers rule where capturing is compulsory when available)
- Unit tests for move-validation logic

# Author

Kawtharul Jannah Mohd Sukki
