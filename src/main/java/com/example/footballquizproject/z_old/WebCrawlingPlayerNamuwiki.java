//package com.example.footballquizproject.service;
//
//import com.example.footballquizproject.domain.Players;
//import com.example.footballquizproject.domain.TeamCategory;
//import com.example.footballquizproject.repository.PlayersRepository;
//import com.example.footballquizproject.repository.TeamCategoryRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class WebCrawlingPlayerNamuwiki {
//
//    private final static String WEB_DRIVER_PATH = "C:\\Users\\sjyou\\Downloads\\chromedriver-win64\\chromedriver.exe";
//    private final TeamCategoryRepository teamCategoryRepository;
//    private final PlayersRepository playersRepository;
//
//    private static final String URL_SSC = "https://namu.wiki/w/SSC%20%EB%82%98%ED%8F%B4%EB%A6%AC#s-4";
//
//    private static final String testURL ="https://www.google.com/search?q=springboot+jsoup&rlz=1C1GCEB_enKR1106KR1106&oq=springboot+js&gs_lcrp=EgZjaHJvbWUqBggAEEUYOzIGCAAQRRg7MgYIARBFGDkyBwgCEAAYgAQyBwgDEAAYgAQyBwgEEAAYgAQyBwgFEAAYgAQyBggGEEUYPTIGCAcQRRg80gEINDcxM2owajeoAgCwAgA&sourceid=chrome&ie=UTF-8";
//    private static final String team_name = "SSC 나폴리";
//
////    @PostConstruct
//    public List<Players> getPlayersInfo() throws InterruptedException {
//
//        TeamCategory team = teamCategoryRepository.findTeamCategoriesByTeamName(team_name);
//        List<Players> playersInfoList = new ArrayList<>();
//
//        //크롬 드라이버 셋팅 (드라이버 설치한 경로 입력)
//        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
//
//        // 크롬 드라이버 사용
//        WebDriver driver = new ChromeDriver();
//        driver.get(testURL);
//        Thread.sleep(1000);
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");
//
////        String fullX= "/html/body/div/main/div[2]/div[4]/article/div[4]/div/div[2]/div/div/div[15]/div[1]/table/tbody/tr[2]/td/div/div/dl/dd/div/div[1]/table/tbody/tr[2]/td[1]/div/div/span/span/img[2]";
////        String X = //*[@id="app"]/main/div[2]/div[4]/article/div[4]/div/div[2]/div/div/div[15]/div[1]/table/tbody/tr[2]/td/div/div/dl/dd/div/div[1]/table/tbody/tr[2]/td[1]/div/div/span/span/img[2];
//
////         페이지 높이만큼 스크롤하면서 이미지 태그 가져오기
//        for (int i = 0; i < pageHeight; i += 1000) {
//            js.executeScript("window.scrollTo(0, " + i + ")");
//            Thread.sleep(1000); // 스크롤 시간을 기다림 (필요에 따라 조절)
//        }
//
////        List<WebElement> expandButtons = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div[2]/div[4]/article/div[4]/div/div[2]/div/div/div[15]/div[1]/table/tbody/tr[2]/td/div/div/dl"));
////        for (WebElement button : expandButtons) {
////            // 버튼이 보이는 위치까지 스크롤하기
////            js.executeScript("arguments[0].scrollIntoView(true);", button);
////            // 버튼 클릭
////            button.click();
////        }
//
//
////        List<WebElement> imgElements =
////                driver.findElements(By.xpath(
////                        "//*[@id=app]/main/div[2]/div[4]/article/div[4]/div/div[2]/div/div/div[15]/div[1]/table/tbody/tr[2]/td/div/div/dl/dd/div/div[1]/table/tbody/tr[2]/td[1]/div/div/span/span/img[2]"
////                        ));
//
////List<WebElement> allElements = driver.findElements(By.cssSelector("div._9kJJZrJx"));
//
////        List<WebElement> allElements2 = driver.findElements(By.cssSelector("div[class='_9kJJZrJx']"));
//
//        List<WebElement> testE = driver.findElements(By.cssSelector("#rso > div.hlcw0c > div > div > div > div.kb0PBd.cvP2Ce.A9Y9g.jGGQ5e > div > div > span > a > h3"));
//
//
////        WebElement element = driver.findElement(By.xpath("//*[@id='app']/main/div[2]/div[4]/article/div[4]/div/div[2]/div/div/div[15]/div[1]/table/tbody/tr[2]/td/div/div/dl/dd/div/div[1]/table/tbody/tr[2]/td[1]/div/div/span/span/img[2]"));
//
////        System.out.println(element);
////        List<WebElement> imgElements = driver.findElements(By.cssSelector("#app > main > div._9kJJZrJx > div.pDlpchRt > article > div.jUYjlxj4 > div > div:nth-child(2) > div > div > div:nth-child(23) > div._9zSC-Hta > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div._9zSC-Hta > table > tbody > tr:nth-child(2) > td:nth-child(1) > div > div > span > span > img.CVF0kzUU"));
//
//        for (int i = 0; i < testE.size(); i++) {
//            String imgURL = testE.get(i).getText();
////            String playerInfo = nameElements.get(i).getAttribute("title");
//
////            String[] parts = playerInfo.split("\n");
////            String playerName = parts[0].trim();
//
//
//            Players player = Players.builder()
//                    .imageUrl(imgURL) // 이미지 링크
//                    .name("playerName")// 이름
//                    .team(team)
//                    .build();
//
//            playersInfoList.add(player);
//
//        }
//
//        driver.close();
//        driver.quit();
//
//        playersRepository.saveAll(playersInfoList);
//
//        return playersInfoList;
//    }
//
//
//}


