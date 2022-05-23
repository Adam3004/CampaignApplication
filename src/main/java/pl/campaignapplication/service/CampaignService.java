package pl.campaignapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.campaignapplication.campaign.Campaign;
import pl.campaignapplication.repository.CampaignRrepository;
import pl.campaignapplication.session.Session;
import pl.campaignapplication.tools.CampaignDataUpdater;
import pl.campaignapplication.tools.CampaignFundsCalculator;
import pl.campaignapplication.tools.IsCampaignCorrect;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {
    private final CampaignRrepository campaignRrepository;
    private Session session = new Session();
    private final KeywordsService keywordsService;

    public List<Campaign> getCampaigns() {
        return campaignRrepository.findAll();
    }

    public Campaign getSingleCampaign(long id) {
        return campaignRrepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public String addCampaign(Campaign campaign, String word) {
        int currentBalance = CampaignFundsCalculator.updateBalance(session.getCurrentBalance(), campaign.getBidAmount());
        if (IsCampaignCorrect.checkNumbers(currentBalance, campaign.getRadius(), campaign.getBidAmount())) {
//        keywordsService.addKeyword(word,campaign.getId());
            session.setCurrentBalance(currentBalance);
            campaign.setCampaignFunds(currentBalance);
            campaignRrepository.save(campaign);
            String output = "Your updated balance equals: " + Integer.toString(currentBalance);
            return output;
        } else {
            return "Wrong number";
        }
    }


    public String updateCampaign(long id, Campaign campaign) {
        Campaign previousCamp = getSingleCampaign(id);
        int currentBalance = CampaignFundsCalculator.updateBalance(session.getCurrentBalance(),
                campaign.getBidAmount() - previousCamp.getBidAmount());
        if (IsCampaignCorrect.checkNumbers(currentBalance, campaign.getRadius(), campaign.getBidAmount())) {
//        keywordsService.addKeyword(word,campaign.getId());
            previousCamp = CampaignDataUpdater.updateOldData(previousCamp, campaign, currentBalance, session);
            campaignRrepository.save(previousCamp);
            return "User updated";
        } else {
            return "Wrong number";
        }
    }

    public String deleteCampaign(long id) {
        campaignRrepository.deleteById(id);
        return "Campaign has been deleted";
    }

}
