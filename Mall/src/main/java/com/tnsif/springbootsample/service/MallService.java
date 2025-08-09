package com.tnsif.springbootsample.service;



import com.tnsif.springbootsample.entity.Mall;
import com.tnsif.springbootsample.repository.MallRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MallService {
    private final MallRepository repo;

    public MallService(MallRepository repo) {
        this.repo = repo;
    }

    public List<Mall> findAll() {
        return repo.findAll();
    }

    public Optional<Mall> findById(Long id) {
        return repo.findById(id);
    }

    public Mall save(Mall m) {
        return repo.save(m);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
