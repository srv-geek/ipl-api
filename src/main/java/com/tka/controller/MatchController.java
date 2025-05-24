package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.dto.MatchDTO;
import com.tka.entity.Matches;
import com.tka.service.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {

	@Autowired
	private MatchService matchService;

	@PostMapping("/matchSchedule")
	public Matches createMatch(@RequestBody Matches matches) {
		return matchService.createMatch(matches);
	}
	
	@PostMapping("/addMatch")
	public MatchDTO addMatch(@RequestBody Matches matches) {
	    Matches savedMatch = matchService.createMatch(matches);

	    MatchDTO dto = new MatchDTO();
	    dto.setId(savedMatch.getId());
	    dto.setMatchTime(savedMatch.getMatchTime().toString());
	    dto.setMatchDate(savedMatch.getMatchDate());
	    dto.setLocation(savedMatch.getLocation());

	    dto.setTeam1Id(savedMatch.getTeam1().getId());
	    dto.setTeam1Name(savedMatch.getTeam1().getName());
	    dto.setTeam2Id(savedMatch.getTeam2().getId());
	    dto.setTeam2Name(savedMatch.getTeam2().getName());

	    return dto;
	}


	@GetMapping("/getSingleMatch/{id}")
	public Matches getMatchById(@PathVariable Long id) {
		return matchService.getMatchById(id);
	}

	@GetMapping("/getSchedule")
	public List<Matches> getAllMatches() {
		return matchService.getAllMatches();
	}

	@GetMapping("/getAllMatches")
	public List<MatchDTO> getAllMatchesDTO() {
		return matchService.getAllMatchDTOs();
	}
}
