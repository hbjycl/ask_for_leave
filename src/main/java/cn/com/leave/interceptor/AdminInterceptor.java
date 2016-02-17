package cn.com.leave.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.leave.entity.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
//		Customer loginCustomer = (Customer) session.getAttribute(AppConst.LOGINCUSTOMER);
        User loginAdmin = (User) session.getAttribute("loginUser");

        String url = request.getRequestURI();
        if (loginAdmin == null && loginAdmin == null) {
            response.sendRedirect("login.jsp");
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            HttpSession session = request.getSession();
        }
        super.postHandle(request, response, handler, modelAndView);
    }
}