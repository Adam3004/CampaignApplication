package pl.campaignapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.campaignapplication.campaign.Campaign;
import pl.campaignapplication.keyword.Keyword;
import pl.campaignapplication.service.CampaignService;
import pl.campaignapplication.service.KeywordsService;

import java.security.Key;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campaigns")
public class Controller {
    private final CampaignService campaignService;
    private final KeywordsService keywordsService;

    //stworzyłem tylko jeden kontorler dla obu service, ponieważ nie dałem rady stworzyć drugiego, aby działał jak należy
    @GetMapping("/keywords/{campaignId}")
    public List<Keyword> getCampaignKeywords(@PathVariable("campaignId") long campaignId){
        return keywordsService.getCampaignKeywords(campaignId);
    }
    @GetMapping("/keyword/{id}")
    public Keyword getSingleKeyword(@PathVariable("id") long id){
        return keywordsService.getSingleKeyword(id);
    }

    @PostMapping("/keyword/{campaignId}")
    public String addCampaignKeyword(@PathVariable("campaignId") long campaignId, @RequestBody Keyword keyword){
        return keywordsService.addCampaignKeyword(campaignId, keyword);
    }

    @PutMapping("/keyword/{id}")
    public Keyword updateKeyword(@PathVariable("id") long id, @RequestBody Keyword keyword){
        return keywordsService.updateKeyword(id, keyword);
    }

    @DeleteMapping("/keyword/{id}")
    public String deleteKeyword(@PathVariable("id") long id){
        return keywordsService.deleteKeyword(id);
    }

    @GetMapping
    public List<Campaign> getCampaings() {
        return campaignService.getCampaigns();
    }

    @GetMapping("/{id}")
    public Campaign getSingleCampaign(@PathVariable("id") long id) {
        return campaignService.getSingleCampaign(id);
    }

    @PostMapping()
    public String addCampaign(@RequestBody Campaign campaign) {
        return campaignService.addCampaign(campaign);
    }

    @PutMapping("/{id}")
    public String updateCampaign(@PathVariable("id") Long id, @RequestBody Campaign campaign){
        return campaignService.updateCampaign(id, campaign);
    }

    @DeleteMapping("/{id}")
    public String deleteCampaign(@PathVariable("id") long id){
        return campaignService.deleteCampaign(id);
    }

}
