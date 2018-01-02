import com.zhaozhiguang.component.weixin.config.WxProperties;
import com.zhaozhiguang.component.weixin.facade.WeiXinManager;
import org.junit.Test;

public class WxManagerTest {

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

}
