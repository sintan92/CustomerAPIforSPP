package com.example.CustomerAPI.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        String personOfficialId,
        Address address,
        String firstName,
        String lastName,

        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
        Timestamp lastUpdated,
        String personType
) {
}
