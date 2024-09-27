package com.CiSU.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final float MINIMUMSCORE = 0;
    private final float MAXIMUMSCORE = 100;

    public float randomizeScore() {

        Random r = new Random();
        float score = MINIMUMSCORE + r.nextFloat() * (MAXIMUMSCORE - MINIMUMSCORE);
        System.out.println("Score: "+score);

        return score;
    }
    

}
