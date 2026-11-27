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

        line = new LineEntity("Cronos");
        line.setId(1);

        assertEquals(Integer.valueOf(1), line.getId());
        assertEquals("Cronos", line.getName());
        assertEquals("Cronos", line.toString());
    }

    @Test
    public void parameterizedConstructorTest() {
        LineEntity line = new LineEntity("Ares");

        assertNull(line.getId());
        assertEquals("Ares", line.getName());
        assertEquals("Ares", line.toString());
    }
}