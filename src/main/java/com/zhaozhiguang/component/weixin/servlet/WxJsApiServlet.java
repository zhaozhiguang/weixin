package com.zhaozhiguang.component.weixin.servlet;

import com.alibaba.fastjson.JSON;
import com.zhaozhiguang.component.weixin.facade.WeiXinManager;
import com.zhaozhiguang.component.weixin.pojo.res.JsSignResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 微信js接口验证
 */
public class WxJsApiServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(WxJsApiServlet.class);

    private WeiXinManager manager = new WeiXinManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        JsSignResult result = manager.getJsApiSignResult(url);
        String s = JSON.toJSONString(result);
        PrintWriter writer = resp.getWriter();
        writer.print(s);
        writer.flush();
        writer.close();
    }
}
