insert into team_category (team_name, team_emblem, league, league_emblem) values
('아틀레티코 마드리드', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , 'Laliga', 'http://dummyimage.com/238x100.png/ff4444/ffffff'),
('레알 마드리드', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , 'Laliga', 'http://dummyimage.com/238x100.png/ff4444/ffffff'),
('바르셀로나', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , 'Laliga', 'http://dummyimage.com/238x100.png/ff4444/ffffff'),
('레알 소시에다드', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , 'Laliga', 'http://dummyimage.com/238x100.png/ff4444/ffffff'),
('그라나다', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , 'Laliga', 'http://dummyimage.com/238x100.png/ff4444/ffffff'),
('첼시', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , '프리미어리그', 'http://dummyimage.com/238x100.png/ff4444/ffffff'),
('나폴리', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , '세리에 A', 'http://dummyimage.com/238x100.png/ff4444/ffffff'),
('도르트문트', 'http://dummyimage.com/238x100.png/ff4444/ffffff' , '분데스리가 A', 'http://dummyimage.com/238x100.png/ff4444/ffffff');

INSERT INTO players(name, image_url, team_name) values
('a', 'http://dummyimage.com/238x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('b', 'http://dummyimage.com/224x100.png/cc0000/ffffff', '아틀레티코 마드리드'),
('c', 'http://dummyimage.com/117x100.png/dddddd/000000','아틀레티코 마드리드'),
('d', 'http://dummyimage.com/238x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('e', 'http://dummyimage.com/250x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('f', 'http://dummyimage.com/231x100.png/dddddd/000000','아틀레티코 마드리드'),
('g', 'http://dummyimage.com/189x100.png/5fa2dd/ffffff','아틀레티코 마드리드'),
('h', 'http://dummyimage.com/101x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('i', 'http://dummyimage.com/238x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('j', 'http://dummyimage.com/185x100.png/dddddd/000000','아틀레티코 마드리드'),
('k', 'http://dummyimage.com/238x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('l', 'http://dummyimage.com/238x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('m', 'http://dummyimage.com/110x100.png/5fa2dd/ffffff','아틀레티코 마드리드'),
('o', 'http://dummyimage.com/172x100.png/5fa2dd/ffffff','아틀레티코 마드리드'),
('n', 'http://dummyimage.com/223x100.png/cc0000/ffffff','아틀레티코 마드리드'),
('p', 'http://dummyimage.com/116x100.png/5fa2dd/ffffff','아틀레티코 마드리드'),
('q', 'http://dummyimage.com/139x100.png/5fa2dd/ffffff','아틀레티코 마드리드'),
('r', 'http://dummyimage.com/238x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('s', 'http://dummyimage.com/238x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('t', 'http://dummyimage.com/153x100.png/ff4444/ffffff','아틀레티코 마드리드'),
('v', 'http://dummyimage.com/102x100.png/dddddd/000000','아틀레티코 마드리드'),
('u', 'http://dummyimage.com/105x100.png/dddddd/000000','아틀레티코 마드리드');

INSERT INTO game_category(category_id,category_name, category_description, category_thumbnail ) values
(1, '축구 선수 사진 보고 이름 맞추기', '축구 선수 사진을 보고 이름을 맞춰봐' , 'http://dummyimage.com/238x100.png/ff4444/ffffff');

INSERT INTO alias_category(alias, min_correct_answers, max_correct_answers) values
('뉴비' , 0 , 5),
('패션' , 6 , 10),
('라이트팬',11 , 15),
('고인물', 16, 19),
('썩은물', 20, 20);


