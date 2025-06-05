package lecture.readableCode.studycafe.tobe.model;

import java.util.Set;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권"),
    WEEKLY("주 단위 이용권"),
    FIXED("1인 고정석");


    private static final Set<StudyCafePassType> LOCKET_TYPES = Set.of(StudyCafePassType.FIXED);

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }

    public boolean isLockerType() {
        return LOCKET_TYPES.contains(this);
    }

    public boolean isNotLockerType() {
        return !isLockerType();
    }
}
