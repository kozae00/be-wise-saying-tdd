package app.standard;

import org.example.app.standard.Util;
import org.junit.jupiter.api.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.isDirectory;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileTest {
    // 테스트 시작전에 test.txt를 저장할 디렉토리 생성
    // 테스트 전처리
    @BeforeAll
    static void beforeAll() {
        System.out.println("테스트 실행 전에 한번 실행");
        Util.File.createDir("test");
    }

    // 테스트 종료후에 test.txt를 디렉토리 삭제
    // 테스트 후처리
    @AfterAll
    static void afterAll() {
        System.out.println("테스트 실행 전에 한번 실행");
        Util.File.delete("test");
    }

    @Test
    @DisplayName("최초의 파일 테스트")
    void t1() {
        Util.File.test();
    }

    @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t2() {
        String file = "test/test.txt";
        
        Util.File.createFile(file);


        assertThat(Files.exists(Paths.get(file)))
                .isTrue();
    }

    @Test
    @DisplayName("파일 내용 읽어 오기")
    void t3() {
        String file = "test/test.txt";
        String testContent = "Hello, World!";

        Util.File.wirte("test/test.txt", testContent);
        String content = Util.File.readAsString(file);

        assertThat(content)
                .isEqualTo(testContent);
    }

    @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t4() {
        String file = "test/test.txt";
        String wirteContent = "modify content";

        Util.File.wirte(file, wirteContent);

        String content = Util.File.readAsString(file);

        assertThat(content)
                .isEqualTo(wirteContent);
    }

    @Test
    @DisplayName("파일 삭제.")
    void t5() {
        String file = "test/test.txt";

        // test3.txt 파일 생성
        Util.File.createFile(file);
        assertThat(Files.exists(Paths.get(file)))
                .isTrue();

        // test3.txt 파일 삭제
        Util.File.delete(file);

        // test3.txt 존재 여부 확인
        assertThat(Files.exists(Paths.get(file)))
                .isFalse();
    }

    @Test
    @DisplayName("디렉토리 생성.")
    void t6() {
        String dirPath = "test";

        Util.File.createDir(dirPath);

        assertThat(Files.exists(Paths.get(dirPath)))
                .isTrue();

        assertThat(Files.isDirectory(Path.of(dirPath)))
                .isTrue();
    }

    @Test
    @DisplayName("디렉토리 삭제.")
    void t7() {
        String dirPath = "test";

        Util.File.delete(dirPath);

        assertThat(Files.exists(Paths.get(dirPath)))
                .isFalse();
    }
}
