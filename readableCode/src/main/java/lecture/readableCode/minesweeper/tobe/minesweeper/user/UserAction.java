package lecture.readableCode.minesweeper.tobe.minesweeper.user;

public enum UserAction {

    OPEN("셀 열기"),
    FLAG("깃발 꽂기"),
    UNKNOW("알수 없음");

    private final String description;

    UserAction(String description) {
        this.description = description;
    }
}
