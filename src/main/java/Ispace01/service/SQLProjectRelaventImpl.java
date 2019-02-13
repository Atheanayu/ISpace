package Ispace01.service;

import Ispace01.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SQLProjectRelaventImpl implements SQLProjectRelavent{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Project addProject(Project project) {// 后期可添加线程锁
        String sql = "insert into Projects (name, classification, description, contact, state, need) value " +
                "(?, ?, ?, ?, ?, ?)";
        int temp =  jdbcTemplate.update(sql,new Object[]{project.getName(), project.getClassification(),
        project.getDescription(), project.getContact(), project.getState(), project.getNeed()});
        if(temp >=0)
            return searchProjectID(jdbcTemplate.query("select max(id) from Projects",new Object[]{},(rs,index)->{
                Long rid = new Long(rs.getLong("max(id)"));
                return rid;
            }).get(0));
        else
            return null;
    }

    @Override
    public Project searchProjectID(Long id) {
        String sql = "select * from Projects where id = ?";
        List<Project> temp = jdbcTemplate.query(sql, new Object[]{id}, (rs, index)->{
            Project project = new Project();
            project.setId(rs.getLong("id"));
            project.setName(rs.getString("name"));
            project.setClassification(rs.getString("classification"));
            project.setDescription(rs.getString("description"));
            project.setContact(rs.getString("contact"));
            project.setState(rs.getString("state"));
            project.setNeed(rs.getString("need"));
            return project;
        });
        if(temp.isEmpty())
            return null;
        else
            return temp.get(0);
    }

    @Override
    public Project searchPorjectName(String name) {
        String sql = "select * from Projects where name = ?";
        List<Project> temp = jdbcTemplate.query(sql, new Object[]{name}, (rs, index)->{
            Project project = new Project();
            project.setId(rs.getLong("id"));
            project.setName(rs.getString("name"));
            project.setClassification(rs.getString("classification"));
            project.setDescription(rs.getString("description"));
            project.setContact(rs.getString("contact"));
            project.setState(rs.getString("state"));
            project.setNeed(rs.getString("need"));
            return project;
        });
        if(temp.isEmpty())
            return null;
        else
            return temp.get(0);
    }

    @Override
    public int deleteProject(Long id) {
        String sql = "delete from Projects where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Project modifyProject(Project project) {
        String sql = "update Projects set name = ?, classification = ?, description = ?, contact = ?, state = ?, need = ?" +
                " where id = ?";
        int temp = jdbcTemplate.update(sql, new Object[]{project.getName(), project.getClassification(),
        project.getDescription(), project.getContact(), project.getState(), project.getNeed(), project.getId()});
        if(temp >= 0)
            return searchProjectID(project.getId());
        else
            return null;
    }
}
