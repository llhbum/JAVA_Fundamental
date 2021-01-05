public class Exception_handling {
    public static void main(String[] args) {
        /*
            ** 예외처리
                * 오류와 예외
                    - 자바 프로그램을 작성할 때 자바 문법에 맞지 않게 코드를 작성하고 컴파일하려고 하면, 자바 컴파일러는 문법오류를 발생시킵니다.
                    - 또한, 자바 문법에는 맞게 작성되었다 하더라도 프로그램이 실행되면서 예상히지 못한 오류가 발생할 수 있습니다.
                    - 이렇게 컴퓨터 시스템이 동작하는 도중에 예상하지 못한 사태가 발생하여 실행 중인 프로그램이 영향을 받는 것을 오류와 예외 두가지로 구분할 수 있습니다.

                    - 오류는 시스템 레벨에서 프로그램에 심각한 문제를 야기하여 실행중인 프로그램을 종료시킵니다.
                    - 이러한 오류는 개발자가 미리 예측하여 처리할 수 없는 것이 대부분이므로, 오류에 대한 처리는 할 수 업습니다.

                    - 하지만 예외는 오류와 마찬가지로 실행중인 프로그램을 비정상으로 종료시키지만, 발생할 수 있는 상황을 미리 예측하여 처리할 수 있습니다.
                    - 따라서 개발자는 예외처리를 통해 예외 상황을 처리할 수 있도록 코드의 흐름을 바꿀 필요가 있습니다.

                * 예외 처리
                    - 자바에서는 프로그램이 실행되는 도중 발생하는 예외를 처리하기 위해 try/ catch/ finally문을 사용할 수 있습니다.
                    1. try 블록: 기본적으로 맨 먼저 실행되는 코드로 여기에서 발생한 예외는 catch 블록에서 처리됩니다.
                    2. catch 블록 : try블록에서 발생한 예외 코드나 예외 객체를 인수로 전달 받아 그 처리를 담당합니다.
                    3. finally 블록 : 이 블록은 try 블록에서 예외가 발생하건 안 하건 맨 마지막에 무조건 실행됩니다.

                    * catch블록과 finally 블록은 선택적인 옵션으로 반드시 사용할 필요는 없습니다.
                    * 따라서 사용할 수 있는 모든 적합한 try 구문은 다음과 같습니다.
                    1 try/ catch
                    2 try/ finally
                    3 try/ catch /../finally

                * 예외 처리 메커니즘
                    - 자바에서 예외처리는 다음과 같은 순서로 진행됩니다.
                    1 try블록에 도달한 프로그램의 제어는 try 블록 내의 코드를 실행합니다.
                      이때 만약 예외가 발생(throw)하지 않고, finally 블록이 존재하면 프로그램의 제어는 바로 finally블록으로 이동합니다.
                    2 try 블록에서 예외가 발생하면 catch 핸들러는 다음과 같은 순서로 적절한 catch 블록을 찾게 됩니다.
                      2-1 스택에서 try 블록과 가장 가까운 catch 블록부터 차례대로 검사합니다.
                      2-2 만약 적절한 catch 블록을 찾지 못하면, 바로 다음 바깥쪽 try 블록 다음에 위치한 catch 블록을 차례대로 검사합니다.
                      2-3 이러한 과정을 가장 바깥쪽 try블록까지 계속 검사하게됩니다.
                      2-4 그래도 적절한 catch 블록을 찾지 못하면, 예외는 처리되지 못합니다.
                    3 만약 적절한 catch 블록을 찾게 되면, throw 문의 피연산자는 예외 객체의 형식 매개변수로 전달됩니다.
                    4 모든 예외 처리가 끝나면 프로그램의 제어는 finally 블록으로 이동합니다.
                    5 finally 블록이 모두 처리되면, 프로그램의 제어는 예외 처리문 바로 다음으로 이동합니다.

            ** 예외 클래스
                * Exception 클래스
                    - 자바에서 모든 예외의 조상 클래스가 되는 Exception 클래스는 크게 다음과 같이 구분할 수 있습니다.
                    1 RuntimeException 클래스
                    2 그 외의 Exception 클래스의 자식 클래스

                    - RuntimeException 클래스를 상속받는 자식 클래스들은 주로 치명적인 예외 상황을 발생시키지 않는 예외들로 구성됩니다.
                    - 따라서 try/catch 문을 사용하기 보다는 프로그램을 작성하면서 예외가 발생하지 않도록 주의를 기울이는 편이 좋습니다.
                    - 하지만 그 외의 Exception 클래스에 속하는 자식 클래스들은 치명적인 예외 상황응ㄹ 발생시키므로, 반드시 try/ catch문을 사용하여 예외를 처리해야만 합니다.
                    - 따라서 자바 컴파일러는 RuntimeException 클래스 이외의 Exception 클래스의 자식 클래스에 속하는 예외가 발생할 가능성이 있는 구문에는 반드시 예외 처리하도록 강제하고 있습니다.
                    - 만약 이러한 예외가 발생할 가능성이 있는 구문을 예외 처리하지 않았을 때는 컴파일 시 오류를 발생시킵니다.

                * 예외 처리의 계층 관계
                    - 자바에서는 예외가 발생하면, try 블록과 가장 가까운 catch 블록부터 순서대로 검사합니다.
                    - 따라서 여러 개의 catch 블록을 사용할 때는 Exception 클래스의 계층 관계에도 주의를 기울여야만 합니다.

                    try {
                        System.out.write(list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    - 위의 예제에서 IOException이 발생하면, 자바는 첫 번째 catch 블록부터 순서대로 해당 예외를 처리할 수 있는지를 검사합니다.
                    - 그런데 IOException은 Exception의 자식 클래스이므로, 첫 번째 catch 블록에서도 IOException을 처리할 수 있습니다.
                    - 따라서 IOException을 비롯한 Exception 클래스의 자식 클래스에 해당하는 예외가 발생하면, 언제나 첫 번째 catch 블록에서만 처리될 것입니다.
                    - 즉, catch 블록의 순서를 위의 예제처럼 작성하면, 두 번째 catch 블록은 영원히 실행되지 못할 것입니다.

                    - 따라서 IOException만을 따로 처리하고자 한다면, 다음 예제처럼 catch 블록의 순서를 변경해야 합니다.
                    try {
                        System.out.write(list);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    - 위의 예제에서 IOException이 발생하면, 첫 번째 catch 블록에서 해당 예외를 처리할 것입니다.
                    - 또한, IOException 외의 Exception 클래스의 자식 클래스에 해당하는 예외가 발생하면, 두 번째 catch 블록에서 처리될 것입니다.
                    - 이처럼 범위가 더 좁은 예외를 처리하는 catch 블록을 먼저 명시하고, 범위가 더 넓은 예외를 처리하는 catch 블록은 나중에 명시해야만 정상적으로 해당 예외를 처리할 수 있습니다.

                * 여러 예외 타입의 동시 처리
                    - Java SE 7부터는 '|' 기호를 사용하여 하나의 catch 블록에서 여러 타입의 예외를 동시에 처리할 수 있습니다.
                    - 하지만 둘 이상의 예외 타입를 동시에 처리하는 catch블록에서 매개변수로 전달받은 예외 객체는 묵시적으로 final 제어자를 가지게 됩니다.
                    - 따라서 catch 블록 내에서는 해당 매개변수에는 어떠한 값도 대입할 수 없습니다.

                * Throwalbe 클래스
                    - 자바에서 Trowable 클래스는 모든 예외의 조상이 되는 Exception 클래스와 모든 오류의 조상이 되는 Error 클래스의 부모 클래스입니다.
                    - Trowable 타입과 이 클래스를 상속받은 서브 타입만이 자바 가상 머신 JVM이나 throw 키워드에 의해 던져질 수 있습니다.

                    - 이 클래스에는 예외나 오류에 관한 다양한 정보를 확인할 수 있는 다음과 같은 메소드가 포함되어 있습니다.
                    String getMessage() : 해당 throwable 객체에 대한 자세한 내용을 문자열로 반환함
                    void printStackTrace() : 해당 throwalbe 객체와 표준 오류 스트림에서 해당 객체의 스택 드레이스를 출력함
                    String toString() : 해당 throwalbe 객체에 대한 간략한 내용을 문자열로 반환함

                * 자주 사용되는 예외 클래스
                    - ClassCastException : 수행할 수 없는 타입 변환이 진행될 경우
                    - ArrayIndexOutOfBoundsExcpetion 배열에 잘못된 인덱스를 사용하여 접근할 경우
                    - NullPointException : null 객체의 인스턴스 메소드를 호출하는 등의 경우
                    - ArithmeticException : 산술 연산에서 정수를 0으로 나누는 등 연산을 수행할 수 없는 경우

            ** 예외 발생 및 회피
                * 예외 발생시키기
                    - 자바에서는 throw 키워드를 사용하여 강제로 예외를 발생시킬 수 있습니다.
                    Exception e = new Exception("오류메시지");
                    ...
                    throw e;
                    - 위의 예저처럼 생성자에 전달된 문자열은 getMessage() 메소드를 사용하여 오류 메시지로 출력할 수 있습니다.

                * 예외 회피하기
                    - 메소드 선언부에 throws 키워드를 사용하여 해당 메소드를 사용할 때 발생할 수 있는 예외를 미리 명시할 수도 있습니다.
                    - 이렇게 하면 해당 메소드를 사용할 떄 발생할 수 있는 예외를 사용자가 충분히 인지할 수 있으며, 그에 대한 처리까지도 강제할 수 있습니다.
                    - 따라서 더욱 안정성 있는 프로그램을 손쉽게 작성할 수 있도록 도와줄 수 있습니다.

                    - 다음 예제는 호출된 메소드에서 발생한 예외를 호출된 메소드에서 처리하는 예제입니다.
                    public class Exception03 {
                        static void handlingException() {
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                System.out.println("호출된 메소드에서 예외가 처리됨!");
                            }
                        }
                        public static void main(String[] args) {
                            try {
                                handlingException();
                            } catch (Exception e) {
                                System.out.println("main() 메소드에서 예외가 처리됨!");
                            }
                        }
                    }
                    - 이때 호출된 메소드의 try/catch문을 생략하면 컴파일 오류가 발생합니다.
                    - 또한 이 메소드를 호출한 main()메소드는 호출된 메소드에서 예외가 발생한 사실을 알 수 없습니다.

                * 사용자정의 예외 클래스
                    - 자바에서는 Exception 클래스를 상속받아 자신만의 새로운 예외 클래스를 정의하여 사용할 수 있습니다.
                    - 사용자 정의 예외 클래스에는 생성자뿐만 아니랄 필드 및 메소드도 원하는 만큼 추가할 수 있습니다.
                    class MyException extends RuntimeException {
                        MyException(String errMsg) {
                            super(errMsg);
                        }
                    }
                    - 요즘에는 위와 같은 Exception 클래스가 아닌 예외 처리를 강제하지 않는 RuntimeException 클래스를 상속받아 작성하는 경우가 많습니다.

                * try-with-resources문
                    - Java SE7부터는 사용한 자원을 자동으로 해제해 주는 try-with-resources 문을 사용할 수 있습니다.
                    - try블록에 괄호(())를 추가하여 파일을 열거나 자원을 할당하는 명령문을 명시하면, 해당 try 블록이 끝나자마자 자동으로 파일을 닫거나 할당된 자원을 해제해 줍니다.

         */
    }
}
