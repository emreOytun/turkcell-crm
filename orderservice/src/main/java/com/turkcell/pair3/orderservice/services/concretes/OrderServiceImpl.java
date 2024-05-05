package com.turkcell.pair3.orderservice.services.concretes;

import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.messages.Messages;
import com.turkcell.pair3.orderservice.clients.ProductServiceClient;
import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.repositories.OrderRepository;
import com.turkcell.pair3.orderservice.services.abstracts.OrderService;
import com.turkcell.pair3.orderservice.services.dtos.requests.CreateOrderRequest;
import com.turkcell.pair3.orderservice.services.dtos.responses.CreateOrderResponse;
import com.turkcell.pair3.orderservice.services.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    private final MessageService messageService;

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
        // TODO remove magic string
        Order order = orderRepository.findOrderByOrderId(orderId)
                .orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.ORDER_NOT_FOUND)));
        orderRepository.delete(order);
    }

    @Override
    public List<Date> getDatesOfOrdersByBillAccounts(List<Integer> billAccountIdList) {
        // TODO test this method it used in IndividualCustomerServiceImpl deleteCustomer method

//        List<Integer> orderIds = new ArrayList<>();
//        for (Integer billAccountId : billAccountIdList) {
//            orderIds.addAll(orderRepository.findOrderIdsByBillAccountId(billAccountId));
//        }
//
//        //find all OrderDetails by orderIds
//        List<Date> orderDates = new ArrayList<>();
        return null;

    }

}