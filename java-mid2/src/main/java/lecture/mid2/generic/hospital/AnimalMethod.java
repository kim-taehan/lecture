package lecture.mid2.generic.hospital;

public class AnimalMethod {
    public static <T extends Animal> String checkup(T t) {
        return t.sound();
    }
}
