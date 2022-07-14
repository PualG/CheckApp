package com.signin.dao;

import android.util.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.signin.db.DbConnect;
import com.signin.beans.Record;

public class RecordDAO implements IRecordDAO {
    protected static String TBALE_NAME = "signin_table";
    protected static final String FIELDS_INSERT = "date_time, name, temp,temp1,temp2,temp3,temp4,temp8,temp5, location,temp6,temp9,temp7";
    protected static String INSERT_SQL = "insert into "+ TBALE_NAME + "(" + FIELDS_INSERT + ") values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    protected static String SELECT_SQL="select " + FIELDS_INSERT + " from "+ TBALE_NAME + " where name = ? and date_time = ?";
    protected static String UPDATE_SQL="update "+ TBALE_NAME + " set date_time = ?, name = ?, temp = ?, temp1 = ?, temp2 = ?, temp3 = ?, temp4 = ?,temp8 = ?, temp5 = ?, location = ?, temp6 = ?, temp9 = ?, temp7 = ?";
    protected static String DELETE_SQL ="delete from "+ TBALE_NAME + " where name = ? and date_time = ?";

    //实现向数据库中添加记录的方法
    public int insert(Record record) throws Exception{
        int result = 0;
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs = null;
        try{
            con=DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(INSERT_SQL);
            prepStmt.setString(1, record.getDate_time());
            prepStmt.setString(2, record.getName());
            prepStmt.setString(3, record.getTemp());
            prepStmt.setString(4, record.getTemp1());
            prepStmt.setString(5, record.getTemp2());
            prepStmt.setString(6, record.getTemp3());
            prepStmt.setString(7, record.getTemp4());
            prepStmt.setString(8, record.getTemp8());
            prepStmt.setString(9, record.getTemp5());
            prepStmt.setString(10, record.getLocation());
            prepStmt.setString(11, record.getTemp6());
            prepStmt.setString(12, record.getTemp9());
            prepStmt.setString(13, record.getTemp7());
            result = prepStmt.executeUpdate();
        } catch(Exception e){
        } finally{
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return result;
    }

    //实现查询数据库中对指定的记录是否存在的方法
    public Record select(Record record) throws Exception {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Record record2 = null;
        try {
            con = DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(SELECT_SQL);
            prepStmt.setString(1, record.getName());
            prepStmt.setString(2, record.getDate_time());
            rs = prepStmt.executeQuery();
            if (rs.next()){
                record2 = new Record();
                record2.setDate_time(rs.getString(1));
                record2.setName(rs.getString(2));
                record2.setTemp(rs.getString(3));
                record2.setTemp1(rs.getString(4));
                record2.setTemp2(rs.getString(5));
                record2.setTemp3(rs.getString(6));
                record2.setTemp4(rs.getString(7));
                record2.setTemp8(rs.getString(8));
                record2.setTemp5(rs.getString(9));
                record2.setLocation(rs.getString(10));
                record2.setTemp6(rs.getString(11));
                record2.setTemp9(rs.getString(12));
                record2.setTemp7(rs.getString(13));
            }
        } catch (Exception e) {
            // handle exception
        } finally {
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return record2;
    }

    //实现列出数据库全部记录的方法
    public List<Record> selectAll() throws Exception {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        List<Record> recordList = new ArrayList<Record>();
        con = DbConnect.getDBconnection();
        prepStmt = con.prepareStatement("select * from " + TBALE_NAME + " order by date_time desc");
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            Record record2 = new Record();
            record2.setDate_time(rs.getString(1));
            record2.setName(rs.getString(2));
            record2.setTemp(rs.getString(3));
            record2.setTemp1(rs.getString(4));
            record2.setTemp2(rs.getString(5));
            record2.setTemp3(rs.getString(6));
            record2.setTemp4(rs.getString(7));
            record2.setTemp8(rs.getString(8));
            record2.setTemp5(rs.getString(9));
            record2.setLocation(rs.getString(10));
            record2.setTemp6(rs.getString(11));
            record2.setTemp9(rs.getString(12));
            record2.setTemp7(rs.getString(13));
            recordList.add(record2);
        }
        DbConnect.closeDB(con, prepStmt, rs);
        return recordList;
    }

    //实现删除数据库中指定的记录方法
    public int delete(Record record) throws Exception {
        int result = 0;
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            con = DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(DELETE_SQL);
            prepStmt.setString(1, record.getDate_time());
            prepStmt.setString(2, record.getName());
            prepStmt.executeUpdate();
        }catch(Exception e) {
            //
        } finally{
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return result;
    }

    //实现用指定的对象修改数据库中记录的方法
    public int update(Record record) throws Exception {
        int result = 0;
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        try {
            con=DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1, record.getDate_time());
            prepStmt.setString(2, record.getName());
            prepStmt.setString(3, record.getTemp());
            prepStmt.setString(4, record.getTemp1());
            prepStmt.setString(5, record.getTemp2());
            prepStmt.setString(6, record.getTemp3());
            prepStmt.setString(7, record.getTemp4());
            prepStmt.setString(8, record.getTemp8());
            prepStmt.setString(9, record.getTemp5());
            prepStmt.setString(10, record.getLocation());
            prepStmt.setString(11, record.getTemp6());
            prepStmt.setString(12, record.getTemp9());
            prepStmt.setString(13, record.getTemp7());
            result = prepStmt.executeUpdate();
        } catch (Exception e) {
            // handle exception
        } finally {
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return result;
    }
}
