package developx.lecture.adv3.ch3;

public class BuildGreeterExample {

    // 고차 함수, greeting 문자열을 받아, "새로운 함수를" 반환
    public static StringFunction buildGreeter(String greeting) {
        // 코드 작성
        return s -> greeting + ", " + s; // 적절한 람다 반환
    }
    public static void main(String[] args) {
        StringFunction helloGreeter = buildGreeter("Hello");
        StringFunction hiGreeter = buildGreeter("Hi");
        // 함수가 반환되었으므로, apply()를 호출해 실제로 사용
        System.out.println(helloGreeter.apply("Java"));  // Hello, Java
        System.out.println(hiGreeter.apply("Lambda"));
    }
}
