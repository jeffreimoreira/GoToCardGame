package com.moreira.jeffrei.GoToCardGame.web.rest.controller;

import com.moreira.jeffrei.GoToCardGame.data.model.LogEntry;
import com.moreira.jeffrei.GoToCardGame.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeffr on 2024-05-07
 */
@RestController
@RequestMapping("/api/v1/logs")
public class LogRestController {

    private final LogService service;

    public LogRestController(LogService service) {
        this.service = service;
    }

    @GetMapping("/{entityName}/{id}")
    public ResponseEntity<List<LogEntry>> getCards(@PathVariable String entityName, @PathVariable Long id) {
        List<LogEntry> logEntries = service.getLogsForEntity(entityName, id);

        return new ResponseEntity<>(logEntries, HttpStatus.OK);
    }
}
