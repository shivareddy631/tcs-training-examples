package com.tcs.interfaces.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestItemsList {
	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(200, "Laptop", 98000));
		items.add(new Item(300, "Mobile", 18000));
		items.add(new Item(100, "TV", 48000));
		items.add(new Item(400, "Camera", 28000));
		printItems(items);
		Collections.sort(items, new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				return Integer.compare(i1.getItemId(), i2.getItemId());
			}
		});
		printItems(items);
		Collections.sort(items, (i1, i2) -> i1.getItemName().compareTo(i2.getItemName()));
		printItems(items);
		Collections.sort(items, (i1, i2) -> Double.compare(i1.getItemPrice(), i2.getItemPrice()));
		printItems(items);
	}
	public static void printItems(List<Item> items) {
		for(Item item: items) {
			System.out.println(item);
		}
		System.out.println("-------------------------");
	}
}
