import com.alibaba.fastjson.JSON;
import com.zhaozhiguang.component.weixin.config.WxProperties;
import com.zhaozhiguang.component.weixin.facade.WeiXinManager;
import com.zhaozhiguang.component.weixin.pojo.Constant;
import com.zhaozhiguang.component.weixin.pojo.req.customer.CustomerSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.req.template.TemplateSupportMsg;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WxManagerTest {

    WeiXinManager manager = null;

    @Before
    public void Before(){
        manager = new WeiXinManager();
        WxProperties properties = new WxProperties();
        properties.setAppId("wx5f86cdc91f66646c");
        properties.setSecret("34ce8a046ed82e36170ad063edc4fdaa");
        properties.setToken("comzzger");
        manager.setProperties(properties);
    }

    @Test
    public void wxmanagerTest(){
        WeiXinManager manager = new WeiXinManager();

        WxProperties properties = new WxProperties();

        manager.setProperties(properties);

        manager.getAuthorizedLoginUrl("http://example.com","state");

        manager.getOpenId("code");

        manager.getUserInfoByOpenId("code");

        manager.getUserInfoByCode("code");



    }

    @Test
    public void jsonTest(){
        List<CustomerSupportMsg.NewsMsg.Article> articles = new ArrayList<>();
        CustomerSupportMsg.NewsMsg.Article article = new CustomerSupportMsg.NewsMsg.Article("标题","描述","https://www.baidu.com/img/bd_logo1.png","http://www.baidu.com");
        articles.add(article);
        CustomerSupportMsg customerSupportMsg = new CustomerSupportMsg();
        customerSupportMsg.setTouser("ov-v2wFORZJbSo5Dk5tfhmWj0Lqs");
        customerSupportMsg.setMsgtype(Constant.MESSAGE_TYPE_NEWS);
        customerSupportMsg.setNews(new CustomerSupportMsg.NewsMsg(articles));
        String result = JSON.toJSONString(customerSupportMsg);
        System.err.println(result);

        manager.SendCustomerMsg(customerSupportMsg);
    }

    @Test
    public void json1Test(){
        TemplateSupportMsg templateSupportMsg = new TemplateSupportMsg();
        templateSupportMsg.setTouser("ov-v2wFORZJbSo5Dk5tfhmWj0Lqs");
        templateSupportMsg.setTemplate_id("yVLG1-OSvHkoGdbGpCmvE3p-lk1V7L5enjeELAgaz98");
        templateSupportMsg.setUrl("http://www.baidu.com");
        templateSupportMsg.addData("first","欢迎你的光临");
        templateSupportMsg.addData("keyword2","你的名字");
        templateSupportMsg.addData("keyword1","yyyy-MM-dd");
        templateSupportMsg.addData("remark","再接再厉哦");
        String result = JSON.toJSONString(templateSupportMsg);
        System.err.println(result);
        manager.SendTemplateMsg(templateSupportMsg);
    }

}
