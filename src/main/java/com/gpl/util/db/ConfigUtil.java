package com.gpl.util.db;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gpl.common.Constant;
/**
 * Created by gpl on 2016/7/14.
 */
public class ConfigUtil {
    private static ConfigUtil confUtil = null;
    private Encrypt encrypt = new Encrypt();

    private ConfigUtil(){}

    public synchronized static ConfigUtil getInstance(){
        if(confUtil == null){
            confUtil = new ConfigUtil();
        }
        return confUtil;
    }

    private Map<String,Map<String,String>> parseXml(String[] confKeys) throws Exception{
        Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();

        SAXReader reader = new SAXReader();
        Document document = null;

        try{
            document = reader.read(new File(Constant.confxml));
            Element root = document.getRootElement();

            for(String confKey:confKeys){
                Element curRootElement = root.element(confKey);
                Map<String,String> curMap = new HashMap<String,String>();
                List<Element> childElements = curRootElement.elements();
                for(Element childElement:childElements){
                    curMap.put(childElement.getName(),childElement.getText());
                }
                map.put(confKey,curMap);
            }
        }catch(Exception ex){
            throw ex;
        }

        return map;
    }

    private Map<String,String> parseXMLSpecific(String confKey) throws Exception{
        String[] confKeys = new String[]{
                confKey
        };
        return parseXml(confKeys).get(confKey);
    }

    private ArrayList<String> parseByLine(String filename) throws Exception {
        ArrayList<String> regexs =  new ArrayList<String>();
        FileReader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader(filename);
            br = new BufferedReader(reader);
            String str = null;
            while ((str = br.readLine()) != null) {
                regexs.add(str.replaceAll("[\r\n]", ""));
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                throw e;
            }
        }
        return regexs;
    }

    //得到pg的配置信息
    public Map<String,String> getPostgresqlConf() throws Exception{
        return parseXMLSpecific("postgresql");
    }

//    //得到pg的配置信息  加密
//    public Map<String,String> getPostgresqlConf() throws Exception{
//        Map<String,String> map = parseXMLSpecific("postgresql");
//        map.put("username",encrypt.decrypt(map.get("username")));
//        map.put("password",encrypt.decrypt(map.get("password")));
//        map.put("database",encrypt.decrypt(map.get("database")));
//        return map;
//    }
}
