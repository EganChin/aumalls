package com.mall.common.utils;

import com.mall.common.SpringfoxJsonToGsonSeializer;
import com.mall.common.enumeration.EnumTypeAdapter;
import com.mall.enumeration.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import springfox.documentation.spring.web.json.Json;

/**
 * @author LiangYongjie
 * @date 2019-01-05
 */
public class GsonUtils {

    private GsonUtils(){}

    public static Gson get() {
        return GsonHolder.INSTANCE;
    }

    private static class GsonHolder {
        private static final Gson INSTANCE =
            new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(EnumApplyStatus.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumApplyType.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumBill.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumInviteCodeStatus.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumInviteCodeType.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumPhoneCodeType.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumRole.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumTaskStatus.class, new EnumTypeAdapter())
                .registerTypeAdapter(EnumUser.class, new EnumTypeAdapter())
                .registerTypeAdapter(Json.class, new SpringfoxJsonToGsonSeializer())
                .create();
    }
}
