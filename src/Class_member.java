public class Class_member {
    public static void main(String[] args) {
        /*
        ** 필드의 구분
            * 필드의 구분
                - 클래스의 필드란 클래스에 포함된 변수를 의미합니다.
                - 클래스 내에서 필드는 선언된 위치에 따라 다음과 같이 구분됩니다.

                1. 클래스 변수
                2. 인스턴스 변수
                3. 지역 변수
                class Car {
                    static int modelOutput; // 클래스 변수
                    String modelName;       // 인스턴스 변수
                    void method() {
                        int something = 10; // 지역 변수
                    }
                }
                - 클래스 변수와 인스턴스 변수는 초기화를 하지 않아도 변수의 타입에 맞게 자동으로 초기화될 것입니다.
                - 하지만 지역 변수는 사용하기 전에 초기화하지 않으면, 자바 컴파일러가 오류를 발생시킵니다.

            * 클래스 변수와 인스턴스 변수
                - 클래스 영역에 위치한 변수 중에서 static 키워드를 가지는 변수를 클래스 변수라고 합니다.
                - 그리고 클래스 영역에 위치한 변수 중 static 키워드를 가지지 않는 변수는 인스턴스 변수라고 합니다.
                - 또한 메소드나 생성자, 초기화 블록 내에 위치한 변수를 지역변수라고 합니다.
                - 이렇게 선언된 위치에 따라 구분되는 변수는 생성 및 소멸 시기, 저장되는 메모리 공간과 사용 방법까지도 서로 다릅니다.
                변수	생성 시기	소멸 시기	저장 메모리	사용 방법
                클래스 변수	클래스가 메모리에 올라갈 때/	프로그램이 종료될 때/	메소드 영역	클래스이름.변수이름
                인스턴스 변수	인스턴스가 생성될 때/	인스턴스가 소멸할 때/	힙 영역	인스턴스이름.변수이름
                지역 변수	블록 내에서 변수의 선언문이 실행될 때/	블록을 벗어날 때/	스택 영역	변수이름

                - 클래스 변수는 인스턴스를 생성하지 않고도 바로 사용할 수 있습니다.
                - 따라서 이러한 클래스 변수를 공유 변수라고도 합니다.
                - 이러한 클래스 변수는 해당 클래스의 모든 인스턴스가 공유해야 하는 값을 유지하기 위해서 사용됩니다.
                - 반면에 인스턴스 변수는 인스턴스마다 가져야 하는 고유한 값을 유지하기 위해 사용됩니다.

                - 클래스 변수는 생성된 모든 인스턴스가 같은 값을 공유하는 것을 확인할 수 있습니다.
                - 하지만 인스턴스 변수는 각 인스턴스마다 고유한 값을 가지는 것을 확인할 수 있습니다.

        ** 메소드의 구분
            * 메서드의 구분
                - 클래스의 메소드란 어떠한 작업을 수행하기 위한 명령문의 집합이라 할 수 있습니다.
                - 클래스 내에서 메소드는 static 키워드의 여부에 따라 다음과 같이 구분됩니다.

                1. 클래스 메소드
                2. 인스턴스 메소드

            * 클래스 메소드와 인스턴스 메소드
                - 위와 같이 static 키워드를 가지는 메소드를 클래스 메소드라고 합니다.
                - 또한, static 키워드를 가지지않는 메소드는 인스턴스 메소드라고 합니다.

                - 클래스 메소드는 클래스 변수와 마찬가지로 인스턴스를 생성하지 않고도 바로 사용할 수 있습니다.
                - 따라서 클래스 메소드는 메소드 내부에서 인스턴스 변수를 사용할 수 없습니다.
                - 그러므로 메소드 내부에서 인스턴스 변수나 인스턴스 메소드를 사용하지 않는 메소드를 클래스 메소드로 정의하는 것이 일반적입니다.

                class Method {
                    int a = 10, b = 20;                            // 인스턴스 변수
                    int add() { return a + b; }                    // 인스턴스 메소드
                    static int add(int x, int y) { return x + y; } // 클래스 메소드
                }
                public class Member02 {
                    public static void main(String[] args) {
                        System.out.println(Method.add(20, 30)); // 클래스 메소드의 호출
                        Method myMethod = new Method();         // 인스턴스 생성
                        System.out.println(myMethod.add());     // 인스턴스 메소드의 호출
                    }
                }
                - 위의 예제처럼 클래스 메소드는 인스턴스 변수를 사용하지 않고, 전달된 매개변수만으로 동작하는 메소드입니다.

            ** 초기화 블록
                * 필드의 초기화
                    - 자바에서 필드는 초기화하지 않아도 변수의 타입에 맞는 초깃값으로 자동으로 초기화됩니다.
                    - 하지만 지역 변수와 마찬가지로 적절한 값으로 초기화한 후에 사용하는 것이 좋습니다.
                    - 이러한 필드는 지역 변수와는 달리 여러 가지 방법으로 초기화할 수 있습니다.
                    - 자바에서는 필드를 초기화하기 위해 다음과 같은 방법들을 제공합니다.

                    1. 명시적 초기화
                    2. 생성자를 이용한 초기화
                    3. 초기화 블록을 이용한 초기화

                    - 명시적 초기화는 지역 변수를 초기화하는 방법과 마찬가지로 필드를 선언과 동시에 초기화하는 방법입니다.
                    class Field {
                        static int classVar = 10; // 클래스 변수의 명시적 초기화
                        int instanceVar = 20;     // 인스턴스 변수의 명시적 초기화
                    }
                    - 생성자를 이용한 초기화는 객체의 생성과 동시에 필드를 초기화하는 방법입니다.
                    - 따라서 생성자를 이용한 초기화는 인스턴스를 생성할 때까지 필드를 초기화할 수 없습니다.

                * 초기화 블록
                    - 필드를 초기화하는 마지막 방법으로는 자바에서 제공하는 초기화 블록을 이용하는 방법이 있습니다.
                    - 초기화 블록이란 클래스 필드의 초기화만을 담당하는 중괄호로 둘러싸인 블록을 의미합니다.
                    - 초기화 블록은 생성자보다 먼저 호출되며, static 키워드의 유무에 따라 다음과 같이 구분됩니다.
                    1. 인스턴스 초기화 블록
                    2. 클래스 초기화 블록

                    - 이러한 초기화 블록에는 다양한 명령문 및 제어문을 사용할 수 있으므로, 복잡한 초기화를 해야할 경우 유용하게 사용됩니다.

                * 인스턴스 초기화 블록
                    - 인스턴스 초기화 블록은 단순히 중괄호 만을 사용하여 정의할 수 있습니다.
                    - 이러한 인스턴스 초기화 블록은 생성자와 마찬가지로 인스턴스가 생성될 때마다 실행됩니다.
                    - 하지만 언제나 인스턴스 초기화 블록이 생성자보다 먼저 실행됩니다.

                    - 생성자와 인스턴스 초기화 블록의 차이는 거의 없으므로 인스턴스 초기화 블록은 잘 사용되지 않습니다.
                    - 단, 여러 개의 생성자가 있으면 모든 생성자에서 공통으로 수행되어야 할 코드를 인스턴스 초기화 블록에 포함하여 코드의 중복을 막을 수 있습니다.
                    class Car {
                    private String modelName;
                    private int modelYear;
                    private String color;
                    private int maxSpeed;
                    private int currentSpeed;
                    { // 인스턴스 초기화 블록
                        this.currentSpeed = 0;
                    }
                    Car() {}
                    Car(String modelName, int modelYear, String color, int maxSpeed) {
                        this.modelName = modelName;
                        this.modelYear = modelYear;
                        this.color = color;
                        this.maxSpeed = maxSpeed;
                    }
                    public int getSpeed() {
                        return currentSpeed;
                    }
                }
                public class Member03 {
                    public static void main(String[] args) {
                        Car myCar = new Car();                // 인스턴스 생성
                        System.out.println(myCar.getSpeed()); // 인스턴스 메소드의 호출
                    }
                }

            * 클래스 초기화 블록
                - 클래스 초기화 블록은 인스턴스 초기화 블록에 static 키워드를 추가하여 정의할 수 있습니다.
                - 이러한 클래스 초기화 블록은 클래스가 처음으로 메모리에 로딩될 때 단 한번만 실행됩니다.
                - 클래스 초기화 블록은 생성자나 인스턴스 초기화 블록으로는 수행할 수 없는 클래스 변수의 초기화를 수행할 때 사용됩니다.
                class InitBlock {
                    static int classVar; // 클래스 변수
                    int instanceVar;     // 인스턴스 변수
                    static { // 클래스 초기화 블록을 이용한 초기화
                        classVar = 10;
                    }
                }
                public class Member04 {
                    public static void main(String[] args) {
                        System.out.println(InitBlock.classVar); // 클래스 변수에 접근
                    }
                }

            * 필드의 초기화 순서
                - 클래스의 필드는 앞서 살펴본 것과 같이 다양한 방법으로 초기화할 수 있습니다.
                - 따라서 같은 필드가 여러 번 초기화될 가능성이 있습니다.

                - 자바에서는 필드는 다음과 같은 순서로 초기화 됩니다.
                1. 클래스 변수 : 기본값 -> 명시적 초기화 -> 클래스 초기화 블록
                2. 인스턴스 변수 : 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블록 -> 생성자

                class InitBlock {
                    static int classVar = 10;         // 클래스 변수의 명시적 초기화
                    int instanceVar = 10;             // 인스턴스 변수의 명시적 초기화
                    static { classVar = 20; }         // 클래스 초기화 블록을 이용한 초기화
                    { instanceVar = 20; }             // 인스턴스 초기화 블록을 이용한 초기화
                    InitBlock() { instanceVar = 30; } // 생성자를 이용한 초기화
                }
                public class Member05 {
                    public static void main(String[] args) {
                        System.out.println(InitBlock.classVar);
                        InitBlock myInit = new InitBlock();
                        System.out.println(myInit.instanceVar);
                    }
                }
                - 위의 예제처럼 같은 필드를 여러번 초기화하면, 제일 마지막으로 초기화한 값만이 남게 됩니다.
         */
    }
}
