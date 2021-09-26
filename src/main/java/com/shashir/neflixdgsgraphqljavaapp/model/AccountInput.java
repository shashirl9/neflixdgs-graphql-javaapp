package com.shashir.neflixdgsgraphqljavaapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInput {

    private Long accountNumber;
    private String accountStatus;
    private Double accountBalance;
}
