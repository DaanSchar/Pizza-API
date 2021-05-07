package com.um.apitest.order;

import com.um.apitest.database.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    public OrderService( ) {}

    /**
     * @param customerId customer we want to retrieve the order history of
     * @return list of all PizzaOrders containing this customerId
     */
    public List<Order> getPizzaOrders(int customerId) {
        List<Order> orderList = getOrderHistory(customerId);

        if (orderList == null || orderList.size() == 0)
            throw new IllegalStateException("Customer with id " + customerId + " does not exist" );

        return orderList;
    }


    /**
     * @param customerId customer we want to retrieve the order history of
     * @return list of all PizzaOrders containing this customerId
     */
    private List<Order> getOrderHistory(int customerId) {
        List<Order> allOrders = getAllPizzaOrders();
        List<Order> customerOrders = new ArrayList<>();

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
    public  List<Order> getAllPizzaOrders() {
        return OrderRepository.getOrderList();
    }

}




