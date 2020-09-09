package com.github.jizumer.rps.playground.rounds.domain;

import java.util.List;
import java.util.Optional;

public interface RoundRepository {

    void save(Round round);

    Optional<Round> search(RoundId id);

    List<Round> searchByCriteria(RoundCriteria criteria);

    long countByResult(RoundResult draw);
}
