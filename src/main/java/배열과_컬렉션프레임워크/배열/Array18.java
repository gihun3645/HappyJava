package 배열과_컬렉션프레임워크.배열;

import java.util.Arrays;

public class Array18 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 1, 2};

        Arrays.sort(array);

        // 1~100 x 이라는 숫자를 생각하자
        // 20. 커
        // 50. 작아
        // 1~100 50
        // 1~50 25
        // 25~49
        // binarySearch는 원래 있는 배열을 정렬해야함
        int i = Arrays.binarySearch(array, 4);
        // 3
        // 3번째 인덱스에 4가 있다.
        System.out.println(i);
    }
}
