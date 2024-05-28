import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
        play(board);
    }

    public static void play(char[][] board) {
        boolean isGameOver = false;
        boolean isPlayer = true;
        while (!isGameOver) {
            char player = isPlayer ? 'X' : 'O';
            if (!isBoardFull(board)) {
                System.out.println();
                displayBoard(board);
                boolean success = takeUserInput(board, player);
                if (success) {
                    isGameOver = haveWon(board);
                    if (isGameOver) {
                        System.out.println("\n" + player + " wins!");
                        displayBoard(board);
                    } else {
                        isPlayer = !isPlayer;
                    }
                }
            } else {
                isGameOver = true;
            }
        }
        System.out.println("\nGame Over!");
    }

    private static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    private static boolean haveWon(char[][] board) {
        // check for rows
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) return true;
        }

        // check for columns
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) return true;
        }

        // check for diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) return true;
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) return true;

        return false;
    }

    private static boolean takeUserInput(char[][] board, char player) {
        Scanner sc = new Scanner(System.in);
        System.out.println(player + "'s Move?");
        System.out.print("Row: ");
        int row = sc.nextInt();
        System.out.print("Column: ");
        int col = sc.nextInt();
        if (row > 0  && col > 0 && row <= board.length && col <= board.length) {
            if (board[row-1][col-1] == ' ') {
                board[row-1][col-1] = player;
                return true;
            }
        }
        System.out.println("Invalid move!");
        return false;
    }

    public static void displayBoard(char[][] board) {
        for (char[] row: board) {
            for(int i = 0; i < row.length; i++) {
                String separator = i != row.length - 1 ? " | " : "";
                System.out.print(row[i] + separator);
            }
            System.out.println();
        }
    }
}
