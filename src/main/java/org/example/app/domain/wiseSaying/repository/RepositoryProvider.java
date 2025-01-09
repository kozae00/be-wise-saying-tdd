package org.example.app.domain.wiseSaying.repository;

public class RepositoryProvider {

    public static WiseSayingRepository provide() {
//        if(AppConfig.isFileDb()) {
//            return new WiseSayingFileRepository();
//        } else { // File이랑 Mem만 있어어 else로만 사용해도 무관
//            return new WiseSayingMemRepository();
//        }
            return new WiseSayingFileRepository();
    }
}
