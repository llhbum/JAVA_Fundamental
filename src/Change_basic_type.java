public class Change_basic_type {
    public static void main(String[] args) {
        String s = "123";
        char c = '7';

        // 문자 -> 숫자 : 문자 - '0' => 숫자
        System.out.println(c - '0');
        // 문자열 -> 숫자 : Integer.parseInt()
        System.out.println(Integer.parseInt(s));

        //숫자 -> 문자 : (char) c + '0'
        System.out.println((char)(1 + '0'));

        //숫자 ->  문자열  : Integer.valueOf(s)
        System.out.println(Integer.valueOf(s));
    }
}
