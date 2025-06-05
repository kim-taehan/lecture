package lecture.readableCode.minesweeper.tobe.io.sign;

import lecture.readableCode.minesweeper.tobe.cell.CellSnapshot;
import lecture.readableCode.minesweeper.tobe.cell.CellSnapshotStatus;

@Deprecated
public class NumberCellSignProvider implements CellSignProvidable {

    @Override
    public boolean supports(CellSnapshot cellSnapshot) {
        return cellSnapshot.isSameStatus(CellSnapshotStatus.NUMBER);
    }
    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return String.valueOf(cellSnapshot.getNearByLandMineCount());
    }
}
