# 📅 Day 12: Bit Manipulation (Optional)

## Topics Covered
1. Check if a Number is Power of 2
2. Count Total Set Bits
3. Divide Integers Without / Operator
4. Power Set ⭐
5. Find MSB in O(1)
6. Find Square Without Multiplication/Division

---

## 📝 Notes

### 1. Power of 2
- **Check**: `n > 0 && (n & (n-1)) == 0`
- **Why**: Power of 2 has exactly one set bit. `n-1` flips all bits after that.
- **Time**: O(1)

### 2. Count Set Bits
- **Brian Kernighan's Algorithm**: `n = n & (n-1)` removes last set bit
- **Time**: O(log n)

### 3. Divide Without / Operator
- **Approach**: Repeatedly subtract divisor × powers of 2
- Use bit shifting: `divisor << i`
- **Time**: O(log²n)

### 4. Power Set ⭐ (Very Important)
- **Problem**: Generate all subsets using bit manipulation
- **Approach**: For 2^n subsets (0 to 2^n - 1):
  - If bit j is set in i, include arr[j] in subset
- **Time**: O(2^n × n)

### 5. Find MSB (Most Significant Bit)
- **Approach**: `Integer.highestOneBit(n)` or bit manipulation
- **Time**: O(1)

### 6. Square Without × or ÷
- **Approach**: `n² = sum of first n odd numbers` → 1+3+5+...+(2n-1)
- Or use bit shifting
