package com.alexm.MyNutRest.cucumber.steps;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
import com.alexm.MyNutRest.domain.service.MyFitServiceImpl;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FitSteps {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MyFitServiceImpl myFitServiceImpl;

	private final ScenarioContext context;
	private Exception caughtException;

	private String programName;
	private String programDescription;
	private String programDifficulty;
	private Integer programDurationWeeks;
	private Long currentProgramId;

	private String exerciseName;
	private String exerciseDescription;
	private String exerciseMuscleGroup;
	private String exerciseEquipmentNeeded;

	private String workoutName;
	private String workoutDescription;
	private Integer workoutDayOfWeek;

	private Long currentWorkoutId;
	private Long currentExerciseId;
	private Integer weOrderInWorkout;
	private Integer weSets;
	private Integer weReps;
	private Integer weRestSeconds;

	private Long currentUserId;
	private Long currentUserProgramId;
	private String enrollStartDate;
	private String enrollEndDate;
	private Boolean enrollIsActive;

	public FitSteps(ScenarioContext context) {
		this.context = context;
	}

	// --- Program ---

	@Étantdonné("un nouveau programme avec le name {string}")
	public void aNewProgramWithName(String name) {
		programName = name;
	}

	@Et("la description du programme {string}")
	public void theDescriptionOfProgram(String description) {
		programDescription = description;
	}

	@Et("la difficulté du programme {string}")
	public void theDifficultyOfProgram(String difficulty) {
		programDifficulty = difficulty;
	}

	@Et("la durée du programme {int} semaines")
	public void theDurationOfProgram(Integer durationWeeks) {
		programDurationWeeks = durationWeeks;
	}

	// --- Exercise ---

	@Étantdonné("un nouvel exercice avec le name {string}")
	public void aNewExerciseWithName(String name) {
		exerciseName = name;
	}

	@Et("la description de l'exercice {string}")
	public void theDescriptionOfExercise(String description) {
		exerciseDescription = description;
	}

	@Et("le muscleGroup de l'exercice {string}")
	public void theMuscleGroupOfExercise(String muscleGroup) {
		exerciseMuscleGroup = muscleGroup;
	}

	@Et("le equipmentNeeded de l'exercice {string}")
	public void theEquipmentNeededOfExercise(String equipmentNeeded) {
		exerciseEquipmentNeeded = equipmentNeeded;
	}

	// --- Workout ---

	@Étantdonné("un programme existant avec l'id {long}")
	public void anExistingProgramWithId(Long id) {
		currentProgramId = id;
		when(myFitServiceImpl.addWorkoutToProgram(eq(id), any(WorkoutDomain.class)))
				.thenAnswer(invocation -> {
					WorkoutDomain wd = invocation.getArgument(1);
					return new WorkoutResponseDomain(1L, wd.name(), wd.description(), wd.dayOfWeek());
				});
	}

	@Étantdonné("un programme inexistant avec l'id {long}")
	public void aNonExistingProgramWithId(Long id) {
		currentProgramId = id;
		when(myFitServiceImpl.addWorkoutToProgram(eq(id), any(WorkoutDomain.class)))
				.thenThrow(new RuntimeException("Program not found with id: " + id));
	}

	@Et("un nouveau workout avec le name {string}")
	public void aNewWorkoutWithName(String name) {
		workoutName = name;
	}

	@Et("la description du workout {string}")
	public void theDescriptionOfWorkout(String description) {
		workoutDescription = description;
	}

	@Et("le dayOfWeek du workout {int}")
	public void theDayOfWeekOfWorkout(Integer dayOfWeek) {
		workoutDayOfWeek = dayOfWeek;
	}

	// --- WorkoutExercise ---

	@Étantdonné("un workout existant avec l'id {long} et un exercice existant avec l'id {long}")
	public void anExistingWorkoutAndExercise(Long workoutId, Long exerciseId) {
		currentWorkoutId = workoutId;
		currentExerciseId = exerciseId;
		when(myFitServiceImpl.addExerciseToWorkout(eq(workoutId), eq(exerciseId), any(WorkoutExerciseDomain.class)))
				.thenAnswer(invocation -> {
					WorkoutExerciseDomain wed = invocation.getArgument(2);
					return new WorkoutExerciseResponseDomain(workoutId, exerciseId,
							wed.orderInWorkout(), wed.sets(), wed.reps(), wed.restSeconds());
				});
	}

	@Étantdonné("un workout inexistant avec l'id {long} et un exercice existant avec l'id {long}")
	public void aNonExistingWorkoutAndExercise(Long workoutId, Long exerciseId) {
		currentWorkoutId = workoutId;
		currentExerciseId = exerciseId;
		when(myFitServiceImpl.addExerciseToWorkout(eq(workoutId), eq(exerciseId), any(WorkoutExerciseDomain.class)))
				.thenThrow(new RuntimeException("Workout not found with id: " + workoutId));
	}

	@Et("un lien workout-exercice avec le orderInWorkout {int}")
	public void aWorkoutExerciseLinkWithOrderInWorkout(Integer orderInWorkout) {
		weOrderInWorkout = orderInWorkout;
	}

	@Et("le sets du lien {int}")
	public void theSetsOfLink(Integer sets) {
		weSets = sets;
	}

	@Et("le reps du lien {int}")
	public void theRepsOfLink(Integer reps) {
		weReps = reps;
	}

	@Et("le restSeconds du lien {int}")
	public void theRestSecondsOfLink(Integer restSeconds) {
		weRestSeconds = restSeconds;
	}

	// --- UserProgram ---

	@Étantdonné("un utilisateur fitness existant avec l'id {long} et un programme existant avec l'id {long}")
	public void anExistingUserAndProgram(Long userId, Long programId) {
		currentUserId = userId;
		currentUserProgramId = programId;
		when(myFitServiceImpl.enrollUserInProgram(eq(userId), eq(programId), any(UserProgramDomain.class)))
				.thenAnswer(invocation -> {
					UserProgramDomain upd = invocation.getArgument(2);
					return new UserProgramResponseDomain(userId, programId,
							upd.startDate(), upd.endDate(), upd.isActive());
				});
	}

	@Étantdonné("un utilisateur fitness inexistant avec l'id {long} et un programme existant avec l'id {long}")
	public void aNonExistingUserAndProgram(Long userId, Long programId) {
		currentUserId = userId;
		currentUserProgramId = programId;
		when(myFitServiceImpl.enrollUserInProgram(eq(userId), eq(programId), any(UserProgramDomain.class)))
				.thenThrow(new RuntimeException("User not found with id: " + userId));
	}

	@Et("une inscription avec la startDate {string}")
	public void anEnrollmentWithStartDate(String startDate) {
		enrollStartDate = startDate;
	}

	@Et("la endDate de l'inscription {string}")
	public void theEndDateOfEnrollment(String endDate) {
		enrollEndDate = endDate;
	}

	@Et("le isActive de l'inscription {word}")
	public void theIsActiveOfEnrollment(String isActive) {
		enrollIsActive = Boolean.parseBoolean(isActive);
	}

	// --- POST dispatch ---

	@Quand("on effectue un POST fitness sur {string}")
	public void callingWithPOSTFitness(String uri) {
		String json;
		String resolvedUri;

		if (uri.contains("program/id/{program-id}/workout")) {
			resolvedUri = uri.replace("{program-id}", currentProgramId.toString());
			json = String.format("""
					{"name":"%s","description":"%s","dayOfWeek":%d}""",
					workoutName, workoutDescription, workoutDayOfWeek);
		} else if (uri.contains("workout/id/{workout-id}/exercise/{exercise-id}")) {
			resolvedUri = uri.replace("{workout-id}", currentWorkoutId.toString())
					.replace("{exercise-id}", currentExerciseId.toString());
			json = String.format("""
					{"orderInWorkout":%d,"sets":%d,"reps":%d,"restSeconds":%d}""",
					weOrderInWorkout, weSets, weReps, weRestSeconds);
		} else if (uri.contains("user/id/{user-id}/program/{program-id}")) {
			resolvedUri = uri.replace("{user-id}", currentUserId.toString())
					.replace("{program-id}", currentUserProgramId.toString());
			json = String.format("""
					{"startDate":"%s","endDate":"%s","isActive":%s}""",
					enrollStartDate, enrollEndDate, enrollIsActive);
		} else if (uri.contains("exercise")) {
			resolvedUri = uri;
			json = String.format("""
					{"name":"%s","description":"%s","muscleGroup":"%s","equipmentNeeded":"%s"}""",
					exerciseName, exerciseDescription, exerciseMuscleGroup, exerciseEquipmentNeeded);
			when(myFitServiceImpl.createExercise(any(ExerciseDomain.class)))
					.thenReturn(new ExerciseResponseDomain(1L, exerciseName, exerciseDescription,
							exerciseMuscleGroup, exerciseEquipmentNeeded));
		} else {
			resolvedUri = uri;
			json = String.format("""
					{"name":"%s","description":"%s","difficulty":"%s","durationWeeks":%d}""",
					programName, programDescription, programDifficulty, programDurationWeeks);
			when(myFitServiceImpl.createProgram(any(ProgramDomain.class)))
					.thenReturn(new ProgramResponseDomain(1L, programName, programDescription,
							programDifficulty, programDurationWeeks, java.time.Instant.now()));
		}

		try {
			context.setLastResult(mockMvc.perform(post(resolvedUri)
					.contentType(MediaType.APPLICATION_JSON)
					.content(json)
					.accept(MediaType.APPLICATION_JSON)));
		} catch (Exception e) {
			caughtException = e;
		}
	}

	// --- Assertions HTTP ---

	@Alors("la réponse HTTP fitness est {int}")
	public void theHTTPResponseIs(int statusCode) throws Exception {
		context.getLastResult().andExpect(status().is(statusCode));
	}

	// --- Program assertions ---

	@Et("la réponse programme contient le name {string}")
	public void theProgramResponseContainsName(String name) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.name", is(name)));
	}

	@Et("la réponse programme contient la difficulté {string}")
	public void theProgramResponseContainsDifficulty(String difficulty) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.difficulty", is(difficulty)));
	}

	@Et("la réponse programme contient la durée {int}")
	public void theProgramResponseContainsDuration(int durationWeeks) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.durationWeeks", is(durationWeeks)));
	}

	// --- Exercise assertions ---

	@Et("la réponse exercice contient le name {string}")
	public void theExerciseResponseContainsName(String name) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.name", is(name)));
	}

	@Et("la réponse exercice contient le muscleGroup {string}")
	public void theExerciseResponseContainsMuscleGroup(String muscleGroup) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.muscleGroup", is(muscleGroup)));
	}

	// --- Workout assertions ---

	@Et("la réponse workout contient le name {string}")
	public void theWorkoutResponseContainsName(String name) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.name", is(name)));
	}

	@Et("la réponse workout contient le dayOfWeek {int}")
	public void theWorkoutResponseContainsDayOfWeek(int dayOfWeek) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.dayOfWeek", is(dayOfWeek)));
	}

	// --- WorkoutExercise assertions ---

	@Et("la réponse workoutExercise contient le sets {int}")
	public void theWorkoutExerciseResponseContainsSets(int sets) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.sets", is(sets)));
	}

	@Et("la réponse workoutExercise contient le reps {int}")
	public void theWorkoutExerciseResponseContainsReps(int reps) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.reps", is(reps)));
	}

	@Et("la réponse workoutExercise contient le orderInWorkout {int}")
	public void theWorkoutExerciseResponseContainsOrderInWorkout(int orderInWorkout) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.orderInWorkout", is(orderInWorkout)));
	}

	// --- UserProgram assertions ---

	@Et("la réponse userProgram contient la startDate {string}")
	public void theUserProgramResponseContainsStartDate(String startDate) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.startDate", is(startDate)));
	}

	@Et("la réponse userProgram contient le isActive {word}")
	public void theUserProgramResponseContainsIsActive(String isActive) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.isActive", is(Boolean.parseBoolean(isActive))));
	}

	// --- Error assertions ---

	@Alors("une erreur fitness est levée avec le message {string}")
	public void aFitnessErrorIsRaisedWithMessage(String message) {
		assertThat(caughtException, is(notNullValue()));
		assertThat(caughtException.getCause(), instanceOf(RuntimeException.class));
		assertThat(caughtException.getCause().getMessage(), containsString(message));
	}
}
