package com.eletra.controller;

import com.eletra.dto.LineDTO;
import com.eletra.service.LineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LineControllerTest {
    @Mock
    private LineService lineService;

    private LineDTO cronosDTO;
    private LineDTO aresDTO;

    @InjectMocks
    private LineController lineController;

    @Before
    public void setUp() {
        cronosDTO = new LineDTO(1, "Cronos");
        aresDTO = new LineDTO(2, "Ares");
    }

    @Test
    public void testGetAllLines() {
        List<LineDTO> lineDTOs = new ArrayList<>();
        lineDTOs.add(cronosDTO);
        lineDTOs.add(aresDTO);

        when(lineService.getAllLines()).thenReturn(lineDTOs);

        ResponseEntity<List<LineDTO>> result = lineController.getAllLines();

        assertNotNull(result.getBody());

        assertEquals(2, result.getBody().size());

        assertEquals(Integer.valueOf(1), result.getBody().get(0).getId());
        assertEquals(Integer.valueOf(2), result.getBody().get(1).getId());
        assertEquals("Cronos", result.getBody().get(0).getName());
        assertEquals("Ares", result.getBody().get(1).getName());

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}
