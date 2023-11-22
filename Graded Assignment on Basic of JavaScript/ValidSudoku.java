const board = [
  ["5", "3", ".", ".", "7", ".", ".", ".", "."],
  ["6", ".", ".", "1", "9", "5", ".", ".", "."],
  [".", "9", "8", ".", ".", ".", ".", "6", "."],
  ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
  ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
  ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
  [".", "6", ".", ".", ".", ".", "2", "8", "."],
  [".", ".", ".", "4", "1", "9", ".", ".", "5"],
  [".", ".", ".", ".", "8", ".", ".", "7", "9"],
];

function isValidSudoku(board) {
  // Check each row for valid numbers
  for (let row = 0; row < 9; row++) {
    const rowSet = new Set();

    for (let col = 0; col < 9; col++) {
      const num = board[row][col];

      if (num !== ".") {
        if (rowSet.has(num)) {
          return false;
        }

        rowSet.add(num);
      }
    }
  }

  // Check each column for valid numbers
  for (let col = 0; col < 9; col++) {
    const colSet = new Set();

    for (let row = 0; row < 9; row++) {
      const num = board[row][col];

      if (num !== ".") {
        if (colSet.has(num)) {
          return false;
        }

        colSet.add(num);
      }
    }
  }

  // Check each 3x3 sub-box for valid numbers
  for (let subBoxRow = 0; subBoxRow < 3; subBoxRow++) {
    for (let subBoxCol = 0; subBoxCol < 3; subBoxCol++) {
      const subBoxSet = new Set();

      for (let row = 3 * subBoxRow; row < 3 * subBoxRow + 3; row++) {
        for (let col = 3 * subBoxCol; col < 3 * subBoxCol + 3; col++) {
          const num = board[row][col];

          if (num !== ".") {
            if (subBoxSet.has(num)) {
              return false;
            }

            subBoxSet.add(num);
          }
        }
      }
    }
  }

  return true;
}

const isValid = isValidSudoku(board);
console.log(isValid);
