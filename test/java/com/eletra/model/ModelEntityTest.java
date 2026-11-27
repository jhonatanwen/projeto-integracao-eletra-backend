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

        LineEntity line = new LineEntity(1, "Cronos");
        CategoryEntity category = new CategoryEntity(1, "Cronos Old", line);

        model = new ModelEntity(1, "Cronos 6001-A", category);

        assertEquals(Integer.valueOf(1), model.getId());
        assertEquals("Cronos 6001-A", model.getName());
        assertEquals(category, model.getCategory());
        assertEquals("Cronos 6001-A", model.toString());
    }
}