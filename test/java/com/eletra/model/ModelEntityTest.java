package com.eletra.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ModelEntityTest {

    @Test
    public void defaultConstructorAndGettersSettersTest() {
        ModelEntity model = new ModelEntity();
        assertNull(model.getId());
        assertNull(model.getName());
        assertNull(model.getCategory());

        LineEntity line = new LineEntity("Cronos");
        line.setId(1);
        CategoryEntity category = new CategoryEntity("Cronos Old", line);
        category.setId(1);

        model.setId(1);
        model.setName("Cronos 6001-A");
        model.setCategory(category);

        assertEquals(Integer.valueOf(1), model.getId());
        assertEquals("Cronos 6001-A", model.getName());
        assertEquals(category, model.getCategory());
        assertEquals("Cronos 6001-A", model.toString());
    }

    @Test
    public void parameterizedConstructorTest() {
        LineEntity line = new LineEntity("Ares");
        line.setId(2);
        CategoryEntity category = new CategoryEntity("Ares TB", line);
        category.setId(4);

        ModelEntity model = new ModelEntity("ARES 7021", category);

        assertNull(model.getId());
        assertEquals("ARES 7021", model.getName());
        assertEquals(category, model.getCategory());
        assertEquals("ARES 7021", model.toString());
    }
}