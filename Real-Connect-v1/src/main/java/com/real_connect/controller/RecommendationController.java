package com.real_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.real_connect.entity.Recommendation;
import com.real_connect.entity.User;
import com.real_connect.service.RecommendationService;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/byClient")
    public ResponseEntity<List<Recommendation>> getRecommendations(@RequestParam Long clientId) {
        if (clientId == null || clientId <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        User client = new User();
        client.setUserId(clientId); // Correctly setting the ID

        return ResponseEntity.ok(recommendationService.getRecommendationsForClient(client));
    }

}
