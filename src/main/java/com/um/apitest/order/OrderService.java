package com.um.apitest.order;

import com.um.apitest.database.OrderRepository;
import com.um.apitest.database.PizzaRepository;
import com.um.apitest.order.util.Message;
import com.um.apitest.pizza.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    public final long DELIVERY_TIME_IN_MIN = 40;


    public OrderService() {}

    /**
     * @param customerId customer we want to retrieve the order history of
     * @return list of all PizzaOrders containing this customerId
     */
    public List<Order> getOrders(int customerId) {
        List<Order> orderList = getOrderHistory(customerId);

        //TODO: add message 404: "Customer_ID not found"
        //          message 400: "Invalid ID supplied"

        if (orderList == null || orderList.size() == 0)
            throw new IllegalStateException("Customer with id " + customerId + " does not exist" );

        return orderList;
    }


    /**
     * @param customerId customer we want to retrieve the order history of
     * @return list of all PizzaOrders containing this customerId
     */
    private List<Order> getOrderHistory(int customerId) {
        List<Order> allOrders = getAllOrders();
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
    public  List<Order> getAllOrders() {
        return OrderRepository.getOrderList();
    }

    /**
     *  saves the order to the database
     * @param orderPost
     */
    public ResponseEntity submitOrder(OrderPost orderPost) {
        Order newOrder = convertToOrder(orderPost);

        // TODO: Add message 400: “The format of the object is not valid”

        OrderResponse response = new OrderResponse();
        response.setOrder(newOrder);
        response.setOrdered_at(newOrder.getOrderedAt());

        // determine delivery time
        long timeInMs = newOrder.getOrderedAt().getTime();
        Date orderDate = new Date(timeInMs + (DELIVERY_TIME_IN_MIN * 60000));
        response.setDelivery_time(orderDate);

        OrderRepository.insert(newOrder);
        return new ResponseEntity<OrderResponse>(response, HttpStatus.ACCEPTED);
    }


    /**
     *  converts a PostOrder object to a Order Object
     * @param orderPost
     * @return Order object
     */
    private Order convertToOrder(OrderPost orderPost) {
        Order newOrder = new Order();

        newOrder.setDeliveryAddress(orderPost.getDeliveryAddress());
        newOrder.setPaymentType(orderPost.getPaymentType());
        newOrder.setCustomerId(orderPost.getCustomerId());
        newOrder.setTakeAway(orderPost.getTakeaway());
        newOrder.setPizzas(convertPizzaList(orderPost));
        newOrder.setStatus("In Progress");

        Date date = new Date();
        newOrder.setOrderedAt(date);

        newOrder.setId(OrderRepository.getOrderList().size()+1);

        return newOrder;
    }


    /**
     * converts list of PizzaOrder objects to list of Pizza objects
     *
     * @param orderPost containing pizzaOrder list
     * @return list containing pizza object
     */
    private List<Pizza> convertPizzaList(OrderPost orderPost) {

        List<Pizza> pizzas = new ArrayList<>();

        for (int i = 0; i < orderPost.getPizzas().size(); i++)
            pizzas.add(PizzaRepository.getPizza(orderPost.getPizzas().get(i).getPizza_id()));

        return pizzas;
    }

    /**
     *  cancels the order of the orderId
     * @param orderId
     */
    public ResponseEntity cancelOrder(int orderId) {
        Order order = getOrder(orderId);

        long orderTime = order.getOrderedAt().getTime();
        long cancelTime = new Date().getTime();
        long dTime = cancelTime - orderTime;

        if (dTime > 5 * 60000)
            return new ResponseEntity<Message>(new Message("Cant cancel an order after 5 minutes have elapsed"), HttpStatus.BAD_REQUEST);

        if (order.getStatus().equals("cancelled"))
            return new ResponseEntity<Message>(new Message("Order has already been cancelled"), HttpStatus.BAD_REQUEST);

        order.setStatus("cancelled");
        return new ResponseEntity<CancelResponse>(new CancelResponse(orderId, "cancelled"), HttpStatus.ACCEPTED);
    }


    /**
     *
     * @param orderId id of the order
     * @return Order object corresponding with the given orderId
     */
    public Order getOrder(int orderId) {
        List<Order> orderList = getAllOrders();

        for (int i = 0; i < orderList.size(); i++)
            if (orderList.get(i).getId() == orderId)
                return orderList.get(i);

        throw new IllegalStateException("order with id " + orderId + " does not exist");
    }

}




