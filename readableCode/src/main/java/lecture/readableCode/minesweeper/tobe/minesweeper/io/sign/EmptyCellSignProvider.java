package lecture.readableCode.minesweeper.tobe.minesweeper.io.sign;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotStatus;

@Deprecated
public class EmptyCellSignProvider implements CellSignProvidable {

    private static final String EMPTY_SIGN = "■";

    @Override
    public boolean supports(CellSnapshot cellSnapshot) {
        return cellSnapshot.isSameStatus(CellSnapshotStatus.EMPTY);
    }

    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return EMPTY_SIGN;
    }
}
