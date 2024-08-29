package com.turkcell.pair3.orderservice.services.concretes;

import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.core.events.CartProductEvent;
import com.turkcell.pair3.core.messages.Messages;
import com.turkcell.pair3.orderservice.clients.ProductServiceClient;
import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.entities.OrderDetails;
import com.turkcell.pair3.orderservice.repositories.OrderDetailsRepository;
import com.turkcell.pair3.orderservice.repositories.OrderRepository;
import com.turkcell.pair3.orderservice.services.abstracts.OrderService;
import com.turkcell.pair3.orderservice.services.dtos.requests.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    private final MessageService messageService;
    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public double calculateTotalPrice(CreateOrderRequest request) {
        //return request.getProducts().stream().mapToDouble(productId -> productServiceClient.findProductPriceById(Integer.parseInt(productId))).sum();
        return 1000;
    }

    @Override
    public String createOrder(CreateOrderRequest createOrderRequest) {
        Order order = new Order();
        order.setBillAccountId(createOrderRequest.getBillAccountId());
        order.setBillAddressId(createOrderRequest.getBillAddressId());

        order.setOrderDate(new Date());
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setTotalPrice(calculateTotalPrice(createOrderRequest));
        String orderId = orderRepository.save(order).getId();

        List<CartProductEvent> productEventList = productServiceClient.getProductsByCartId(createOrderRequest.getCartId());

        for(CartProductEvent cartProductEvent : productEventList){
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(orderId);
            orderDetails.setProductId(cartProductEvent.getProductId());
            orderDetails.setProductSpecDetailsId(cartProductEvent.getProductSpecId());
            orderDetails.setServiceStartDate(new Date(System.currentTimeMillis()));
            orderDetails.setServiceEndDate(new Date(System.currentTimeMillis() + 1000*60*60*24*30));
            orderDetails.setOrderPrice(productServiceClient.findProductPriceById(cartProductEvent.getProductId()));
            orderDetailsRepository.save(orderDetails);
        }
        return orderId;
    }

    @Override
    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.ORDER_NOT_FOUND)));
        orderRepository.delete(order);
    }

    @Override
    public List<Date> getDatesOfOrdersByBillAccounts(List<Integer> billAccountIdList) {
        return null;
    }

}