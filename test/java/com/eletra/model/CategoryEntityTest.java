package com.eletra.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CategoryEntityTest {

    @Test
    public void defaultConstructorAndGettersSettersTest() {
        CategoryEntity category = new CategoryEntity();
        assertNull(category.getId());
        assertNull(category.getName());
        assertNull(category.getLine());

        LineEntity line = new LineEntity("Cronos");
        line.setId(1);

        category = new CategoryEntity("Cronos Old", line);
        category.setId(1);

        assertEquals(Integer.valueOf(1), category.getId());
        assertEquals("Cronos Old", category.getName());
        assertEquals(line, category.getLine());
        assertEquals("Cronos Old", category.toString());
    }

    @Test
    public void parameterizedConstructorTest() {
        LineEntity line = new LineEntity("Ares");
        line.setId(2);

        CategoryEntity category = new CategoryEntity("Ares TB", line);

        assertNull(category.getId());
        assertEquals("Ares TB", category.getName());
        assertEquals(line, category.getLine());
        assertEquals("Ares TB", category.toString());
    }
}