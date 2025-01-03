import org.example.TestApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest {

    @Test
    void t1() {
        int rst = 1;
        assertThat(rst).isEqualTo(1); // 예상값과 실제값 비교
    }

    @Test
    void t2() {
        TestApp app =new TestApp();
        app.run();

        // aaa 가 출력 되는가
        // assertThat(result).isEqualTo("aaa");
        // Test를 하기위해서 String 변수를 계속 추가해야하는 번거로움 문제.. 이를 해결하기 위해 구조 조정이 필요!! -> result 대신
    }
    
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

    @Test
    @DisplayName("앱 시작시 '== 명언 앱 ==' 출력")
    void t4() {
        // 테스트봇 선입력
        Scanner sc = new Scanner("종료\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream(); // 비어있는 스트림
        System.setOut(new PrintStream(out));

        TestApp app = new TestApp();
        app.run();





        assertThat(out.toString())
                .containsSubsequence("== 명언 앱 ==", "명언앱을 종료합니다.");

        // 출력값을 체크
    }
}
