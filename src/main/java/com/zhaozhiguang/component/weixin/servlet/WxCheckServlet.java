package com.zhaozhiguang.component.weixin.servlet;

import com.zhaozhiguang.component.weixin.facade.WeiXinManager;
import com.zhaozhiguang.component.weixin.sign.WxSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * 微信接口验证请求
 * @author zhiguang
 */
public class WxCheckServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(WxCheckServlet.class);

    /**
     * 微信验证的token,需要与微信端那边的设置一致
     */
    private String token = "token";

    private WeiXinManager manager = new WeiXinManager();

    /**
     * 可以在web.xml配置该token
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        String token = config.getInitParameter("token");
        if(token!=null) this.token = token;
    }


    /**
     * get请求是微信验证的请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 微信加密签名
        String signature = req.getParameter("signature");
        // 时间戮
        String timestamp = req.getParameter("timestamp");
        // 随机数
        String nonce = req.getParameter("nonce");
        // 随机字符串
        String echostr = req.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 通过检验 signature 对请求进行校验，若校验成功则原样返回 echostr，表示接入成功，否则接入失败
        if(WeiXinManager.checkSignature(token, signature, timestamp, nonce)){
            out.print(echostr);
        }
        out.flush();
        out.close();
    }

    /**
     * post请求时微信处理信息的请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //Map<String, String> requestMap = ParseUtils.parseXml(req);
        //Object respMessage = processRequest(req,resp,requestMap);
        //out.print(respMessage);
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
