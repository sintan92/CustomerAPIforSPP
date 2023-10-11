package com.example.CustomerAPI.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
        @Id
        String personOfficialId,
        Address address,
        String firstName,
        String lastName,
        Timestamp lastUpdated,
        String personType
) {
}
