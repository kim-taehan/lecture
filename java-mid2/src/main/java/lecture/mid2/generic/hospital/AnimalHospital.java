package lecture.mid2.generic.hospital;

public class AnimalHospital <T extends Animal> {

    private final T animal;

    public AnimalHospital(T animal) {
        this.animal = animal;
    }

    public void checkUp() {
        animal.sound();
    }
}
