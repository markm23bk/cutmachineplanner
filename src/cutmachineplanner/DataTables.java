/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author petr
 */
public class DataTables {
    
   public DataTables (){
       
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");

Statement st = conn.createStatement();


//
//st.executeUpdate("DROP TABLE inputmaterial CASCADE");
//st.executeUpdate("DROP TABLE deadline CASCADE");
//st.executeUpdate("DROP TABLE termin CASCADE");
//st.executeUpdate("DROP TABLE outputmaterial CASCADE");
//st.executeUpdate("DROP TABLE responsibility CASCADE");
//st.executeUpdate("DROP TABLE druhpapiru CASCADE");
//st.executeUpdate("DROP TABLE state CASCADE");
//st.executeUpdate("DROP TABLE person CASCADE");
//st.executeUpdate("DROP TABLE capacity CASCADE");
//
//
//
//st.executeUpdate("CREATE TABLE druhpapiru (cislopap INT,druhpap VARCHAR(13),rychlost INT, "
//                  + "CONSTRAINT pk_cislopap PRIMARY KEY (cislopap));");
////
//st.executeUpdate("INSERT INTO druhpapiru VALUES (1,'CD BL');");
//st.executeUpdate("INSERT INTO druhpapiru VALUES (2,'CD UB');");
//
//
//st.executeUpdate("CREATE TABLE state(id INT,state VARCHAR(13),"
//        + "CONSTRAINT pk_id PRIMARY KEY (id));");
//
//
//st.executeUpdate("CREATE TABLE person"
//        + "(cislozam INT,jmeno VARCHAR(13),prijmeni VARCHAR(13),username VARCHAR(13),"
//        + "password VARCHAR(13),role INT, " 
//        + "CONSTRAINT pk_cislozam PRIMARY KEY (cislozam));");
//
//
//st.executeUpdate("CREATE TABLE inputmaterial"
//        + "(cislozak INT,cislorol VARCHAR(13),sire INT,druhpap INT,delkrol INT,cisvyrobku VARCHAR(13),"
//        + "CONSTRAINT pk_cislozak PRIMARY KEY(cislozak));");
//    
//
//st.executeUpdate("CREATE TABLE deadline"
//        + "(cislozak INT,deadday INT,deadmounth INT,deadyear INT,deadhour INT,deadminute INT,"
//        + " CONSTRAINT pk_cislozak PRIMARY KEY (cislozak));");
//
//
//
//st.executeUpdate("CREATE TABLE termin"
//        + "(cislozak INT,startday INT,startmounth INT,startyear INT,starthour INT,startminute INT,"
//        + "endday INT,endmounth INT,endyear INT,endhour INT,endminute INT,vyrdoba INT,state INT, "
//        + "CONSTRAINT pk_cislozak PRIMARY KEY (cislozak));");
//
//
//
//st.executeUpdate("CREATE TABLE outputmaterial"
//        + "(cislozak INT,c1 INT ,c2 INT ,c3 INT ,c4 INT ,c5 INT ,"
//        + "c6 INT ,c7 INT ,c8 INT ,c9 INT ,c10 INT ,c11 INT,"
//        + "CONSTRAINT pk_cislozak PRIMARY KEY (cislozak));");
//
//st.executeUpdate("CREATE TABLE responsibility"
//        + "(cislozak INT,osoba INT, "
//        + "CONSTRAINT pk_cislozak PRIMARY KEY (cislozak));");
//       
//
//st.executeUpdate("CREATE TABLE capacity"
//        + "(day INT,mounth INT,year INT,rani INT,odpoledni INT,nocni INT,volkap INT, "
//        + "CONSTRAINT pk_datum PRIMARY KEY (day,mounth,year));");
//       
//
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (5,40,40,50,50,60,60,70,0,0,0,0);");
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (6,40,40,50,50,60,60,70,0,0,0,0);");
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (7,40,40,50,50,60,60,70,0,0,0,0);");
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (8,40,40,50,50,60,60,70,0,0,0,0);");
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (1,40,40,50,50,60,60,70,0,0,0,0);");
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (2,40,40,50,50,60,60,70,0,0,0,0);");
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (3,40,40,50,50,60,60,70,0,0,0,0);");
//st.executeUpdate("INSERT INTO outputmaterial "
//        + "VALUES (4,40,40,50,50,60,60,70,0,0,0,0);");



//st.executeUpdate("INSERT INTO person "
//        + "VALUES (1,'admin','admin','admin','1234',1);");

//
//st.executeUpdate("INSERT INTO state "
//        + "VALUES (1,'CEKA');");
//st.executeUpdate("INSERT INTO state "
//        + "VALUES (2,'AKTIVNI');");
//st.executeUpdate("INSERT INTO state "
//        + "VALUES (3,'VYROBENO');");

st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (1,'KS UB/70',600);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (2,'KS UB/80',600);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (3,'KS UB/90',550);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (4,'KS UB/100',550);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (5,'KS BL/70',600);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (6,'KS BL/80',600);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (7,'KS BL/90',550);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (8,'KS BL/100',550);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (9,'BL HPO/80',400);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (10,'BL HPO/90',400);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (11,'KS UB MAG/80',530);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (12,'KS UB MAG/90',530);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (13,'KP UB MAG/90',470);");
st.executeUpdate("INSERT INTO druhpapiru "
        + "VALUES (14,'KP UB MAG/100',470);");



}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");

System.out.println(e.toString());}

}     
   }
    

