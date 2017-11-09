package com.mockito.tutorial.order.bo;

import java.sql.SQLException;

import com.mockito.tutorial.order.bo.exception.BOException;
import com.mockito.tutorial.order.dao.OrderDAO;
import com.mockito.tutorial.order.dto.Order;

public class OrderBOImpl implements OrderBO {
	
	OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = dao.create(order);
			
			if(result == 0) return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int orderId) throws BOException {
		try {
			Order order = dao.read(orderId);
			order.setStatus("cancelled");
			int result = dao.update(order);
			if(result == 0) return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		
		return true;
	}

	@Override
	public boolean deleteOrder(int orderId) throws BOException {
		try {
			int result = dao.delete(orderId);
			if(result == 0) return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		
		return true;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

}
