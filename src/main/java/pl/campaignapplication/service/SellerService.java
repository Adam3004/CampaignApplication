package pl.campaignapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.campaignapplication.repository.SellersRepository;
import pl.campaignapplication.seller.Seller;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellersRepository sellersRepository;

    public List<Seller> getSellers() {
        return sellersRepository.findAll();
    }

    public void addSeller(Seller seller){
        sellersRepository.save(seller);
    }
}
