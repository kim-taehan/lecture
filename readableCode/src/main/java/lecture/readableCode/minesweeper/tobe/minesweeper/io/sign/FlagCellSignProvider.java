package lecture.readableCode.minesweeper.tobe.minesweeper.io.sign;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotStatus;

@Deprecated
public class FlagCellSignProvider implements CellSignProvidable {

    private static final String FLAG_SIGN = "⚑";
    @Override
    public boolean supports(CellSnapshot cellSnapshot) {
        return cellSnapshot.isSameStatus(CellSnapshotStatus.FLAG);
    }
    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return FLAG_SIGN;
    }
}
