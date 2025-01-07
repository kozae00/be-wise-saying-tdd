package app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.WiseSaying;
import org.example.app.domain.wiseSaying.repository.WiseSayingFileRepository;
import org.example.app.domain.wiseSaying.repository.WiseSayingRepository;
import org.example.app.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class WiseSayingFileRepositoryTest {
    
    WiseSayingRepository wiseSayingRepository = new WiseSayingFileRepository();
    
    @Test
    @DisplayName("명언 저장")
    void t1() {

        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");
        wiseSayingRepository.save(wiseSaying);

        String filePath = "db/wiseSaying/1.json";

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
        String filePath = "db/wiseSaying/1.json";
        boolean delRst = wiseSayingRepository.deleteById(1);
        boolean rst = Files.exists(Path.of(filePath));
        assertThat(rst).isFalse();
        assertThat(delRst).isTrue();
    }
}
