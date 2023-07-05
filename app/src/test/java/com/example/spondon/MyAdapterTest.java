package com.example.spondon;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import com.example.spondon.Item;
import com.example.spondon.MyAdapter;

public class MyAdapterTest {
    private MyAdapter adapter;
    private List<Item> items;

    @Before
    public void setup() {
        // Initialize the adapter and the items list
        items = new ArrayList<>();
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());
        adapter = new MyAdapter(null, items);
    }

    @Test
    public void getItemCount_ReturnsCorrectItemCount() {
        // Assert that the getItemCount() method returns the correct item count
        assertEquals(items.size(), adapter.getItemCount());
    }
}
