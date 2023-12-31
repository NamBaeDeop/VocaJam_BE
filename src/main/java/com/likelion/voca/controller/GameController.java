package com.likelion.voca.controller;

import com.likelion.voca.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") // 경우에 따라 3001번으로 변경 필요
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService GameService;

    @GetMapping("/jp")
    public ResponseEntity<Map<String, String>> getJPWordGame() {
        // 랜덤한 일본어 단어와 해당 단어의 의미를 가져오기
        Map<String, String> wordAndMeaning = GameService.getRandomJPWordAndMeaning();

        // 랜덤한 세 개의 다른 의미를 가져오기
        List<String> otherMeanings = GameService.getRandomOtherJPMeanings(wordAndMeaning.get("meaning"));

        // 응답에 필요한 데이터 구성
        Map<String, String> response = new HashMap<>();
        response.put("word", wordAndMeaning.get("word"));
        response.put("meaning", wordAndMeaning.get("meaning"));
        response.put("pronunciation", wordAndMeaning.get("pronunciation"));
        response.put("otherMeaning1", otherMeanings.get(0));
        response.put("otherMeaning2", otherMeanings.get(1));
        response.put("otherMeaning3", otherMeanings.get(2));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/cn")
    public ResponseEntity<Map<String, String>> getCNWordGame() {
        // 랜덤한 일본어 단어와 해당 단어의 의미를 가져오기
        Map<String, String> wordAndMeaning = GameService.getRandomCNWordAndMeaning();

        // 랜덤한 세 개의 다른 의미를 가져오기
        List<String> otherMeanings = GameService.getRandomOtherCNMeanings(wordAndMeaning.get("meaning"));

        // 응답에 필요한 데이터 구성
        Map<String, String> response = new HashMap<>();
        response.put("word", wordAndMeaning.get("word"));
        response.put("meaning", wordAndMeaning.get("meaning"));
        response.put("pronunciation", wordAndMeaning.get("pronunciation"));
        response.put("otherMeaning1", otherMeanings.get(0));
        response.put("otherMeaning2", otherMeanings.get(1));
        response.put("otherMeaning3", otherMeanings.get(2));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/en")
    public ResponseEntity<Map<String, String>> getENWordGame() {
        // 랜덤한 일본어 단어와 해당 단어의 의미를 가져오기
        Map<String, String> wordAndMeaning = GameService.getRandomENWordAndMeaning();

        // 랜덤한 세 개의 다른 의미를 가져오기
        List<String> otherMeanings = GameService.getRandomOtherENMeanings(wordAndMeaning.get("meaning"));

        // 응답에 필요한 데이터 구성
        Map<String, String> response = new HashMap<>();
        response.put("word", wordAndMeaning.get("word"));
        response.put("meaning", wordAndMeaning.get("meaning"));
        response.put("otherMeaning1", otherMeanings.get(0));
        response.put("otherMeaning2", otherMeanings.get(1));
        response.put("otherMeaning3", otherMeanings.get(2));

        return ResponseEntity.ok(response);
    }
}
