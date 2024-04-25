//package com.example.footballquizproject.util;
//
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WebCrawler {
//
//    /**조회할 URL셋팅 및 Document 객체 로드하기*/
//    public static final String url_ATM = "https://namu.wiki/w/%EC%95%84%ED%8B%80%EB%A0%88%ED%8B%B0%EC%BD%94%20%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C";
//
//    public void process(){
//        //Jsoup 커넥션 생성
//        Connection conn = Jsoup.connect(url_ATM);
//
//        Document document = null;
//
//        try{
//            document = conn.get();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        List<String> list = getDataList(document);
//    }
//
//    /**
//     * data가져오기
//     */
//    private List<String> getDataList(Document document) {
//        List<String> list = new ArrayList<>();
////        Element selects = document.select();
//        return null;
//    }
//
//}
