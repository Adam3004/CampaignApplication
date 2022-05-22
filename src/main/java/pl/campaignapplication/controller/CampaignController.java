package pl.campaignapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.campaignapplication.campaign.Campaign;
import pl.campaignapplication.seller.Seller;
import pl.campaignapplication.service.CampaignService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campaigns")
public class CampaignController {
    private final CampaignService campaignService;

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
        String word = "xd";
        return campaignService.addCampaign(campaign, word);
    }

}
