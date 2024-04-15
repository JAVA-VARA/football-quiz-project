package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WebCrawlingPlayersService {

    private final TeamCategoryRepository teamCategoryRepository;
    private final PlayersRepository playersRepository;

    private static final String URL_ATM = "https://namu.wiki/w/%EC%95%84%ED%8B%80%EB%A0%88%ED%8B%B0%EC%BD%94%20%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C";

//    private static final String URL_RM = "https://namu.wiki/w/%EB%B3%B4%EB%A3%A8%EC%8B%9C%EC%95%84%20%EB%8F%84%EB%A5%B4%ED%8A%B8%EB%AC%B8%ED%8A%B8";


    private static final String team_name = "아틀레티코 마드리드";

    @Transactional
    public List<Players> getPlayersInfo() throws IOException {

        TeamCategory team = teamCategoryRepository.findTeamCategoriesByTeamName(team_name);
        List<Players> playersInfo = new ArrayList<>();


        Document doc = Jsoup.connect(URL_ATM).get();


        Elements div1 = doc.getElementsByClass("BFgp7eXo");
        Elements div2 = div1.select("div[class^=_9zSC-Hta]");
        Elements table1 = div2.select("table[class^=_1W4KUSzU]");
        Elements div3 = table1.select("div[class=dkYV+6r2]");

        Elements div4 = div3.select("div[class=_9zSC-Hta]");
        Elements table2 = div4.select("table[class^=_1W4KUSzU]");
        Elements div5 = table2.select("div[class=dkYV+6r2]");


        Elements a = div5.select("a[class=b8VqAR6G]");
        Elements span1 = a.select("span[class=Z1BL0yTj]");
        Elements span2 = span1.select("span[class=cCoTwOHF]");
        Elements imgElements = span2.select("img[class=CVF0kzUU]");

        Elements playersWebpElements = imgElements.select("img[src$=.webp]");


        for (Element playerImg : playersWebpElements) {

            String playerImage = playerImg.attr("src");
            String playerName = playerImg.attr("alt");

            Players player = Players.builder()
                    .imageUrl(playerImage) // 이미지 링크
                    .name(playerName)// 이름
                    .team(team)
                    .build();

            playersInfo.add(player);

        }
        playersRepository.saveAll(playersInfo);

        return playersInfo;
    }

}
//
//    // img 클래스가 "CVF0kzUU"인 모든 이미지 요소 선택 => 선수 사진 저장되어 있음. attr("src")
//    Elements imgElements = doc.select("img.CVF0kzUU");
//
//    // a 클래스가 "b8VqAR6G"인 모든  요소 선택 => 선수 이름 저장되어 있음. attr("title")
//    Elements playersName = doc.select("a.b8VqAR6G");
//
//        for (int i = 0; i < imgElements.size(); i++) {
//        Element imgElement = imgElements.get(i);
//        Element playerName = playersName.get(i);
//
//        String imageUrl = imgElement.attr("src");
//        String name = playerName.attr("title");
//
//        Players player = Players.builder()
//        .imageUrl(imageUrl) // 이미지 링크
//        .name(name)        // 이름
//        .build();
//
//        // Players 객체를 리스트에 추가합니다.
//        playersInfo.add(player);
//
//
//
//        }

// 테이블 클래스가 "_1W4KUSzU"로 시작하는 요소 선택
//        Element table = doc.selectFirst("div[class=BFgp7eXo]");

//        Element table = doc.select("table[class=_1W4KUSzU_0171955f146ebd53531f53d883e96584]");


// div 클래스가 "dkYV+6r2"인 요소 선택
//        assert table != null;
//        assert table != null;
//        Elements divs = table.getClass("div[class=dkYV+6r2]");
//        Elements span1 = divs.select("span[class=Z1BL0yTj]");
//        Elements a = span1.select("a[class=b8VqAR6G]"); //여기서 title 값이 선수 이름
//        Elements span2 = a.select("span[class=Z1BL0yTj]");



//        for (Element div : divs) {
//            // a 클래스가 "b8VqAR6G"인 요소 선택
//            Elements links = span.select("img[class=CVF0kzUU]");
//
//            // 선택된 링크 출력
//            for (Element link : links) {
//                String src = link.attr("src");
//                System.out.println("Href: " + src);
//
//                Players player = Players.builder()
//                        .imageUrl(src) // 이미지 링크
//                        .name(src)        // 이름
//                        .build();
//
//                // Players 객체를 리스트에 추가합니다.
//                playersInfo.add(player);
//
//            }
//        }





