package pl.campaignapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.campaignapplication.seller.Seller;
import pl.campaignapplication.service.SellerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("/towns")
    public List<Seller> getTowns() {
        return sellerService.getSellers();
    }


}
