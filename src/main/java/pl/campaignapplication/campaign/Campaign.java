package pl.campaignapplication.campaign;

import lombok.Getter;
import lombok.Setter;
import pl.campaignapplication.keyword.Keyword;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int bidAmount;
    private int campaignFunds;
    private boolean status;
    private String town;
    private int radius;

    @OneToMany
    @JoinColumn(name = "campaignId")
    private List<Keyword> keyWords;
}
