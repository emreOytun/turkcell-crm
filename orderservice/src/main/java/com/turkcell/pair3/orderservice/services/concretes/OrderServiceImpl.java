package com.turkcell.pair3.orderservice.services.concretes;

import com.turkcell.pair3.orderservice.clients.ProductServiceClient;
import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.repositories.OrderRepository;
import com.turkcell.pair3.orderservice.services.abstracts.OrderService;
import com.turkcell.pair3.orderservice.services.dto.request.CreateOrderRequest;
import com.turkcell.pair3.orderservice.services.dto.response.CreateOrderResponse;
import com.turkcell.pair3.orderservice.services.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    @Override
    public double calculateTotalPrice(CreateOrderRequest request) {
        return request.getProducts().stream().mapToDouble(productId ->
                        productServiceClient.findProductPriceById(Integer.parseInt(productId))).sum();
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        Order order = OrderMapper.INSTANCE.addOrderFromRequest(createOrderRequest);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(calculateTotalPrice(createOrderRequest));
        order.setOrderId(UUID.randomUUID().toString());
        orderRepository.save(order);
        return OrderMapper.INSTANCE.fromCreateRequest(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        Order order = orderRepository.findOrderByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }

}
