package ru.multicard.mock.shop.db.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goods")
public class GoodEntity {
    @Id
    @Column(name = "good_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "purchase_goods",
            joinColumns = { @JoinColumn(name = "good_id") },
            inverseJoinColumns = { @JoinColumn(name = "purchase_id") })
    private List<PurchaseEntity> purchases = new ArrayList<>();
}
