# 📅 Day 2: Arrays (Continued)

## Topics Covered
1. Set Matrix Zeros
2. Pascal's Triangle
3. Next Permutation
4. Inversion of Array (Using Merge Sort)
5. Stock Buy and Sell
6. Rotate Matrix (90 degrees)

---

## 📝 Notes

### 1. Set Matrix Zeros
- **Problem**: If an element is 0, set its entire row and column to 0.
- **Approach (Optimal — O(1) space)**:
  - Use first row and first column as markers
  - Use a separate variable `col0` to track if first column should be zero
  - First pass: mark rows/cols that need to be zero
  - Second pass (reverse): fill zeros based on markers
- **Time Complexity**: O(m × n)
- **Space Complexity**: O(1)

### 2. Pascal's Triangle
- **Problem**: Generate Pascal's Triangle up to N rows.
- **Key Property**: `triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]`
- **Variations**:
  - Print entire triangle
  - Print nth row
  - Find element at position (r, c) → `C(r-1, c-1)`
- **Time Complexity**: O(n²)

### 3. Next Permutation
- **Problem**: Find the next lexicographically greater permutation.
- **Algorithm**:
  1. Find breakpoint: rightmost `i` where `arr[i] < arr[i+1]`
  2. Find swap point: rightmost `j` where `arr[j] > arr[i]`
  3. Swap arr[i] and arr[j]
  4. Reverse everything after index `i`
- **Time Complexity**: O(n)

### 4. Inversion of Array
- **Problem**: Count inversions where `i < j` but `arr[i] > arr[j]`.
- **Approach**: Modified Merge Sort
  - While merging, if `left[i] > right[j]`, count += (mid - i + 1)
- **Time Complexity**: O(n log n)

### 5. Stock Buy and Sell
- **Problem**: Find maximum profit from buying and selling a stock once.
- **Approach**: Track minimum price so far, calculate profit at each step
- **Time Complexity**: O(n)

### 6. Rotate Matrix 90°
- **Problem**: Rotate an N×N matrix 90 degrees clockwise in-place.
- **Approach**: Transpose + Reverse each row
- **Time Complexity**: O(n²)

---

## 🔗 Video Resources
- [Set Matrix Zeros](https://www.youtube.com/watch?v=M65xBewcqcI)
- [Pascal Triangle](https://www.youtube.com/watch?v=6FLvhQjZqvM)
- [Next Permutation](https://www.youtube.com/watch?v=LuLCLgMElus)
- [Inversion of Array](https://www.youtube.com/watch?v=kQ1mJlwW-c0)
- [Stock Buy and Sell](https://www.youtube.com/watch?v=eMSfBgbiEjk)
- [Rotate Matrix](https://www.youtube.com/watch?v=Y72QeX0Efxw)
