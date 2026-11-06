import java.util.Scanner;

public class MinMax {

    static final char AI = 'X';
    static final char HUMAN = 'O';
    static final char EMPTY = ' ';

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe – hraješ jako O");
        printBoard();

        while (true) {
            humanMove();
            printBoard();

            if (checkWinner(HUMAN)) {
                System.out.println("🎉 Vyhrál jsi!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("🤝 Remíza!");
                break;
            }

            System.out.println("AI přemýšlí...");
            makeBestMove();
            printBoard();

            if (checkWinner(AI)) {
                System.out.println("💀 AI vyhrála!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("🤝 Remíza!");
                break;
            }
        }
    }

    // ===== TAH HRÁČE =====
    static void humanMove() {
        int row, col;
        while (true) {
            System.out.print("Zadej řádek (0-2): ");
            row = sc.nextInt();
            System.out.print("Zadej sloupec (0-2): ");
            col = sc.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                board[row][col] = HUMAN;
                break;
            } else {
                System.out.println("❌ Neplatný tah, zkus znovu.");
            }
        }
    }

    // ===== TAH AI =====
    static void makeBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int moveRow = -1;
        int moveCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = AI;
                    int score = minimax(0, false);
                    board[i][j] = EMPTY;

                    if (score > bestScore) {
                        bestScore = score;
                        moveRow = i;
                        moveCol = j;
                    }
                }
            }
        }
        board[moveRow][moveCol] = AI;
    }

    // ===== MINIMAX =====
    static int minimax(int depth, boolean isMaximizing) {

        if (checkWinner(AI)) return 10 - depth;
        if (checkWinner(HUMAN)) return depth - 10;
        if (isBoardFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = AI;
                        int score = minimax(depth + 1, false);
                        board[i][j] = EMPTY;
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = HUMAN;
                        int score = minimax(depth + 1, true);
                        board[i][j] = EMPTY;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    // ===== KONTROLY =====
    static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) return true;

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) return true;
        }

        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) return true;

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) return true;

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == EMPTY)
                    return false;
        return true;
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}
