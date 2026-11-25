package com.eletra.service;

import com.eletra.dto.CategoryDTO;
import com.eletra.model.CategoryEntity;
import com.eletra.model.LineEntity;
import com.eletra.repository.CategoryRepository;
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
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    private CategoryEntity cronosOldEntity;
    private CategoryEntity cronosLEntity;
    private CategoryEntity cronosNGEntity;

    @InjectMocks
    private CategoryService categoryService;

    @Before
    public void setUp(){
        LineEntity cronosEntity = new LineEntity("Cronos");
        cronosEntity.setId(1);

        cronosOldEntity = new CategoryEntity("Cronos Old", cronosEntity);
        cronosOldEntity.setId(1);

        cronosLEntity = new CategoryEntity("Cronos L", cronosEntity);
        cronosLEntity.setId(2);

        cronosNGEntity = new CategoryEntity("Cronos-NG", cronosEntity);
        cronosNGEntity.setId(3);
    }

    @Test
    public void testGetCategoriesByLineId(){
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        categoryEntities.add(cronosOldEntity);
        categoryEntities.add(cronosLEntity);
        categoryEntities.add(cronosNGEntity);

        when(categoryRepository.findByLineId(1)).thenReturn(categoryEntities);

        List<CategoryDTO> result = categoryService.getCategoriesByLineId(1);

        assertEquals(3, result.size());

        assertEquals(Integer.valueOf(1), result.get(0).getId());
        assertEquals(Integer.valueOf(2), result.get(1).getId());
        assertEquals(Integer.valueOf(3), result.get(2).getId());

        assertEquals("Cronos Old", result.get(0).getName());
        assertEquals("Cronos L", result.get(1).getName());
        assertEquals("Cronos-NG", result.get(2).getName());
    }
}
