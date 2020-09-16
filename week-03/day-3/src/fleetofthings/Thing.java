package fleetofthings;

/**
 * Created by aze on 2017.03.29..
 */
public class Thing {
    private String name;
    private boolean completed;

    public Thing(String name, boolean na) {
        this.name = name;
        this.completed = na;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}