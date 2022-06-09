package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.OrderItemsController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemController {

	@Mock
	private Utils utils;

	@Mock
	private OrderItemsDAO dao;

	@InjectMocks
	private OrderItemsController controller;

	@Test
	public void testCreate() {
		final Long fkItemsId = (long) 1;
		final Long fkOrderId = (long) 1;
		final Long itemQuantity = (long) 1;
		
		final OrderItems created = new OrderItems(fkOrderId, fkItemsId, itemQuantity);

		Mockito.when(utils.getLong()).thenReturn(fkOrderId, fkItemsId, itemQuantity);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<OrderItems> orderitems = new ArrayList<>();
		orderitems.add(new OrderItems(1L, 1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(orderitems);

		assertEquals(orderitems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderItems updated = new OrderItems(1L, 1L, 1L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getFkOrderId());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getFkItemsId());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getItemQuantity());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long orderItemsId = 1L;

		Mockito.when(utils.getLong()).thenReturn(orderItemsId);
		Mockito.when(dao.delete(orderItemsId)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(orderItemsId);
	}

}


