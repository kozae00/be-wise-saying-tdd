package org.example.app.domain.wiseSaying.repository;

import org.example.app.global.AppConfig;

public class RepostioryProvider {

    public static WiseSayingRepository provide() {
        if(AppConfig.isFileDb()) {
            return new WiseSayingFileRepository();
        } else { // File이랑 Mem만 있어어 else로만 사용해도 무관
            return new WiseSayingMemRepository();
        }
    }
}
