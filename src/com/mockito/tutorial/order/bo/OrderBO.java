package com.mockito.tutorial.order.bo;

import com.mockito.tutorial.order.bo.exception.BOException;
import com.mockito.tutorial.order.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int orderId) throws BOException;
	
	boolean deleteOrder(int orderId) throws BOException;
}
