package pl.campaignapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.campaignapplication.campaign.Campaign;
import pl.campaignapplication.exception.NegativeBalnceException;
import pl.campaignapplication.exceptionMethod.IsBalanceGood;
import pl.campaignapplication.keyword.Keyword;
import pl.campaignapplication.repository.CampaignRrepository;
import pl.campaignapplication.session.Session;
import pl.campaignapplication.tools.CampaignFundsCalculator;

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
        try {
            IsBalanceGood.check(currentBalance);
        } catch (NegativeBalnceException e) {
            return e.getLocalizedMessage();
        }
//        keywordsService.addKeyword(word,campaign.getId());
        session.setCurrentBalance(currentBalance);
        campaign.setCampaignFunds(currentBalance);
        campaignRrepository.save(campaign);
        String output = "Your updated balance equals: " + Integer.toString(currentBalance);
        return output;
    }


    public String updateCampaign(long id, Campaign campaign) {
        Campaign previousCamp = getSingleCampaign(id);
        int currentBalance = CampaignFundsCalculator.updateBalance(session.getCurrentBalance(),
                campaign.getBidAmount() - previousCamp.getBidAmount());
        try {
            IsBalanceGood.check(currentBalance);
        } catch (NegativeBalnceException e) {
            return e.getLocalizedMessage();
        }

//        keywordsService.addKeyword(word,campaign.getId());
        session.setCurrentBalance(currentBalance);
        campaign.setCampaignFunds(currentBalance);
        previousCamp.setCampaignFunds(currentBalance);
        previousCamp.setBidAmount(campaign.getBidAmount());
        previousCamp.setName(campaign.getName());
        previousCamp.setRadius(campaign.getRadius());
        previousCamp.setStatus(campaign.getStatus());
        previousCamp.setTown(campaign.getTown());
        campaignRrepository.save(previousCamp);
        String output = "User updated";
        return output;
    }

    public String deleteCampaign(long id) {
        campaignRrepository.deleteById(id);
        return "Campaign has been deleted";
    }
}
