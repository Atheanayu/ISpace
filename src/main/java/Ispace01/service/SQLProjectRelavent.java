package Ispace01.service;

import Ispace01.pojo.Project;
import org.springframework.stereotype.Service;

@Service
public interface SQLProjectRelavent {
    public Project addProject(Project project);
    public Project searchProjectID(Long id);
    public Project searchPorjectName(String name);
    public int deleteProject(Long id);
    public Project modifyProject(Project project);
}
