package com.demo.servletpath.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletRequest1")
public class ServletRequest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ip = request.getRemoteUser();
        String method = request.getMethod();
        String authType = request.getAuthType();
        String contextPath = request.getContextPath();
        String serverName = request.getServerName();
        String servletPath = request.getServletPath();
        String remoteAddr = request.getRemoteAddr();
        String protocol = request.getProtocol();
        String remoteHost = request.getRemoteHost();
        String pathInfo = request.getPathInfo();
        String pathTranslated = request.getPathTranslated();
        String referer = request.getHeader("referer");
        String userAgent = request.getHeader("user-agent");
//        response.getWriter().write("ip=" + ip + "\nmethod=" + method + "\nauthtype=" + authType + "\ncontextpath=" +
//                contextPath + "\nserverName=" + serverName + "\nservletPath=" + servletPath + "\nremoteAddr=" +
//                remoteAddr + "\nprotocol=" + protocol + "\nremoteHost=" + remoteHost + "\npathInfo=" + pathInfo +
//                "\npathTranslated=" + pathTranslated + "\nreferer=" + referer + "\nuserAgent=" + userAgent);

    }
}
