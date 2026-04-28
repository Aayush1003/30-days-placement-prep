# 📅 Day 10: Recursion & Backtracking

## Topics Covered
1. Print All Permutations of a String/Array
2. N-Queens Problem
3. Sudoku Solver
4. M-Coloring Problem
5. Rat in a Maze
6. Word Break (Print All Ways)

---

## 📝 Notes

### 1. All Permutations
- **Approach 1**: Swap-based — swap element at each position, recurse
- **Approach 2**: Boolean visited array + build permutation
- **Time**: O(n! × n)

### 2. N-Queens ⭐
- **Problem**: Place N queens on N×N board so no two attack each other
- **Approach**: Backtrack column by column, check row/diagonal safety
- **Optimization**: Use arrays for column, left-diag, right-diag to check O(1)
- **Time**: O(n!)

### 3. Sudoku Solver
- **Approach**: Try 1-9 at each empty cell, validate, backtrack if invalid
- **Validation**: Check row, column, and 3×3 sub-box
- **Time**: O(9^(empty cells))

### 4. M-Coloring
- **Problem**: Color graph with M colors so no adjacent nodes have same color
- **Approach**: Backtrack — try each color for each node

### 5. Rat in a Maze
- **Problem**: Find all paths from (0,0) to (n-1,n-1) in a maze
- **Approach**: Backtrack in all 4 directions, mark visited

### 6. Word Break (Print All Ways)
- **Problem**: Given string and dictionary, find all valid word breaks
- **Approach**: Try every prefix, if in dictionary, recurse on remaining
