package Ispace01.controller;

import Ispace01.pojo.User;
import Ispace01.service.SQLUserRelaventImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class AppUserController {
    @Autowired
    SQLUserRelaventImpl sqlUserRelaventImpl;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public User userRegistController(@RequestBody User user){
        return sqlUserRelaventImpl.addUser(user);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User userSearchController(@PathVariable Long id){
        return sqlUserRelaventImpl.searchUserID(id);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public String userDeleteController(@PathVariable Long id){
        if(sqlUserRelaventImpl.deleteUser(id)>=0)
            return "{}";
        else
            return "{error: something wrong with delete user}";
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public User userModifyController(@RequestBody User user){
        return sqlUserRelaventImpl.modifyUser(user);
    }

    // 现在假设所有的用户有所有的权限，暂时不对登陆做处理
    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public User userLoginController(HttpSession httpSession){
        return null;
    }
}
