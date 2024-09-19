import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    
    // Initialize the board with numbers 1-9
    char num = '1';
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = num;
        num++;
      }
    }

    char player = 'X';
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);

    while (!gameOver) {
      printBoard(board);
      System.out.print("Player " + player + ", enter your move (1-9): ");
      int move = scanner.nextInt();
      System.out.println();

      int row = -1, col = -1;
      switch (move) {
        case 1: row = 0; col = 0; break;
        case 2: row = 0; col = 1; break;
        case 3: row = 0; col = 2; break;
        case 4: row = 1; col = 0; break;
        case 5: row = 1; col = 1; break;
        case 6: row = 1; col = 2; break;
        case 7: row = 2; col = 0; break;
        case 8: row = 2; col = 1; break;
        case 9: row = 2; col = 2; break;
        default:
          System.out.println("Invalid move. Try again!");
          continue; // Skip the rest of the loop and ask for input again
      }

      if (board[row][col] != 'X' && board[row][col] != 'O') {
        board[row][col] = player; // place the element
        gameOver = haveWon(board, player);
        if (gameOver) {
          System.out.println("Player " + player + " has won!");
        } else {
          // Switch player using ternary operator
          player = (player == 'X') ? 'O' : 'X';
        }
      } else {
        System.out.println("Invalid move. Try again!");
      }
    }
    printBoard(board);
  }

  public static boolean haveWon(char[][] board, char player) {
    // check the rows
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }

    // check for col
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }

    // diagonal
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    return false;
  }

  public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " | ");
      }
      System.out.println();
    }
  }
}
