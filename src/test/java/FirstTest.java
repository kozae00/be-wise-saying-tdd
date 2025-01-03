import org.example.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest {

    @Test
    void t1() {
        int rst = 1;
        assertThat(rst).isEqualTo(1); // 예상값과 실제값 비교
    }

    @Test
    void t2() {
        App app =new App();
        app.run();

        // aaa 가 출력 되는가
        // assertThat(result).isEqualTo("aaa");
        // Test를 하기위해서 String 변수를 계속 추가해야하는 번거로움 문제.. 이를 해결하기 위해 구조 조정이 필요!! -> result 대신
    }
    
    @Test
    void t3() {
        // 테스트봇 선입력
        String out = TestBot.run("");

        assertThat(out.toString())
                .contains("명령 )")
                .contains("명언앱을 종료합니다.");

        // 출력값을 체크
    }

    @Test
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

    @Test
    @DisplayName("앱 시작시 '== 명언 앱 ==' 출력")
    void t5() {
        // 테스트봇 선입력
        String out = TestBot.run("");

        assertThat(out.toString())
                .containsSubsequence("== 명언 앱 ==", "명언앱을 종료합니다.");

        // 출력값을 체크
    }

    @Test
    @DisplayName("등록 - 명언 1개 입력")
    void t6() {
        // 테스트봇 선입력
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(out.toString())
                .containsSubsequence("명언 : ", "작가 : ");
    }
}
