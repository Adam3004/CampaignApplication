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

    //    I created one controller both for keyword and campaign because I wasn't able to create second one which work
    //    properly

    //    keyword controller
    @GetMapping("/keywords/{campaignId}")
    public List<Keyword> getCampaignKeywords(@PathVariable("campaignId") long campaignId) {
        return keywordsService.getCampaignKeywords(campaignId);
    }

    @GetMapping("/keyword/{id}")
    public Keyword getSingleKeyword(@PathVariable("id") long id) {
        return keywordsService.getSingleKeyword(id);
    }

    @PostMapping("/keyword/{campaignId}")
    public String addCampaignKeyword(@PathVariable("campaignId") long campaignId, @RequestBody Keyword keyword) {
        return keywordsService.addCampaignKeyword(campaignId, keyword);
    }

    @PutMapping("/keyword/{id}")
    public Keyword updateKeyword(@PathVariable("id") long id, @RequestBody Keyword keyword) {
        return keywordsService.updateKeyword(id, keyword);
    }

    @DeleteMapping("/keyword/{id}")
    public String deleteKeyword(@PathVariable("id") long id) {
        return keywordsService.deleteKeyword(id);
    }

    //    campaign controller
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
    public String updateCampaign(@PathVariable("id") Long id, @RequestBody Campaign campaign) {
        return campaignService.updateCampaign(id, campaign);
    }

    @DeleteMapping("/{id}")
    public String deleteCampaign(@PathVariable("id") long id) {
        return campaignService.deleteCampaign(id);
    }

}
