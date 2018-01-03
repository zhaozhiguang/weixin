package com.zhaozhiguang.component.weixin.pojo.req.qrcode;


/**
 * 微信二维码
 * 临时二维码需要设置expire_seconds
 * 之后调用addScene
 * 根据传入的对象 自动设置 临时\永久 类型
 * @author zhiguang
 */
public class QrCodeMsg {

    /**
     * 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，
     * QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    private String action_name;

    /**
     * 临时才需要设置 过期时间
     */
    private Integer expire_seconds;

    private Info action_info = new Info();

    public void addScene(QrSecneId qrSecneId){
        this.action_name = qrSecneId.type;
        this.action_info.getScene().setSceneId(qrSecneId.sceneId);
    }

    public void addScene(QrSecneStr qrSecneStr){
        this.action_name = qrSecneStr.type;
        this.action_info.getScene().setSceneStr(qrSecneStr.sceneStr);
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public Integer getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(Integer expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public Info getAction_info() {
        return action_info;
    }

    public void setAction_info(Info action_info) {
        this.action_info = action_info;
    }

    public static class Info {

        public Scene scene = new Scene();

        public Scene getScene() {
            return scene;
        }

        public void setScene(Scene scene) {
            this.scene = scene;
        }

    }

    public static class Scene {

        private Integer sceneId;

        private String sceneStr;

        public Integer getSceneId() {
            return sceneId;
        }

        public void setSceneId(Integer sceneId) {
            this.sceneId = sceneId;
        }

        public String getSceneStr() {
            return sceneStr;
        }

        public void setSceneStr(String sceneStr) {
            this.sceneStr = sceneStr;
        }
    }


    public enum QR_SCENE_TYPE_Integer {
        QR_SCENE("QR_SCENE"),QR_LIMIT_SCENE("QR_LIMIT_SCENE");
        private String type;
        QR_SCENE_TYPE_Integer(String type){
            this.type = type;
        }
    }

    public enum QR_SCENE_TYPE_String {
        QR_STR_SCENE("QR_STR_SCENE"),QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE");
        private String type;
        QR_SCENE_TYPE_String(String type){
            this.type = type;
        }
    }

    public static class QrSecneId {
        private String type;
        private Integer sceneId;
        public QrSecneId(QR_SCENE_TYPE_Integer type, Integer sceneId){
            this.type = type.type;
            this.sceneId = sceneId;
        }
    }

    public static class QrSecneStr {
        private String type;
        private String sceneStr;
        public QrSecneStr(QR_SCENE_TYPE_String type, String sceneStr){
            this.type = type.type;
            this.sceneStr = sceneStr;
        }
    }

}
