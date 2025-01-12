# java Method들 이해

## split()

```java
 public Command(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        // 이름 = 차태진(key-value)
        String[] cmdBits = cmd.split("\\?"); // ["삭제", "id=1"]
        actionName = cmdBits[0];
        if(cmdBits.length < 2) {
            paramValue = "";
            return;
        }
        String param = cmdBits[1];
        String[] paramBits = param.split("=");
        paramKey = paramBits[0];
        paramValue = paramBits[1];
    }
```
예시 코드와 같이, split()을 활용하여 key-value값을 얻을려고 한다.

입력값으로 "삭제?id=1" 이라는 문자열을 받았을 때 예시 코드와 같이 '?'을 기준으로 문자열을 자른다.

그렇게되면 String [ ] cmdBits라는 배열안에 ["삭제", "id=1"] 이라는 두 문자열이 입력된다.

String [ ] param 또한 "id=1" 이라는 문자열을 '=' 이라는 기준으로 ["id","1"] 로 자른다.

```java
@Test
    @DisplayName("입력값 - 삭제?id=1 일 때, 파라미터를 달라고 하면 1이 나와야 한다.")
    void t5() {
        Command cmd = new Command("삭제?id=1");
        int id = cmd.getParam();
        assertThat(id).isEqualTo(1);
    }
```
이에 대한 결과를 테스트코드를 통하여 위에서 id 값을 '1'로 받았기 때문에 1로 반환되는지 여부를 확인한다.

```java
// key1=val1&key2=val2
String queryString = cmdBits[1];

// ["key1=val1", "key2=val2"]
        String[] params = queryString.split("&");
        for(String param : params) {
            String[] paramBits = param.split("=", 2);
            if(paramBits.length < 2) {
                continue;
            }
            paramMap.put(paramBits[0], paramBits[1]);
```
또 다른 예시 코드를 통해 이해를 해보자. 만약에 입력 값으로 "key1=val1&key2=val2" 들어오게 되었을 때 어떻게 해결할 것 인가?

앞에 예시에서 우리는 '='을 기준으로 split()을 진행하였다. 하지만 '&'이 들어오게 되면서 '='을 기준으로 자르기가 힘들어졌다.

그렇기 때문에 우선 '&' 기준으로 split()을 진행하고, 그 후에 '='을 기준으로 split을 진행하면 문제가 해결될 것으로 보인다.

## File

### createFile(), readString(), write()

```java
public static void createFile(String pathValue) {
            Path filePath = Paths.get(pathValue);
            try {
                Files.createFile(filePath);
            } catch (Exception e) {
                System.out.println("파일 생성 중 실패");
                e.printStackTrace();
            }
        }
        public static String readAsString(String file) {
            Path filePath = Paths.get(file);
            try {
                return Files.readString(filePath);
            } catch (IOException e) {
                System.out.println("파일 읽기 실패");
                e.printStackTrace();
            }
            return "";
        }
```

자바에서 제공하는 파일 method를 활용해 파일 생성 및 읽기 등을 진행해보자. 

예시 코드에서는 create와 read를 통해 파일을 생성 및 읽기를 진행하고 실패했을 때 try와 catch문을 사용하여 디버깅을 수행할 수 있도록 한다.

```java
public static void wirte(String file, String content) {
            Path filePath = Paths.get(file);
            
            try {
                Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                System.out.println("파일 쓰기 실패");
                e.printStackTrace();
            }
            
        }
```
write 또한 예시 코드와 같이 method를 활용해서 파일에 데이터를 입력할 수 있게한다.
```java
 @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t4() {
        String file = "test2.txt";
        String wirteContent = "modify content";
        Util.File.wirte(file, wirteContent);
        String content = Util.File.readAsString(file);
        assertThat(content)
                .isEqualTo(wirteContent);
    }
```
테스트 코드를 통하여 데이터를 입력했을 때, test2.txt 파일에 "modify content"라는 문자열이 입력되는지 검증한다.

