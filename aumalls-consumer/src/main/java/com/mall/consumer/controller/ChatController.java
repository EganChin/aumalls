package com.mall.consumer.controller;

import com.mall.common.service.ChatLogService;
import com.mall.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Egan
 * @date 2019/7/16 1:07
 **/
@RestController
@RequestMapping("chat")
public class ChatController {


//    @Reference
    private ChatLogService chatLogService;

    @RequestMapping("overview")
    public R getOverview(){
        return R.ok().put("list", chatLogService.getOverviews());
    }

    @RequestMapping("detail")
    public R getDetail(){
        return R.ok().put("vo", chatLogService.getDetails());
    }

}
