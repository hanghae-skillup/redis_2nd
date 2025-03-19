package com.module.redis2nd.domain.customer.entity;

import com.module.redis2nd.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "customer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Customer extends BaseEntity {
    private String email;
    private String password;

    public static Customer createCustomer() {
        return Customer.builder()
                .build();
    }
}
