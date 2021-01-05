import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Stream {
    public static void main(String[] args)  {
        ArrayList<Object> list = new ArrayList<>();

        int age;
        String name;
        String address;


        Scanner sc = new Scanner(System.in);

        System.out.println("나이를 입력하세요");
        age = sc.nextInt();
        list.add(age);
        System.out.println("이름을 입력하세요");
        name = sc.next();
        list.add(name);
        System.out.println("주소를 입력하세요");
        address = sc.next();
        list.add(address);

        for(int i = 0 ; i < list.size(); i ++){
            System.out.println(list.get(i));
        }


    }
}
