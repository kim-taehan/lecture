package lecture.readableCode.minesweeper.tobe.io.sign;

import lecture.readableCode.minesweeper.tobe.cell.CellSnapshot;

public interface CellSignProvidable {

    boolean supports(CellSnapshot cellSnapshot);

    String provide(CellSnapshot cellSnapshot);
}
