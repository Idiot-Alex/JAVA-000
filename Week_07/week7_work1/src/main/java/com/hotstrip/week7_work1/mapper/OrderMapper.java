package com.hotstrip.week7_work1.mapper;

import com.hotstrip.week7_work1.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface OrderMapper {

    /**
     * 批量新增
     * @param collection
     * @return
     */
    int insertBatch(@Param("collection") final Collection<Order> collection);
}
