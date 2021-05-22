package com.um.apitest.order;

import com.um.apitest.database.OrderRepository;
import com.um.apitest.database.PizzaRepository;
import com.um.apitest.order.post.OrderPost;
import com.um.apitest.order.response.CancelResponse;
import com.um.apitest.order.response.DeliveryTimeResponse;
import com.um.apitest.order.response.OrderResponse;
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


    public ResponseEntity getOrderById(int orderId) {
        Order order = getOrder(orderId);

        if (order == null)
            return new ResponseEntity(new Message("order_id " + orderId + " not found" ),HttpStatus.NOT_FOUND);

        return new ResponseEntity(order, HttpStatus.ACCEPTED);
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
        response.setDelivery_time(getDeliveryTime(newOrder));

        OrderRepository.insert(newOrder);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }


    /**
     * returns new date with added delivery time
     * @param order order we get the orderTime from
     * @return orderDate + delivery time
     */
    public Date getDeliveryTime(Order order) {
        long timeInMs = order.getOrderedAt().getTime();
        return new Date(timeInMs + (DELIVERY_TIME_IN_MIN * 60000));
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

        if (order == null)
            return new ResponseEntity(new Message("Order not found"), HttpStatus.NOT_FOUND);

        long orderTime = order.getOrderedAt().getTime();
        long cancelTime = new Date().getTime();
        long dTime = cancelTime - orderTime;

        if (dTime > 5 * 60000)
            return new ResponseEntity(new Message("Cant cancel an order after 5 minutes have elapsed"), HttpStatus.BAD_REQUEST);

        if (order.getStatus().equals("cancelled"))
            return new ResponseEntity(new Message("Order has already been cancelled"), HttpStatus.BAD_REQUEST);

        order.setStatus("cancelled");
        return new ResponseEntity(new CancelResponse(orderId, "cancelled"), HttpStatus.ACCEPTED);
    }


    /**
     *
     * @param orderId id of the order
     * @return Order object corresponding with the given orderId
     */
    private Order getOrder(int orderId) {
        List<Order> orderList = getAllOrders();

        for (int i = 0; i < orderList.size(); i++)
            if (orderList.get(i).getId() == orderId)
                return orderList.get(i);

        return null;
    }

    /**
     * @param orderId id of the order
     * @return response with delivery time
     */
    public ResponseEntity getDeliveryTime(int orderId) {

        Order order = getOrder(orderId);

        if (order == null)
            return new ResponseEntity(new Message("Order not found"), HttpStatus.NOT_FOUND);

        DeliveryTimeResponse response = new DeliveryTimeResponse();
        response.setOrder(order);
        response.setDeliveryTime(getDeliveryTime(order));

        //TODO: Write method to get delivery time of order

        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }
}




