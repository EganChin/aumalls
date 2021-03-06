package com.mall.consumer.controller;

import com.google.gson.Gson;
import com.mall.common.domain.User;
import com.mall.common.form.user.LoginForm;
import com.mall.common.service.UserService;
import com.mall.common.utils.R;
import com.mall.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Egan
 * @date 2019/7/10 10:44
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public R login(@RequestBody LoginForm form){
        ValidatorUtils.validate(form);
        return R.ok().put("vo", userService.UserLogin(form));
    }



    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginbypro")
    public String loginbypro(){
        return "userLogin/findaccount";
    }

//    @RequestMapping("/home/index")
//    public String loginCheck(HttpServletRequest request, HttpServletResponse response){
//
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("utf-8");
//
//        String loginName = request.getParameter("user_name");
//        String loginPassword = request.getParameter("user_password");
//        User user = userService.findUserByName(loginName);
//
//        if (user == null){
//            System.out.println("登陆失败,用户名不存在");
//            request.setAttribute("error",1);
//            return "userLogin/userlogin";
//        } else if (!user.getUserPass().equals(loginPassword)) {
//            System.out.println("登陆失败,密码错误");
//            request.setAttribute("error",0);
//            return "userLogin/userlogin";
//        } else {
//            request.getSession().setAttribute("user", user);
//            System.out.println("登陆成功");
//            return "home/index";
//        }
//    }

    @RequestMapping("/userinfo")
    public String userinfo(){
        return "userinfo";
    }



    @RequestMapping(value = "/signout")
    public String signOut(HttpServletResponse response, HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }

    @RequestMapping("findUserByName")
    public void findUserByName(HttpServletResponse response, HttpServletRequest request){
        User user = userService.findUserByName(request.getParameter("userName"));
        try {
            if(user!=null){
                response.getWriter().print(1);
            }
            else{
                response.getWriter().print(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("modifyUserinfo")
    public void modifyUserinfo(HttpServletResponse response, HttpServletRequest request){
        String jsonData = request.getParameter("jsonData");
        System.out.println(jsonData);
        Gson gson = new Gson();
        Map<String,String> map = gson.fromJson(jsonData,Map.class);
        User user = (User)request.getSession().getAttribute("user");



        user.setUserId(Integer.parseInt(map.get("userId")));
        user.setUserName(map.get("userName"));
        user.setUserPhone(map.get("userPhone"));
        user.setUserAddress(map.get("userAddress"));
        request.getSession().setAttribute("user", user);
        int flag = userService.modifyUserinfo(user);
        try {
            response.getWriter().print(flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("modifyUserPass")
    public void modifyUserPass(HttpServletResponse response, HttpServletRequest request){
        String jsonData = request.getParameter("jsonData");
        Gson gson = new Gson();
        Map<String,String> map = gson.fromJson(jsonData,Map.class);
        User user = (User)request.getSession().getAttribute("user");

        user.setUserPass(map.get("userPass"));
        request.getSession().setAttribute("user", user);
        userService.modifyUserPass(user);
        try {
            response.getWriter().print("修改失败");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("deleteUserinfo")
    public void deleteUserinfo(HttpServletResponse response, HttpServletRequest request){

        userService.deleteUserinfo(Integer.parseInt(request.getParameter("userId")));


    }

    @RequestMapping("findUserByUserId")
    public List<User> findUserByUserId(HttpServletRequest request, HttpServletResponse response){
        return userService.findUserByUserId(Integer.parseInt(request.getParameter("userId")));
    }

    @RequestMapping("selectAll")
    public List<User> getUserList(HttpServletRequest request, HttpServletResponse response){
        return userService.selectAll();
    }
}
