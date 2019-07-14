package com.mall.chat.utils;

import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author Egan
 * @date 2019/7/14 11:43
 **/
public class SecurityUtils {


    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get();
    }


}