//    private static final String URL_ATM = "https://namu.wiki/w/%EC%95%84%ED%8B%80%EB%A0%88%ED%8B%B0%EC%BD%94%20%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C";

//    private static final String URL_RM = "https://namu.wiki/w/%EB%B3%B4%EB%A3%A8%EC%8B%9C%EC%95%84%20%EB%8F%84%EB%A5%B4%ED%8A%B8%EB%AC%B8%ED%8A%B8";

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
//                String playerImage = playerImg.attr("src");
//                String playerName = playerImg.attr("alt");
////            String playerName = playerImg.attr("alt");
//
//                Players player = Players.builder()
//                .imageUrl(playerImage) // 이미지 링크
//                .name(playerName)// 이름
//                .team(team)
//                .build();
//
//                playersInfo.add(player);
//
//                }
//                playersRepository.saveAll(playersInfo);


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
//            playersInfoList.add(player);
//
//        }


//        try {
//                Document doc = Jsoup.connect(URL_ATM).get();
//
//                Elements imageWrappers = doc.getElementsByClass("styled__ImageWrapper-sc-1cljep8-2 hclRXE");
//                for (Element imageWrapper : imageWrappers) {
//                // 이미지 태그 선택
//                Element img = imageWrapper.selectFirst("img");
//                if (img != null) {
//                // src 속성 가져오기
//                String src = img.attr("src");
//                System.out.println("이미지 소스: " + src);
//                }
//                }
//                } catch (IOException e) {
//                e.printStackTrace();
//                }


//        Elements imgs = doc.select("img[class^=styled__ImageStyled-sc-17v9b6o-0]");


//        Elements divImg = doc.getElementsByClass("styled__ImageStyled-sc-17v9b6o-0 coeclD");
//
//        Elements imgSrc = doc.select("img");
//
//        Elements playersInfo = doc.getElementsByClass("styled__NameContainer-sc-148d0nz-2 fAPIHU");
//
//        for(int i =0; i < Math.min(imgSrc.size(), playersInfo.size());i++){
//
//            String playerImgURL = imgSrc.get(i).attr("src");
//            String playerName = playersInfo.get(i).text();
//
//            Players player = Players.builder()
//                    .imageUrl(playerImgURL) // 이미지 링크
//                    .name(playerName)// 이름
//                    .team(team)
//                    .build();
//
//            playersInfoList.add(player);
//        }
