package com.qf.interceptor;

import com.qf.constant.SsmConstant;
import com.qf.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: day06-ssm
 * @BelongsPackage: com.qf.interceptor
 * @Author: WisemanDong
 * @CreateTime: 2019-07-18 20:46
 * @Description: todo
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    //前处理,执行controller方法之前.
    //可以选择对请求进行拦截/放行
    //return false->拦截   return true->放行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //1.获得session.
        HttpSession session = httpServletRequest.getSession();
        //2.通过session获取用户信息.
        User user = (User)session.getAttribute(SsmConstant.USER);
        //3.判断是否为null.
        if(user == null){
            //3.1 为null->用户未登录. ->跳转到登录页面.->return false.
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/user/login-ui");
            return false;
        }else {
            //3.2 不为null->return true.
            return true;
        }
    }

    //执行完controller,返回ModelAndView之后执行.
    //拦截器的post处理中,修改ModelAndView
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //拦截器后处理,响应数据之前.
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
