package web.app;

import java.util.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userdetails {

    public int savedata(String name, String addr) throws ClassNotFoundException, SQLException {
        int nid = 0;
        Connection c;
        c = moc.goc();
        Statement s = c.createStatement();

        ResultSet rs = s.executeQuery("select max(Id) from cust_mast");

        while (rs.next()) {
            nid = rs.getInt(1);

        }
        nid = nid + 1;
        String sql = "INSERT INTO cust_mast (Id,Name,Address) values(" + nid + ",'" + name + "','" + addr + "')";
        s.execute(sql);
        return nid;
    }

    public int saveregistration(String name, String gender, int age, String addr, int mtype, int salary, String username, String password) throws SQLException, ClassNotFoundException {
        int id = 0;
        Connection c = moc.goc();
        //SaveRegistration(vname in varchar, vage in number, vaddress in varchar,vmtype in number,
        //                 vgender in char,vsalary in number, vusername in varchar , vpassword in varchar)
        String fn = "{? = call SaveRegistration(?,?,?,?,?,?,?,?) }";
        CallableStatement cs = c.prepareCall(fn);
        cs.registerOutParameter(1, Types.NUMERIC);
        cs.setString(2, name);
        cs.setInt(3, age);
        cs.setString(4, addr);
        cs.setInt(5, mtype);
        cs.setString(6, gender);
        cs.setInt(7, salary);
        cs.setString(8, username);
        cs.setString(9, password);
        cs.executeUpdate();
        id = cs.getInt(1);
        return id;
    }

    public ArrayList getreport(String name, String gender, int mtype) throws ClassNotFoundException, SQLException {
        Connection co = moc.goc();
        Statement s = co.createStatement();
        String sql;
        ArrayList al = new ArrayList();
        sql = "select * from cust_mast where name like '" + name + "%' and gender='" + gender + "' and mtype=" + mtype + " order by id";
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            al.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
        }
        s.close();
        return al;
    }

    public int checklogin(String username, String password) throws ClassNotFoundException, SQLException {
        Connection c = moc.goc();
        CallableStatement cs = c.prepareCall("{ ? = call checklogindet(?,?)}");
        cs.setString(2, username);
        cs.setString(3, password);
        cs.registerOutParameter(1, Types.NUMERIC);
        cs.executeUpdate();
        int nid = cs.getInt(1);
        return nid;
    }

    public updatecust update1(int id) {
       updatecust uc = null;
        try {
            Connection c = moc.goc();
            CallableStatement cs = c.prepareCall("{call getupdatedet(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.NUMERIC);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.NUMERIC);
            cs.registerOutParameter(7, Types.NUMERIC);
            cs.registerOutParameter(8, Types.VARCHAR);
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.executeUpdate();
            String name = cs.getString(2);
            String gender = cs.getString(3);
            int age = cs.getInt(4);
            String address = cs.getString(5);
            int mtype = cs.getInt(6);
            int salary = cs.getInt(7);
            String username = cs.getString(8);
            String pass = cs.getString(9);
             uc = new updatecust(name, gender, address, username, pass, age, mtype, salary);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return uc;
    }

    public int update2(int id, String name, String gender, int age, String addr, int mtype, int sal, String username, String pass) throws SQLException {
        Connection c = moc.goc();
        CallableStatement cs = c.prepareCall("{call updatereg(?,?,?,?,?,?,?,?,?)}");
        cs.setInt(1, id);
        cs.setString(2, name);
        cs.setString(3, gender);
        cs.setInt(4, age);
        cs.setString(5, addr);
        cs.setInt(6, mtype);
        cs.setInt(7, sal);
        cs.setString(8, username);
        cs.setString(9, pass);
        cs.registerOutParameter(1, Types.NUMERIC);

        cs.executeUpdate();

        int id1 = cs.getInt(1);
        return id1;
    }
}
