package net.thumbtack.school.ttschool;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {
    Queue<Trainee> queue = new LinkedList<>();

    public TraineeQueue() {

    }

    public void addTrainee(Trainee trainee) {
        queue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (queue.size() == 0) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        } else {
            return queue.remove();
        }
    }
}
