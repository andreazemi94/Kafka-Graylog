package com.myproject.order;

import com.myproject.order.graylog.GraylogProducer;
import com.myproject.order.kafka.KafkaProducer;
import com.myproject.order.model.Order;
import com.myproject.order.repository.OrderRepository;
import com.myproject.order.service.OrderService;
import com.myproject.order.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceImplTest {
    @InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    GraylogProducer graylogProducer;
    @Mock
    ModelMapper modelMapper;
    @Mock
    KafkaProducer kafkaProducer;
    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        order = Order.builder().orderId(1L).build();
    }

    @Test
    void testSaveOrderWhenOrderNotExists() {
        Optional<Order> result = orderService.save(order);
        assertTrue(result.isPresent());
    }
}
