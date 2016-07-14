package com.gpl.util;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by gpl on 2016/7/14.
 */
public class DBPool {
    private DruidDataSource dataSource = null;
    private static DBPool dbpool = null;
    private String url = "jdbc:postgresql://%s:%s/%s";
    private String classname = "org.postgresql.Driver";

    private DBPool(String ip,int port,String database,String username,String password){
        try{
            dataSource = new DruidDataSource();
            dataSource.setDriverClassName(classname);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setUrl(String.format(url, ip, port, database));
            //保留1个活跃连接足矣，主要是复用它
            dataSource.setMinIdle(1);
            dataSource.setMinIdle(5);
            dataSource.setMaxActive(5);
            //idle time设置为10分钟
            dataSource.setMaxWait(600000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static DBPool getInstance(){
        if(dbpool == null){
            Map<String,String> dbMap = null;
            try {
                dbMap = ConfigUtil.getInstance().getPostgresqlConf();
                dbpool = new DBPool(dbMap.get("ip"),Integer.valueOf(dbMap.get("port")),dbMap.get("databsae"),dbMap.get("username"),dbMap.get("password"));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return dbpool;
    }

    public static DBPool getInstance(String ip,int port,String database,String username,String password){
        if(dbpool == null){
            try {
                dbpool = new DBPool(ip,port,database,username,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dbpool;
    }

    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
