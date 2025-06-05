package lecture.readableCode.minesweeper.tobe;

import lecture.readableCode.minesweeper.tobe.cell.*;
import lecture.readableCode.minesweeper.tobe.gamelevel.GameLevel;
import lecture.readableCode.minesweeper.tobe.position.CellPosition;
import lecture.readableCode.minesweeper.tobe.position.CellPositions;
import lecture.readableCode.minesweeper.tobe.position.RelativePosition;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static lecture.readableCode.minesweeper.tobe.position.RelativePosition.SURROUND_POSITIONS;

public class GameBoard {
    private final Cell[][] board;

    private final int landMineCount;
    private final int rowSize;
    private final int colSize;
    private GameStatus gameStatus;

    public GameBoard(GameLevel gameLevel) {
        board = new Cell[gameLevel.getRowSize()][gameLevel.getColSize()];
        this.landMineCount = gameLevel.getLandMineCount();
        this.rowSize = gameLevel.getRowSize();
        this.colSize = gameLevel.getColSize();
        initializeGameStatus();
    }
    public void initializeGame() {

        initializeGameStatus();

        CellPositions cellPositions = CellPositions.from(board);

        initializeEmptyCells(cellPositions);

        List<CellPosition> landMineCellPositions = cellPositions.extractRandomPositions(landMineCount);
        initializeLandMineCells(landMineCellPositions);

        List<CellPosition> numberPositionCandidates = cellPositions.subtract(landMineCellPositions);
        initializeNumberCells(numberPositionCandidates);
    }

    private void initializeGameStatus() {
        gameStatus = GameStatus.IN_PROGRESS;
    }

    private void initializeNumberCells(List<CellPosition> numberPositionCandidates) {
        for (CellPosition candidatePosition : numberPositionCandidates) {
            int count = countNearByLandMines(candidatePosition);
            if (count != 0) {
                updateCellAt(candidatePosition, () -> new NumberCell(count));
            }
        }
    }

    private void initializeLandMineCells(List<CellPosition> landMineCellPositions) {
        updateCellsAt(landMineCellPositions, LandMineCell::new);
    }

    private void initializeEmptyCells(CellPositions cellPositions) {
        List<CellPosition> allPositions = cellPositions.getPositions();
        updateCellsAt(allPositions, EmptyCell::new);
    }

    private void updateCellsAt(List<CellPosition> allPositions, Supplier<Cell> supplierForCell) {
        for (CellPosition position : allPositions) {
            updateCellAt(position, supplierForCell);
        }
    }

    private void updateCellAt(CellPosition position, Supplier<Cell> supplierForCell) {
        board[position.getRowIndex()][position.getColIndex()] = supplierForCell.get();
    }

    public boolean isLandMineCellAt(CellPosition cellPosition) {
        Cell cell = findCell(cellPosition);
        return cell.isLandMine();
    }

    public boolean isInvalidCellPosition(CellPosition cellPosition) {
        return cellPosition.isRowIndexMoreThanOrEqual(rowSize)
                || cellPosition.isColIndexMoreThanOrEqual(colSize);
    }

    public CellSnapshot getSnapshot(CellPosition cellPosition) {
        Cell cell = findCell(cellPosition);
        return cell.getSnapshot();
    }

    public void flagAt(CellPosition cellPosition) {
        Cell cell = findCell(cellPosition);
        cell.flag();

        checkIfGameIsOver();
    }

    private  void checkIfGameIsOver() {
        if (isAllChecked()) {
            changeGameStatusToWin();
        }
    }



    private void changeGameStatusTOLose() {
        gameStatus = GameStatus.LOSE;
    }
    private void changeGameStatusToWin() {
        gameStatus = GameStatus.WIN;
    }

    public void openOneCellAt(CellPosition cellPosition) {
        Cell cell = this.findCell(cellPosition);
        cell.open();
    }

    public boolean isAllChecked() {
        Cells cells = Cells.from(board);
        return cells.isAllChecked();
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


    public boolean isInProgress() {
        return gameStatus == GameStatus.IN_PROGRESS;
    }

    public void openAt(CellPosition cellPosition) {
        if (isLandMineCellAt(cellPosition)) {
            openOneCellAt(cellPosition);
            changeGameStatusTOLose();
            return;
        }

        openSurroundedCells(cellPosition);
        checkIfGameIsOver();
    }

    public boolean isWinStatus() {
        return gameStatus == GameStatus.WIN;
    }

    public boolean isLoseStatus() {
        return gameStatus == GameStatus.LOSE;
    }
}
