package lecture.readableCode.minesweeper.tobe.cell;

public class CellSnapshot {

    private final CellSnapshotStatus status;

    private final int nearByLandMineCount;

    private CellSnapshot(CellSnapshotStatus status, int nearByLandMineCount) {
        this.status = status;
        this.nearByLandMineCount = nearByLandMineCount;
    }

    public static CellSnapshot of(CellSnapshotStatus status, int nearByLandMineCount) {
        return new CellSnapshot(status, nearByLandMineCount);
    }

    public static CellSnapshot ofEmpty() {
        return of(CellSnapshotStatus.EMPTY, 0);
    }

    public static CellSnapshot ofFlag() {
        return of(CellSnapshotStatus.FLAG, 0);
    }

    public static CellSnapshot ofLandMine() {
        return of(CellSnapshotStatus.LAND_MINE, 0);
    }

    public static CellSnapshot ofNumber(int nearByLandMineCount) {
        return of(CellSnapshotStatus.NUMBER, nearByLandMineCount);
    }

    public static CellSnapshot ofUnchecked() {
        return of(CellSnapshotStatus.UNCHECKED,0);
    }

    public CellSnapshotStatus getStatus() {
        return status;
    }

    public int getNearByLandMineCount() {
        return nearByLandMineCount;
    }
}
