package com.alexm.MyNutRest.infrastructure.entity;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nuts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nut {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant instant;
	private BigDecimal kcal;
	private BigDecimal fat;
	private BigDecimal saturatedFattyAcids;
	private BigDecimal carbohydrates;
	private BigDecimal sugar;
	private BigDecimal fibers;
	private BigDecimal protein;
	private BigDecimal sodium;
	@ManyToOne
	@JoinColumn(name = "nut_user_id")
	private NutUser nutUser;
}
