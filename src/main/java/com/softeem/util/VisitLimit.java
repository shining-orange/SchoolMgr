package com.softeem.util;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-13 09:11
 **/

@WebFilter({"/pages/admin/*","/pages/stu/*"})
public class VisitLimit implements Filter {


    public void init(FilterConfig filterConfig){
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进行过滤");
        //设置白名单
        String[] urls={"/pages/admin/log.jsp","/pages/admin/reg.jsp","/log","/reg","/showCode","/adminLog","/adminReg"};
        //获取请求的地址名称
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        String path = req.getServletPath();
        System.out.println(path);
        boolean visit=false;
        for (String url : urls) {
            if (path.equals(url)){
                visit=true;
                break;
            }
        }
        if (visit){
            //设置白名单
//            doFilter(servletRequest,servletResponse,filterChain);//放行不能放在循环中 放行时重新发送请求重新循环
              filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            //请求被拦截
            System.out.println("请求被拦截");
            //拦截时判断是否登录
            Object data = req.getSession().getAttribute("logData");
            if (data!=null){
                //已登录
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                //未登录
//                req.getRequestDispatcher("/pages/admin/log.jsp").forward(servletRequest,servletResponse);
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().print("<script>alert('请登录后操作');location.href='/pages/admin/log.jsp'</script>");
            }
        }
        //登录成功后，放行（获取登录成功后的session中的数据）
    }

    public void destroy(){
        System.out.println("销毁");
    }
}