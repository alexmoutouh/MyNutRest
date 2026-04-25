package com.alexm.MyNutRest.domain.service;

import org.springframework.stereotype.Service;

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
import com.alexm.MyNutRest.domain.port.MyFitService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyFitServiceImpl implements MyFitService {

	private MyFitPort myFitPort;

	@Override
	public ProgramResponseDomain createProgram(ProgramDomain programDomain) {
		return myFitPort.saveProgram(programDomain);
	}

	@Override
	public ExerciseResponseDomain createExercise(ExerciseDomain exerciseDomain) {
		return myFitPort.saveExercise(exerciseDomain);
	}

	@Override
	public WorkoutResponseDomain addWorkoutToProgram(Long programId, WorkoutDomain workoutDomain) {
		return myFitPort.saveWorkout(programId, workoutDomain);
	}

	@Override
	public WorkoutExerciseResponseDomain addExerciseToWorkout(Long workoutId, Long exerciseId,
			WorkoutExerciseDomain workoutExerciseDomain) {
		return myFitPort.saveWorkoutExercise(workoutId, exerciseId, workoutExerciseDomain);
	}

	@Override
	public UserProgramResponseDomain enrollUserInProgram(Long userId, Long programId, UserProgramDomain userProgramDomain) {
		return myFitPort.saveUserProgram(userId, programId, userProgramDomain);
	}
}
