# 1. 제너릭 Generic
- 제네릭의 핵심은 사용할 타입을 미리 결정하지 않는다는 점이다.
- 클래스 내부에서 사용하는 타입을 클래스를 정의하는 시점에 결정하는 것이 아니라 실제 사용하는 생성 시점에 타입을 결정하는 것이다.
- 제너릭 타입: 클래스, 인터페이스를 정의시에 타입 매개변수를 사용하는 것을 말한다.
- 타입 매개변수: GenericBox<T>에서 T
- 타입인자  GenericBox<Integer> 에서 Integer
- 타입 인자로 기본형은 사용할 수 없다 (int, double..)

## 타입 매개변수 상한
```java
public class AnimalHospital <T extends Animal> {

    private final T animal;

    public AnimalHospital(T animal) {
        this.animal = animal;
    }

    public void checkUp() {
        animal.sound();
    }
}
```

## generic method
- 제네릭 메서드는 인스턴스 메서드와 static 메서드에 모두 적용할 수 있다.
- 제네릭 타입은 static 메서드에 타입 매개변수를 사용할 수 없다. (당연)
```java
public class AnimalMethod {
    public static <T extends Animal> String checkup(T t) {
        return t.sound();
    }
}
```

## wildcard
- 제네릭 타입을 조금 더 편리하게 사용할 수 있는 와일드카드는 여러 타입을 들어올 수 있게 한다.
- 와일드카드는 제네릭 타입이나, 제네릭 메서드를 선언하는 것이 아니다. 와일드카드는 이미 만들어진 제네릭 타입을 활용할 때 사용한다
```java
public class WildcardEx {
    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println("이름 = " + animal.sound());
    }
}
```

## generic method vs wildcard
- 제네릭 타입이나 제네릭 메서드를 정의하는게 꼭 필요한 상황이 아니라면, 더 단순한 와일드카드 사용을 권장한다


## 타입 이레이저
- 제네릭은 자바 컴파일 단계에서만 사용되고, 컴파일 이후에는 제네릭 정보가 삭제된다.
- 쉽게 이야기해서 컴파 전인 자바 바이트코드에는 제네릭의 타입 매개변수가 존재하지만, 컴파일 이후에는 타입 매개변수가 존재하지 않는 것
```java
class EraserBox<T> {
    public boolean instanceCheck(Object param) {
        return param instanceof T; // 오류
    }
    public T create() {
        return new T(); // 오류
    }
}
```

# 자료구조

## 빅오 표기법
![img.png](bigO.png)
- O(1) - 상수 시간: 입력 데이터의 크기에 관계없이 알고리즘의 실행 시간이 일정한다.
- O(n) - 선형 시간: 알고리즘의 실행 시간이 입력 데이터의 크기에 비례하여 증가한다.
- O(n²) - 제곱 시간: 알고리즘의 실행 시간이 입력 데이터의 크기의 제곱에 비례하여 증가한다.
- O(log n) - 로그 시간: 알고리즘의 실행 시간이 데이터 크기의 로그에 비례하여 증가한다.
- O(n log n) - 선형 로그 시간

## 배열
- 인덱스를 통한 입력, 변경, 조회의 경우 한번의 계산으로 자료의 위치를 찾을 수 있다.
- 배열은 메모리 상으로 연속된 위치에 저장되기에 list 와 다르게 자바에서 최적화가 가능하다.
- 배열의 길이를 동적으로 변경할 수 없다.
- 데이터를 추가하는 경우 직접 오른쪽으로 한 칸씩 데이터를 밀어야 한다.

### 배열에 데이터를 추가할 때 위치에 따른 성능 변화
- 배열의 첫번째 위치에 추가 : 모든 데이터를 배열의 크기만큼 한 칸씩 이동해야 한다. 따라서 O(n) 만큼의 연산
- 배열의 중간 위치에 추가 :  O(1 + n/2)  O(n)이 된다.
- 배열의 마지막 위치에 추가 
  - 이 경우 배열이 이동하지 않고 배열의 길이를 사용하면 마지막 인덱스에 바로 접근할 수 있으므로 한번의 계
    산으로 위치를 찾을 수 있고, 기존 배열을 이동하지 않으므로 O(1)이 된다.
- 