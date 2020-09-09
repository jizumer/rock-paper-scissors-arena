package com.github.jizumer.rps.playground.rounds.application;

import com.github.jizumer.rps.playground.rounds.domain.PlayerId;
import com.github.jizumer.rps.playground.rounds.domain.Round;
import com.github.jizumer.rps.playground.rounds.domain.RoundCriteria;
import com.github.jizumer.rps.playground.rounds.domain.RoundRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoundSearcher {

    private RoundRepository roundRepository;

    public RoundSearcher(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }


    public List<Round> searchByCriteria(RoundSearcherRequest request) {
        return roundRepository.searchByCriteria(new RoundCriteria(new PlayerId(request.getIdPlayer())));
    }
}
