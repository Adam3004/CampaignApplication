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

//    public void addKeyword(String word, long campaignId) {
//        Keyword keyword = new Keyword();
//        keyword.setId(0);
//        keyword.setWord(word);
//        keyword.setCampaignId(campaignId);
//        keywordsRepository.save(keyword);
//    }

    public List<Keyword> getCampaignKeywords(long id) {
        List<Keyword> keywords = keywordsRepository.findAll();
        List<Keyword> keywordsOutput = keywords
                .stream()
                .filter(keyword -> keyword.getCampaignId() == id)
                .collect(Collectors.toList());
        return keywordsOutput;
    }

    public String addCampaignKeyword(long campaignId, Keyword keyword) {
        keyword.setCampaignId(campaignId);
//        nie musze sprawdzać czy takie id istnieje, bo zawsze będzie przekazywane już istniejące id
        keywordsRepository.save(keyword);
        return "added";
    }
}
