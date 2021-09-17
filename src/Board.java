/**
 * board class is in charge of the game mechanics a.k.a
 * when the game is over or win; how the tiles would move if a key
 * is pressed and the addition of the tiles
 */
public class Board {

    private Tile[][] board;

    private int grids;

    private int border;

    private int score;

    private int highTile;

    /**
     * creates a standard 2048 board (4 grids)
     */
    public Board() {
        score = 0;
        border = 0;
        grids = 4;
        highTile = 0;
        board = new Tile[grids][grids];

        for (int i = 0; i < grids; i++) {
            for (int j = 0; j < grids; j++) {
                board[i][j] = new Tile();
            }
        }
    }

    /**
     * creates a board according to the grids size
     * @param grids
     */
    public Board(int grids) {
        score = 0;
        border = 0;
        this.grids = grids;
        board = new Tile[grids][grids];

        for (int i = 0; i < grids; i++) {
            for (int j = 0; j < grids; j++) {
                board[i][j] = new Tile();
            }
        }
    }

    /**
     * returns board
     * @return
     */
    public Tile[][] getBoard() {
        return board;
    }

    /**
     * returns score
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * returns number of grids/tiles per row
     * @return
     */
    public int getGrids() {
        return grids;
    }

    /**
     * returns highest tile value
     * @return
     */
    public int getHighTile() {
        return highTile;
    }

    /**
     * prints the board
     */
    public void print() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i][0].getValue());
            for (int j = 1; j < board[i].length; j++) {
                System.out.print(" " + board[i][j].getValue());
            }
            System.out.println();
        }
    }

    /**
     * board in string form
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < board.length; i++) {
            s += board[i][0];
            for (int j = 1; j < board[i].length; j++) {
                s += " " + board[i][j];
            }
            s += "\n";
        }
        return s;
    }

    /**
     * spawns a tile that is not value = 0
     */
    public void spawn() {
        boolean state = true;

        while (state) {
            int row = (int)(Math.random() * this.grids);
            int col = (int)(Math.random() * this.grids);
            double x = Math.random();

            if (board[row][col].getValue() == 0) {
                if (x <= 0.1) {
                    board[row][col].setValue(4);
                } else {
                    board[row][col].setValue(2);
                }
                state = false;
            }
        }
    }

    /**
     * checks to see if user has won
     * @return true if win
     */
    public boolean win() {
        return this.getHighTile() == 2048;
    }

    /**
     * checks if game is over
     * @return false if user lost
     */
    public boolean gameOver() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() == 0) {
                    return false;
                }

                if (i == 0) {
                    if (j == 0) {
                        if (board[i][j].getValue() == board[i + 1][j].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i][j + 1].getValue()) {
                            return false;
                        }
                    } else if (j == grids - 1) {
                        if (board[i][j].getValue() == board[i + 1][j].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i][j - 1].getValue()) {
                            return false;
                        }
                    } else {
                        if (board[i][j].getValue() == board[i + 1][j].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i][j + 1].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i][j - 1].getValue()) {
                            return false;
                        }
                    }
                } else if (i == grids - 1) {
                    if (j == 0) {
                        if (board[i][j].getValue() == board[i - 1][j].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i][j + 1].getValue()) {
                            return false;
                        }
                    } else if (j == grids - 1) {
                        if (board[i][j].getValue() == board[i - 1][j].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i][j - 1].getValue()) {
                            return false;
                        }
                    } else {
                        if (board[i][j].getValue() == board[i][j - 1].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i - 1][j].getValue()) {
                            return false;
                        } else if (board[i][j].getValue() == board[i][j + 1].getValue()) {
                            return false;
                        }
                    }
                } else if (j == 0) {
                    if (board[i][j].getValue() == board[i - 1][j].getValue()) {
                        return false;
                    } else if (board[i][j].getValue() == board[i][j + 1].getValue()) {
                        return false;
                    } else if (board[i][j].getValue() == board[i + 1][j].getValue()) {
                        return false;
                    }
                } else if (j == grids - 1) {
                    if (board[i][j].getValue() == board[i - 1][j].getValue()) {
                        return false;
                    } else if (board[i][j].getValue() == board[i][j - 1].getValue()) {
                        return false;
                    } else if (board[i][j].getValue() == board[i + 1][j].getValue()) {
                        return false;
                    }
                } else {
                    if (board[i][j].getValue() == board[i - 1][j].getValue()) {
                        return false;
                    } else if (board[i][j].getValue() == board[i][j + 1].getValue()) {
                        return false;
                    } else if (board[i][j].getValue() == board[i + 1][j].getValue()) {
                        return false;
                    } else if (board[i][j].getValue() == board[i][j - 1].getValue()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * for upward movement
     */
    public void up() {
        for (int i = 0; i < grids; i++) {
            border = 0;

            for (int j = 0; j < grids; j++) {
                if (board[j][i].getValue() != 0) {
                    verticalMove(j, i, "up");
                }
            }
        }
    }

    /**
     * for downward movement
     */
    public void down() {
        for (int i = 0; i < grids; i++) {
            border = grids - 1;

            for (int j = grids - 1; j >= 0 ; j--) {
                if (board[j][i].getValue() != 0) {
                    verticalMove(j, i, "down");
                }
            }
        }
    }

    /**
     * left movement
     */
    public void left() {
        for (int i = 0; i < grids; i++) {
            border = 0;
            
            for (int j = 0; j < grids; j++) {
                if (board[i][j].getValue() != 0) {
                    horizontalMove(i, j, "left");
                }
            }
        }
    }

    /**
     * right movement
     */
    public void right() {
        for (int i = 0; i < grids; i++) {
            border = grids - 1;
            
            for (int j = grids - 1; j >= 0; j--) {
                if (board[i][j].getValue() != 0) {
                    horizontalMove(i, j, "right");
                }
            }
        }
    }

    private void horizontalMove(int row, int col, String direction) {
        Tile initial = board[row][border];
        Tile compare = board[row][col];

        if (initial.getValue() == 0 || (initial.getValue() == compare.getValue())) {
            if (border < col || (direction.equals("right") && border > col)) {
                int sum = initial.getValue() + compare.getValue();
                if (initial.getValue() != 0) {
                    score += sum;
                    initial.setValue(sum);
                    if (direction.equals("right")) {
                        border--;
                    } else {
                        border++;
                    }
                } else {
                    initial.setValue(sum);
                }

                if (sum > highTile) {
                    highTile = sum;
                }

                compare.setValue(0);
            }
        } else {
            if (direction.equals("right")) {
                border--;
            } else {
                border++;
            }

            horizontalMove(row, col, direction);
        }
    }

    private void verticalMove(int row, int col, String direction) {
        Tile initial = board[border][col];
        Tile compare = board[row][col];

        if (initial.getValue() == 0 || initial.getValue() == compare.getValue()) {
            if (row > border || (direction.equals("down") && row < border)) {
                int sum = initial.getValue() + compare.getValue();
    
                if (initial.getValue() != 0) {
                    score += sum;
                    initial.setValue(sum);
                    if (direction.equals("down")) {
                        border--;
                    } else {
                        border++;
                    }
                } else {
                    // looks redundant, but it's not cause border will increase/decrease in if case
                    initial.setValue(sum);
                }

                if (sum > highTile) {
                    highTile = sum;
                }

                compare.setValue(0);
            }
        } else {
            if (direction.equals("down")) {
                border--;
            } else {
                border++;
            }

            verticalMove(row, col, direction);
        }
    }
}
