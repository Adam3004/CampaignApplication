package pl.campaignapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.campaignapplication.campaign.Campaign;
import pl.campaignapplication.keyword.Keyword;
import pl.campaignapplication.service.CampaignService;
import pl.campaignapplication.service.KeywordsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campaigns")
public class Controller {
    private final CampaignService campaignService;
    private final KeywordsService keywordsService;

    //stworzyłem tylko jeden kontorler dla obu service, ponieważ nie dałem rady stworzyć drugiego, aby działał jak należy
    @GetMapping("/keywords/{id}")
    public List<Keyword> getCampaignKeywords(@PathVariable("id") long id){
        return keywordsService.getCampaignKeywords(id);
    }

    @PostMapping("/keywords/{campaignId}")
    public String addCampaignKeyword(@PathVariable("campaignId") long campaignId, @RequestBody Keyword keyword){
        return keywordsService.addCampaignKeyword(campaignId, keyword);
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
