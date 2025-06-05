package lecture.readableCode.minesweeper.tobe.minesweeper.io.sign;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotStatus;

@Deprecated
public class LandMineCellSignProvider implements CellSignProvidable {

    private static final String LAND_MINE_SIGN = "☼";

    @Override
    public boolean supports(CellSnapshot cellSnapshot) {
        return cellSnapshot.isSameStatus(CellSnapshotStatus.LAND_MINE);
    }

    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return LAND_MINE_SIGN;
    }
}
