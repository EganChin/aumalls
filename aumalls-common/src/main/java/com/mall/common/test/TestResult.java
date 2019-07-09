package com.mall.common.test;

import com.mall.common.utils.GsonUtils;
import com.mall.common.utils.R;
import org.junit.Assert;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

/**
 * @author LiangYongjie
 * @date 2019-05-30
 */
public class TestResult {

    private R r;
    private MockHttpServletResponse response;
    private String responseString;

    TestResult(MvcResult result) throws UnsupportedEncodingException {
        response = result.getResponse();
        Assert.assertEquals(200, response.getStatus());
        responseString = response.getContentAsString();
        r = GsonUtils.get().fromJson(responseString, R.class);
    }

    public TestResult assertCode(int expect) {
        Assert.assertEquals(r.getMessage(), expect, r.getCode());
        return this;
    }

    public TestResult assertMsg(String expect) {
        Assert.assertEquals(expect, r.getMessage());
        return this;
    }

    public TestResult printResponse() {
        System.out.println(responseString);
        return this;
    }

    public TestResult isOk() {
        return this.assertCode(200);
    }

    public TestResult isError() {
        return this.assertCode(500);
    }
}
