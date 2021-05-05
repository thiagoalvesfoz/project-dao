package com.monfauna.dao.impl;

import com.monfauna.dao.ProjectDao;
import com.monfauna.model.Project;

import java.sql.Connection;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    private final Connection conn;

    public ProjectDaoImpl(Connection conn ) {
        this.conn = conn;
    }


    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public List<Project> findAll() {



        return null;
    }

    @Override
    public Project findById(Integer id) {
        return null;
    }

    @Override
    public Project update(Project project) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
