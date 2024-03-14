package com.erichgamma.api.lab;
import java.util.*;
import java.util.stream.*;

/**
 Primitive 타입의 경우에 다른 결과를 보입니다.
 Stream.of 는 Stream<int[]>
 Arrays.stream 은 IntStream 을 반환합니다.
 * */
public class ListOfIsGood {
    public static void main(String... args) {
        // stream() - - String[]
        String[] arr = {"foo","bar","baz","qux"};
        Arrays.stream(arr)
                .forEach(str -> System.out.print(str + " "));
        System.out.println();
        // stream() - - int[]
        int intArr[] = { 1, 2, 3, 4, 5 };
        Arrays.stream(intArr).forEach(str -> System.out.print(str + " "));
        System.out.println();
        // of() - String
        Stream.of( "foo","bar","baz","qux")
                .forEach(str -> System.out.print(str + " "));
        System.out.println();
        // of() - int
        Stream.of(6,7,8,9,10)
                .forEach(str -> System.out.print(str + " "));
        System.out.println();

        List<Number> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // Arrays 클래스의 asList 메서드
        // Arrays.asList는 원소에 null 값을 가질 수 있다.
        // Arrays.asList를 통해 생성된 리스트는 반만 불변
        List<Number> asList = Arrays.asList(1, 2, 3);
        asList.add(1); // UnsupportedOperationException
        asList.set(0, 3); // 가능

        // List 인터페이스의 of 메서드 (jdk 9)
        // List.of는 원소에 null 값을 절대 가질 수 없다.
        // List.of를 통해 생성된 리스트는 완전한 불변 리스트
        List<Number> listOf = List.of(1, 2, 3);
        listOf.add(2); // UnsupportedOperationException
        listOf.set(0, 3); // UnsupportedOperationExceptio

        // Arrays.asList 와 List.of 를 통해 생성된 리스트가 추가, 삭제가 불가능한 불변 객체로 구성된 이유는,
        // 불변 객체만의 이점을 이용해 다른 컬렉션 자료구조로 변환이 용이하게 하기 위해서 이다.

        Queue<Number> queue = new ArrayDeque<>(List.of(1, 2, 3));
        Set<Number> set = new HashSet<>(List.of(1, 2, 3));

        /**
         * 불변 객체의 몇가지 이점을 정리하면 다음과 같다.
         *
         * 스레드 안전성 : 불변 객체는 동기화 없이도 여러 스레드에서 안전하게 공유하고 액세스할 수 있다.
         * (추가, 삭제가 안되기 때문에)
         * 코드 간소화 : 불변 개체는 동시성을 위해 설계할 필요가 없으므로 코드가 간소화되고 버그 가능성이 낮다.
         * 향상된 성능 : 변경 불가능한 개체는 항상 동일한 상태를 유지하므로 캐시하고 재사용할 수 있다.
         *
         * 이처러 불변 개체를 사용하면 코드의 안정성과 성능을 향상시킬 수 있으므로
         * 많은 프로그래밍 컨텍스트에서 권장되는 방법이기 때문에 이런식으로 설계된 것이다.
         * 이외에도 라이브러리나 프레임워크로 소스를 제공하다보면,
         * 꼭 말안듣는 개발자들이 값을 자기 마음대로 조작하다가 오류를 유발시키는 경우가 많아,
         * 아예 그런 행동을 막아 부수효과를 줄이기 위한 이유도 있다.
         * */

    }
}
