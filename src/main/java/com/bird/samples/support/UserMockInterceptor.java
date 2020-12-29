package com.bird.samples.support;

import com.bird.core.session.BirdSession;
import com.bird.core.session.SessionContext;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuxx
 * @since 2020/12/28
 */
@Component
public class UserMockInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 根据请求获取session信息并存入ThreadLocal
        BirdSession session = new BirdSession();
        session.setUserId("123456");
        session.setUserName("liuxx");
        SessionContext.setSession(session);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //移除线程中session信息，防止数据返回后线程未清掉session信息，线程复用时拿到无效的session信息
        SessionContext.removeSession();
    }
}
