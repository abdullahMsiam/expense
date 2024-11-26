package com.user.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Document(collection = "wallets")
class Wallet{
    @Id
   private String id;
   private String userId;
   private String name;
   private Double balance;
   private String currency;
   private LocalDateTime createdAt;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
};

//repo
interface WalletRepository extends MongoRepository<Wallet, String> {
 // Find wallets by user ID
//   List<Wallet> findByUserId(String userId);
//
//     Find a wallet by user ID and name
//    Wallet findByUserIdAndName(String userId, String name);
};

@RestController
public class WalletsControllers {
    private final WalletRepository walletRepository;
    @Autowired
    public WalletsControllers(WalletRepository walletRepository) {this.walletRepository = walletRepository;}
    @GetMapping("/wallets")
    public List<Wallet> getWallets() {return walletRepository.findAll();}
}
