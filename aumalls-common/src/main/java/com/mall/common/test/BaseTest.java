package com.mall.common.test;

import com.mall.common.utils.GsonUtils;
import com.mall.common.utils.R;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.subject.WebSubject;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiangYongjie
 * @date 2019-05-29
 */
public abstract class BaseTest {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private SecurityManager securityManager;

    protected Subject subject;
    protected MockMvc mvc;
    protected MockHttpServletRequest mockRequest;
    protected MockHttpServletResponse mockResponse;
    protected MockHttpSession mockSession;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();

        mockSession = new MockHttpSession(context.getServletContext());
        mockRequest = new MockHttpServletRequest(context.getServletContext());
        mockRequest.setSession(mockSession);
        mockResponse = new MockHttpServletResponse();

        SecurityUtils.setSecurityManager(securityManager);
        subject = new WebSubject.Builder(mockRequest, mockResponse).buildSubject();
    }

    protected abstract void login();

    protected TestResult request(String uri, HttpMethod method, Map<String, String> map) {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(method, uri);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            request.param(entry.getKey(), entry.getValue());
        }

        try {
            MvcResult result = mvc.perform(request).andReturn();

            return new TestResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected TestResult request(String uri, HttpMethod method, Object... objects) {
        Map<String, String> map = new HashMap<>();
        try {
            for (Object object : objects) {
                Map<String, String> describe = BeanUtils.describe(object);
                for (Map.Entry<String, String> entry : describe.entrySet()) {
                    if (StringUtils.isNotBlank(entry.getValue())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return this.request(uri, method, map);
    }

    protected void requestOK(String uri, HttpMethod method, Map<String, String> map) {
        request(uri, method, map).isOk();
    }

    protected void requestOK(String uri, HttpMethod method, Object... objects) {
        request(uri, method, objects).isOk();
    }

    protected TestResult post(String uri, Map<String, String> map) {
        return request(uri, HttpMethod.POST, map);
    }

    protected TestResult post(String uri, Object... objects) {
        return request(uri, HttpMethod.POST, objects);
    }

    protected TestResult get(String uri, Map<String, String> map) {
        return request(uri, HttpMethod.GET, map);
    }

    protected TestResult get(String uri, Object... objects) {
        return request(uri, HttpMethod.GET, objects);
    }

    private R getR(String response) {
        return GsonUtils.get().fromJson(response, R.class);
    }
}
