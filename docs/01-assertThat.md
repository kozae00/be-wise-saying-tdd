# assertThat 검증 종료

## .contains()

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
이 때, **containsSubsequence()를 활용하면 contains()를 일일이 사용할 필요 없이 한줄로 확인이 가능하다. 

