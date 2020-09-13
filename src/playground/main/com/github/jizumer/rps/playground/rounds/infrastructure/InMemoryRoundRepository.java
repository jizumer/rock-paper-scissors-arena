package com.github.jizumer.rps.playground.rounds.infrastructure;

import com.github.jizumer.rps.core.domain.rounds.RoundResult;
import com.github.jizumer.rps.playground.rounds.domain.Round;
import com.github.jizumer.rps.playground.rounds.domain.RoundCriteria;
import com.github.jizumer.rps.playground.rounds.domain.RoundId;
import com.github.jizumer.rps.playground.rounds.domain.RoundRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public final class InMemoryRoundRepository implements RoundRepository {

    //Special attention to concurrency here. We don't have modification of rounds, so we don't need to worry about
    //stale reads or concurrent access, but in other cases, we would need a mechanism to deal with concurrency and
    //transactionality.
    private HashMap<String, Round> rounds = new HashMap<>();

    @Override
    public void save(Round round) {
        //This could be a great point to publish an event that could be handled by other bounded context aggregates
        //or even by other systems
        rounds.put(round.getId().getValue(), round);
    }

    @Override
    public List<Round> searchByCriteria(RoundCriteria criteria) {
        //In more complex situations, it would be necessary to analyze the criteria to identify which fields
        //are informed and use them to query data. This time, we only have one single criteria field.

        //Filtering rounds by its first player Id
        return rounds.values()
                .stream()
                .filter(round -> round.
                        getPlayer1()
                        .getId()
                        .equals(criteria
                                .getFirstPlayerId()))
                .collect(Collectors.toList());
    }

    @Override
    public long countByResult(RoundResult result) {
        return rounds
                .values()
                .stream()
                .filter(round ->
                        round.getResult()
                                .equals(result))
                .count();
    }

    @Override
    public Optional<Round> search(RoundId id) {
        return Optional.ofNullable(rounds.get(id.getValue()));
    }
}