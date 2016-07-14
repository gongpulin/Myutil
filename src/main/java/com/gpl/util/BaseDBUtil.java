package com.gpl.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by gpl on 2016/7/14.
 */
public abstract class BaseDBUtil {
    public abstract Connection getConnection();
    public void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    public void closeStatement(Statement stmt){
        if (stmt != null){
            try {
                stmt.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public List<Map<String,Object>> querywithParameter(String sqlFormat,Object[] columns){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlFormat);
            for(int i=0;i<columns.length;i++){
                stmt.setObject(i+1,columns[i]);
            }
            rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while(rs.next()){
                Map<String,Object> curMap = new HashMap<String,Object>();
                for(int i=1;i<=columnCount;i++){
                    curMap.put(md.getColumnName(i),rs.getObject(i));
                }
                result.add(curMap);
            }

        } catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            closeStatement(stmt);
            closeConnection(conn);
        }
        return result;
    }

    public List<Map<String,Object>> query(String sql){
        return querywithParameter(sql,new Object[]{});
    }

    public boolean executeWithParamter(String sqlFormat,Object[] columns){
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean tag = false;
        try {
            conn =getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sqlFormat);
            for(int i=0;i<columns.length;i++){
                stmt.setObject(i+1,columns[i]);
            }
            stmt.execute();
            conn.commit();
            conn.setAutoCommit(true);
            tag = true;
        } catch(Exception ex){
            try {
                conn.rollback();
            } catch (SQLException e){
                e.printStackTrace();
            }
            ex.printStackTrace();
        }finally{
            closeStatement(stmt);
            closeConnection(conn);
        }
        return tag;
    }

    public boolean execute(String sql){
        return executeWithParamter(sql,new Object[]{});
    }

    public boolean executeSqls(String[] sqls){
        boolean executeRtn = false;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            for(int i=0;i<sqls.length;i++){
                stmt.addBatch(sqls[i]);
            }
            stmt.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            executeRtn = true;
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            closeStatement(stmt);
            closeConnection(conn);
        }
        return executeRtn;
    }

    public Map<String,String> queryColumnByTb(String schema,String tbname,boolean withId){
        String sql = "select column_name,data_type from information_schema.columns where table_name=? and table_schema=?";
        Map<String,String> map = new HashMap<String,String>();

        try{
            List<Map<String,Object>> list = querywithParameter(sql,new Object[]{tbname,schema});
            for(int i=0;i<list.size();i++){
                if(!withId && String.valueOf(list.get(i).get("column_name")).equals("id")){
                    continue;
                }

                map.put(String.valueOf(list.get(i).get("column_name")),
                        String.valueOf(list.get(i).get("data_type")));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return map;
    }

}
