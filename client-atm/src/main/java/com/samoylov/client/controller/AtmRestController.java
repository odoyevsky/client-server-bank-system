package com.samoylov.client.controller;

import com.samoylov.client.service.ATMService;
import com.samoylov.dto.CardDTO;
import com.samoylov.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class AtmRestController {
    private ATMService atmService;

    @PostMapping("customer/infoinfo")
    public CustomerDTO getCustomerInfo(@RequestBody CardDTO cardDTO) {
        return atmService.getCustomerByCard(cardDTO);
    }

    @PostMapping("customer/account/balance")
    public BigDecimal getAccountBalanceByCard(@RequestBody CardDTO cardDTO) {
        return atmService.getAccountBalanceByCard(cardDTO);
    }
}
