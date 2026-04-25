package com.alexm.MyNutRest.cucumber.steps;

import java.time.LocalDate;

import com.alexm.MyNutRest.domain.model.UserProgramDomain;
import com.alexm.MyNutRest.domain.model.UserProgramResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.UserProgram;
import com.alexm.MyNutRest.infrastructure.entity.UserProgramId;
import com.alexm.MyNutRest.infrastructure.mapper.UserProgramDomainMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserProgramDomainMapperSteps {

	private Long userIdDomain;
	private Long programIdDomain;
	private String startDateDomain;
	private String endDateDomain;
	private Boolean isActiveDomain;
	private UserProgram userProgramEntity;

	private Long userIdEntity;
	private Long programIdEntity;
	private String startDateEntity;
	private String endDateEntity;
	private Boolean isActiveEntity;
	private UserProgramResponseDomain userProgramResponseDomain;

	@Étantdonné("un UserProgramDomain avec le userId {long} et le programId {long}")
	public void aUserProgramDomainWithUserIdAndProgramId(Long userId, Long programId) {
		userIdDomain = userId;
		programIdDomain = programId;
	}

	@Et("la startDate {string}")
	public void theStartDate(String startDate) {
		startDateDomain = startDate;
		startDateEntity = startDate;
	}

	@Et("la endDate {string}")
	public void theEndDate(String endDate) {
		endDateDomain = endDate;
		endDateEntity = endDate;
	}

	@Et("le isActive {word}")
	public void theIsActive(String isActive) {
		isActiveDomain = Boolean.parseBoolean(isActive);
		isActiveEntity = Boolean.parseBoolean(isActive);
	}

	@Quand("il est convertit en entité UserProgram")
	public void itIsConvertedToUserProgramEntity() {
		UserProgramDomain domain = new UserProgramDomain(
				LocalDate.parse(startDateDomain), LocalDate.parse(endDateDomain), isActiveDomain);
		userProgramEntity = UserProgramDomainMapper.toEntity(userIdDomain, programIdDomain, domain);
	}

	@Alors("l'entité UserProgram résultante contient le userId {long}")
	public void theEntityContainsUserId(Long userId) {
		assertThat(userProgramEntity.getId().getUserId(), is(userId));
	}

	@Et("l'entité UserProgram résultante contient le programId {long}")
	public void theEntityContainsProgramId(Long programId) {
		assertThat(userProgramEntity.getId().getProgramId(), is(programId));
	}

	@Et("l'entité UserProgram résultante contient la startDate {string}")
	public void theEntityContainsStartDate(String startDate) {
		assertThat(userProgramEntity.getId().getStartDate(), is(LocalDate.parse(startDate)));
	}

	@Et("l'entité UserProgram résultante contient la endDate {string}")
	public void theEntityContainsEndDate(String endDate) {
		assertThat(userProgramEntity.getEndDate(), is(LocalDate.parse(endDate)));
	}

	@Et("l'entité UserProgram résultante contient le isActive {word}")
	public void theEntityContainsIsActive(String isActive) {
		assertThat(userProgramEntity.getIsActive(), is(Boolean.parseBoolean(isActive)));
	}

	@Étantdonné("une entité UserProgram avec le userId {long} et le programId {long}")
	public void aUserProgramEntityWithUserIdAndProgramId(Long userId, Long programId) {
		userIdEntity = userId;
		programIdEntity = programId;
	}

	@Et("la startDate entity {string}")
	public void theStartDateEntity(String startDate) {
		startDateEntity = startDate;
	}

	@Et("la endDate entity {string}")
	public void theEndDateEntity(String endDate) {
		endDateEntity = endDate;
	}

	@Et("le isActive entity {word}")
	public void theIsActiveEntity(String isActive) {
		isActiveEntity = Boolean.parseBoolean(isActive);
	}

	@Quand("elle est convertit en UserProgramResponseDomain")
	public void itIsConvertedToUserProgramResponseDomain() {
		UserProgram userProgram = new UserProgram();
		UserProgramId id = new UserProgramId(userIdEntity, programIdEntity, LocalDate.parse(startDateEntity));
		userProgram.setId(id);
		userProgram.setEndDate(LocalDate.parse(endDateEntity));
		userProgram.setIsActive(isActiveEntity);
		userProgramResponseDomain = UserProgramDomainMapper.toResponseDomain(userProgram);
	}

	@Alors("le UserProgramResponseDomain résultant contient le userId {long}")
	public void theResponseDomainContainsUserId(Long userId) {
		assertThat(userProgramResponseDomain.userId(), is(userId));
	}

	@Et("le UserProgramResponseDomain résultant contient le programId {long}")
	public void theResponseDomainContainsProgramId(Long programId) {
		assertThat(userProgramResponseDomain.programId(), is(programId));
	}

	@Et("le UserProgramResponseDomain résultant contient la startDate {string}")
	public void theResponseDomainContainsStartDate(String startDate) {
		assertThat(userProgramResponseDomain.startDate(), is(LocalDate.parse(startDate)));
	}

	@Et("le UserProgramResponseDomain résultant contient la endDate {string}")
	public void theResponseDomainContainsEndDate(String endDate) {
		assertThat(userProgramResponseDomain.endDate(), is(LocalDate.parse(endDate)));
	}

	@Et("le UserProgramResponseDomain résultant contient le isActive {word}")
	public void theResponseDomainContainsIsActive(String isActive) {
		assertThat(userProgramResponseDomain.isActive(), is(Boolean.parseBoolean(isActive)));
	}
}
