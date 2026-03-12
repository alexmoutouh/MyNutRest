package com.alexm.MyNutRest.infrastructure.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "programs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Difficulty difficulty;

	@Column(nullable = false)
	private Integer durationWeeks;

	private Instant createdAt;

	@OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Workout> workouts = new ArrayList<>();

	@OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserProgram> userPrograms = new ArrayList<>();
}
