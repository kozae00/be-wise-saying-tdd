package org.example.app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.Page;
import org.example.app.domain.wiseSaying.WiseSaying;

import java.util.Optional;

public interface WiseSayingRepository {

    WiseSaying save(WiseSaying wiseSaying);
    Page<WiseSaying> findAll(int itemsPerPage, int page);
    boolean deleteById(int id);
    Optional<WiseSaying> findById(int id);
    void build();
    int count();
    void makeSampleData(int cnt);
    Page<WiseSaying> findByKeyword(String ktype, String kw, int itemsPerPage, int page);
    void createTable();
    void truncateTable();
}
