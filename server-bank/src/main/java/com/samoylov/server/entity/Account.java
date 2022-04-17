package com.samoylov.server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Account")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @Column(name = "account_number")
    private long accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "account")
    private Set<Card> cards;
}
