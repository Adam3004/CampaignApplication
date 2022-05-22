package pl.campaignapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.campaignapplication.keyword.Keyword;
import pl.campaignapplication.repository.KeywordsRepository;

@Service
@RequiredArgsConstructor
public class KeywordsService {
    private final KeywordsRepository keywordsRepository;

    public void addKeyword(String word, long campaignId){
        Keyword keyword = new Keyword();
        keyword.setId(0);
        keyword.setWord(word);
        keyword.setCampaignId(campaignId);
        keywordsRepository.save(keyword);
    }
}
