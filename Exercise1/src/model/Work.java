package model;

public class Work {
private int id;
private String titleTask;
private int idUser;
private String status;

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", titleTask='" + titleTask + '\'' +
                ", idUser=" + idUser +
                ", status='" + status + '\'' +
                '}';
    }

    public Work(int id, String titleTask, int idUser, String status) {
        this.id = id;
        this.titleTask = titleTask;
        this.idUser = idUser;
        this.status = status;
    }

    public Work(String titleTask, String status) {
        this.titleTask = titleTask;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
