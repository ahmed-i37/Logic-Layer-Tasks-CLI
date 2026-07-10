import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private int urgency;
    private String dueDate;
    private boolean isCompleted;

    public Task(int id, String title, int urgency, String dueDate) {
        this.id = id;
        this.title = title;
        setUrgency(urgency);
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {

        if (urgency >= 1 && urgency <=5) {
            this.urgency = urgency;
        }
        else {
            this.urgency = 1;
        }

    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id + "\n"+
                ", title= '" + title + '\'' +"\n"+
                ", urgency= " + urgency +"\n"+
                ", dueDate= '" + dueDate + '\'' +"\n"+
                ", isCompleted= " + isCompleted +
                " } ";
    }
}
