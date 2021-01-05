import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Class {
    public static void main(String[] args) {
        /*
            *객체지향프로그래밍(OOP)
                - 객체 지향 프로그래밍에서는 모든 데이터를 객체로 취급하며, 이러한 객체가 바로 프로그래밍의 중심이 됩니다.
                - 객체란 간단히 이야기하자면 실생활에서 우리가 인식할 수 있는 사물로 설명할 수 있습니다.
                - 이러한 객체의 상태와 행동을 구체화하는 형태의 프로그래밍이 바로 객체 지향 프로그래밍입니다.
                - 이떄 객체를 만들어 내기 위한 설계도와 같은 개념을 클래스라고 합니다.

         */

        String[] g =  {"data1", "data2", "data3", "data4", "data5"};
        Integer[] g2 = {1,2,3,4,5};
        Collections.shuffle(Arrays.asList(g2));
        ArrayList<String> pitches = new ArrayList();
        pitches.add("123");
        pitches.add("321");
        pitches.add("456");

        pitches.remove("123");

        for(int i =0; i < pitches.size(); i++){
            String str = pitches.get(i);
            System.out.println(str);

        }

//        for(Integer val : g2){
//           System.out.print(val + " ");
//        }
//        String[] array = {"data1", "data2", "data3", "data4", "data5"};
//
//        Collections.shuffle(Arrays.asList(array));
//
//        for (String value : array) {
//            System.out.print(value + " ");
//        }

    }
}
