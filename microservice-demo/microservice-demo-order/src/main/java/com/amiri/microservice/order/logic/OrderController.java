package com.amiri.microservice.order.logic;

import com.amiri.microservice.order.clients.CatalogClient;
import com.amiri.microservice.order.clients.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/order")
class OrderController {

    private OrderRepository orderRepository;

    private OrderService orderService;

    private CustomerClient customerClient;
    private CatalogClient catalogClient;

    @Autowired
    private OrderController(OrderService orderService, OrderRepository orderRepository, CustomerClient customerClient,
                            CatalogClient catalogClient) {
        super();
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
        this.catalogClient = catalogClient;
        this.orderService = orderService;
    }

    @GetMapping(value = "/")
    public Iterable<Order> orderList() {
        return orderRepository.findAll();
    }

    @PostMapping(value = "/line")
    public Order addLine(Order order) {
        order.addLine(0, catalogClient.findAll().iterator().next().getItemId());
        return order;
    }

    @GetMapping(value = "/{id}")
    public Order get(@PathVariable("id") long id) {
        return orderRepository.findById(id).get();
    }

    @PostMapping(value = "/")
    public Order post(Order order) {
        return orderService.order(order);
    }

    @DeleteMapping(value = "/{id}")
    public void post(@PathVariable("id") long id) {
        orderRepository.deleteById(id);
    }

}
