package com.github.alanpinho.citiesapi.countries.resource;

import com.github.alanpinho.citiesapi.countries.model.Country;
import com.github.alanpinho.citiesapi.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);
        if(optional.isPresent())
            return ResponseEntity.ok(optional.get());
        else
            return ResponseEntity.notFound().build();
    }
}
