package com.um.apitest.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderService {

    private final PizzaOrderRepository orderRepository;

    @Autowired
    public PizzaOrderService(PizzaOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * @param customerId customer we want to retrieve the order history of
     * @return list of all PizzaOrders containing this customerId
     */
    public List<PizzaOrder> getPizzaOrders(int customerId) {

        boolean exists = orderRepository.existsById(customerId);
        if(!exists)
            throw new IllegalStateException("Customer " + customerId + " does not exist");

        return getOrderHistory(customerId);
    }


    /**
     * @param customerId customer we want to retrieve the order history of
     * @return list of all PizzaOrders containing this customerId
     */
    private List<PizzaOrder> getOrderHistory(int customerId) {
        List<PizzaOrder> allOrders = getAllPizzaOrders();
        List<PizzaOrder> customerOrders = new ArrayList<>();

        for (int i = 0; i < allOrders.size(); i++) {
            if(allOrders.get(i).getCustomerId() == customerId) {
                customerOrders.add(allOrders.get(i));
            }
        }
        return customerOrders;
    }


    /**
     * @return list containing all PizzaOrders from the database
     */
    public List<PizzaOrder> getAllPizzaOrders() {
        return orderRepository.findAll();
    }

}




