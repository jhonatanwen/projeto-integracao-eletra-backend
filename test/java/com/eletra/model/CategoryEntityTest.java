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

        LineEntity line = new LineEntity(1, "Cronos");

        category = new CategoryEntity(1,"Cronos Old", line);

        assertEquals(Integer.valueOf(1), category.getId());
        assertEquals("Cronos Old", category.getName());
        assertEquals(line, category.getLine());
        assertEquals("Cronos Old", category.toString());
    }
}