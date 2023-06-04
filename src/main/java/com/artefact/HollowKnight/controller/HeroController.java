package com.artefact.HollowKnight.controller;

import com.artefact.HollowKnight.model.Hero;
import com.artefact.HollowKnight.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/heroes")
@CrossOrigin(origins = "*")
public class HeroController {
    @Autowired
    private HeroService service;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Hero>> getAllHeroes(){
        return new ResponseEntity<>(service.allHero(), HttpStatus.OK);
    }

    @GetMapping("/{heroId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Optional<Hero>> getSingleHero(@PathVariable String heroId){
        return new ResponseEntity<>(service.singleHero(heroId), HttpStatus.OK);
    }
}
