package Ispace01.service;

import Ispace01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SQLUserRelaventImpl implements SQLUserRelavent {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User addUser(User user){
        String sql = "insert into Users (username, password, profession, " +
                "reg_time, unionid, telephone, email, qq, wechat, organization, major, description," +
                " ability, experience) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int temp =  jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
                user.getProfession(), user.getReg_time(), user.getUnionid(), user.getTelephone(),
                user.getEmail(),user.getQq(),user.getWechat(),user.getOrganization(),
                user.getMajor(), user.getDescription(), user.getAbility(), user.getExperience());
        if(temp >= 0)
            return searchUserID(jdbcTemplate.query("select max(id) from Users",new Object[]{},(rs,index)->{
                Long rid = new Long(rs.getInt("max(id)"));
                return rid;
            }).get(0));
        else
            return null;
    }

    @Override
    public User searchUserID(Long id) {
        String sql =  "select * from Users where id = ?";
        List<User> tempUsers = jdbcTemplate.query(sql, new Object[]{id},(rs, index)->{
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setProfession(rs.getString("profession"));
            user.setReg_time(rs.getDate("reg_time"));
            user.setUnionid(rs.getString("unionid"));
            user.setTelephone(rs.getString("telephone"));
            user.setEmail(rs.getString("email"));
            user.setQq(rs.getString("qq"));
            user.setWechat(rs.getString("wechat"));
            user.setOrganization(rs.getString("organization"));
            user.setMajor(rs.getString("major"));
            user.setDescription(rs.getString("description"));
            user.setAbility(rs.getString("ability"));
            user.setExperience(rs.getString("experience"));
            return user;
        });
        if(tempUsers.isEmpty())
            return null;
        else
            return tempUsers.get(0);
    }

    @Override
    public User searchUserName(String username) {
        String sql =  "select * from Users where username = ?";
        List<User> tempUsers = jdbcTemplate.query(sql, new Object[]{username},(rs, index)->{
            User user = new User();
            user.setUsername(rs.getString("username"));
            return user;
        });
        if(tempUsers.isEmpty())
            return null;
        else
            return tempUsers.get(0);
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from Users where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public User modifyUser(User user) {
        String sql = "update Users set username = ?, password = ?, profession = ?," +
                "telephone = ?, email = ?, qq = ?, wechat = ?,organization = ?, major = ?," +
                " description = ?, ability = ?, experience = ? where id = ?";
        int temp = jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword(),user.getProfession(),
        user.getTelephone(), user.getEmail(), user.getQq(), user.getWechat(), user.getOrganization(),
        user.getMajor(), user.getDescription(), user.getAbility(), user.getExperience(), user.getId()});
        if(temp>=0)
            return searchUserID(user.getId());
        else
            return null;
    }
}
