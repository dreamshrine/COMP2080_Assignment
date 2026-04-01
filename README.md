COMP 2080 - Group Project Work Split (5 People)
Due Date: Friday, April 3rd, 2026
================================================

Shayne - Game Setup & Main Menu
----------------------------------
- Mode selection (2-player vs 1-player vs AI)
- Prompt players for their names
- Symbol choice ('X' or 'O')
- Enforce X-goes-first logic
- Overall game launch flow

Annika - Board & Display
----------------------------
- Define and initialize the char[][] board array
- Print the board to the console
- Handle player input (row and column prompts)
- Validate input (bounds checking, occupied cell checking)
- Place symbols on the board

Grace - Win/Draw Detection
-------------------------------
- Check all rows for a winning line
- Check all columns for a winning line
- Check both diagonals for a winning line
- Detect full-board draw (tie) condition
- Return game state result to the main loop

Jack - Minimax AI (5-mark component)
------------------------------------------
- Implement the recursive minimax algorithm
- Score terminal game states (win/loss/draw)
- Select the optimal move for the computer
- Integrate the computer's turn into the game flow
- Ensure the AI plays perfectly against the human

Phil - Integration, Testing & Report
------------------------------------------
- Wire all components together into a working game loop
- Handle end-of-game display (winner or draw message)
- Test the full game for bugs across both modes
- Format and compile the submission document (code pasted neatly)
- Ensure submission format is correct (avoid 2-mark deduction)

EVERYONE
---------
- Add your name and student number in a comment at the top
  of every Java class you write (required by submission format)

================================================
IMPORTANT NOTES
================================================
- Only basic arrays (char[][] or int[][]) may be used for the board.
  Using higher-level data structures caps the group's grade at 50%.

- Persons 1-3 and 5 collectively cover the 2-player mode (10 marks).
- Person 4 covers the minimax AI mode (5 marks).
