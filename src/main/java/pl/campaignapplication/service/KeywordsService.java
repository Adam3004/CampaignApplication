package pl.campaignapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.campaignapplication.keyword.Keyword;
import pl.campaignapplication.repository.KeywordsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeywordsService {
    private final KeywordsRepository keywordsRepository;

    public List<Keyword> getCampaignKeywords(long campaignId) {
        List<Keyword> keywords = keywordsRepository.findAll();
        List<Keyword> keywordsOutput = keywords
                .stream()
                .filter(keyword -> keyword.getCampaignId() == campaignId)
                .collect(Collectors.toList());
        return keywordsOutput;
    }

    public String addCampaignKeyword(long campaignId, Keyword keyword) {
        try {
            keyword.setCampaignId(campaignId);
            //        id is correct, bec frontend guard it
            keywordsRepository.save(keyword);
            return "added";
        } catch (Exception e) {
            return "something went wrong";
        }
    }

    public Keyword getSingleKeyword(long id) {
        return keywordsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Keyword updateKeyword(long id, Keyword keyword) {
        Keyword prevKeyword = getSingleKeyword(id);
        prevKeyword.setWord(keyword.getWord());
        return keywordsRepository.save(prevKeyword);
    }

    public String deleteKeyword(long id) {
        List<Keyword> CampaignKeywords = getCampaignKeywords(getSingleKeyword(id).getCampaignId());
        if (CampaignKeywords.size() > 1) {
            keywordsRepository.deleteById(id);
            return "Deleted";
        }
        return "Cannot delete last element";
    }


    public void deleteKeywords(long campaignId) {
        List<Long> listOfId = findKeywordsToRemoval(campaignId);
        keywordsRepository.deleteAllById(listOfId);
    }

    private List<Long> findKeywordsToRemoval(long campaignId) {
        List<Keyword> CampaignKeywords = getCampaignKeywords(campaignId);
        List<Long> listOfId = CampaignKeywords
                .stream()
                .map(keyword -> keyword.getId())
                .collect(Collectors.toList());
        return listOfId;
    }
}
