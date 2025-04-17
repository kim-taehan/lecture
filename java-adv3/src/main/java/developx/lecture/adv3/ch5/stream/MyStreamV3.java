package developx.lecture.adv3.ch5.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV3 <T> {

    private List<T> internalList;

    private MyStreamV3(List<T> internalList) {
        this.internalList = internalList;
    }
    // static factory
    public static <T> MyStreamV3<T> of(List<T> internalList) {
        return new MyStreamV3<>(internalList);
    }
    public MyStreamV3<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return MyStreamV3.of(filtered);
    }
    public <R> MyStreamV3<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (T element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return MyStreamV3.of(mapped);
    }
    public List<T> toList() {
        return internalList;
    }

    public static void main(String[] args) {
        List<Student> list = List.of(new Student("kim", 100)
        ,new Student("lee", 30)
        ,new Student("pack", 90)
        ,new Student("bae", 70));


        List<Student> list1 = MyStreamV3.of(list)
                .filter(student -> student.score > 80)
                .map(student -> new Student(student.name, student.score * 2))
                .toList();

        System.out.println("list1 = " + list1);
    }


    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
