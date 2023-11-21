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
  for (let i = 0; i < 9; i++) {
    const row = new Set();
    const col = new Set();

    for (let j = 0; j < 9; j++) {
      const num = board[i][j];
      if (num !== ".") {
        if (row.has(num) || col.has(num)) {
          return false;
        }

        row.add(num);
        col.add(num);
      }
    }
  }

  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      const subBox = new Set();

      for (let k = 3 * i; k < 3 * i + 3; k++) {
        for (let l = 3 * j; l < 3 * j + 3; l++) {
          const num = board[k][l];
          if (num !== ".") {
            if (subBox.has(num)) {
              return false;
            }

            subBox.add(num);
          }
        }
      }
    }
  }

  return true;
}

const valid = isValidSudoku(board);
console.log(valid);
