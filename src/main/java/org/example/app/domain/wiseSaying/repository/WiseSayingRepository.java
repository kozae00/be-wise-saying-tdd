package org.example.app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.Page;
import org.example.app.domain.wiseSaying.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {
    WiseSaying save(WiseSaying wiseSaying);
    Page findAll(int itemsPerPage, int page);
    boolean deleteById(int id);
    Optional<WiseSaying> findById(int id);
    void build();
    void makeSampleData(int cnt);
    int count();
}
