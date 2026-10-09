package com.eletra.controller;

import com.eletra.model.Category;
import com.eletra.model.Line;
import com.eletra.model.Model;

import java.util.ArrayList;
import java.util.List;

public class LineController {
    public List<Line> getAllLines() {
        List<Line> lines = new ArrayList<>();

        Line cronos = new Line("Cronos");

        Category cronosOld = new Category("Cronos Old");
        cronosOld.addModel(new Model("Cronos 6001-A"));
        cronosOld.addModel(new Model("Cronos 6003"));
        cronosOld.addModel(new Model("Cronos 7023"));

        Category cronosL = new Category("Cronos L");
        cronosL.addModel(new Model("Cronos 6021L"));
        cronosL.addModel(new Model("Cronos 7023L"));

        Category cronosNG = new Category("Cronos-NG");
        cronosNG.addModel(new Model("Cronos 6001-NG"));
        cronosNG.addModel(new Model("Cronos 6003-NG"));
        cronosNG.addModel(new Model("Cronos 6021-NG"));
        cronosNG.addModel(new Model("Cronos 6031-NG"));
        cronosNG.addModel(new Model("Cronos 7021-NG"));
        cronosNG.addModel(new Model("Cronos 7023-NG"));

        cronos.addCategory(cronosOld);
        cronos.addCategory(cronosL);
        cronos.addCategory(cronosNG);

        Line ares = new Line("Ares");

        Category aresTB = new Category("Ares TB");
        aresTB.addModel(new Model("ARES 7021"));
        aresTB.addModel(new Model("ARES 7031"));
        aresTB.addModel(new Model("ARES 7023"));

        Category aresTHS = new Category("Ares THS");
        aresTHS.addModel(new Model("ARES 8023 15"));
        aresTHS.addModel(new Model("ARES 8023 200"));
        aresTHS.addModel(new Model("ARES 8023 2,5"));

        ares.addCategory(aresTB);
        ares.addCategory(aresTHS);

        lines.add(cronos);
        lines.add(ares);

        return lines;
    }

    public Line getLineByName(String name) {
        if (name == null){
            return null;
        }

        for (Line line : getAllLines()) {
            if (line.getName().equalsIgnoreCase(name)){
                return line;
            }
        }

        return null;
    }

}
