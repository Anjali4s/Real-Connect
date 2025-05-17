package com.real_connect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real_connect.entity.Recommendation;
import com.real_connect.entity.User;
import com.real_connect.repository.RecommendationRepository;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public List<Recommendation> getRecommendationsForClient(User client) {
        return recommendationRepository.findByClient(client);
    }
}