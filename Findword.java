public Findword {

  //call this method
  public static ScrabbleWord findWord(char[][] board) {
    for (int row = 0; row < board.length; row ++) {
        for (int col = 0; col < board.length; col++) {
            if (board[row][col] != ' ') {
                char orientation;
                if (board[row][col + 1] != ' ') {
                    orientation = 'h';
                } else if (board[row + 1][col] != ' ') {
                    orientation = 'v';
                } else {
                    orientation = 'o';

                }
                String word = getWord(orientation, board, row, col);
                return new ScrabbleWord(word, row, col, orientation);
            }
        }
    }
    return null;
  }

  //this method only supports findWord
  public static String getWord(char orientation, char[][] board, int row, int col) {
      if (orientation == 'h') {
          int wordSize = board.length - col;
          String word = "";
          for (int c = 0; c < wordSize; c++) {
              word = word.concat(Character.toString(board[row][col + c]));
          }
          return word;
      } else if (orientation == 'v'){
          int wordSize = board.length - row;
          String word = "";
          for (int r = 0; r < wordSize; r++) {
              word = word.concat(Character.toString(board[row + r][col]));
          }
          return word;
      } else {
          return Character.toString(board[row][col]);
      }
  }
}
