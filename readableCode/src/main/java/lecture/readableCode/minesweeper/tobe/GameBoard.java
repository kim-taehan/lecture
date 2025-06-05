package lecture.readableCode.minesweeper.tobe;

import lecture.readableCode.minesweeper.tobe.cell.Cell;
import lecture.readableCode.minesweeper.tobe.cell.EmptyCell;
import lecture.readableCode.minesweeper.tobe.cell.LandMineCell;
import lecture.readableCode.minesweeper.tobe.cell.NumberCell;
import lecture.readableCode.minesweeper.tobe.gamelevel.GameLevel;
import lecture.readableCode.minesweeper.tobe.position.CellPosition;
import lecture.readableCode.minesweeper.tobe.position.RelativePosition;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static lecture.readableCode.minesweeper.tobe.position.RelativePosition.SURROUND_POSITIONS;

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

    public GameBoard(GameLevel gameLevel) {
        board = new Cell[gameLevel.getRowSize()][gameLevel.getColSize()];
        this.landMineCount = gameLevel.getLandMineCount();
        this.rowSize = gameLevel.getRowSize();
        this.colSize = gameLevel.getColSize();
    }

    public void initializeGame() {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                board[row][col] = new EmptyCell();
            }
        }

        for (int i = 0; i < landMineCount; i++) {
            int col = new Random().nextInt(colSize);
            int row = new Random().nextInt(rowSize);
            board[row][col] = new LandMineCell();
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                CellPosition cellPosition = CellPosition.of(row, col);
                if (isLandMineCellAt(cellPosition)) {
                    continue;
                }
                int count = countNearByLandMines(cellPosition);
                if(count == 0) continue;

                board[row][col] = new NumberCell(count);
            }
        }
    }

    public boolean isLandMineCellAt(CellPosition cellPosition) {
        Cell cell = findCell(cellPosition);
        return cell.isLandMine();
    }

    public boolean isInvalidCellPosition(CellPosition cellPosition) {
        return cellPosition.isRowIndexMoreThanOrEqual(rowSize)
                || cellPosition.isColIndexMoreThanOrEqual(colSize);
    }

    public void flagAt(CellPosition cellPosition) {
        Cell cell = findCell(cellPosition);
        cell.flag();
    }

    public void openAt(CellPosition cellPosition) {
        Cell cell = this.findCell(cellPosition);
        cell.open();
    }

    public boolean isAllChecked() {
        return Arrays.stream(board)
                .flatMap(Arrays::stream)
                .allMatch(Cell::isChecked);
    }

    public void openSurroundedCells(CellPosition cellPosition) {

        if (isOpenedCell(cellPosition)) {
            return;
        }
        if (isLandMineCellAt(cellPosition)) {
            return;
        }
        openAt(cellPosition);
        if (doesCellHaveLandMineCount(cellPosition)) {
            return;
        }

        List<CellPosition> cellPositions = calculateSurroundedPositions(cellPosition);
        cellPositions.forEach(this::openSurroundedCells);
    }

    private boolean canMovePosition(CellPosition cellPosition, RelativePosition relativePosition) {
        return cellPosition.canCalculatePositionBy(relativePosition);
    }

    private boolean doesCellHaveLandMineCount(CellPosition cellPosition) {
        Cell cell = this.findCell(cellPosition);
        return cell.hasLandMineCount();
    }

    private boolean isOpenedCell(CellPosition cellPosition) {
        Cell cell = this.findCell(cellPosition);
        return cell.isOpened();
    }

    public String getSignAt(CellPosition cellPosition) {
        Cell cell = findCell(cellPosition);
        return cell.getSign();
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }

    private Cell findCell(CellPosition cellPosition) {
        return board[cellPosition.getRowIndex()][cellPosition.getColIndex()];
    }

    private int countNearByLandMines(CellPosition cellPosition) {

        return (int) calculateSurroundedPositions(cellPosition)
                .stream()
                .filter(this::isLandMineCellAt)
                .count();
    }

    private List<CellPosition> calculateSurroundedPositions(CellPosition cellPosition) {
        return SURROUND_POSITIONS.stream()
                .filter(cellPosition::canCalculatePositionBy)
                .map(cellPosition::calculatePositionBy)
                .filter(position -> position.isRowIndexLessThan(rowSize))
                .filter(position -> position.isColIndexLessThan(colSize)).toList();
    }
}
