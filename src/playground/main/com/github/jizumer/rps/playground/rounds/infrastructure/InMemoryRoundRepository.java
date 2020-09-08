package com.github.jizumer.rps.playground.rounds.infrastructure;

import com.github.jizumer.rps.playground.rounds.domain.Round;
import com.github.jizumer.rps.playground.rounds.domain.RoundId;
import com.github.jizumer.rps.playground.rounds.domain.RoundRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;


@Service
public final class InMemoryRoundRepository implements RoundRepository {

    //Special attention to concurrency here. We don't have modification of rounds, so we don't need to worry about
    //stale reads or concurrent access, but in other cases, we would need a mechanism to deal with concurrency and
    //transactionality.
    private HashMap<String, Round> rounds = new HashMap<>();

    @Override
    public void save(Round round) {
        rounds.put(round.getId().getValue(), round);
    }

    public Optional<Round> search(RoundId id) {
        return Optional.ofNullable(rounds.get(id.getValue()));
    }
}