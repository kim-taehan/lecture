package lecture.mid2.generic.hospital;

public class WildcardEx {
    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println("이름 = " + animal.sound());
    }
}
