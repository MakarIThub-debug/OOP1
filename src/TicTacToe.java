import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static class Player {
        private String name;
        private char mark;

        public Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public char getMark() {
            return mark;
        }
    }

    public static class Game {
        private char[][] board;
        private Player player1;
        private Player player2;
        private int moves;
        private final int size = 3; // Size of the board

        public Game(Player player1, Player player2) {
            this.board = new char[size][size];
            for (char[] row : board) {
                Arrays.fill(row, ' ');
            }
            this.player1 = player1;
            this.player2 = player2;
            this.moves = 0;
        }


        public void printBoard() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        public boolean makeMove(Player player, int row, int col) {
            if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                return false;
            }
            board[row][col] = player.getMark();
            moves++;
            return true;
        }

        public boolean isGameOver() {
            return checkWin() || moves == size * size; // Check if game is over
        }

        public boolean checkWin() {
            return checkRows() || checkCols() || checkDiagonals();
        }


        private boolean checkRows() {
            for (char[] row : board) {
                if (row[0] == row[1] && row[1] == row[2] && row[0] != ' ') return true;
            }
            return false;
        }

        private boolean checkCols() {
            for (int i = 0; i < size; i++) {
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') return true;
            }
            return false;
        }

        private boolean checkDiagonals() {
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                    (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
                return true;
            }
            return false;
        }

        public void play() {
            Scanner scanner = new Scanner(System.in);
            Player currentPlayer = player1;
            while (!isGameOver()) {
                printBoard();
                System.out.println(currentPlayer.getName() + "'s turn (enter row and column, 0-2):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (makeMove(currentPlayer, row, col)) {
                    if(currentPlayer == player1){
                        currentPlayer = player2;
                    } else{
                        currentPlayer = player1;
                    }
                }
            }
            printBoard();
            if (checkWin()){
                System.out.println(currentPlayer == player1 ? player2.getName() : player1.getName() + " won!");
            }else{
                System.out.println("Draw!");
            }

        }


    }

    public static void main(String[] args) {
        Player playerX = new Player("Player X", 'X');
        Player playerO = new Player("Player O", 'O');
        Game game = new Game(playerX, playerO);
        game.play();
    }
}
