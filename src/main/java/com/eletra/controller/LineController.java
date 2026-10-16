package com.eletra.controller;

import com.eletra.model.LineEntity;
import com.eletra.repository.LineRepository;
import java.util.List;

public class LineController {
   private final LineRepository lineRepository;

   public LineController() {
       this.lineRepository = new LineRepository();
   }

   public List<LineEntity> getAllLines() {
       return lineRepository.findAll();
   }

   public LineEntity getLineByName(String lineName) {
       return lineRepository.findByName(lineName);
   }
}
