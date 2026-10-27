package com.eletra.controller;

import com.eletra.model.CategoryEntity;
import com.eletra.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/categories")
@Tag(name = "Categories", description = "Endpoint de categorias de medidores")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController() {
        this.categoryRepository = new CategoryRepository();
    }

    @GetMapping
    @Operation
    public ResponseEntity<List<CategoryEntity>> getCategoriesByLineId(Integer lineId) {
        return ResponseEntity.ok(categoryRepository.findByLineId(lineId));
    }
}
