package Ispace01.service.upperService;

import Ispace01.pojo.Project;

import java.util.List;

public interface Mine {
    List<Project> projectsIStart(Long usrId);
    List<Project> projectsIAttend(Long userId);
    //个人资料已经在SQLUserRelaventImpl 中实现完毕了
}
