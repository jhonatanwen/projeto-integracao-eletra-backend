package com.eletra.service;

import com.eletra.dto.LineDTO;
import com.eletra.model.LineEntity;
import com.eletra.repository.LineRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LineServiceTest {
    @Mock
    private LineRepository lineRepository;

    private LineEntity cronosEntity;
    private LineEntity aresEntity;

    @InjectMocks
    private LineService lineService;

    @Before
    public void setUp() {
        cronosEntity = new LineEntity("Cronos");
        cronosEntity.setId(1);

        aresEntity = new LineEntity("Ares");
        aresEntity.setId(2);
    }

    @Test
    public void testGetAllLines() {
        List<LineEntity> linesEntities = new ArrayList<>();
        linesEntities.add(cronosEntity);
        linesEntities.add(aresEntity);

        when(lineRepository.findAll()).thenReturn(linesEntities);

        List<LineDTO> result = lineService.getAllLines();

        assertEquals(2, result.size());

        assertEquals(Integer.valueOf(1), result.get(0).getId());
        assertEquals("Cronos", result.get(0).getName());

        assertEquals(Integer.valueOf(2), result.get(1).getId());
        assertEquals("Ares", result.get(1).getName());
    }
}
