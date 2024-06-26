--INSERT INTO game_category(category_id,category_name, category_description, category_thumbnail, category_url ) values
--(1, '축구 선수 사진 보고 이름 맞추기(현역)', '축구 선수 사진을 보고 이름을 맞춰봐' , 'https://yt3.googleusercontent.com/YX4OsyDiIve5FRwgEIs1eFzn5PwDUc8vPsLRSWP4bWagBsVNRPEIdleAw8eMuac45aupDfEHkA=s900-c-k-c0x00ffffff-no-rj', '/who-are-you');
--
--
--INSERT INTO level_category(levels, min_correct_answers, max_correct_answers) values
--('뉴비' , 0 , 5),
--('패션' , 6 , 10),
--('라이트팬',11 , 15),
--('고인물', 16, 19),
--('썩은물', 20, 20);
--
--insert into league_category(league, league_emblem) values
--('PREMIER_LEAGUE', 'https://upload.wikimedia.org/wikipedia/ko/thumb/7/73/%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8_%EB%A1%9C%EA%B3%A0.png/375px-%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8_%EB%A1%9C%EA%B3%A0.png'),
--('LA_LIGA', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/LaLiga_EA_Sports_2023_Vertical_Logo.svg/300px-LaLiga_EA_Sports_2023_Vertical_Logo.svg.png'),
--('SERIE_A', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Serie_A_logo_2022.svg/225px-Serie_A_logo_2022.svg.png'),
--('BUNDES_LIGA', 'https://upload.wikimedia.org/wikipedia/ko/thumb/2/2c/%EB%B6%84%EB%8D%B0%EC%8A%A4%EB%A6%AC%EA%B0%80_%EB%A1%9C%EA%B3%A0.svg/300px-%EB%B6%84%EB%8D%B0%EC%8A%A4%EB%A6%AC%EA%B0%80_%EB%A1%9C%EA%B3%A0.svg.png'),
--('LEGUE_1', 'https://upload.wikimedia.org/wikipedia/ko/thumb/8/85/%EB%A6%AC%EA%B7%B8_1_%EB%A1%9C%EA%B3%A0.svg/225px-%EB%A6%AC%EA%B7%B8_1_%EB%A1%9C%EA%B3%A0.svg.png');
--
--
----TEST DATA
--
----insert into team_category (team_name, team_emblem, league) values
----('아틀레티코 마드리드', 'https://i.namu.wiki/i/lMqcxJZ1Rzt6xUjQ5oSRWfZre6QgW0np7nb9xzIGrqPq3aAs9U4I3TuPQyun7FRneuqWuL2gg_c1eOvhJKB4H_WKvfb7gWpaHdtaao5Tn353Kbgxdr3yZHpdjgM-dsEBqD3MDrN0tsPFpmwZ4smUjg.svg','Laliga'),
----('레알 마드리드', 'https://i.namu.wiki/i/y9beRpjSm-07bFzfcaZZ95v3LaJz7dCg5rDM_3PL7BembuCtMNZ2fJBAjLFAuE0lQP1pm6GA2cgW85jJM9_KUyrfbwehIGZbY7ns6xdGK_eegspLCpvHpojIqPbG0y1QBYjKyzLqq0lFBNSL8ql72g.svg' ,'Laliga'),
----('바르셀로나', 'https://i.namu.wiki/i/fpe-G8vS-1tRDpxzXWusnmRiDU2GL_rA25nNWD9OLtNDTaSfM_u84DeS7HPhPWX8hm5pIHBugEWR6lj5VH08Qg.svg' ,'Laliga'),
----('레알 소시에다드', 'https://i.namu.wiki/i/PYQ_9wWJE5_TcSQu14kmo34U-NOjaDjc3aEAd3c4FhDWN1lU8iaHOOrdGYtKcJ5RT4halCKOmLEt2LwMNTTmLQ.svg' ,'Laliga'),
----('그라나다', 'https://i.namu.wiki/i/jIxO10OigoKwmzqDqM5ph3-e4OxqJqT2FSSWDjXaqUZCzP5O2hWwOpgICkf7YIyF2lpJ8jQQDJW7j1XhEVPI6A.svg' ,'Laliga'),
----('첼시', 'https://i.namu.wiki/i/lC_JEj4UOKxxmld_-t6mfevHbvzwO_-aiqppfqZ-NtKbkDkCkbbzna1HxfrTZJrX7hSXmAxhANS_Ckxr0XNLxlAghFKq_GWXUbvXCxV7Nza8DqZqmmmd08ACVKa51nzJSioxo4NJomjdgOSGxfyApA.svg','프리미어리그'),
----('나폴리', 'https://i.namu.wiki/i/ISJnVSF5iwipwPMEHAXVsGv3c1pgt2AJ9JzmQJNR1UyyH9YmiqRF7b1nxNa_QYEp3UDrkU8CuWogHcdcQ5ty-6pM54dTZZ66sLw0JTO8AbFPjbpmkN8mMPAqoZeSt3xbDpx14NGpYpoC1xEVIrlwdA.svg', '세리에'),
----('도르트문트', 'https://i.namu.wiki/i/pO641DHNLInam_HbfikSs5CnMDZBYO6FuzT0stgWhc2E7KEzd9G5KiPmZC_-ThoMIGJw3ASB9_QPEJK8wCpg5juytUtfebetAgnZGF0iK2JNYT6LXu6pNFGiSkadj2F9OC9r2W6OjmJN-3POLgC_-g.svg', '분데스리가');
--
----INSERT INTO league_category(league_emblem, league) values
----('https://upload.wikimedia.org/wikipedia/ko/thumb/7/73/%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8_%EB%A1%9C%EA%B3%A0.png/375px-%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8_%EB%A1%9C%EA%B3%A0.png', 'Premier League'
----);
--
----INSERT INTO team_category(league, team_emblem, team_name) values
----('LA_LIGA', 'https://i.namu.wiki/i/lMqcxJZ1Rzt6xUjQ5oSRWfZre6QgW0np7nb9xzIGrqPq3aAs9U4I3TuPQyun7FRneuqWuL2gg_c1eOvhJKB4H_WKvfb7gWpaHdtaao5Tn353Kbgxdr3yZHpdjgM-dsEBqD3MDrN0tsPFpmwZ4smUjg.svg' ,'아틀레티코 마드리드');
--
----INSERT INTO players(name, image_url, team_name) values
----('오블락','https://assets.laliga.com/squad/2023/t175/p81352/512x512/p81352_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----('고미스', 'https://assets.laliga.com/squad/2023/t175/p493104/512x512/p493104_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('히메네스', 'https://assets.laliga.com/squad/2023/t175/p151883/512x512/p151883_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('아스필리쿠에타', 'https://assets.laliga.com/squad/2023/t175/p41328/512x512/p41328_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('사비치', 'https://assets.laliga.com/squad/2023/t175/p65807/512x512/p65807_t175_2023_1_003_000.png','아틀레티코 마드리드');
----
----('몰리나', 'https://assets.laliga.com/squad/2023/t175/p221586/512x512/p221586_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('에르모소', 'https://assets.laliga.com/squad/2023/t175/p213431/512x512/p213431_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('헤이닐두', 'https://assets.laliga.com/squad/2023/t175/p434399/512x512/p434399_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('코스티스', 'https://assets.laliga.com/squad/2023/t175/p551309/512x512/p551309_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('데폴', 'https://assets.laliga.com/squad/2023/t175/p119141/512x512/p119141_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('코케', 'https://assets.laliga.com/squad/2023/t175/p77390/512x512/p77390_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('사울', 'https://assets.laliga.com/squad/2023/t175/p89335/512x512/p89335_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('르마', 'https://assets.laliga.com/squad/2023/t175/p167449/512x512/p167449_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('요렌테', 'https://assets.laliga.com/squad/2023/t175/p192364/512x512/p192364_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('비첼', 'https://assets.laliga.com/squad/2023/t175/p41189/512x512/p41189_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('리켈메', 'https://assets.laliga.com/squad/2023/t175/p437834/512x512/p437834_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----('바리오스', 'https://assets.laliga.com/squad/2023/t175/p503523/512x512/p503523_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('그리즈만', 'https://assets.laliga.com/squad/2023/t175/p76650/512x512/p76650_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('데파이', 'https://assets.laliga.com/squad/2023/t175/p106824/512x512/p106824_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('코레아', 'https://assets.laliga.com/squad/2023/t175/p156223/512x512/p156223_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('리누', 'https://assets.laliga.com/squad/2023/t175/p249823/512x512/p249823_t175_2023_1_003_000.png','아틀레티코 마드리드'),
----
----('모라타', 'https://assets.laliga.com/squad/2023/t175/p88482/512x512/p88482_t175_2023_1_003_000.png','아틀레티코 마드리드');
--
--
--
