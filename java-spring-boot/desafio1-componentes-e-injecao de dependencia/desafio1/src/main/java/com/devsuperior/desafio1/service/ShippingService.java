package com.devsuperior.desafio1.service;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double basic = order.getBasic();
        if (basic < 100.0) {
            return 20.0;
        } else if (basic < 200.0) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
}