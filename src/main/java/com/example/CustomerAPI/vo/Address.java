package com.example.CustomerAPI.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Address(
        String city,
        String postCode,
        String street

) {
}
