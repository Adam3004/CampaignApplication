package pl.campaignapplication.tools;

import pl.campaignapplication.campaign.Campaign;
import pl.campaignapplication.session.Session;

public class CampaignDataUpdater {
    public static Campaign updateOldData(Campaign oldCampaign, Campaign newCampaign, int currentBalance, Session session) {
        session.setCurrentBalance(currentBalance);
        newCampaign.setCampaignFunds(currentBalance);
        oldCampaign.setCampaignFunds(currentBalance);
        oldCampaign.setBidAmount(newCampaign.getBidAmount());
        oldCampaign.setName(newCampaign.getName());
        oldCampaign.setRadius(newCampaign.getRadius());
        oldCampaign.setStatus(newCampaign.getStatus());
        oldCampaign.setTown(newCampaign.getTown());
        return oldCampaign;
    }
}
