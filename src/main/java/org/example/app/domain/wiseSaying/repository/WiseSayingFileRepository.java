package org.example.app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.WiseSaying;
import org.example.app.standard.Util;

import java.nio.file.Path;
import java.util.*;

public class WiseSayingFileRepository implements WiseSayingRepository {

    private static final String DB_PATH = "db/test/wiseSaying/";

    public WiseSayingFileRepository() {
        System.out.println("파일 DB 사용");
    }

    public WiseSaying save(WiseSaying wiseSaying) {

        Util.Json.writeAsMap(getFilePath(wiseSaying.getId()), wiseSaying.toMap());
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {

        return Util.File.getPaths(DB_PATH).stream()
                .map(Path::toString)
                .map(Util.Json::readAsMap)
                .map(WiseSaying::fromMap)
                .toList();

    }

    public boolean deleteById(int id) {
        return Util.File.delete(getFilePath(id));
    }

    public Optional<WiseSaying> findById(int id) {
        String path = getFilePath(id);
        Map<String, Object> map = Util.Json.readAsMap(path);

        if (map.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(WiseSaying.fromMap(map));

    }

    private String getFilePath(int id) {
        return DB_PATH + id + ".json";
    }
}
