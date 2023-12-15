package com.yeditepe.comp301.microservices.customer;

public record CustomerRecord(
        String username,
        String password,
        String email
) {
}
