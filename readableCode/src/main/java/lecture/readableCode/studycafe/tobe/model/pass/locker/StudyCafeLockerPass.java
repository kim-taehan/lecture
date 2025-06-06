package lecture.readableCode.studycafe.tobe.model.pass.locker;

import lecture.readableCode.studycafe.tobe.model.pass.StudyCafePass;
import lecture.readableCode.studycafe.tobe.model.pass.StudyCafePassType;

public class StudyCafeLockerPass implements StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    @Override
    public StudyCafePassType getPassType() {
        return passType;
    }

    public boolean isSamePassType(StudyCafePassType passType) {
        return passType == this.passType;
    }

    public boolean isSameDuration(int duration) {
        return duration == this.duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getPrice() {
        return price;
    }


}
