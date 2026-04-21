package com.alexm.MyNutRest.presentation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexm.MyNutRest.domain.model.ExerciseDomain;
import com.alexm.MyNutRest.domain.model.ExerciseResponseDomain;
import com.alexm.MyNutRest.domain.model.ProgramDomain;
import com.alexm.MyNutRest.domain.model.ProgramResponseDomain;
import com.alexm.MyNutRest.domain.model.UserProgramDomain;
import com.alexm.MyNutRest.domain.model.UserProgramResponseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseResponseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutResponseDomain;
import com.alexm.MyNutRest.domain.service.MyFitService;
import com.alexm.MyNutRest.presentation.dto.request.ExerciseDTO;
import com.alexm.MyNutRest.presentation.dto.request.ProgramDTO;
import com.alexm.MyNutRest.presentation.dto.request.UserProgramDTO;
import com.alexm.MyNutRest.presentation.dto.request.WorkoutDTO;
import com.alexm.MyNutRest.presentation.dto.request.WorkoutExerciseDTO;
import com.alexm.MyNutRest.presentation.dto.response.ExerciseResponseDTO;
import com.alexm.MyNutRest.presentation.dto.response.ProgramResponseDTO;
import com.alexm.MyNutRest.presentation.dto.response.UserProgramResponseDTO;
import com.alexm.MyNutRest.presentation.dto.response.WorkoutExerciseResponseDTO;
import com.alexm.MyNutRest.presentation.dto.response.WorkoutResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.ExerciseDTOMapper;
import com.alexm.MyNutRest.presentation.mapper.ProgramDTOMapper;
import com.alexm.MyNutRest.presentation.mapper.UserProgramDTOMapper;
import com.alexm.MyNutRest.presentation.mapper.WorkoutDTOMapper;
import com.alexm.MyNutRest.presentation.mapper.WorkoutExerciseDTOMapper;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "my-nut/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MyFitController {

	private final MyFitService myFitService;

	@PostMapping(path = "program")
	public ProgramResponseDTO createProgram(@RequestBody ProgramDTO request) {
		ProgramDomain programDomain = ProgramDTOMapper.toDomain(request);
		ProgramResponseDomain programResponseDomain = myFitService.createProgram(programDomain);
		return ProgramDTOMapper.toResponseDTO(programResponseDomain);
	}

	@PostMapping(path = "exercise")
	public ExerciseResponseDTO createExercise(@RequestBody ExerciseDTO request) {
		ExerciseDomain exerciseDomain = ExerciseDTOMapper.toDomain(request);
		ExerciseResponseDomain exerciseResponseDomain = myFitService.createExercise(exerciseDomain);
		return ExerciseDTOMapper.toResponseDTO(exerciseResponseDomain);
	}

	@PostMapping(path = "program/id/{program-id}/workout")
	public WorkoutResponseDTO addWorkoutToProgram(
			@PathVariable(name = "program-id") Long programId,
			@RequestBody WorkoutDTO request) {
		WorkoutDomain workoutDomain = WorkoutDTOMapper.toDomain(request);
		WorkoutResponseDomain workoutResponseDomain = myFitService.addWorkoutToProgram(programId, workoutDomain);
		return WorkoutDTOMapper.toResponseDTO(workoutResponseDomain);
	}

	@PostMapping(path = "workout/id/{workout-id}/exercise/{exercise-id}")
	public WorkoutExerciseResponseDTO addExerciseToWorkout(
			@PathVariable(name = "workout-id") Long workoutId,
			@PathVariable(name = "exercise-id") Long exerciseId,
			@RequestBody WorkoutExerciseDTO request) {
		WorkoutExerciseDomain workoutExerciseDomain = WorkoutExerciseDTOMapper.toDomain(request);
		WorkoutExerciseResponseDomain workoutExerciseResponseDomain = myFitService.addExerciseToWorkout(workoutId, exerciseId, workoutExerciseDomain);
		return WorkoutExerciseDTOMapper.toResponseDTO(workoutExerciseResponseDomain);
	}

	@PostMapping(path = "user/id/{user-id}/program/{program-id}")
	public UserProgramResponseDTO enrollUserInProgram(
			@PathVariable(name = "user-id") Long userId,
			@PathVariable(name = "program-id") Long programId,
			@RequestBody UserProgramDTO request) {
		UserProgramDomain userProgramDomain = UserProgramDTOMapper.toDomain(request);
		UserProgramResponseDomain userProgramResponseDomain = myFitService.enrollUserInProgram(userId, programId, userProgramDomain);
		return UserProgramDTOMapper.toResponseDTO(userProgramResponseDomain);
	}
}
