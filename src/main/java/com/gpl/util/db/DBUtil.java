package com.gpl.util.db;

import java.util.List;
import java.util.Map;
import java.sql.*;
/**
 * Created by gpl on 2016/7/14.
 */
public class DBUtil extends BaseDBUtil {
//    private static DBUtil dbutil = null;
    private volatile static DBUtil dbutil = null;
    private DBUtil(){}

//    private static class SingletonHolder{
//        private static final DBUtil INSTANCE = new DBUtil();
//    }
//    public static final DBUtil getInstance(){
//        return SingletonHolder.INSTANCE;
//    }

    public static DBUtil getInstance(){
        if (dbutil == null){
            synchronized(DBUtil.class){
                if (dbutil == null){
                    dbutil = new DBUtil();
                }
            }
        }
        return dbutil;
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DBPool.getInstance().getConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args){
        List<Map<String,Object>> rs1 = null;

        try{
            rs1 = DBUtil.getInstance().query("select count(*) as num from tb_user");
            for(int i=0;i<rs1.size();i++){
                System.out.println(rs1.get(i).get("num"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
