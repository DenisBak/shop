package ru.multicard.mock.shop.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ru.multicard.mock.shop.db.entities.GoodEntity;

@Repository
public interface GoodRepository extends JpaRepository<GoodEntity, Long> {
    @Query(value = "SELECT * FROM goods " +
            "WHERE good_id = (" +
            "SELECT purchase_goods.good_id FROM clients " +
            "INNER JOIN purchases ON clients.client_id = purchases.client_id " +
            "INNER JOIN purchase_goods ON purchases.purchase_id = purchase_goods.purchase_id " +
            "WHERE clients.age = 18 GROUP BY purchase_goods.good_id " +
            "ORDER BY COUNT(purchase_goods.good_id) DESC LIMIT 1" +
                ");", nativeQuery = true)
    GoodEntity getMostSellGoodAmongEighteen();
}
