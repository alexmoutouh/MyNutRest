package com.alexm.MyNutRest.presentation.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.domain.service.MyNutService;
import com.alexm.MyNutRest.presentation.dto.NutDTO;
import com.alexm.MyNutRest.presentation.dto.NutResponseDTO;
import com.alexm.MyNutRest.presentation.dto.NutUserResponseDTO;
import com.alexm.MyNutRest.presentation.dto.UserDTO;
import com.alexm.MyNutRest.presentation.mapper.NutDTOMapper;
import com.alexm.MyNutRest.presentation.mapper.NutUserDTOMapper;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "my-nut/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MyNutUserController {

	private final MyNutService myNutService;

	@GetMapping(path = "user/id/{user-id}")
	public Optional<NutUserResponseDTO> findUserById(@PathVariable(name = "user-id") Long userId) {
		return myNutService.findUserById(userId).map(NutUserDTOMapper::toResponseDTO);
	}

	@GetMapping(path = "user/lastname/{user-lastname}")
	public List<NutUserResponseDTO> findUserById(@PathVariable(name = "user-lastname") String userLastname) {
		return myNutService.findUsersByLastName(userLastname).stream().map(NutUserDTOMapper::toResponseDTO).toList();
	}

	@PostMapping(path = "user")
	public NutUserResponseDTO registerNewUser(@RequestBody UserDTO userDto) {
		NutUserDomain nutUserDomain = NutUserDTOMapper.toDomain(userDto);
		NutUserResponseDomain nutUserResponseDomain = myNutService.registerNewUser(nutUserDomain);
		return NutUserDTOMapper.toResponseDTO(nutUserResponseDomain);
	}

	@PostMapping(path = "users")
	public List<NutUserResponseDTO> registerNewUsers(@RequestBody List<UserDTO> users) {
		List<NutUserDomain> usersDomain = users.stream()
				.map(NutUserDTOMapper::toDomain)
				.toList();
		return myNutService.registerNewUsers(usersDomain).stream().map(NutUserDTOMapper::toResponseDTO).toList();
	}

	@PostMapping(path = "user/id/{user-id}/nut")
	public NutResponseDTO saveNutForUser(@PathVariable(name = "user-id") Long userId, @RequestBody NutDTO request) {
		NutDomain nutDomain = NutDTOMapper.toDomain(request);
		NutResponseDomain nutResponseDomain = myNutService.addNutToUser(userId, nutDomain);
		return NutDTOMapper.toResponseDTO(nutResponseDomain);
	}
}
