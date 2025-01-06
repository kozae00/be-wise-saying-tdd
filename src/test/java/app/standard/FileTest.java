package app.standard;

import org.example.app.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileTest {

    @Test
    @DisplayName("최초의 파일 테스트")
    void t1() {
        Util.File.test();
    }

    @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t2() {
        String file = "test.txt";
        
        Util.File.createFile(file);


        assertThat(Files.exists(Paths.get(file)))
                .isTrue();
    }

    @Test
    @DisplayName("파일 내용 읽어 오기")
    void t3() {
        String testContent = "Hello, world";

        String file = "test.txt";
        String content = Util.File.readAsString(file);

        assertThat(Files.exists(Paths.get(file)))
                .isTrue();
    }

//    @Test
//    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
//    void t3() {
//        String file = "test.txt";
//
//        Util.File.wirte(file, "Hello, World!");
//
//        String content = Files.readString(Paths.get(file));
//
//        assertThat(Files.exists(Paths.get(file)))
//                .isTrue();
//    }
}
