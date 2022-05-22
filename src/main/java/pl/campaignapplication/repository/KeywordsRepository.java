package pl.campaignapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.campaignapplication.keyword.Keyword;

public interface KeywordsRepository extends JpaRepository<Keyword, Long> {
}
