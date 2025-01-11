# assertThat 검증 종료

## contains()

contains()를 사용해, 출력값에 대한 결과가 포함 되어 있는지 여부를 확인한다.

```java
@Test
void t4() {
        assertThat(out.toString())
                .contains("== 명언 앱 ==")
                .contains("명언앱을 종료합니다.");
                .containsSubsequence("== 명언 앱 ==", "명언앱을 종료합니다.");

        // 출력값을 체크
    }
```

예시 코드를 통해,    
contains를 사용해 out값에 "==명언 앱==", "명언앱을 종료합니다."이 출력 되는지 여부를 확인 할 수 있다.   

하지만 contains() 같은 경우 순서를 고려하지 않기 때문에 "== 명언 앱 ==", "명언앱을 종료합니다."의 순서가
바뀌어도 옳다고 나온다.

이 때, **containsSubsequence()** 를 활용하면 순서를 고려해 출력 결과를 확인한다.
## isEqualTo()
두 개의 객체가 내용면에서 동일한지 확인하는 데 사용된다.

assertThat(obj1).isEqualTo(obj2)를 사용해 obj1이 obj2와 동일한지 확인한다.

```java
@DisplayName("명령을 여러번 입력할 수 있다.")
    void t4() {
        String out = TestBot.run("""
                등록
                종료
                """);
        // "명령 )" 횟수를 세서 검증 해야함.
        long count = out.split("명령 \\)").length - 1;
        assertThat(count)
                .isEqualTo(2);
    }
```
예시 코드와 같이, App.java에서 "명령 )" 출력값이 몇번 발생했는데 횟수를 확인한다.

```java
public void run() {
        System.out.println("== 명언 앱 ==");
        System.out.println("명령 )");
        System.out.println("명령 )");
        System.out.println("명언 : ");
        System.out.println("작가 : ");
        System.out.println("명언앱을 종료합니다.");

    }
```
"명령 )"이라는 출력문이 2번 발생한 것을 확인할 수 있다. 

