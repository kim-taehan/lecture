package lecture.readableCode.minesweeper.tobe.minesweeper.io.sign;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;

import java.util.List;

@Deprecated
public class CellSignFinder {

    private static final List<CellSignProvidable> CELL_SIGN_PROVIDABLE_LIST = List.of(
            new EmptyCellSignProvider(),
            new FlagCellSignProvider(),
            new LandMineCellSignProvider(),
            new NumberCellSignProvider(),
            new UncheckedCellSignProvider()
    );

    public String findCellSignFrom(CellSnapshot snapshot) {
        return CELL_SIGN_PROVIDABLE_LIST.stream()
                .filter(provider -> provider.supports(snapshot))
                .findFirst()
                .map(provider -> provider.provide(snapshot))
                .orElseThrow(() -> new IllegalArgumentException("확인할 수 없는 cell 입니다."));
    }
}
