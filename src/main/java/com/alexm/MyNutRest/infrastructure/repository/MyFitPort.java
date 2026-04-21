package com.alexm.MyNutRest.infrastructure.repository;

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

public interface MyFitPort {

	ProgramResponseDomain saveProgram(ProgramDomain programDomain);

	ExerciseResponseDomain saveExercise(ExerciseDomain exerciseDomain);

	WorkoutResponseDomain saveWorkout(Long programId, WorkoutDomain workoutDomain);

	WorkoutExerciseResponseDomain saveWorkoutExercise(Long workoutId, Long exerciseId, WorkoutExerciseDomain workoutExerciseDomain);

	UserProgramResponseDomain saveUserProgram(Long userId, Long programId, UserProgramDomain userProgramDomain);
}
