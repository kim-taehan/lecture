package developx.lecture.adv3.ch5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringToIntMapper {

    public static List<Integer> map(List<String> List, Function<String, Integer> mapper) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (String i : List) {
            ret.add(mapper.apply(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> objects = List.of("kim", "TETS");

        List<Integer> map = StringToIntMapper.map(objects, s -> s.length());
        System.out.println("map = " + map);

    }
}
