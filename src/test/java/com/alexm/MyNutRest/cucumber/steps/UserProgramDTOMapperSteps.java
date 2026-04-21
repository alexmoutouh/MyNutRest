package com.alexm.MyNutRest.cucumber.steps;

import java.time.LocalDate;

import com.alexm.MyNutRest.domain.model.UserProgramDomain;
import com.alexm.MyNutRest.domain.model.UserProgramResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.UserProgramDTO;
import com.alexm.MyNutRest.presentation.dto.response.UserProgramResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.UserProgramDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserProgramDTOMapperSteps {

	private String dtoStartDate;
	private String dtoEndDate;
	private Boolean dtoIsActive;

	private Long responseDomainUserId;
	private Long responseDomainProgramId;
	private String responseDomainStartDate;
	private String responseDomainEndDate;
	private Boolean responseDomainIsActive;

	private UserProgramDomain userProgramDomain;
	private UserProgramResponseDTO userProgramResponseDTO;

	@Étantdonné("un UserProgramDTO avec la startDate {string}")
	public void aUserProgramDTOWithStartDate(String startDate) {
		dtoStartDate = startDate;
	}

	@Et("le UserProgramDTO ayant aussi la endDate {string}")
	public void theUserProgramDTOAlsoWithEndDate(String endDate) {
		dtoEndDate = endDate;
	}

	@Et("le UserProgramDTO ayant aussi le isActive {word}")
	public void theUserProgramDTOAlsoWithIsActive(String isActive) {
		dtoIsActive = Boolean.parseBoolean(isActive);
	}

	@Quand("il est convertit en UserProgramDomain")
	public void itIsConvertedToUserProgramDomain() {
		UserProgramDTO dto = new UserProgramDTO(
				LocalDate.parse(dtoStartDate), LocalDate.parse(dtoEndDate), dtoIsActive);
		userProgramDomain = UserProgramDTOMapper.toDomain(dto);
	}

	@Alors("le UserProgramDomain résultant contient la startDate {string}")
	public void theResultContainsStartDate(String startDate) {
		assertThat(userProgramDomain.startDate(), is(LocalDate.parse(startDate)));
	}

	@Et("le UserProgramDomain résultant contient la endDate {string}")
	public void theResultContainsEndDate(String endDate) {
		assertThat(userProgramDomain.endDate(), is(LocalDate.parse(endDate)));
	}

	@Et("le UserProgramDomain résultant contient le isActive {word}")
	public void theResultContainsIsActive(String isActive) {
		assertThat(userProgramDomain.isActive(), is(Boolean.parseBoolean(isActive)));
	}

	@Étantdonné("un UserProgramResponseDomain avec le userId {long} et le programId {long}")
	public void aUserProgramResponseDomainWithUserIdAndProgramId(Long userId, Long programId) {
		responseDomainUserId = userId;
		responseDomainProgramId = programId;
	}

	@Et("le UserProgramResponseDomain ayant aussi la startDate {string}")
	public void theUserProgramResponseDomainAlsoWithStartDate(String startDate) {
		responseDomainStartDate = startDate;
	}

	@Et("le UserProgramResponseDomain ayant aussi la endDate {string}")
	public void theUserProgramResponseDomainAlsoWithEndDate(String endDate) {
		responseDomainEndDate = endDate;
	}

	@Et("le UserProgramResponseDomain ayant aussi le isActive {word}")
	public void theUserProgramResponseDomainAlsoWithIsActive(String isActive) {
		responseDomainIsActive = Boolean.parseBoolean(isActive);
	}

	@Quand("il est convertit en UserProgramResponseDTO")
	public void itIsConvertedToUserProgramResponseDTO() {
		UserProgramResponseDomain domain = new UserProgramResponseDomain(
				responseDomainUserId, responseDomainProgramId,
				LocalDate.parse(responseDomainStartDate), LocalDate.parse(responseDomainEndDate),
				responseDomainIsActive);
		userProgramResponseDTO = UserProgramDTOMapper.toResponseDTO(domain);
	}

	@Alors("le UserProgramResponseDTO résultant contient le userId {long}")
	public void theResultingDTOContainsUserId(Long userId) {
		assertThat(userProgramResponseDTO.userId(), is(userId));
	}

	@Et("le UserProgramResponseDTO résultant contient le programId {long}")
	public void theResultingDTOContainsProgramId(Long programId) {
		assertThat(userProgramResponseDTO.programId(), is(programId));
	}

	@Et("le UserProgramResponseDTO résultant contient la startDate {string}")
	public void theResultingDTOContainsStartDate(String startDate) {
		assertThat(userProgramResponseDTO.startDate(), is(LocalDate.parse(startDate)));
	}

	@Et("le UserProgramResponseDTO résultant contient la endDate {string}")
	public void theResultingDTOContainsEndDate(String endDate) {
		assertThat(userProgramResponseDTO.endDate(), is(LocalDate.parse(endDate)));
	}

	@Et("le UserProgramResponseDTO résultant contient le isActive {word}")
	public void theResultingDTOContainsIsActive(String isActive) {
		assertThat(userProgramResponseDTO.isActive(), is(Boolean.parseBoolean(isActive)));
	}
}
