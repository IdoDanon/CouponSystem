package com.couponhub.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JdbcType(CharJdbcType.class)
    private UUID uuid;
    @JdbcType(CharJdbcType.class)
    private UUID companyUuid;
    private int category;
    private String title;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    private int amount;
    private String description;
    private double price;
    @Column(name = "image_url")
    private String imageUrl;
    @ElementCollection
    @CollectionTable(name = "customer_coupon", joinColumns = @JoinColumn(name = "coupon_id"))
    @JdbcType(CharJdbcType.class)
    @Column(name = "customer_uuid")
    private Set<UUID> customers;
}
