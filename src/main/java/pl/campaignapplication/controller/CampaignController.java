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
        String word = "requested word"; // it have to be repaired
        return campaignService.addCampaign(campaign, word);
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
