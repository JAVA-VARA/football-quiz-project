//package com.example.footballquizproject.service;
//
//import com.example.footballquizproject.domain.Players;
//import com.example.footballquizproject.domain.TeamCategory;
//import com.example.footballquizproject.repository.PlayersRepository;
//import com.example.footballquizproject.repository.TeamCategoryRepository;
//import lombok.RequiredArgsConstructor;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class JsoupTest {
//
//    private final TeamCategoryRepository teamCategoryRepository;
//    private final PlayersRepository playersRepository;
//
//    private static final String URL_ATM = "https://namu.wiki/w/%EC%95%84%ED%8B%80%EB%A0%88%ED%8B%B0%EC%BD%94%20%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C";
//
////    private static final String URL_RM = "https://namu.wiki/w/%EB%B3%B4%EB%A3%A8%EC%8B%9C%EC%95%84%20%EB%8F%84%EB%A5%B4%ED%8A%B8%EB%AC%B8%ED%8A%B8";
//
//
//    private static final String team_name = "아틀레티코 마드리드";
//
//    @Transactional
////    @PostConstruct
//    public List<Players> getPlayersInfo() throws IOException {
//
//        TeamCategory team = teamCategoryRepository.findTeamCategoriesByTeamName(team_name);
//        List<Players> playersInfo = new ArrayList<>();
//
//
//        Document doc = Jsoup.connect(URL_ATM).get();
//
//
//        Elements div1 = doc.getElementsByClass("BFgp7eXo");
//        Elements div2 = div1.select("div[class^=_9zSC-Hta]");
//        Elements table1 = div2.select("table[class^=_1W4KUSzU]");
//        Elements div3 = table1.select("div[class=dkYV+6r2]");
//
//        Elements div4 = div3.select("div[class=_9zSC-Hta]");
//        Elements table2 = div4.select("table[class^=_1W4KUSzU]");
//        Elements div5 = table2.select("div[class=dkYV+6r2]");
//
//
//        Elements a = div5.select("a[class=b8VqAR6G]");
//        Elements span1 = a.select("span[class=Z1BL0yTj]");
//        Elements span2 = span1.select("span[class=cCoTwOHF]");
//        Elements imgElements = span2.select("img[class=CVF0kzUU]");
//
//        Elements playersWebpElements = imgElements.select("img[src$=.webp]");
//
//
//        for (Element playerImg : playersWebpElements) {
//
//            String playerImage = playerImg.attr("src");
//            String playerName = playerImg.attr("alt");
//
//            Players player = Players.builder()
//                    .imageUrl(playerImage) // 이미지 링크
//                    .name(playerName)// 이름
//                    .team(team)
//                    .build();
//
//            playersInfo.add(player);
//
//        }
//        playersRepository.saveAll(playersInfo);
//
//        /*TO-DO: 받아온 URL IMAGE를 다운로드
//         * */
//
//
//        return playersInfo;
//    }
//
//}