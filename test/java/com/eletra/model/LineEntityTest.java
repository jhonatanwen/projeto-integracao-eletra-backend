package com.eletra.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LineEntityTest {

    @Test
    public void defaultConstructorAndGettersSettersTest() {
        LineEntity line = new LineEntity();
        assertNull(line.getId());
        assertNull(line.getName());

        line = new LineEntity(1, "Cronos");

        assertEquals(Integer.valueOf(1), line.getId());
        assertEquals("Cronos", line.getName());
        assertEquals("Cronos", line.toString());
    }
}