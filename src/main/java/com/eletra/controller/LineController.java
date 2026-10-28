package com.eletra.controller;

import com.eletra.dto.LineDTO;
import com.eletra.service.LineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/lines")
@Tag(name = "Lines", description = "Endpoint de linhas dos medidores")
public class LineController {
    private final LineService lineService;

    public LineController(LineService lineService) { this.lineService = lineService; }

   @GetMapping("/")
   @Operation(summary = "Lista todas as linhas dos medidores")
   public ResponseEntity<List<LineDTO>> getAllLines() {
       return ResponseEntity.ok(lineService.getAllLines());
   }
}
