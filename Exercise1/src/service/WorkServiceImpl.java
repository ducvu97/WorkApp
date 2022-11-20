package service;

import model.Work;

import java.util.ArrayList;

public class WorkServiceImpl {

    public static WorkServiceImpl getInstance() {
        return new WorkServiceImpl();
    }

    public static ArrayList<Work> workList = addWork();

    public static ArrayList<Work> addWork() {
        ArrayList<Work> workList = new ArrayList<Work>();
        workList.add(new Work(1, "Training OOP", 1, "done"));
        workList.add(new Work(2, "Training Data", 3, "done"));
        return workList;
    }

    public ArrayList<Work> findByIdUser(int idUser) {
        ArrayList<Work> workArrayList = new ArrayList<>();
        for (Work works : workList) {
            if (works.getIdUser() == idUser) {
                workArrayList.add(works);
            }
        }
        return workArrayList;
    }

    public boolean createTask(Work work, String username) {
        for (Work works : workList)
            if (works.equals(work)) {
                return false;
            }
        work.setIdUser(UserServiceImpl.getInstance().findByUsername(username));
        int id = workList.size();
        work.setId(id);
        workList.add(work);
        return true;
    }

    public void viewAllTask() {
        System.out.println(workList);
    }

    public void deleteTask(String username) {
        for (Work work : workList) {
            if (work.getIdUser() == UserServiceImpl.getInstance().findByUsername(username)) {
                workList.remove(work);
            }
        }
    }

    public Work findByTitleTask(String titleTask, int i) {
        for (Work work : workList) {
            if (work.getTitleTask().equals(titleTask)) {
                if (i==1) {
                    System.out.println(work);
                }
                return work;
            }
        }
        return null;
    }

    public void editTask(Work work, String titleTask, String username,int i) {
        int index;
        index = workList.indexOf(findByTitleTask(titleTask, i));
        work.setIdUser(UserServiceImpl.getInstance().findByUsername(username));
        workList.set(index, work);
        System.out.println(workList);
    }
}

