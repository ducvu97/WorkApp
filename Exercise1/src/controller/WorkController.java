package controller;

import model.Work;
import service.WorkServiceImpl;

import java.util.ArrayList;

public class WorkController {

    public static WorkController getInstance(){
        return new WorkController();
    }

    public ArrayList<Work> findByIdUser(int idUser){
        return WorkServiceImpl.getInstance().findByIdUser(idUser);
    }

    public boolean createTask(Work work,String username){
     return WorkServiceImpl.getInstance().createTask(work, username);
    }

    public void viewAllTask(){
        WorkServiceImpl.getInstance().viewAllTask();
    }

    public void deleteTask(String username){
        WorkServiceImpl.getInstance().deleteTask(username);
    }

    public Work findByTittleTask(String titleTask, int i){
        return WorkServiceImpl.getInstance().findByTitleTask(titleTask, i);
    }

    public void editTask (Work work, String titleTask, String username, int i){
        WorkServiceImpl.getInstance().editTask(work,titleTask,username, i);
    }
}
