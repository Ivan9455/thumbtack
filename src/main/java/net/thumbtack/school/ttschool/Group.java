package net.thumbtack.school.ttschool;


import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees = new ArrayList<>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        } else {
            this.name = name;

        }
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        } else {
            this.room = room;
        }
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.contains(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        } else {
            trainees.remove(trainee);
        }
        trainees.remove(trainee);
    }

    public void removeTrainee(int index) throws TrainingException {
        try {
            trainees.listIterator(index);
            trainees.remove(index);
        } catch (Throwable e) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (int i = 0; i < trainees.size(); i++) {
            if (trainees.listIterator(i).next().getFirstName().equals(firstName)) {
                return trainees.listIterator(i).next();
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (int i = 0; i < trainees.size(); i++) {
            if (trainees.listIterator(i).next().getFullName().equals(fullName)) {
                return trainees.listIterator(i).next();
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                if (o1.getRating() == o2.getRating()) {
                    return 0;
                }
                if (o1.getRating() > o2.getRating()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        List<Trainee> tr = new ArrayList<>();
        if (trainees.size() != 0) {
            sortTraineeListByRatingDescendant();
            for (int i = 0; i < trainees.size(); i++) {
                if (trainees.listIterator(i).next().getRating() == trainees.listIterator(0).next().getRating()) {
                    tr.add(trainees.listIterator(i).next());
                }
            }
            return tr;
        } else {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public boolean hasDuplicates() {
        HashSet<Trainee> hashSet = new HashSet();
        hashSet.addAll(trainees);
        return hashSet.size() != trainees.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}
