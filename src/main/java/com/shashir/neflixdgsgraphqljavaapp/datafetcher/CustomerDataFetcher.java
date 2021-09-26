package com.shashir.neflixdgsgraphqljavaapp.datafetcher;

import com.netflix.graphql.dgs.*;
import com.shashir.neflixdgsgraphqljavaapp.model.Account;
import com.shashir.neflixdgsgraphqljavaapp.model.AccountInput;
import com.shashir.neflixdgsgraphqljavaapp.model.Customer;
import com.shashir.neflixdgsgraphqljavaapp.model.CustomerInput;
import com.shashir.neflixdgsgraphqljavaapp.repository.AccountRepository;
import com.shashir.neflixdgsgraphqljavaapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class CustomerDataFetcher {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @DgsData(parentType = "Query", field = "customers")
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @DgsData(parentType = "Customer", field = "accounts")
    public List<Account> accounts(DgsDataFetchingEnvironment dgsDataFetchingEnvironment) {
        Customer customer = dgsDataFetchingEnvironment.getSource();
        List<Account> accountList = new ArrayList<>();
        for (Account account : customer.getAccounts()) {
           Account accountResponse = accountRepository.findById(account.getAccountId()).get();
           accountList.add(accountResponse);
        }
        return accountList;
    }

    @DgsMutation
    public Customer customer(CustomerInput customerInput) {
        Customer customer = Customer.builder()
                .contact(customerInput.getContact())
                .name(customerInput.getName())
                .gender(customerInput.getGender())
                .mail(customerInput.getMail())
                .accounts(mapCustomerAccounts(customerInput.getAccounts()))
                .build();
        Customer customerResponse = customerRepository.save(customer);
        return customerResponse;
    }

    private List<Account> mapCustomerAccounts(List<AccountInput> accountIpnut) {
        List<Account> accountsList = accountIpnut.stream().map(accInput -> {
            Account account = Account.builder()
                    .accountBalance(accInput.getAccountBalance())
                    .accountNumber(accInput.getAccountNumber())
                    .accountStatus(accInput.getAccountStatus())
                    .build();
            return account;
        }).collect(Collectors.toList());
        return accountsList;
    }
}
