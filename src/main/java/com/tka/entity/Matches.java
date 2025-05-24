package com.tka.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Matches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String matchDate;

	@Column(nullable = false)
	private String location;

	@Column(nullable = false)
	@JsonFormat(pattern = "HH:mm") 
	private LocalTime matchTime;

	@ManyToOne
	@JoinColumn(name = "team1_id", nullable = false)
	private Team team1;

	@ManyToOne
	@JoinColumn(name = "team2_id", nullable = false)
	private Team team2;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalTime getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(LocalTime matchTime) {
		this.matchTime = matchTime;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	@Override
	public String toString() {
		return "Matches [id=" + id + ", matchDate=" + matchDate + ", location=" + location + ", matchTime=" + matchTime
				+ ", team1=" + team1 + ", team2=" + team2 + "]";
	}
}
