package pl.campaignapplication.seller;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Seller {
    @Id
    private String town;
}
