package com.eletra.controller;

import com.eletra.dto.CategoryDTO;
import com.eletra.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/categories")
@Tag(name = "Categories", description = "Endpoint de categorias de medidores")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }

    @GetMapping("/lines/{lineId}")
    @Operation(summary = "Lista as categorias dos medidores de acordo com sua linha")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByLineId(@PathVariable Integer lineId) {
        return ResponseEntity.ok(categoryService.getCategoriesByLineId(lineId));
    }
}
