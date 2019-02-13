package Ispace01.controller;

import Ispace01.pojo.Relation;
import Ispace01.service.SQLRelationRelaventImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppRelationController {
    @Autowired
    SQLRelationRelaventImpl sqlRelationRelavent;

    @RequestMapping(value = "/projects/{id}/users", method = RequestMethod.GET)
    public List<Relation> usersOfProject(@PathVariable Long id){
        return sqlRelationRelavent.searchRelationProjectID(id);
    }

    @RequestMapping(value = "/projects/users", method = RequestMethod.DELETE)
    public String deleteUserFromProject(@RequestBody Relation relation){
        Relation relationUPID = sqlRelationRelavent.searchRelationUPID(relation.getUserId(),relation.getProjectId());
        relationUPID.setUserId(null);
        if(sqlRelationRelavent.modifyRelation(relationUPID)==null)
            return "{error:something wrong with delete user from project}";
        else
            return "{}";
    }

    @RequestMapping(value = "/projects/users", method = RequestMethod.POST )
    public Relation addNeededUserOfProject(@RequestBody Relation relation){
        return sqlRelationRelavent.modifyRelation(relation);
    }

    @RequestMapping(value = "/projects/users", method = RequestMethod.PUT)
    public Relation modifyRelation(@RequestBody Relation relation){
        return sqlRelationRelavent.modifyRelation(relation);
    }

}
