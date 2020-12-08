package com.hotstrip.week08_work1;

import com.hotstrip.week08_work1.entity.Order;
import com.hotstrip.week08_work1.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Week08Work1ApplicationTests {
	private static Logger logger = LoggerFactory.getLogger(Week08Work1ApplicationTests.class);

	@Resource
	private OrderRepository orderRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testOrder() {
		// 这里插入两次数据，而且第二次插入 userId + 1 是为了让每个数据表都有数据
		for (int i = 0; i < 100; i++) {
			Order order = new Order();
			order.setOrderId(i);
			order.setUserId(i);
			orderRepository.save(order);
		}
		for (int i = 0; i < 100; i++) {
			Order order = new Order();
			order.setOrderId(i+100);
			order.setUserId(i+1);
			orderRepository.save(order);
		}

		logger.info("insert done...");
		/**
		 * 112 13 应该在 demo_ds_0.t_order_0
 		 */
		Order order = orderRepository.getOneByIds(112, 13);
		logger.info("order => orderId: {}, userId: {}", order.getOrderId(), order.getUserId());

		// userId 为 2 应该有 2 条数据
		List<Order> list = orderRepository.findAllByUserId(11);
		logger.info("order list => size: {}", list.size());
	}

}
