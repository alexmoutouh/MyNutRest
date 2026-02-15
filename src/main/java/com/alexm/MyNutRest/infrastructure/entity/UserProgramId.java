package com.alexm.MyNutRest.infrastructure.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserProgramId implements Serializable {

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "program_id")
	private Long programId;

	@Column(name = "start_date")
	private LocalDate startDate;
}
