package org.example.app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.WiseSaying;
import org.example.app.standard.simpleDb.SimpleDb;

public class WiseSayingDbRepository {

    private final SimpleDb simpleDb;

    public WiseSayingDbRepository() {
        this.simpleDb = new SimpleDb("localhost", "root", "lldj123414", "simpleDb__test");
    }

    public void createWsieSayingTable() {
        simpleDb.run("DROP TABLE IF EXISTS wise_saying");

        simpleDb.run("""
                CREATE TABLE article (
                    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    content VARCHAR(100) NOT NULL,
                    author VARCHAR(100),
                )
                """);
    }

    public void truncateWiseSayingTable() {
    }
}
