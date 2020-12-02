package com.hotstrip.week7_work1;

import com.hotstrip.week7_work1.model.Order;
import com.hotstrip.week7_work1.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SpringBootTest
class Week7Work1ApplicationTests {

	@Resource
	private OrderService orderService;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsertBatch1() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			Collection<Order> collection = new ArrayList<>();
			for (int j = 0; j < 10000; j++) {
				Order order = new Order();
				order.setOrderId(String.valueOf(i));
				order.setDescription("description " + i + "-" + j);
				order.setTotalNum(j % 10);
				order.setTotalPrice(BigDecimal.valueOf(j));
				order.setCreateTime(new Date());
				collection.add(order);
			}
			orderService.insertBatch(collection);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("耗时 ms ：" + (endTime - startTime));
	}

}
