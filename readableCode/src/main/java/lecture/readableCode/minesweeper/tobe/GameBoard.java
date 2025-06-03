package lecture.readableCode.minesweeper.tobe;

import java.util.Arrays;
import java.util.Random;

public class GameBoard {
    private final Cell[][] board;

    private final int landMineCount;
    private final int rowSize;
    private final int colSize;
    public GameBoard(int rowSize, int colSize, int landMineCount) {
        board = new Cell[rowSize][colSize];
        this.landMineCount = landMineCount;
        this.rowSize = rowSize;
        this.colSize = colSize;
    }

    public void initializeGame() {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                board[row][col] = Cell.create();
            }
        }

        for (int i = 0; i < landMineCount; i++) {
            int col = new Random().nextInt(colSize);
            int row = new Random().nextInt(rowSize);
            Cell cell = getCell(row, col);
            cell.turnOnLandMine();
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (isLandMineCell(row, col)) {
                    continue;
                }
                Cell cell = findCell(row, col);
                int count = countNearByLandMines(row, col);
                cell.updateNearByLandMineCount(count);
            }
        }
    }

    public boolean isLandMineCell(int rowIndex, int colIndex) {
        Cell cell = findCell(rowIndex, colIndex);
        return cell.isLandMine();
    }

    private Cell getCell(int rowIndex, int colIndex) {
        return findCell(rowIndex, colIndex);
    }

    public void flag(int rowIndex, int colIndex) {
        Cell cell = findCell(rowIndex, colIndex);
        cell.flag();
    }

    public void open(int rowIndex, int colIndex) {
        Cell cell = this.findCell(rowIndex, colIndex);
        cell.open();
    }

    public boolean isAllChecked() {
        return Arrays.stream(board)
                .flatMap(Arrays::stream)
                .allMatch(Cell::isChecked);
    }

    public void openSurroundedCells(int rowIndex, int colIndex) {

        if (rowIndex < 0 || rowIndex >= rowSize || colIndex < 0 || colIndex >= colSize) {
            return;
        }
        if (isOpenedCell(rowIndex, colIndex)) {
            return;
        }
        if (isLandMineCell(rowIndex, colIndex)) {
            return;
        }
        open(rowIndex,colIndex);
        if (doesCellHaveLandMineCount(rowIndex, colIndex)) {
            return;
        }
        openSurroundedCells(rowIndex - 1, colIndex - 1);
        openSurroundedCells(rowIndex - 1, colIndex);
        openSurroundedCells(rowIndex - 1, colIndex + 1);
        openSurroundedCells(rowIndex, colIndex - 1);
        openSurroundedCells(rowIndex, colIndex + 1);
        openSurroundedCells(rowIndex + 1, colIndex - 1);
        openSurroundedCells(rowIndex + 1, colIndex);
        openSurroundedCells(rowIndex + 1, colIndex + 1);
    }

    private boolean doesCellHaveLandMineCount(int rowIndex, int colIndex) {
        return this.findCell(rowIndex, colIndex).hasLandMineCount();
    }

    private boolean isOpenedCell(int rowIndex, int colIndex) {
        return this.findCell(rowIndex, colIndex).isOpened();
    }

    public String getSign(int rowIndex, int colIndex) {
        Cell cell = findCell(rowIndex, colIndex);
        return cell.getSign();
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }

    private Cell findCell(int row, int col) {
        return board[row][col];
    }

    private int countNearByLandMines(int row, int col) {
        int count = 0;
        if (row - 1 >= 0 && col - 1 >= 0 && isLandMineCell(row - 1, col - 1)) {
            count++;
        }
        if (row - 1 >= 0 && isLandMineCell(row - 1, col)) {
            count++;
        }
        if (row - 1 >= 0 && col + 1 < colSize && isLandMineCell(row - 1, col + 1)) {
            count++;
        }
        if (col - 1 >= 0 && isLandMineCell(row, col - 1)) {
            count++;
        }
        if (col + 1 < colSize && isLandMineCell(row, col + 1)) {
            count++;
        }
        if (row + 1 < rowSize && col - 1 >= 0 && isLandMineCell(row + 1, col - 1)) {
            count++;
        }
        if (row + 1 < rowSize && isLandMineCell(row + 1, col)) {
            count++;

        }
        if (row + 1 < rowSize && col + 1 < colSize && isLandMineCell(row + 1, col + 1)) {
            count++;
        }
        return count;
    }

}
