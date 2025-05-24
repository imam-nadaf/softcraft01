
###Object-Oriented Modeling and Design
#### **Classes and Behaviors**

1. **User**
   - **Attributes**:
     - userId: User's ID.
     - name: User's name.
     - age: User's age.
     - weight: User's current weight.
     - height: User's height.
   - **Behaviors**:
     - createProfile(): Create a new user profile.
     - logWorkout(workout): Log a new workout.
     - viewProgress(): View progress summary.

2. **Workout**
   - **Attributes**:
     - workoutId: Unique identifier for the workout.
     - userId: Reference to the user who performed the workout.
     - date: Date of the workout.
     - duration: Total duration of the workout (in minutes).
     - totalCaloriesBurned: Total calories burned in the workout.
     - exercises: List of exercises performed in the workout.
   - **Behaviors**:
     - addExercise(exercise): Add an exercise to the workout.
     - calculateCaloriesBurned(): Calculate total calories based on exercises and duration.
     - viewWorkoutDetails(): Display details of the workout.
  
3. **Exercise**
   - **Attributes**:
     - exerciseId: Unique identifier for the exercise.
     - name: Name of the exercise (e.g., "Running", "Push-ups").
     - type: Category (e.g., cardio, strength, flexibility).
     - intensity: Intensity level (e.g., low, medium, high).
     - duration: Duration of the exercise (in minutes).
     - caloriesPerMinute: Estimated calories burned per minute for the exercise.
   - **Behaviors**:
     - createExercise(name, type, intensity, caloriesPerMinute): Create a new exercise.
     - updateExercise(name, type, intensity, caloriesPerMinute): Update exercise details.
     - deleteExercise(): Remove an exercise from the system.

4. **Progress**
   - **Attributes**:
     - userId: Reference to the user.
     - totalWorkouts: Total number of workouts completed.
     - totalCaloriesBurned: Sum of calories burned across all workouts.
     - workoutHistory: List of past workouts.
   - **Behaviors**:
     - calculateProgress(): Compute progress metrics (e.g., total workouts, calories).
     - viewProgressSummary(): Display progress metrics (e.g., charts or stats).
     - filterProgressByDate(startDate, endDate): Show progress for a specific time range.

#### **Relationships Between Classes**:
- **User - Workout**: One-to-Many (One user can have multiple workouts).
- **Workout - Exercise**: One-to-Many (One workout can include multiple exercises).
- **User - Progress**: One-to-One (Each user has one progress summary).
- **Exercise**: Independent entity, reusable across workouts.
