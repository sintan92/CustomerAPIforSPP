package com.example.CustomerAPI.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
        @Id
        @Schema(description = "Id of the customer",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "Id")
        String personOfficialId,
        @Schema(description = "Address of the customer",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "Adrress")
        Address address,
        @Schema(description = "First name of the customer",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "First name")
        String firstName,
        @Schema(description = "Last name of the customer",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "Last name")
        String lastName,
        @Schema(description = "The last time the customer object was updated",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "Last Updated")
        Timestamp lastUpdated,
        @Schema(description = "If the person is of type Legal or Private",
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "personType")
        String personType
) {
}
