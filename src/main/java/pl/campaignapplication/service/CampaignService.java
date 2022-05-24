package pl.campaignapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.campaignapplication.campaign.Campaign;
import pl.campaignapplication.repository.CampaignRepository;
import pl.campaignapplication.session.Session;
import pl.campaignapplication.tools.CampaignDataUpdater;
import pl.campaignapplication.tools.CampaignFundsCalculator;
import pl.campaignapplication.tools.IsCampaignCorrect;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final int startingMoney = 10000;
    private Session session = new Session(startingMoney);
    private final KeywordsService keywordsService;

    public List<Campaign> getCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign getSingleCampaign(long id) {
        return campaignRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public String addCampaign(Campaign campaign) {
        int currentBalance = CampaignFundsCalculator.updateBalance(session.getCurrentBalance(), campaign.getBidAmount());
        if (IsCampaignCorrect.checkNumbers(currentBalance, campaign.getRadius(), campaign.getBidAmount())) {
            campaign = CampaignDataUpdater.addNewData(campaign, currentBalance, session);
            campaignRepository.save(campaign);
            return "Your updated balance equals: " + Integer.toString(currentBalance);
        } else {
            return "Wrong number";
        }
    }


    public String updateCampaign(long id, Campaign campaign) {
        Campaign previousCamp = getSingleCampaign(id);
        int currentBalance = CampaignFundsCalculator.updateBalance(session.getCurrentBalance(),
                campaign.getBidAmount() - previousCamp.getBidAmount());
        if (IsCampaignCorrect.checkNumbers(currentBalance, campaign.getRadius(), campaign.getBidAmount())) {
            previousCamp = CampaignDataUpdater.updateOldData(previousCamp, campaign, currentBalance, session);
            campaignRepository.save(previousCamp);
            return "User updated";
        } else {
            return "Wrong number";
        }
    }

    public String deleteCampaign(long id) {
//        id is correct, bec frontend guard it
        session.setCurrentBalance(session.getCurrentBalance() + getSingleCampaign(id).getBidAmount());
        keywordsService.deleteKeywords(id);
        campaignRepository.deleteById(id);
        return "Campaign has been deleted";
    }

    public int getBalance() {
        return session.getCurrentBalance();
    }
}
