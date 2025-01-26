package com.devsuperior.desafio1.services;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        if (order.getDiscount() != 0) {
            return order.getBasic() + shippingService.shipment(order) - order.getBasic()*(order.getDiscount()/100);
        } else {
            return order.getBasic() + shippingService.shipment(order);
        }
    }
}
