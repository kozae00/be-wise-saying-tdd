package org.example.app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.WiseSaying;
import org.example.app.standard.Util;

import java.util.*;

public class WiseSayingFileRepository implements WiseSayingRepository {

    private static final String DB_PATH = "db/test/wiseSaying/";
    private final List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingFileRepository() {
        wiseSayingList = new ArrayList<>();
        System.out.println("파일 DB 사용");
    }

    public WiseSaying save(WiseSaying wiseSaying) {

        // 파일 만들기
        Util.Json.writeAsMap(getFilePath(wiseSaying.getId()), wiseSaying.toMap());
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public boolean deleteById(int id) {
        // return wiseSayingList.removeIf(w -> w.getId() == id); // 삭제 성공 : true, 삭제 실패 : false
        return Util.File.delete("db/wiseSaying/%d.json".formatted(id));
    }

    public Optional<WiseSaying> findById(int id) {
        String path = getFilePath(id);
        Map<String, Object> map = Util.Json.readAsMap(path);
        if(map.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(WiseSaying.fromMap(map));
    }

    private String getFilePath(int id) {
        return DB_PATH + id + ".json";
    }
}
