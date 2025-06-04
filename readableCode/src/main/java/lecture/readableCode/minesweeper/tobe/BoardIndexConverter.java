package lecture.readableCode.minesweeper.tobe;

public class BoardIndexConverter {

    private static final char BASE_CHAR_FOR_COL = 'a';

    public int getSelectedRowIndex(String cellInput, int rowSize) {

        String cellInputRow = cellInput.substring(1);
        return convertRowFrom(cellInputRow, rowSize);
    }

    public int getSelectedColIndex(String cellInput, int colSize) {

        char cellInputCol = cellInput.charAt(0);
        return convertColFrom(cellInputCol, colSize);
    }

    private int convertRowFrom(String cellInputRow, int rowSize) {

        int rowIndex = Integer.parseInt(cellInputRow) - 1;
        checkLength(rowSize, rowIndex);
        return rowIndex;
    }

    private int convertColFrom(char cellInputCol, int colSize) {

        int colIndex = cellInputCol - BASE_CHAR_FOR_COL;
        checkLength(colSize, colIndex);
        return colIndex;
    }

    private static void checkLength(int size, int index) {
        if (index < 0 || index > size) {
            throw new GameException("잘못된 입력입니다.");
        }
    }
}
