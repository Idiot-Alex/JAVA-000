package com.hotstrip.week08_work1.repository;

import com.hotstrip.week08_work1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // 查询
    @Query(value = "select * from t_order where order_id = :orderId and user_id = :userId", nativeQuery = true)
    Order getOneByIds(@Param("orderId") int orderId, @Param("userId") int userId);

    // 根据 userId 查询
    @Query(value = "select * from t_order where user_id = :userId", nativeQuery = true)
    List<Order> findAllByUserId(@Param("userId") int userId);
}
