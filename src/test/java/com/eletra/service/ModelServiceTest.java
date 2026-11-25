package com.eletra.service;

import com.eletra.dto.ModelDTO;
import com.eletra.model.CategoryEntity;
import com.eletra.model.LineEntity;
import com.eletra.model.ModelEntity;
import com.eletra.repository.ModelRepository;
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
public class ModelServiceTest {
    @Mock
    private ModelRepository modelRepository;

    private ModelEntity cronos6001AEntity;
    private ModelEntity cronos6003Entity;
    private ModelEntity cronos7023Entity;

    @InjectMocks
    private ModelService modelService;

    @Before
    public void setUp(){
        LineEntity cronosEntity = new LineEntity("Cronos");
        cronosEntity.setId(1);

        CategoryEntity cronosOldEntity = new CategoryEntity("Cronos Old", cronosEntity);
        cronosOldEntity.setId(1);

        cronos6001AEntity = new ModelEntity("Cronos 6001-A", cronosOldEntity);
        cronos6001AEntity.setId(1);

        cronos6003Entity = new ModelEntity("Cronos 6003", cronosOldEntity);
        cronos6003Entity.setId(2);

        cronos7023Entity = new ModelEntity("Cronos 7023", cronosOldEntity);
        cronos7023Entity.setId(3);
    }

    @Test
    public void testGetModelsByCategoryId() {
        List<ModelEntity> modelEntities = new ArrayList<>();
        modelEntities.add(cronos6001AEntity);
        modelEntities.add(cronos6003Entity);
        modelEntities.add(cronos7023Entity);

        when(modelRepository.findByCategoryId(1)).thenReturn(modelEntities);


        List<ModelDTO> result = modelService.getModelsByCategoryId(1);

        assertEquals(3, result.size());

        assertEquals(Integer.valueOf(1), result.get(0).getId());
        assertEquals(Integer.valueOf(2), result.get(1).getId());
        assertEquals(Integer.valueOf(3), result.get(2).getId());

        assertEquals("Cronos 6001-A", result.get(0).getName());
        assertEquals("Cronos 6003", result.get(1).getName());
        assertEquals("Cronos 7023", result.get(2).getName());
    }
}
