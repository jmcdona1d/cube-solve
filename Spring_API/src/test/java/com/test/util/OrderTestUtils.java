package com.test.util;

import org.junit.Assert;

import com.domain.Order;

public class OrderTestUtils {

	public static void assertAllButIdsMatchBetweenOrders(Order expected, Order actual) {
		Assert.assertEquals(expected.getDescription(), actual.getDescription());
		Assert.assertEquals(expected.getCostInCents(), actual.getCostInCents());
		Assert.assertEquals(expected.isComplete(), actual.isComplete());
	}

	public static Order generateTestOrder() {
		Order order = new Order();
		order.setDescription("test description");
		order.setCostInCents(150L);
		order.markIncomplete();
		order.setInput("52122200 01445432 34213553 20445145 01413130 30102355");
		return order;
	}

	public static Order generateUpdatedOrder(Order original) {
		Order updated = new Order();
		updated.setDescription(original.getDescription() + " updated");
		updated.setCostInCents(original.getCostInCents() + 100);
		updated.markComplete();
		updated.setInput(original.getInput());
		updated.setResult(original.getResult());
		return updated;
	}
}
