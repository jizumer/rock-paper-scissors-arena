package com.github.jizumer.rps.playground.rounds.application;

import com.github.jizumer.rps.playground.rounds.domain.*;
import org.springframework.stereotype.Service;

import java.util.UUID;


//This annotation should be avoided outside the infrastructure layer. The best alternative might be creating our own
//annotation, and creating a spring filter in the application bootstrap, to include Spring's original @Service
//annotation everytime our annotation appears. This way, we are decoupling our project from Spring infrastructure
@Service
public class RoundPlayer {
    //This is the application service related to the creation of rounds. This is also the entry point to the
    //transactional layer in our applications.
    private RoundRepository roundRepository;

    public RoundPlayer(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    //Here is where we apply the rule of playing rounds with a random player and an always-rock player
    public void playRound(RoundPlayerRequest request) {
        roundRepository.save(new Round(new RoundId(request.getIdRound()),
                new RandomPlayer(new PlayerId(request.getIdPlayer())),
                new AlwaysRockPlayer(UUID.randomUUID().toString())));
    }
}
