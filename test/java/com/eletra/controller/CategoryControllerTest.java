package com.eletra.controller;

import com.eletra.dto.CategoryDTO;
import com.eletra.service.CategoryService;
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
public class CategoryControllerTest {
    @Mock
    private CategoryService categoryService;

    private final Integer lineId = 1;
    private CategoryDTO cronosOld;
    private CategoryDTO cronosL;
    private CategoryDTO cronosNG;

    @InjectMocks
    private CategoryController categoryController;

    @Before
    public void setUp() {
        cronosOld = new CategoryDTO(1, "Cronos Old", lineId);
        cronosL = new CategoryDTO(2, "Cronos L", lineId);
        cronosNG = new CategoryDTO(3, "Cronos NG", lineId);
    }

    @Test
    public void testGetCategoriesByLineId() {
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        categoryDTOs.add(cronosOld);
        categoryDTOs.add(cronosL);
        categoryDTOs.add(cronosNG);

        when(categoryService.getCategoriesByLineId(lineId)).thenReturn(categoryDTOs);

        ResponseEntity<List<CategoryDTO>> result = categoryController.getCategoriesByLineId(1);

        assertNotNull(result.getBody());
        assertEquals(3, result.getBody().size());

        assertEquals(lineId, result.getBody().get(0).getLineId());
        assertEquals(Integer.valueOf(1), result.getBody().get(0).getId());
        assertEquals(Integer.valueOf(2), result.getBody().get(1).getId());
        assertEquals(Integer.valueOf(3), result.getBody().get(2).getId());

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
