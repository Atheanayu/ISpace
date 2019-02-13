package Ispace01.pojo;

public class Relation {
    private Long id;
    private Long userId;
    private Long projectId;
    private String userJob;//组长，副组长，组员
    private String userDuty;//前端什么什么，后台什么什么

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public String getUserDuty() {
        return userDuty;
    }

    public void setUserDuty(String userDuty) {
        this.userDuty = userDuty;
    }

    public int getState(){
        if(this.userId == null)
            return 0;//代表这个连接没有人
        else
            return 1;//代表这个位置已经有人了
    }
}
