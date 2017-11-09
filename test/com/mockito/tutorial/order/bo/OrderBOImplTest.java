package com.mockito.tutorial.order.bo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mockito.tutorial.order.bo.exception.BOException;
import com.mockito.tutorial.order.dao.OrderDAO;
import com.mockito.tutorial.order.dto.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderBOImplTest {

	@Mock
	OrderDAO dao;
	
	private OrderBOImpl bo;
	
	@Before
	public void setup() {
		System.out.println("setup");
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@Test
	void placeOrder_should_create_an_order() throws SQLException, BOException {
		System.out.println("test");
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);
		
		assertTrue(result);
		verify(dao).create(order);
	}
	
	@After
	public void cleanUp() {
		System.out.println("after");
		bo = null;
	}

}
