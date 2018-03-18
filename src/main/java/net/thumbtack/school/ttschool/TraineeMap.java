package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> trainees = new HashMap<>();

    public Set<Trainee> getAllTrainees() {
        return trainees.keySet();
    }

    public Set<String> getAllInstitutes() {
        Set<String> str = new HashSet<>();
        for (Map.Entry map : trainees.entrySet()) {
            str.add(map.getValue().toString());
        }
        return str;
    }

    public TraineeMap() {

    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        for (Map.Entry map : trainees.entrySet()) {
            if (map.getKey().equals(trainee)) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
            }
        }
        trainees.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        for (Map.Entry map : trainees.entrySet()) {
            if (map.getKey().equals(trainee)) {
                trainees.replace(trainee, institute);
                return;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        for (Map.Entry map : trainees.entrySet()) {
            if (map.getKey().equals(trainee)) {
                trainees.remove(trainee);
                return;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public int getTraineesCount() {
        return trainees.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        for (Map.Entry map : trainees.entrySet()) {
            if (map.getKey().equals(trainee)) {
                return map.getValue().toString();
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public boolean isAnyFromInstitute(String institute) {
        for (Map.Entry map : trainees.entrySet()) {
            if (map.getValue().toString().equals(institute)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraineeMap that = (TraineeMap) o;
        return Objects.equals(trainees, that.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainees);
    }
}
