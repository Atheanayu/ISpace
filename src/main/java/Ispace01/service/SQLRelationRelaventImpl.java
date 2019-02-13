package Ispace01.service;

import Ispace01.pojo.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SQLRelationRelaventImpl implements SQLRelationRelavent{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Relation addRelation(Relation relation) {
        String sql = "insert into Relations (userId, projectId, userJob, userDuty) values (?, ?, ?, ?)";
        int temp = jdbcTemplate.update(sql, new Object[]{relation.getUserId(), relation.getProjectId(),
        relation.getUserJob(), relation.getUserDuty()});
        if(temp > 0)
            return searchRelationUPID(relation.getUserId(),relation.getProjectId());
        else
            return null;
    }

    @Override
    public Relation searchRelationID(Long id) {
        String sql = "select * from Relations where id = ?";
        List<Relation> temp = jdbcTemplate.query(sql, new Object[]{id},(rs,index)->{
            Relation relation = new Relation();
            relation.setId(rs.getLong("id"));
            relation.setUserId(rs.getLong("userId"));
            relation.setProjectId(rs.getLong("projectId"));
            relation.setUserJob(rs.getString("userJob"));
            relation.setUserDuty(rs.getString("userDuty"));
            return relation;
        });
        if(temp.isEmpty())
            return null;
        else
            return temp.get(0);
    }

    @Override
    public Relation searchRelationUPID(Long userID, Long projectID) {
        String sql = "select * from Relations where userId = ? and projectId = ?";
        List<Relation> temp = jdbcTemplate.query(sql, new Object[]{userID, projectID}, (rs,index)->{
            Relation relation = new Relation();
            relation.setId(rs.getLong("id"));
            relation.setUserId(rs.getLong("userId"));
            relation.setProjectId(rs.getLong("projectId"));
            relation.setUserJob(rs.getString("userJob"));
            relation.setUserDuty(rs.getString("userDuty"));
            return relation;
        });
        if(temp.isEmpty())
            return null;
        else
            return temp.get(0);
    }

    @Override
    public List<Relation> searchRelationUserID(Long userID) {
        String sql = "select * from Relations where uerId = ?";
        return jdbcTemplate.query(sql, new Object[]{userID}, (rs,index)->{
            Relation relation = new Relation();
            relation.setId(rs.getLong("ID"));
            relation.setUserId(rs.getLong("userID"));
            relation.setProjectId(rs.getLong("projectID"));
            relation.setUserJob(rs.getString("userJob"));
            relation.setUserDuty(rs.getString("userDuty"));
            return relation;
        });
    }

    @Override
    public List<Relation> searchRelationProjectID(Long projectID) {
        String sql = "select * from Relations where projectId = ?";
        return jdbcTemplate.query(sql, new Object[]{projectID}, (rs,index)->{
            Relation relation = new Relation();
            relation.setId(rs.getLong("ID"));
            relation.setUserId(rs.getLong("userID"));
            relation.setProjectId(rs.getLong("projectID"));
            relation.setUserJob(rs.getString("userJob"));
            relation.setUserDuty(rs.getString("userDuty"));
            return relation;
        });
    }

    @Override
    public int deleteRelation(Long id) {
        String sql = "delete from Relations where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Relation modifyRelation(Relation relation) {
        String sql = "update Relations set userId = ?, projectId = ?," +
                "userJob = ?, userDuty = ? where id = ?";
        int temp = jdbcTemplate.update(sql,relation.getUserId(),relation.getProjectId(),
                relation.getUserJob(), relation.getUserDuty(),relation.getId());
        if(temp > 0)
            return searchRelationID(relation.getId());
        else
            return null;
    }


}
