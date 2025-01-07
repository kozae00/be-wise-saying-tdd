package app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.WiseSaying;
import org.example.app.domain.wiseSaying.repository.WiseSayingFileRepository;
import org.example.app.domain.wiseSaying.repository.WiseSayingRepository;
import org.example.app.standard.Util;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WiseSayingFileRepositoryTest {
    
    WiseSayingRepository wiseSayingRepository = new WiseSayingFileRepository();

    @AfterAll
    @DisplayName("파일 DB 삭제")
    static void afterAll() {
        Util.File.deleteForce("db/test");
    }

    @Test
    @DisplayName("명언 저장")
    void t1() {

        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");
        wiseSayingRepository.save(wiseSaying);

        String filePath = "db/test/wiseSaying/1.json";

        boolean rst = Files.exists(Path.of(filePath));
        assertThat(rst).isTrue();

        Map<String, Object> map = Util.Json.readAsMap(filePath);
        WiseSaying restoreWiseSaying = WiseSaying.fromMap(map);

        System.out.println(restoreWiseSaying);
        System.out.println(wiseSaying);

        assertThat(wiseSaying).isEqualTo(restoreWiseSaying);
    }

    @Test
    @DisplayName("명언 삭제")
    void t2() {
        WiseSaying wiseSaying = new WiseSaying(1,"aaa", "bbb");
        wiseSayingRepository.save(wiseSaying);
        String filePath = "db/test/wiseSaying/1.json";
        boolean delRst = wiseSayingRepository.deleteById(1);
        boolean rst = Files.exists(Path.of(filePath));
        assertThat(rst).isFalse();
        assertThat(delRst).isTrue();
    }

    @Test
    @DisplayName("아이디로 해당 명언 가져오기")
    void t3() {
        WiseSaying wiseSaying = new WiseSaying(1,"aaa", "bbb");

        wiseSayingRepository.save(wiseSaying);
        assertThat(Files.exists(Path.of("db/test/wiseSaying/1.json"))).isTrue();

        String filePath = "db/test/wiseSaying/1.json";

        Optional<WiseSaying> opWiseSaying = wiseSayingRepository.findById(1);
        WiseSaying foundWiseSaying = opWiseSaying.orElse(null);

        assertThat(foundWiseSaying).isNotNull();
        assertThat(foundWiseSaying).isEqualTo(wiseSaying);
    }

    @Test
    @DisplayName("모든 명언 가져오기")
    void t4() {

        WiseSaying wiseSaying1 = new WiseSaying(1,"aaa1", "bbb1");
        WiseSaying wiseSaying2 = new WiseSaying(2,"aaa2", "bbb2");
        WiseSaying wiseSaying3 = new WiseSaying(3,"aaa3", "bbb3");

        wiseSayingRepository.save(wiseSaying1);
        wiseSayingRepository.save(wiseSaying2);
        wiseSayingRepository.save(wiseSaying3);

        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();

        assertThat(wiseSayings).hasSize(3);
        assertThat(wiseSayings).contains(wiseSaying1, wiseSaying2, wiseSaying3);

    }
}
