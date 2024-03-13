package com.desafiocid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiocid.entities.Order;

@Service
public class OrderService{
    //Injeção da dependência.

    @Autowired
    private ShippingService shippingService;

    //Metodo
    
    public double total(Order order){
        double discount = order.getBasic() * (order.getDiscount() / 100);
        return (order.getBasic() - discount) + shippingService.shipment(order);
    }
}