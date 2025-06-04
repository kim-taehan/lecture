package lecture.readableCode.minesweeper.tobe.io;

import lecture.readableCode.minesweeper.tobe.GameBoard;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputHandler {

    public void showGameStartComments() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("지뢰찾기 게임 시작!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public void showBoard(GameBoard board) {

        List<String> alphabets = generateColAlphabet(board);
        String joiningAlphabet = String.join(" ", alphabets);
        System.out.println("    " + joiningAlphabet);

        for (int row = 0; row < board.getRowSize(); row++) {
            System.out.printf("%2d  ", row + 1);
            for (int col = 0; col < board.getColSize(); col++) {
                System.out.print(board.getSign(row,col)  + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private List<String> generateColAlphabet(GameBoard board) {
        return IntStream.range(0, board.getColSize())
                .mapToObj(index -> (char) ('a' + index))
                .map(Object::toString)
                .toList();
    }

    public void printGameWinningComment() {
        System.out.println("지뢰를 모두 찾았습니다. GAME CLEAR!");
    }

    public void printGameLosingComment() {
        System.out.println("지뢰 터졌습니다.. GAME OVER!");

    }

    public void printCommentForSelectingCell() {
        System.out.println("선택할 좌표를 입력하세요. (예: a1)");
    }

    public void printCommentForUserAction() {
        System.out.println("선택한 셀에 대한 행위를 선택하세요. (1: 오픈, 2: 깃발 꽂기)");
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println("e.getMessage() = " + exception.getMessage());
    }

    public void printSimpleMessage(String message) {
        System.out.println(message);
    }
}
