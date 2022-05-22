package pl.campaignapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.campaignapplication.campaign.Campaign;

public interface CampaignRrepository extends JpaRepository<Campaign, Long> {
}
