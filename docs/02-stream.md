# stream() 이해

**람다**를 활용해 배열과 컬렉션을 함수형으로 간단하게 처리 가능!!


비어있는 stream을 만들어보자.  
```java
public static String run(String input) {
        Scanner sc = new Scanner(input + "\n");
        Scanner sc = new Scanner(input + "종료\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream(); // 비어있는 스트림
        System.setOut(new PrintStream(out));

        App app = new App();
        app.run();

        return out.toString();
    }
```
예시 코드와 같이 비어있는 스트림을 만들고, 출력될 값을 out에 저장시킨다.

```java
@Test
@DisplayName("등록 - 명언 1개 입력")
void t5() {
        // 테스트봇 선입력
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(out.toString())
                .containsSubsequence("명언 : ", "작가 : ");
```
예시 코드와 같이 @Test를 사용해 위에서 비어있는 스트림에다가 값을 넣어 확인한다.
