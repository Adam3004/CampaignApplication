//package pl.campaignapplication.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import pl.campaignapplication.keyword.Keyword;
//import pl.campaignapplication.service.KeywordsService;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/campaignss")
//public class KeywordsController {
//    private final KeywordsService keywordsService;
//
//    @GetMapping("/keywords/{id}")
//    public List<Keyword> getCampaignKeywords(@PathVariable("id") long id){
//        return keywordsService.getCampaignKeywords(id);
//    }
//
//    @PostMapping("/keywords/{campaignId}")
//    public String addCampaignKeyword(@PathVariable("campaignId") long campaignId, @RequestBody Keyword keyword){
//        return keywordsService.addCampaignKeyword(campaignId, keyword);
//    }
//}
