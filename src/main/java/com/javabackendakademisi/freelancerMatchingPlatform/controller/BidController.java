package com.javabackendakademisi.freelancerMatchingPlatform.controller;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.Bid;
import com.javabackendakademisi.freelancerMatchingPlatform.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    // Tüm teklifleri getirir
    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    // Teklifi ID'ye göre getirir
    @GetMapping("/{id}")
    public ResponseEntity<Bid> getBidById(@PathVariable Long id) {
        Optional<Bid> optionalBid = bidService.findBidById(id);

        return optionalBid.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Yeni teklif oluşturur
    @PostMapping
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.saveBid(bid);
    }

    // Teklifi günceller
    @PutMapping("/{id}")
    public ResponseEntity<Bid> updateBid(@RequestBody Bid bid, @PathVariable Long id) {
        Optional<Bid> optionalBid = bidService.findBidById(id);

        if (optionalBid.isPresent()) {
            Bid updatedBid = bidService.updateBid(bid, id);
            return ResponseEntity.ok(updatedBid);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Teklifi siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBid(@PathVariable Long id) {
        Optional<Bid> optionalBid = bidService.findBidById(id);

        if (optionalBid.isPresent()) {
            bidService.deleteBid(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
