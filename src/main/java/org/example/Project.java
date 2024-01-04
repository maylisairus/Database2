package org.example;

import java.sql.Date;

public class Project {

    private int id;
    private int clientId;
    private Date startDate;
    private Date finishDate;

    public Project(int id, int clientId, Date startDate, Date finishDate) {
        this.id = id;
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
