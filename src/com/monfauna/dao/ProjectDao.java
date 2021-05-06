package com.monfauna.dao;

import com.monfauna.model.Project;
import com.monfauna.model.User;

import java.util.List;

public interface ProjectDao extends Crud<Project> {
    List<User> findAllCollaboratorByProject(Integer idProject);
}
