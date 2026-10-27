package com.eletra.controller;

import com.eletra.model.LineEntity;
import com.eletra.repository.LineRepository;
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
   private final LineRepository lineRepository;

   public LineController() {
       this.lineRepository = new LineRepository();
   }

   @GetMapping
   @Operation
   public ResponseEntity<List<LineEntity>> getAllLines() {
       return ResponseEntity.ok(lineRepository.findAll());
   }
}
