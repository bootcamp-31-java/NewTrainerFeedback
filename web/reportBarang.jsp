<%@page import="tools.HibernateUtil"%>
<%@page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="oracle.jdbc.pool.OracleDataSource"%>
<%@ page contentType="application/pdf" %>
 
<%@ page trimDirectiveWhitespaces="true"%>
 
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
 
<%
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Connection conn = sf.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
     try {
        //Connecting to the database
        
//       OracleDataSource ods = new OracleDataSource();
//            ods.setDriverType("thin");
//            ods.setServerName("localhost");
//            ods.setPortNumber(1521);
//            ods.setUser("system");
//            ods.setServiceName("XE");
//            ods.setPassword("Terminus");
//            conn = ods.getConnection();
//            conn.createStatement().execute("alter session set current_schema = INVENTORY");
 
        //Loading Jasper Report File from Local file system
 
        String jrxmlFile = "\\Java\\NetBeansProjects\\Setok\\src\\java\\report\\reportBarang.jrxml";
  
        InputStream input = new FileInputStream(new File(jrxmlFile));
 
        //Generating the report
 
        JasperReport jasperReport = JasperCompileManager.compileReport(input);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
 
        //Exporting the report as a PDF
 
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
 
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (JRException e) {
        e.printStackTrace();
    } 
    finally {
        if(conn!=null){
            conn.close();
        }
    }
%>