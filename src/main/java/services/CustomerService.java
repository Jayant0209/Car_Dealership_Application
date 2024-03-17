package services;

import entities.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomerById(long customerId);
    List<Customer> getAllCustomers();
}
