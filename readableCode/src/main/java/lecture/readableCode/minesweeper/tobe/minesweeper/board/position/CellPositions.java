package lecture.readableCode.minesweeper.tobe.minesweeper.board.position;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CellPositions {
    private final List<CellPosition> positions;

    private CellPositions(List<CellPosition> positions) {
        this.positions = positions;
    }

    public static CellPositions of(List<CellPosition> positions) {
        return new CellPositions(positions);
    }

    public static CellPositions from(Cell[][] board) {

        ArrayList<CellPosition> cellPositions = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                CellPosition cellPosition = CellPosition.of(row, col);
                cellPositions.add(cellPosition);
            }
        }
        return of(cellPositions);
    }

    public List<CellPosition> extractRandomPositions(int landMineCount) {
        ArrayList<CellPosition> list = new ArrayList<>(this.positions);
        Collections.shuffle(list);
        return list.subList(0, landMineCount);
    }

    public List<CellPosition> getPositions() {
        return new ArrayList<>(positions);
    }

    public List<CellPosition> subtract(List<CellPosition> positionListToSubtract) {
        ArrayList<CellPosition> list = new ArrayList<>(this.positions);
        CellPositions positionsToSubtract = CellPositions.of(positionListToSubtract);

        return list.stream()
                .filter(positionsToSubtract::doesNotContains)
                .toList();
    }

    private boolean doesNotContains(CellPosition position) {
        return !positions.contains(position);
    }
}
