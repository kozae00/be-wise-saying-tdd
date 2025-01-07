package app.standard;

import org.example.app.domain.wiseSaying.WiseSaying;
import org.example.app.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {

    @Test
    @DisplayName("Map을 Json으로 변환1 - 속성이 1개")
    void t1() {
        // Object를 사용하는 이유는.. 입력값들이 어떤값이 들어올지 모르기 때문에
        // 범용성을 위해
        Map<String, Object> map = Map.of("name", "카리나");

        String jsonStr = Util.Json.mapToJson(map);

        assertThat(jsonStr)
                .isEqualTo( """
                {
                    "name" : "카리나"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Map을 Json으로 변환2 - 속성이 2개")
    void t2() {
        // Map<String, Object> map = Map.of("name", "카리나", "home", "서울");

        // 순서보장을 위하여 LinkedHashMap 사용!
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "카리나");
        map.put("home", "서울");
        
        String jsonStr = Util.Json.mapToJson(map);

        assertThat(jsonStr)
                .isEqualTo( """
                {
                    "name" : "카리나",
                    "home" : "서울"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Map을 Json으로 변환3 - 속성이 3개, 문자와 자료형 섞임")
    void t3() {
        // Map<String, Object> map = Map.of("name", "카리나", "home", "서울");

        // 순서보장을 위하여 LinkedHashMap 사용!
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "카리나");
        map.put("home", "서울");
        map.put("age", "25");

        String jsonStr = Util.Json.mapToJson(map);

        assertThat(jsonStr)
                .isEqualTo( """
                {
                    "name" : "카리나",
                    "home" : "서울",
                    "age" : "25"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("WiseSaying을 Map으로 변환 -> Json으로 변환")
    void t4() {

        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");
        Map<String, Object> wiseSayingMap = wiseSaying.toMap();

        String jsonStr = Util.Json.mapToJson(wiseSayingMap);

        assertThat(jsonStr)
                .isEqualTo("""
                        {
                            "id" : 1,
                            "content" : "aaa",
                            "author" : "bbb"
                        }
                        """.stripIndent().trim());
    }

    @Test
    @DisplayName("Map을 넘기면 Json 파일로 저장하기")
    void t5() {
        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");
        Map<String, Object> wiseSayingMap = wiseSaying.toMap();

        String jsonStr = Util.Json.mapToJson(wiseSayingMap);
        String filePath = "test/%d.json".formatted(wiseSaying.getId());
        Util.Json.writeAsMap(filePath, wiseSayingMap);

        boolean rst = Files.exists(Path.of(filePath));

        String content = Util.File.readAsString(filePath);
        assertThat(content)
                .isEqualTo( """
                {
                    "id" : 1,
                    "content" : "aaa",
                    "author" : "bbb"
                }
                """.stripIndent().trim());

        assertThat(rst).isTrue();
    }

    @Test
    @DisplayName("Json 문자열을 Map으로 변환하기")
    void t6() {

        String jsonStr = """
                {
                    "id" : 1,
                    "content" : "aaa",
                    "author" : "bbb"
                }
                """;
        Map<String, Object> map = Util.Json.jsonToMap(jsonStr);

        assertThat(map)
                .hasSize(3)
                .containsEntry("id", 1)
                .containsEntry("content", "aaa")
                .containsEntry("author", "bbb");
    }

    @Test
    @DisplayName("파일명을 넘기면 Map으로 읽어오기")
    void t7() {
        String filePath = "test/%d.json".formatted(1);

        Map<String, Object> map = Util.Json.readAsMap(filePath);

        assertThat(map)
                .hasSize(3)
                .containsEntry("id", 1)
                .containsEntry("content", "aaa")
                .containsEntry("author", "bbb");
    }

    @Test
    @DisplayName("Map을 WiseSaying으로 변환")
    void t8() {
        String filePath = "test/%d.json".formatted(1);
        Map<String, Object> map = Util.Json.readAsMap(filePath);

        WiseSaying wiseSaying = WiseSaying.fromMap(map);

        assertThat(wiseSaying.getId()).isEqualTo(1);
        assertThat(wiseSaying.getContent()).isEqualTo("aaa");
        assertThat(wiseSaying.getAuthor()).isEqualTo("bbb");
    }
}
