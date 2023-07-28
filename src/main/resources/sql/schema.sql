DROP TABLE if exists `USER` CASCADE;
CREATE TABLE `USER`
(
    `ID`       BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `NAME`     VARCHAR(20) NOT NULL,
    `PASSWORD` VARCHAR(20) NOT NULL
);


DROP TABLE if exists `BOARD` CASCADE;
CREATE TABLE `BOARD`
(
    `ID`   BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `NAME` VARCHAR(10) NOT NULL
);


DROP TABLE if exists `POST` CASCADE;
CREATE TABLE `POST`
(
    `ID`                BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `USER_ID`           BIGINT      NOT NULL,
    `BOARD_ID`          BIGINT      NOT NULL,
    `TITLE`             VARCHAR(30) NOT NULL,
    `CONTENT`           TEXT        NOT NULL,
    `CREATED_DATE`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `UPDATED_DATE`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `COUNT_OF_COMMENTS` INT         NOT NULL DEFAULT 0,
    `COUNT_OF_VIEWS`    INT         NOT NULL DEFAULT 0
);


DROP TABLE if exists `COMMENT` CASCADE;
CREATE TABLE `COMMENT`
(
    `ID`           BIGINT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `USER_ID`      BIGINT    NOT NULL,
    `POST_ID`      BIGINT    NOT NULL,
    `CONTENT`      TEXT      NOT NULL,
    `CREATED_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `UPDATED_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);