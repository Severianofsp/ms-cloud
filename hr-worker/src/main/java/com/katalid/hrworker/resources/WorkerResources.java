package com.katalid.hrworker.resources;

import com.katalid.hrworker.entities.Worker;
import com.katalid.hrworker.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
@Slf4j
public class WorkerResources {

    @Value("${test.config}")
    private String testeConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs() {
        log.info("Config = " + testeConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable() Long id) {
        log.info("minha porta: " + env.getProperty("local.server.port"));
        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok().body(worker);
    }

    @PostMapping
    public ResponseEntity<Worker> save(Worker worker){
        return ResponseEntity.ok().body(worker);
    }
}
