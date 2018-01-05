import com.alibaba.fastjson.JSON;
import com.zhaozhiguang.component.weixin.config.WxProperties;
import com.zhaozhiguang.component.weixin.facade.WeiXinManager;
import com.zhaozhiguang.component.weixin.pojo.Constant;
import com.zhaozhiguang.component.weixin.pojo.MediaType;
import com.zhaozhiguang.component.weixin.pojo.req.customer.CustomerSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.req.media.MediaPermNewsReq;
import com.zhaozhiguang.component.weixin.pojo.req.menu.MenuSetReq;
import com.zhaozhiguang.component.weixin.pojo.req.qrcode.QrCodeMsg;
import com.zhaozhiguang.component.weixin.pojo.req.template.TemplateSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.res.media.PermMediaNewsRes;
import com.zhaozhiguang.component.weixin.pojo.res.media.TempMediaSetRes;
import com.zhaozhiguang.component.weixin.pojo.res.menu.MenuQueryRes;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
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
        menu.addButton(new MenuSetReq.Button("菜单哈哈哈").addChildButton(new MenuSetReq.Button("点击进入").
                setType(MenuSetReq.BUTTONTYPE.VIEW).setUrl("http://www.baidu.com")));
        menu.addButton(new MenuSetReq.Button("友军").addChildButton(new MenuSetReq.Button("第一").setType(MenuSetReq.BUTTONTYPE.VIEW).setUrl("http://www.taobao.com"))
                .addChildButton(new MenuSetReq.Button("第二").setType(MenuSetReq.BUTTONTYPE.VIEW).setUrl("http://www.sina.com")));
        System.err.println(JSON.toJSONString(menu));
        manager.menuSet(menu);
    }

    @Test
    public void json4Test(){
        MenuQueryRes menuQueryRes = manager.menuQuery();
        System.err.println(JSON.toJSONString(menuQueryRes));
    }

    @Test
    public void json5Test(){
        File file = new File("D:\\1.jpg");
        String s = manager.mediaImgUrl(file);
        System.err.println(s);
    }

    @Test
    public void json6Test(){
        File file = new File("D:\\1.jpg");
        TempMediaSetRes tempMediaSetRes = manager.mediaTempSet(MediaType.IMAGE, file);
        System.err.println(JSON.toJSONString(tempMediaSetRes));
    }

    @Test
    public void json7Test(){
        File file = new File("D:\\1.jpg");
        TempMediaSetRes tempMediaSetRes = manager.mediaPermSet(MediaType.IMAGE, file);
        System.err.println(JSON.toJSONString(tempMediaSetRes));
        //mhjQ3V6dxXWxx-iwB5rsxhPiuoH6_rbO3bJkDnB-Jvw
    }

    @Test
    public void json8Test(){
        /*MediaPermNewsReq news = new MediaPermNewsReq();
        news.addArticle(new MediaPermNewsReq.Article("标题","mhjQ3V6dxXWxx-iwB5rsxhPiuoH6_rbO3bJkDnB-Jvw"
                ,"作者","摘要",1,"这是具体的内容啊啊啊啊啊啊啊啊啊","原文地址"));
        TempMediaSetRes tempMediaSetRes = manager.mediaPermNewsSet(news);
        System.err.println(JSON.toJSONString(tempMediaSetRes));*/
        MediaPermNewsReq news = new MediaPermNewsReq();
        news.addArticle(new MediaPermNewsReq.Article("标题",null
                ,"作者","摘要",1,"这是具体的内容啊啊啊啊啊啊啊啊啊","原文地址"));
        File file = new File("D:\\1.jpg");
        TempMediaSetRes tempMediaSetRes = manager.mediaPermNewsSet(MediaType.IMAGE, file, news);
        System.err.println(JSON.toJSONString(tempMediaSetRes));
    }

    @Test
    public void json9Test(){
        PermMediaNewsRes permMediaNewsRes = manager.mediaPermNewsQuery("mhjQ3V6dxXWxx-iwB5rsxvV44QjnPXZlI_auGcDs_bU");
        System.err.println(JSON.toJSONString(permMediaNewsRes));
    }

    @Test
    public void json10Test(){
        boolean b = manager.mediaPermDelete("mhjQ3V6dxXWxx-iwB5rsxvV44QjnPXZlI_auGcDs_bU");
        System.err.println(b);
    }

}
