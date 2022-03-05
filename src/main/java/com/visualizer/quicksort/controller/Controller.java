package com.visualizer.quicksort.controller;

import com.visualizer.quicksort.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.visualizer.quicksort.utils.Utils.isArrayValid;

@RestController
public class Controller {

    @Autowired
    private Application application;

    @GetMapping("/")
    public String homePage() {
        return "Algorithm Visualizer Quicksort Homepage";
    }

    @GetMapping(value = "/quicksort/", produces = "application/json")
    public ResponseEntity<?> sortArray(@RequestParam(value = "array") int[] array) {
        if (isArrayValid(array)) {
            application.quickSort(array);
            return ResponseEntity.ok(array);
        } else {
            return ResponseEntity.badRequest().body("No array passed");
        }
    }
}

