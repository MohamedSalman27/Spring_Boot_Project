package com.tnsif.springbootsample.controller;



import com.tnsif.springbootsample.entity.Mall;
import com.tnsif.springbootsample.service.MallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/malls")
public class MallController {
    private final MallService service;

    public MallController(MallService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mall> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mall> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mall> create(@RequestBody Mall m) {
        Mall saved = service.save(m);
        return ResponseEntity.created(URI.create("/api/malls/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mall> update(@PathVariable Long id, @RequestBody Mall m) {
        return service.findById(id)
                .map(existing -> {
                    existing.setName(m.getName());
                    existing.setAddress(m.getAddress());
                    existing.setFloors(m.getFloors());
                    service.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
