package com.github.jizumer.rps.playground.rounds.application;

import com.github.jizumer.rps.playground.rounds.domain.*;
import org.springframework.stereotype.Service;

import java.util.UUID;


//This annotation should be avoided outside the infrastructure layer. Alternatives are extracting context configuration
//to an xml, or making this class abstract and inheriting it in the infrastructure layer. In this case, we have let it
//here for simplicity, but it is open to discussion.
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
        roundRepository.save(new Round(new RoundId(request.getId()),
                new RandomPlayer(UUID.randomUUID().toString()),
                new AlwaysRockPlayer(UUID.randomUUID().toString())));
    }
}
