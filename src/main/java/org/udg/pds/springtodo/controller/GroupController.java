package org.udg.pds.springtodo.controller;


import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.udg.pds.springtodo.entity.IdObject;
import org.udg.pds.springtodo.service.GroupService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@RequestMapping(path="/group")
@RestController
public class GroupController extends BaseController {

    @Autowired
    GroupService groupService;

    @PostMapping(consumes = "application/json")
    public IdObject addGroup(HttpSession session, @Valid @RequestBody R_Group group){

        Long userId = getLoggedUser(session);

        return groupService.addGroup(group.nom, group.descripcio);
    }

    static class R_Group{

        @NotNull
        public String nom;

        public String descripcio;
    }
}
