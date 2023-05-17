package com.matchup.fg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matchup.fg.modelo.Matchup;
import com.matchup.fg.repository.MatchupRepository;

@RestController
@RequestMapping("/api/v1/")
public class MatchupController {

	@Autowired
	private MatchupRepository repository;

	@GetMapping("/matchups")
	public List<Matchup> getAllMatchup() {
		return repository.findAll();
	}
	@GetMapping("/matchup/{id}")	
	public ResponseEntity<Matchup> getMatchupById(@PathVariable Long id){
        Optional<Matchup> optionalMatchup = repository.findById(id);
        
        if (optionalMatchup.isPresent()) {
        	Matchup matchup = optionalMatchup.get();
            return ResponseEntity.ok(matchup);
        } else {
            return ResponseEntity.notFound().build();
        }
	}

}
