import com.alibaba.fastjson.JSON;
import com.zhaozhiguang.component.weixin.config.WxProperties;
import com.zhaozhiguang.component.weixin.facade.WeiXinManager;
import com.zhaozhiguang.component.weixin.pojo.Constant;
import com.zhaozhiguang.component.weixin.pojo.req.customer.CustomerSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.req.menu.MenuSetReq;
import com.zhaozhiguang.component.weixin.pojo.req.qrcode.QrCodeMsg;
import com.zhaozhiguang.component.weixin.pojo.req.template.TemplateSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.res.menu.MenuQueryRes;
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
    public void jsonTest(){
        List<CustomerSupportMsg.NewsMsg.Article> articles = new ArrayList<>();
        CustomerSupportMsg.NewsMsg.Article article =
                new CustomerSupportMsg.NewsMsg.Article("标题","描述","https://www.baidu.com/img/bd_logo1.png","http://www.baidu.com");
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
        templateSupportMsg.setTouser("ov-v2wFORZJbSo5Dk5tfhmWj0Lqs")
                .setTemplate_id("yVLG1-OSvHkoGdbGpCmvE3p-lk1V7L5enjeELAgaz98")
                .setUrl("http://www.baidu.com")
                .addData("first","欢迎你的光临")
                .addData("keyword2","你的名字")
                .addData("keyword1","yyyy-MM-dd")
                .addData("remark","再接再厉哦","#9932CC");
        String result = JSON.toJSONString(templateSupportMsg);
        System.err.println(result);
        manager.SendTemplateMsg(templateSupportMsg);
    }

    @Test
    public void json2Test(){
        //临时
        QrCodeMsg qrCodeMsg = new QrCodeMsg();
        qrCodeMsg.setExpire_seconds(1200);
        qrCodeMsg.addScene(new QrCodeMsg.QrSecneStr(QrCodeMsg.QR_SCENE_TYPE_String.QR_STR_SCENE,"123"));
        System.err.println(JSON.toJSONString(qrCodeMsg));

        //永久
        QrCodeMsg qrCodeMsg1 = new QrCodeMsg();
        qrCodeMsg1.addScene(new QrCodeMsg.QrSecneId(QrCodeMsg.QR_SCENE_TYPE_Integer.QR_LIMIT_SCENE,1));
        System.err.println(JSON.toJSONString(qrCodeMsg1));

        manager.getQrCodeUrl(qrCodeMsg);
    }

    @Test
    public void json3Test(){
        MenuSetReq menu = new MenuSetReq();
        menu.addButton(new MenuSetReq.Button("菜单").addChildButton(new MenuSetReq.Button("点击进入").
                setType(MenuSetReq.BUTTONTYPE.VIEW).setUrl("http://www.baidu.com")));
        System.err.println(JSON.toJSONString(menu));
        manager.menuSet(menu);
    }

    @Test
    public void json4Test(){
        MenuQueryRes menuQueryRes = manager.menuQuery();
        System.err.println(JSON.toJSONString(menuQueryRes));
    }

}
