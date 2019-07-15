package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.service.IUserAdminService;
import com.mall.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zzy on 2019/7/14.
 */
@Controller
@RequestMapping("/useradmin")
public class UserAdminController {

    @Reference
    private IUserAdminService userAdminService;

    @RequestMapping("showAllUser")
    public ModelAndView getAllUsers(@RequestParam("pagenum") int pagenum, @RequestParam(value = "pagesize", defaultValue = "16") int pagesize){

        ModelAndView modelAndView = new ModelAndView();


        modelAndView.addObject("data", userAdminService.getAllUsersForPages(pagesize, pagenum));

        modelAndView.setViewName("usermanganer");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("updataUserWhitetime")
    public R updataUserWhiteTime(@RequestParam("userid") int userid, @RequestParam("time") String time){

        String t = time.replace("T", " ");


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date storetime = null;
        try {
            storetime = format.parse(t);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int i = userAdminService.updateUserDisableTime(userid, storetime.getTime());

        return R.ok().put("data", i);
    }


}
