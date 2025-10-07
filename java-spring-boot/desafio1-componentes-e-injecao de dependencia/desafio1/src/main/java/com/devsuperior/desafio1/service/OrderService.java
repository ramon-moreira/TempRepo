package com.devsuperior.desafio1.service;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double discount = order.getBasic() * (order.getDiscount() / 100.0);
        double total = order.getBasic() - discount + shippingService.shipment(order);
        return total;
    }
}