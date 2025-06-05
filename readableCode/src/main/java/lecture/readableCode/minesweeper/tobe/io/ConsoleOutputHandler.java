package lecture.readableCode.minesweeper.tobe.io;

import lecture.readableCode.minesweeper.tobe.GameBoard;
import lecture.readableCode.minesweeper.tobe.cell.CellSnapshot;
import lecture.readableCode.minesweeper.tobe.cell.CellSnapshotStatus;
import lecture.readableCode.minesweeper.tobe.position.CellPosition;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputHandler implements OutputHandler {

    private static final String EMPTY_SIGN = "■";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String FLAG_SIGN = "⚑";
    private static final String UNCHECKED_SIGN = "□";

    @Override
    public void showGameStartComments() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("지뢰찾기 게임 시작!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void showBoard(GameBoard board) {

        List<String> alphabets = generateColAlphabet(board);
        String joiningAlphabet = String.join(" ", alphabets);
        System.out.println("    " + joiningAlphabet);

        for (int row = 0; row < board.getRowSize(); row++) {
            System.out.printf("%2d  ", row + 1);
            for (int col = 0; col < board.getColSize(); col++) {
                CellPosition cellPosition = CellPosition.of(row, col);

                CellSnapshot snapshot = board.getSnapshot(cellPosition);
                String cellSign = decideCellSignFrom(snapshot);
                System.out.print(cellSign  + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private String decideCellSignFrom(CellSnapshot snapshot) {

        CellSnapshotStatus status = snapshot.getStatus();
        if (status == CellSnapshotStatus.EMPTY) {
            return EMPTY_SIGN;
        }
        if (status == CellSnapshotStatus.FLAG) {
            return FLAG_SIGN;
        }
        if (status == CellSnapshotStatus.LAND_MINE) {
            return LAND_MINE_SIGN;
        }
        if (status == CellSnapshotStatus.NUMBER) {
            return String.valueOf(snapshot.getNearByLandMineCount());
        }
        if (status == CellSnapshotStatus.UNCHECKED) {
            return UNCHECKED_SIGN;
        }
        throw new IllegalArgumentException("확인할 수 없는 cell 입니다.");
    }

    private List<String> generateColAlphabet(GameBoard board) {
        return IntStream.range(0, board.getColSize())
                .mapToObj(index -> (char) ('a' + index))
                .map(Object::toString)
                .toList();
    }

    @Override
    public void showGameWinningComment() {
        System.out.println("지뢰를 모두 찾았습니다. GAME CLEAR!");
    }

    @Override
    public void showGameLosingComment() {
        System.out.println("지뢰 터졌습니다.. GAME OVER!");

    }

    @Override
    public void showCommentForSelectingCell() {
        System.out.println("선택할 좌표를 입력하세요. (예: a1)");
    }

    @Override
    public void showCommentForUserAction() {
        System.out.println("선택한 셀에 대한 행위를 선택하세요. (1: 오픈, 2: 깃발 꽂기)");
    }

    @Override
    public void showExceptionMessage(Exception exception) {
        System.out.println("e.getMessage() = " + exception.getMessage());
    }

    @Override
    public void showSimpleMessage(String message) {
        System.out.println(message);
    }
}
