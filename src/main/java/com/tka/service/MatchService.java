package com.tka.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.MatchDao;
import com.tka.dao.TeamDao;
import com.tka.dto.MatchDTO;
import com.tka.entity.Matches;
import com.tka.entity.Team;

@Service
public class MatchService {

	@Autowired
	private MatchDao matchDao;

	@Autowired
	private TeamDao teamDao;

	public Matches createMatch(Matches matches) {
		// Fetch full team objects using team IDs
		Team team1 = teamDao.findById(matches.getTeam1().getId());
		Team team2 = teamDao.findById(matches.getTeam2().getId());

		matches.setTeam1(team1);
		matches.setTeam2(team2);

		return matchDao.save(matches);
	}

	public Matches getMatchById(Long id) {
		return matchDao.findById(id);

	}

	public List<Matches> getAllMatches() {
		return matchDao.findAll();
	}

	public List<MatchDTO> getAllMatchDTOs() {
		List<Matches> matchList = matchDao.findAll();

		return matchList.stream().map(match -> {
			MatchDTO dto = new MatchDTO();
			dto.setId(match.getId());
			dto.setMatchTime(match.getMatchTime().toString());
			dto.setMatchDate(match.getMatchDate());
			dto.setLocation(match.getLocation());

			dto.setTeam1Id(match.getTeam1().getId());
			dto.setTeam1Name(match.getTeam1().getName());

			dto.setTeam2Id(match.getTeam2().getId());
			dto.setTeam2Name(match.getTeam2().getName());

			return dto;
		}).collect(Collectors.toList());
	}
}
