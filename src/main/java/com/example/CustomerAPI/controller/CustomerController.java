package com.example.CustomerAPI.controller;

import com.example.CustomerAPI.common.exception.CustomerException;
import com.example.CustomerAPI.service.CustomerService;
import com.example.CustomerAPI.vo.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("spp/")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Returns a customer from a given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "204", description = "No customer found"),
            @ApiResponse(responseCode = "400", description = "Validation error"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json")}),
    })
    @GetMapping(value = "getCustomer/{personOfficialId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCustomer(@RequestParam(name = "personOfficialId") String personOfficialId) throws CustomerException {
        Customer customer = customerService.getCustomer(personOfficialId);
        if (customer == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping(value = "createCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a customer object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful operation", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = "Validation error"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json")}),
    })
    public ResponseEntity postEMessage(@RequestBody @Valid Customer customer) {
        try {
            Customer customerResponse = customerService.createCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
        } catch (CustomerException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Customer not created", e);

        }
    }
}
