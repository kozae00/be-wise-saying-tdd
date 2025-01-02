import org.example.TestApp;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest {

    @Test
    void t1() {

        assertThat(2).isEqualTo(1); // 예상값과 실제값 비교
    }

    @Test
    void t2() {
        TestApp app =new TestApp();
        app.run();

        // aaa 가 출력 되는가
        // assertThat(result).isEqualTo("aaa");
        // Test를 하기위해서 String 변수를 계속 추가해야하는 번거로움 문제.. 이를 해결하기 위해 구조 조정이 필요!! -> result 대신
    }
}
