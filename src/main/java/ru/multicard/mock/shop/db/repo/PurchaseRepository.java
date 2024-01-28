package ru.multicard.mock.shop.db.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.multicard.mock.shop.db.entities.PurchaseEntity;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
    List<PurchaseEntity> findAllByDateAfter(LocalDate date);

    PurchaseEntity findTopByDateAfterOrderByCountDesc(LocalDate date);
}
