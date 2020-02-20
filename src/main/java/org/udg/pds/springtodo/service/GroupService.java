package org.udg.pds.springtodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.udg.pds.springtodo.controller.exceptions.ServiceException;
import org.udg.pds.springtodo.entity.Group;
import org.udg.pds.springtodo.entity.IdObject;
import org.udg.pds.springtodo.repository.GroupRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public GroupRepository crud() { return groupRepository; }

    public IdObject addGroup(String nom, String descripcio){
        try{
            Group group = new Group (nom, descripcio);

            groupRepository.save(group);

            return new IdObject(group.getId());
        }
        catch (Exception ex){
            throw new ServiceException(ex.getMessage());
        }
    }
}
