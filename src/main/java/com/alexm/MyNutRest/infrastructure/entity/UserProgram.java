package com.alexm.MyNutRest.infrastructure.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_programs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProgram {

	@EmbeddedId
	private UserProgramId id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private NutUser user;

	@ManyToOne
	@MapsId("programId")
	@JoinColumn(name = "program_id")
	private Program program;

	private LocalDate endDate;

	@Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean isActive;
}
