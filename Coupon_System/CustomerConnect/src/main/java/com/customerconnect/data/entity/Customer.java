package com.customerconnect.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JdbcType(CharJdbcType.class)
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    @CreationTimestamp
    private Timestamp creationTimeStamp;
    @UpdateTimestamp
    private Timestamp updateTimeStamp;
    @Version
    private Long version;
}
