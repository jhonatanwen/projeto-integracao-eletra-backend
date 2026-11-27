package com.eletra.controller;

import com.eletra.dto.ModelDTO;
import com.eletra.service.ModelService;
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
public class ModelControllerTest {
    @Mock
    private ModelService modelService;

    private final Integer categoryId = 1;
    private ModelDTO cronos6001ADTO;
    private ModelDTO cronos6003DTO;
    private ModelDTO cronos7023DTO;

    @InjectMocks
    private ModelController modelController;

    @Before
    public void setUp() {
        cronos6001ADTO = new ModelDTO(1, "Cronos 6001-A", categoryId);
        cronos6003DTO = new ModelDTO(2, "Cronos 6003", categoryId);
        cronos7023DTO = new ModelDTO(3, "Cronos 7023", categoryId);
    }

    @Test
    public void testGetModelsByCategoryId() {
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelDTOs.add(cronos6001ADTO);
        modelDTOs.add(cronos6003DTO);
        modelDTOs.add(cronos7023DTO);

        when(modelService.getModelsByCategoryId(categoryId)).thenReturn(modelDTOs);

        ResponseEntity<List<ModelDTO>> result = modelController.getModelsByCategoryId(1);

       assertNotNull(result.getBody());

       assertEquals(3, result.getBody().size());

       assertEquals(categoryId, result.getBody().get(0).getCategoryId());
       assertEquals(Integer.valueOf(1), result.getBody().get(0).getId());
       assertEquals(Integer.valueOf(2), result.getBody().get(1).getId());
       assertEquals(Integer.valueOf(3), result.getBody().get(2).getId());

       assertEquals("Cronos 6001-A", result.getBody().get(0).getName());
       assertEquals("Cronos 6003", result.getBody().get(1).getName());
       assertEquals("Cronos 7023", result.getBody().get(2).getName());

       assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
