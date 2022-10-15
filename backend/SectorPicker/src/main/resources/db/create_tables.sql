DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS sector;

CREATE TABLE sector
(
    sector_id INT GENERATED ALWAYS AS IDENTITY,
    name      VARCHAR(128) NOT NULL,
    parent_id INT DEFAULT NULL,
    PRIMARY KEY (sector_id),
    CONSTRAINT fk_parent_id
        FOREIGN KEY (parent_id)
            REFERENCES sector (sector_id)
);