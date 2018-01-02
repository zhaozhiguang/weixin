package com.zhaozhiguang.component.weixin.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import java.io.Writer;

/**
 * xml解析工具类
 * @author zhiguang
 */
public class XmlParseUtils {

    private static XStream xstream = new XStream(new XppDriver(){
        @Override
        public HierarchicalStreamWriter createWriter(Writer out){
            return new PrettyPrintWriter(out){
                boolean cdata = true;
                public void startNode(String name,Class clazz){
                    super.startNode(name,clazz);
                }
                protected void writeText(QuickWriter writer, String text){
                    if(cdata){
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }else{
                        writer.write(text);
                    }
                }
            };
        }
    });





}
