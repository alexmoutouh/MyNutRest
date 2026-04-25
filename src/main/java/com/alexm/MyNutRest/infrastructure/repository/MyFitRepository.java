package com.alexm.MyNutRest.infrastructure.repository;

import org.springframework.stereotype.Repository;

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
import com.alexm.MyNutRest.domain.port.MyFitPort;
import com.alexm.MyNutRest.infrastructure.entity.Exercise;
import com.alexm.MyNutRest.infrastructure.entity.NutUser;
import com.alexm.MyNutRest.infrastructure.entity.Program;
import com.alexm.MyNutRest.infrastructure.entity.UserProgram;
import com.alexm.MyNutRest.infrastructure.entity.Workout;
import com.alexm.MyNutRest.infrastructure.entity.WorkoutExercise;
import com.alexm.MyNutRest.infrastructure.mapper.ExerciseDomainMapper;
import com.alexm.MyNutRest.infrastructure.mapper.ProgramDomainMapper;
import com.alexm.MyNutRest.infrastructure.mapper.UserProgramDomainMapper;
import com.alexm.MyNutRest.infrastructure.mapper.WorkoutDomainMapper;
import com.alexm.MyNutRest.infrastructure.mapper.WorkoutExerciseDomainMapper;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MyFitRepository implements MyFitPort {

	private ProgramCrudRepository programCrudRepository;
	private WorkoutCrudRepository workoutCrudRepository;
	private ExerciseCrudRepository exerciseCrudRepository;
	private UserProgramCrudRepository userProgramCrudRepository;
	private WorkoutExerciseCrudRepository workoutExerciseCrudRepository;
	private UserCrudRepository userCrudRepository;

	@Override
	public ProgramResponseDomain saveProgram(ProgramDomain programDomain) {
		Program program = ProgramDomainMapper.toEntity(programDomain);
		return ProgramDomainMapper.toResponseDomain(programCrudRepository.save(program));
	}

	@Override
	public ExerciseResponseDomain saveExercise(ExerciseDomain exerciseDomain) {
		Exercise exercise = ExerciseDomainMapper.toEntity(exerciseDomain);
		return ExerciseDomainMapper.toResponseDomain(exerciseCrudRepository.save(exercise));
	}

	@Override
	public WorkoutResponseDomain saveWorkout(Long programId, WorkoutDomain workoutDomain) {
		Program program = programCrudRepository.findById(programId)
				.orElseThrow(() -> new RuntimeException("Program not found with id: " + programId));
		Workout workout = WorkoutDomainMapper.toEntity(workoutDomain);
		workout.setProgram(program);
		return WorkoutDomainMapper.toResponseDomain(workoutCrudRepository.save(workout));
	}

	@Override
	public WorkoutExerciseResponseDomain saveWorkoutExercise(Long workoutId, Long exerciseId,
			WorkoutExerciseDomain workoutExerciseDomain) {
		Workout workout = workoutCrudRepository.findById(workoutId)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + workoutId));
		Exercise exercise = exerciseCrudRepository.findById(exerciseId)
				.orElseThrow(() -> new RuntimeException("Exercise not found with id: " + exerciseId));
		WorkoutExercise workoutExercise = WorkoutExerciseDomainMapper.toEntity(workoutId, exerciseId, workoutExerciseDomain);
		workoutExercise.setWorkout(workout);
		workoutExercise.setExercise(exercise);
		return WorkoutExerciseDomainMapper.toResponseDomain(workoutExerciseCrudRepository.save(workoutExercise));
	}

	@Override
	public UserProgramResponseDomain saveUserProgram(Long userId, Long programId, UserProgramDomain userProgramDomain) {
		NutUser user = userCrudRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
		Program program = programCrudRepository.findById(programId)
				.orElseThrow(() -> new RuntimeException("Program not found with id: " + programId));
		UserProgram userProgram = UserProgramDomainMapper.toEntity(userId, programId, userProgramDomain);
		userProgram.setUser(user);
		userProgram.setProgram(program);
		return UserProgramDomainMapper.toResponseDomain(userProgramCrudRepository.save(userProgram));
	}
}
