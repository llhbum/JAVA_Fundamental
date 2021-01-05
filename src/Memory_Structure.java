import java.util.Arrays;

public class Memory_Structure {
    public static void main(String[] args) {
        /*
        * 메모리 구조
            - 모든 자바 프로그램은 가상 머신(JVM)을 통해서 실행됩니다.
            - 자바 프로그램이 실행되면, JVM은 운영 체제로 부터 해당 프로그램을 수행할 수 있도록 필요한 메모리를 할당받습니다.

         */

        int[] g = {1,2,3,4,5};
        int[] g2 = Arrays.copyOf(g,10);

        for(int i = 0; i<g2.length; i++){
            System.out.println(g2[i]);
        }
    }
}
