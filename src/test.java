

public class test {
    public static void main(String[] args) {
        Board board = new Board(5);
        board.getBoard()[0][0].setValue(2048);
        board.getBoard()[0][1].setValue(1024);
        board.getBoard()[0][2].setValue(512);
        board.getBoard()[0][3].setValue(256);
        board.getBoard()[0][4].setValue(128);
        new GUIBoard(board);
        board.print();
        System.out.println(board.getGrids());
    }
}