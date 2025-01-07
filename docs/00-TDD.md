# TDD를 이해하기!

TDD는 테스트를 누락하지 않고 분할 정복을 할 수 있게 하는 효과가 있다.

## TestBot
TDD를 이용해 사용자(개발자)가 직접 입력값을 설정하여 코드를 테스트하는 것이 아닌 **테스트 봇**을 통해 미리 입력값을 세팅해 코드를 테스트할 수 있다.

```java
@Test
@DisplayName("최초테스트")
void t1() {
    assertThat(2).isEqualTo(1); // 예상값과 실제값 비교
}
```
예시 코드와 같이 테스트봇을 생성하여 코드가 제대로 구동되는지 검증할 수 있다.


다른 예시를 보며 코드를 이해해보도록 하자.
```java
public class TestApp {
    public void run() {
        System.out.println("aaa");
        System.out.println("명언앱을 종료합니다.");

    }
}
```
TestApp이라는 class에서 run()라는 메서드가 잘 동작하는지 확인하려고한다.
```java
@Test
void t3() {
    // 테스트봇 선입력
    Scanner sc = new Scanner("종료\n");
    ByteArrayOutputStream out = new ByteArrayOutputStream(); // 비어있는 스트림
    System.setOut(new PrintStream(out));
    TestApp app = new TestApp();
    app.run();
    assertThat(out.toString()).contains("명언앱을 종료합니다.");
    // 출력값을 체크
}
```
이와 같이 System.in 대신에 "종료"를 선입력 받게
한다.

그 후, TestApp 클래스의 객체를 생성하고, run 메서드를 호출한다.

assertThat을 통하여 run() 메서드를 통해 출력되어야 하는 값이 제대로 출력되는지 검증한다.

