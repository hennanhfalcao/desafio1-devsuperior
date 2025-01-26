package com.devsuperior.desafio1.services;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {

        double shipment;

        if (order.getBasic() < 100) {
            shipment = 20.00;
        } else if (order.getBasic() >= 100 && order.getBasic() < 200) {
            shipment = 12.00;
        } else {
            shipment = 0.00;
        }

        return shipment;
    }
}
