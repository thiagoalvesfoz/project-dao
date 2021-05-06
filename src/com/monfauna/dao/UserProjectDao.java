package com.monfauna.dao;

import com.monfauna.model.Project;
import com.monfauna.model.User;
import com.monfauna.model.UserProject;

import java.util.List;

public interface UserProjectDao {
    UserProject save(UserProject userProject);
    UserProject update(UserProject userProject);
    void deleteById(Integer id);
    User getOwner(Integer projectId);
    List<User> getCollaborator(Integer projectId);
    List<Project> findAllProjectByUser(Integer userId);
}
