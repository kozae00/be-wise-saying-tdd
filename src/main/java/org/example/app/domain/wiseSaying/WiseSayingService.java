package org.example.app.domain.wiseSaying;

import org.example.app.domain.wiseSaying.repository.RepostioryProvider;
import org.example.app.domain.wiseSaying.repository.WiseSayingFileRepository;
import org.example.app.domain.wiseSaying.repository.WiseSayingMemRepository;
import org.example.app.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = RepostioryProvider.provide();
    }

    public WiseSaying write(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(content, author);
        return wiseSayingRepository.save(wiseSaying);
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingRepository.findAll();
    }

    public boolean delete(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    public Optional<WiseSaying> getItem(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }
}