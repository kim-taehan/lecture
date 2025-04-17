package developx.lecture.adv3.ch5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMapper {

    public static <T, R> List<R> map(List<T> List, Function<T, R> mapper) {
        ArrayList<R> ret = new ArrayList<>();
        for (T i : List) {
            ret.add(mapper.apply(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> objects = List.of("kim", "TETS");

        List<Integer> map = GenericMapper.map(objects, s -> s.length());
        System.out.println("map = " + map);

    }
}
