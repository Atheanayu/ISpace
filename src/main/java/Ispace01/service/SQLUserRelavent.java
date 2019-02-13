package Ispace01.service;

import Ispace01.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface SQLUserRelavent {
    public User addUser(User user);
    public User searchUserID(Long id);
    public User searchUserName(String username);
    public int deleteUser(Long id);
    public User modifyUser(User user);
}
