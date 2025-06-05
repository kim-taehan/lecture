package lecture.readableCode.minesweeper.tobe.minesweeper.io.sign;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;

public interface CellSignProvidable {

    boolean supports(CellSnapshot cellSnapshot);

    String provide(CellSnapshot cellSnapshot);
}
