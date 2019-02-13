package Ispace01.controller;

import Ispace01.pojo.Project;
import Ispace01.pojo.Relation;
import Ispace01.service.SQLProjectRelaventImpl;
import Ispace01.service.SQLRelationRelaventImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AppProjectController {//未完成，即将加入relation相关
    @Autowired
    SQLProjectRelaventImpl sqlProjectRelavent;
    @Autowired
    SQLRelationRelaventImpl sqlRelationRelavent;

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public Project projectRegistController(@RequestBody Project project, Long id){
        Project newProject = sqlProjectRelavent.addProject(project);
        if(newProject==null)
            return null;
        Relation relation = new Relation();
        relation.setUserId(id);
        relation.setProjectId(newProject.getId());
        relation.setUserJob("team leader");
        sqlRelationRelavent.addRelation(relation);
        return newProject;
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
    public Project projectSearchController(@PathVariable Long id){
        return sqlProjectRelavent.searchProjectID(id);
    }


    @RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
    public String projectDeleteController(@PathVariable Long id){
        //删除项目之前先删除相关relation
        List<Relation> temp = sqlRelationRelavent.searchRelationProjectID(id);
        if(!temp.isEmpty()) {
            for (Relation relation : temp) {
                if (sqlRelationRelavent.deleteRelation(relation.getId()) <= 0)
                    return "{error : something wrong with delete relation}";
            }
        }
        if(sqlProjectRelavent.deleteProject(id)>=0)
            return "{}";
        else
            return "{error: something wrong with delete project}";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.PUT)
    public Project projectModifyController(@RequestBody Project project){
        return sqlProjectRelavent.modifyProject(project);
    }

}
