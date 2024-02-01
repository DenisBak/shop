package ru.multicard.mock.shop.db.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases")
public class PurchaseEntity {
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name="purchase_id"))
    private ClientEntity clientId;

    @Column(name = "purchase_items")
    private String basket;

    @Column(name = "count")
    private int count;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "purchase_goods",
            joinColumns = { @JoinColumn(name = "purchase_id") },
            inverseJoinColumns = { @JoinColumn(name = "good_id") })
    private List<GoodEntity> purchases = new ArrayList<>();
}
