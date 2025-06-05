package lecture.readableCode.minesweeper.tobe.minesweeper.io;

import lecture.readableCode.minesweeper.tobe.minesweeper.exception.GameException;

public class BoardIndexConverter {

    private static final char BASE_CHAR_FOR_COL = 'a';

    public int getSelectedRowIndex(String cellInput) {

        String cellInputRow = cellInput.substring(1);
        return convertRowFrom(cellInputRow);
    }

    public int getSelectedColIndex(String cellInput) {

        char cellInputCol = cellInput.charAt(0);
        return convertColFrom(cellInputCol);
    }

    private int convertRowFrom(String cellInputRow) {
        int rowIndex = Integer.parseInt(cellInputRow) - 1;
        checkLength(rowIndex);
        return rowIndex;
    }

    private int convertColFrom(char cellInputCol) {

        int colIndex = cellInputCol - BASE_CHAR_FOR_COL;
        checkLength(colIndex);
        return colIndex;
    }

    private static void checkLength(int index) {
        if (index < 0) {
            throw new GameException("잘못된 입력입니다.");
        }
    }
}
