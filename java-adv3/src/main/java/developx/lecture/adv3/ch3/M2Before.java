package developx.lecture.adv3.ch3;

public class M2Before {

    public static void main(String[] args) {

        method(new Procedure() {
            @Override
            public void run() {
                System.out.println("일반로직");

            }
        });
    }

    public static void method(Procedure procedure) {
        // 시간 측정 로직
        System.out.println("시간측정");
        procedure.run();
    }

    interface Procedure {
        void run();
    }
}
