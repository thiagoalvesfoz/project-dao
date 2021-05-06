package com.monfauna;

import com.monfauna.dao.ProjectDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.Project;
import com.monfauna.model.User;

import java.util.List;

public class ProjectTest {
    public static void main(String[] args) {

        ProjectDao projectDao = DaoFactory.getProjectDao();


        // find all projects
        List<Project> projectList = projectDao.findAll();
        for (Project project : projectList) {
            System.out.println(project);
        }
    }
}
