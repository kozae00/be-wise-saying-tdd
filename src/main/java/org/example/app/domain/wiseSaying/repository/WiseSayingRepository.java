package org.example.app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {
    WiseSaying save(WiseSaying wiseSaying);
    List<WiseSaying> findAll();
    boolean deleteById(int id);
    Optional<WiseSaying> findById(int id);
    void build();
}
