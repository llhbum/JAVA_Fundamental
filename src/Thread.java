public class Thread {
    public static void main(String[] args) {
        /*
        ** 스레드의 개념
            * 프로세스란?
                - 프로세스란 단순히 실행 중인 프로그램이라고 할 수 있습니다.
                - 즉, 사용자가 작성한 프로그램이 운영체제에 의해 메모리 공간을 할당받아 실행 중인 것을 말합니다.
                - 이러한 프로세스는 프로그램에 사용되는 데이터와 메모리 등의 자원 그리고 스레드로 구성됩니다.

            * 스레드란?
                - 스레드란 프로세스 내에서 실제로 작업을 수행하는 주체를 의미합니다.
                - 모든 프로세스에는 한 개 이상의 스레드가 존재하여 작업을 수행합니다.
                - 또한, 두 개 이상의 스레드를 가지는 프로세스를 멀티스레드 프로세스라고 합니다.

            * 스레드의 생성과 실행
                - 자바에서 스레드를 생성하는 방법에는 다음과 같은 두 가지 방법이 있습니다.
                1. Runnalbe 인터페이스를 구현하는 방법
                2. Thread 클래스를 상속받는 방법

                - 두 방법 모두 스레드를 통해 작업하고 싶은 내용을 run() 메소드에 작성하면 됩니다.
                - 다음 예제는 위의 두 가지 방법을 사용하여 스레드를 생성하고 실행하는 예제입니다.

                class ThreadWithClass extends Thread {
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            System.out.println(getName()); // 현재 실행 중인 스레드의 이름을 반환함.
                            try {
                                Thread.sleep(10);          // 0.01초간 스레드를 멈춤.
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                class ThreadWithRunnable implements Runnable {
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            System.out.println(Thread.currentThread().getName()); // 현재 실행 중인 스레드의 이름을 반환함.
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                public class Thread01 {
                    public static void main(String[] args){
                        ThreadWithClass thread1 = new ThreadWithClass();       // Thread 클래스를 상속받는 방법
                        Thread thread2 = new Thread(new ThreadWithRunnable()); // Runnable 인터페이스를 구현하는 방법
                        thread1.start(); // 스레드의 실행
                        thread2.start(); // 스레드의 실행
                    }
                }
                - 위 예제의 실행 결과를 살펴보면, 생성된 스레드가 서로 번갈아가며 실행되고 있는 것을 확인할 수 있습니다.
                - Thread 클래스를 상속받으면 다른 클래스를 상속받을 수 없으므로, 일반적으로 Runnalbe 인터페이스를 구현하는 방법으로 스레드를 생성합니다.

                ? 쓰레드가 run()과 start()로 나누어서 실행하는 이유
                    - main()에서 start()를 실행하면 새로운 호출스택이 생성된다.
                    - 새로운 stack에 run()가 실행된다.
                    - 각각의 스레드가 자기의 독립적인 스택을 가지고 작업
                    - 서로 독립적인 작업 가능.

            * 스레드의 우선순위
                - 자바에서 각 스레드는 우선순위에 관한 자신만의 필드를 가지고 있습니다.
                - 이러한 우선순위에 따라 특정 스레드가 더 많은 시간 동안 작업을 할 수 있도록 설정할 수 있습니다.
                1. static int MAX_PRIORITY : 스레드가 가질 수 있는 최대 우선순위를 명시함.
                2. static int MIN_PRIORITY : 스레드가 가질 수 있는 최소 우선순위를 명시함.
                3. static int NORM_PRIORITY : 스레드가 생성될 때 가지는 기본 우선순위를 명시함.

                - getPriority() 와 setPriority() 메소드를 통해 스레드의 우선순위를 반환하거나 변경할 수 있습니다.
                - 스레드의 우선순위가 가질 수 있는 범위는 1부터 10까지이며, 숫자가 높을수록 우선순위 또한 높아집니다.

                - 하지만 스레드의 우선순위는 비례적인 절대값이 아닌 어디까지나 상대적인 값일 뿐입니다.
                - 우선순위가 10인 스레드가 우선순위가 1인 스레드보다 10배 더 빨리 수행되는 것이 아닙니다.
                - 단지 우선순위가 10인 스레드는 우선순위가 1인 스레드보다 좀 더 많이 실행 큐에 포함되어, 좀 더 많은 작업 시간을 할당받을 뿐입니다.
                - 그리고 스레드의 우선순위는 해당 스레드를 생성한 스레드의 우선순위를 상속받게 됩니다.
                class ThreadWithRunnable implements Runnable {
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            System.out.println(Thread.currentThread().getName()); // 현재 실행 중인 스레드의 이름을 반환함.
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                - main() 메소드를 실행하는 스레드의 우선순위는 언제나 5이므로, main() 메소드 내에서 생생된 스레드 0의 우선순위는 5로 설정되는 것을 확인할 수 있습니다.

        ** 멀티스레드
            * 멀티 스레드
                - 일반적으로 하나의 프로세스는 하나의 스레드를 가지고 작업을 수행하게 됩니다.
                - 하지만 멀티 스레드란 하나의 프로세스 내에서 둘 이상의 스레드가 동시에 작업을 수행하는 것을 의미합니다.
                - 또한, 멀티 프로세스는 여러 개의 CPU를 사용하여 여러 프로세스를 동시에 수행하는 것을 의미합니다.

                - 멀티 스레드와 멀티 프로세스 모두 여러 흐름을 동시에 수행한다는 공통점을 가지고 있습니다.
                - 멀티 프로세스는 각 프로세스가 독립적인 메모리를 가지고 별도롤 실행되지만, 멀티 스레드는 각 스레드가 자신이 속한 프로세스의 메모리를 공유한다는 점이 다릅니다.

                - 멀티 스레드는 각 스레드가 자신이 속한 프로세스의 메모리를 공유하므로, 시스템 자원의 낭비가 적습니다.
                - 또한, 하나의 스레드가 작업을 할 떄 다른 스레드가 별도의 작업을 할 수 있어 사용자와의 응답성이 좋아집니다.

            * 문맥교환
                - 컴퓨터에서 동시에 처리할 수 있는 최대 작업 수는 CPU 코어 수와 같습니다.
                - 만약 CPU의 코어 수보다 더 많은 스레드가 실행되면, 각 코어가 정해진 시간 동안 여러 작업을 번갈아가며 수행하게 됩니다.
                - 이떄 각 스레드가 서로 교체될 떄 스레드 간의 문맥교환이라는 것이 발생합니다.
                - 문맥교환이란 현재까지의 작업 상태나 다음 작업에 필요한 각종 데이터를 저장하고 읽어오는 작업을 가리킵니다.

                - 이러한 문맥교환에 걸리는 시간이 커지면 커질수록, 멀티 스레딩의 효율은 저하됩니다.
                - 오히려 많은 양의 단순한 계산은 싱글 스레드로 동작하는 것이 더 효율적일 수 있습니다.
                - 따라서 많은 수의 스레드를 실행하는 것이 언제나 좋은 성능을 보이는 것은 아니라는 점을 유의해야 합니다.

            * 스레드 그룹
                - 스레드 그룹이란 서로 관련이 있는 스레드를 하나의 그룹으로 묶어 다루기 위한 장치입니다.
                - 자바에서는 스레드 그룹을 다루기 위해 ThreadGroup이라는 클래스를 제공합니다.

                - 이러한 스레드 그룹은 다른 스레드 그룹을 포함할 수 있으며, 이렇게 포함된 스레드 그룹은 트리 형태로 연결됩니다.
                - 이떄 스레드는 자신이 포함된 스레드 그룹이나 그 하위 그룹에는 접근할 수 있지만, 다른 그룹에는 접근할 수 없습니다.
                - 이렇게 스레드 그룹은 스레드가 접근할 수 있는 범위를 제한하는 보안상으로도 중요한 역할을 하고 있습니다.
                class ThreadWithRunnable implements Runnable {
                    public void run() {
                        try {
                            Thread.sleep(10); // 0.01초간 스레드를 멈춤.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public class Thread03 {
                    public static void main(String[] args){
                        Thread thread0 = new Thread(new ThreadWithRunnable());
                        thread0.start(); // Thread-0 실행
                        System.out.println(thread0.getThreadGroup());
                        ThreadGroup group = new ThreadGroup("myThread"); // myThread라는 스레드 그룹 생성함.
                        group.setMaxPriority(7); // 해당 스레드 그룹의 최대 우선순위를 7로 설정함.

                        // 스레드를 생성할 때 포함될 스레드 그룹을 전달할 수 있음.
                        Thread thread1 = new Thread(group, new ThreadWithRunnable());
                        thread1.start(); // Thread-1 실행
                        System.out.println(thread1.getThreadGroup());
                    }
                }

            * 데몬 스레드
                - 데몬 스레드란 다른 일반 스레드의 작업을 돕는 보조적인 역할을 하는 스레드를 가리킵니다.
                - 따라서 데몬 스레드는 일반 스레드가 모두 종료되면 더는 할 일이 없으므로, 데몬 스레드 역시 자동으로 종료됩니다.

                - 데몬 스레드의 생성 방법과 실행 방법은 모두 일반 스레드와 같습니다.
                - 단 실행하기 전에 setDaemon() 메소드를 호출하여 데몬 스레드로 설정하기만 하면 됩니다.
                - 이러한 데몬 스레드는 일정 시간마다 자동으로 수행되는 저장 및 화면 갱신 등에 이용되고 있습니다.

            * 가비지 컬렉터
                - 데몬 스레드를 이용하는 가장 대표적인 예로 가비지 컬렉터를 들 수 있습니다.
                - 가비지 컬렉터란 프로그래머가 동적으로 할당한 메모리 중 더 이상 사용하지 않는 영역을 자동으로 찾아내어 해제해 주는 데모 스레드 입니다.

                - 자바에서는 프로그래머가 메모리에 직접 접근하지 못하게 하는 대신에 다비지 컬렉터가 자동으로 메모리를 관리해 줍니다.
                - 이러한 가비지 컬렉터를 이용하면 프로그래밍을 하기가 훨씬 쉬워지며, 메모리에 관련된 버그가 발생할 확률도 낮아집니다.
                - 보통 가비지 컬렉터가 동작하는 동안에는 프로세서가 일시적으로 중지되므로, 필연적으로 성능의 저하가 발생합니다.
                - 하지만 요즘에는 가비지 컬렉터의 성능이 많이 향상되어, 새롭게 만들어지는 대부분의 프로그래밍 언어에는 가비지 컬렉터를 제공하고 있습니다.
         */
    }
}
