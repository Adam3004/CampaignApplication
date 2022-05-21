package pl.campaignapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.campaignapplication.seller.Seller;

public interface SellersRepository extends JpaRepository<Seller, String> {
}
