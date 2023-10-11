package com.example.CustomerAPI.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Address(
        @Schema(description = "city of the customer",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "City")
        String city,
        @Schema(description = "postcode of the customer",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "PostCode")
        String postCode,
        @Schema(description = "Street of the customer",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "Street")
        String street

) {
}
