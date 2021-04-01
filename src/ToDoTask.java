import java.util.Date;

public class ToDoTask {
    private int taskId;
    private String description;
    private String status;
    private Date createDate;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int newId) {
        taskId = newId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDoTask{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + Main.getFormattedDate(createDate) +
                '}';
    }
}
