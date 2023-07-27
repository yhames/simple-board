INSERT INTO `USER`(`NAME`, `PASSWORD`)
VALUES ("user1", "1234");

INSERT INTO `USER`(`NAME`, `PASSWORD`)
VALUES ("user2", "1234");

INSERT INTO `USER`(`NAME`, `PASSWORD`)
VALUES ("user3", "1234");


INSERT INTO `POST`(`USER_ID`, `CATEGORY`, `TITLE`, `CONTENT`)
VALUES (1, "수필",
        "청춘예찬",
        "힘차게 생명을 청춘의 구하지 이상은 내려온 가치를 예가 듣는다. 청춘의 귀는 석가는 피에 품었기 내려온 황금시대다. 가치를 아니한 같이, 실로 석가는 뜨고, 속에서 끓는다. 간에 보내는 것은 속에 때까지 것은 할지니, 그리하였는가? 가슴이 뼈 곳으로 용감하고 뿐이다. 청춘을 아름답고 두기 새 가슴에 얼음에 인간에 때문이다.");

INSERT INTO `POST`(`USER_ID`, `CATEGORY`, `TITLE`, `CONTENT`)
VALUES (2, "시",
        "별 헤는 밤",
        "북간도에 다 하나의 거외다. 애기 별들을 하나에 같이 무덤 다 봅니다. 하나의 아무 계절이 때 까닭입니다. 내일 마리아 아스라히 옥 애기 위에 봅니다. 내린 계절이 이름을 남은 부끄러운 소녀들의 오는 거외다. 묻힌 어머니, 토끼, 다 나는 까닭이요, 차 부끄러운 까닭입니다.");

INSERT INTO `POST`(`USER_ID`, `CATEGORY`, `TITLE`, `CONTENT`)
VALUES (3, "수필",
        "청춘예찬2",
        "우리 피가 없으면, 아니더면, 운다. 청춘 싸인 피부가 같지 불어 역사를 이것이다. 우리 실현에 것이 하는 수 미인을 그들은 옷을 때문이다. 보배를 과실이 피는 충분히 무엇을 이상은 인간이 뜨거운지라, 이것이다. 얼음과 위하여서, 옷을 되려니와, 끓는다.");

INSERT INTO `POST`(`USER_ID`, `CATEGORY`, `TITLE`, `CONTENT`)
VALUES (1, "시",
        "별 헤는 밤2",
        "어머니, 다 어머님, 소녀들의 토끼, 말 피어나듯이 이웃 계집애들의 있습니다. 불러 시와 시인의 내린 있습니다. 내린 위에도 풀이 우는 계십니다. 아이들의 하나의 노루, 거외다. 별 남은 다 이런 어머니 오는 이름을 있습니다. 피어나듯이 추억과 너무나 그리고 별 프랑시스 부끄러운 봅니다. 파란 비둘기, 하나 별 그리워 이름과, 이제 있습니다. 이름자를 패, 오면 지나고 위에 이름과, 한 파란 못 거외다. 새워 마리아 둘 별에도 까닭입니다.");


INSERT INTO `COMMENT`(`USER_ID`, `POST_ID`, `CONTENT`)
VALUES (1, 1, "이것은 첫번쨰 댓글입니다.");

INSERT INTO `COMMENT`(`USER_ID`, `POST_ID`, `CONTENT`)
VALUES (2, 1, "이것은 두번째 댓글입니다.");

INSERT INTO `COMMENT`(`USER_ID`, `POST_ID`, `CONTENT`)
VALUES (3, 1, "이것은 세번째댓글입니다.");