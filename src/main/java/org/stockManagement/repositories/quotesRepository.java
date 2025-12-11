package org.stockManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stockManagement.entities.OHLC;

import java.util.UUID;

@Repository
public interface quotesRepository extends JpaRepository<OHLC, UUID> {
}
