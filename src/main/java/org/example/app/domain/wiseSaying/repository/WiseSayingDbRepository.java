package org.example.app.domain.wiseSaying.repository;

import org.example.app.domain.wiseSaying.WiseSaying;
import org.example.app.standard.simpleDb.SimpleDb;
import org.example.app.standard.simpleDb.Sql;

import java.util.Optional;

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
        simpleDb.run("TRUNCATE article");
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        Sql sql = simpleDb.genSql();
        sql.append("INSERT INTO wise_saying ")
                .append("SET content = ?", wiseSaying.getContent())
                .append("author = ?", wiseSaying.getAuthor());
        sql.insert();

        return wiseSaying;
    }

    public Optional<WiseSaying> findById(int id) {

        Sql sql = simpleDb.genSql();
        sql.append("SELECT *")
                .append("FROM wise_saying")
                .append("WHERE id = ?", id);
        WiseSaying wiseSaying = sql.selectRow(WiseSaying.class);
        return Optional.of(wiseSaying);
    }
}
