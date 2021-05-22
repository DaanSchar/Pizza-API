package com.um.apitest.pizza;

import com.um.apitest.database.PizzaRepository;
import com.um.apitest.order.util.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    public PizzaService(){}

    /**
     * @return all available pizzas from the pizza database
     */
    public List<Pizza> getPizzas() {
        return PizzaRepository.getPizzaList();
    }

    /**
     * @param pizzaId int to identify a specific pizza type
     * @return corresponding pizza of that pizzaId as it retrieved from the pizza database
     */
    public ResponseEntity getPizza(int pizzaId) {

        //TODO: add message 404: "pizza not found"

        List<Pizza> pizzaList = getPizzas();

        for (int i = 0; i < pizzaList.size(); i++)
            if (pizzaList.get(i).getPizza_id() == pizzaId)
                return new ResponseEntity(pizzaList.get(i), HttpStatus.ACCEPTED);

        return new ResponseEntity(new Message("Pizza not found"), HttpStatus.NOT_FOUND);
    }

}
