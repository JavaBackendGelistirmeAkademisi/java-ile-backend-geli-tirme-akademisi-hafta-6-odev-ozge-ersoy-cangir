package com.javabackendakademisi.freelancerMatchingPlatform.service;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.Bid;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    // Tüm teklifleri getirir
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    // ID'ye göre teklif bulur, Optional döner
    public Optional<Bid> findBidById(Long id) {
        return bidRepository.findById(id);
    }

    // Yeni bir teklif kaydeder
    public Bid saveBid(Bid bid) {
        return bidRepository.save(bid);
    }

    // Teklifi günceller
    public Bid updateBid(Bid updatedBid, Long id) {
        Optional<Bid> existingBid = bidRepository.findById(id);
        if (existingBid.isPresent()) {
            Bid bid = existingBid.get();
            bid.setAmount(updatedBid.getAmount());
            bid.setDescription(updatedBid.getDescription());
            bid.setFreelancer(updatedBid.getFreelancer());
            bid.setProject(updatedBid.getProject());
            return bidRepository.save(bid);
        }
        return null; // Eğer teklif bulunmazsa null döneriz (alternatif olarak hata fırlatılabilir)
    }

    // Teklifi siler
    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }
}
