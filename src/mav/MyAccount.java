/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mehul
 */

public class MyAccount extends javax.swing.JFrame {
    int index=0;
    int BookID;
    static DefaultTableModel model;
    /**
     * Creates new form MyAccount
     */
    public MyAccount() {
        initComponents();
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        initialcall();
    }
        //DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
    void initialcall(){ 
        try{
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String username = "root";
                String password = "mehul";
                Class.forName(driver);
                Connection conn=DriverManager.getConnection(url,username,password);
                //System.out.println("Database Connected.");
                //System.out.println("Creating statement...");
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                Statement stmt=null;
                stmt = conn.createStatement();            
                String sql;
                sql="SELECT * FROM hbsmav.book WHERE Username=\""+CustomerLogin.uname+"\";";
                
                ResultSet rs=stmt.executeQuery(sql);
                           
                while(rs.next()){
                   String name=rs.getString("Name");
                   String sdate=rs.getString("Sdate");
                   String edate=rs.getString("Edate");
                   int nrb=Integer.parseInt(rs.getString("Nrb"));
                   int w=Integer.parseInt(rs.getString("Wait"));
                   String bid=rs.getString("BookingID");
                   String gst=rs.getString("Guests");
                   String tc=rs.getString("Cost");
                   tableModel.addRow(new Object[]{name,sdate,edate,nrb,w,bid,gst,tc});
                }
                }catch(Exception e){System.out.println(e);};        // TODO add your handling code here:
        }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        Hsearch = new javax.swing.JButton();
        Logout = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setText("Booking History");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Checkin", "Checkout", "Rooms", "Wait List", "BookingID", "Guests", "Total Cost"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Welcome,");

        user.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        user.setText(CustomerLogin.uname);

        jToolBar2.setRollover(true);

        jButton1.setVisible(false);
        jButton1.setText("Modify");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.setVisible(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Cancellation Successful!");
        jLabel5.setVisible(false);

        jLabel6.setText("jLabel6");
        jLabel6.setVisible(false);

        jLabel7.setText("New Checkin Date");
        jLabel7.setVisible(false);

        jTextField1.setVisible(false);

        jLabel8.setText("New Checkout Date");
        jLabel8.setVisible(false);

        jTextField2.setVisible(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setText("Rate");
        jButton3.setVisible(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox1.setVisible(false);

        jLabel9.setText("HBS MAV © 2018");

        Hsearch.setText("   Hotel Search            ");
        Hsearch.setFocusable(false);
        Hsearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Hsearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Hsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HsearchActionPerformed(evt);
            }
        });

        Logout.setText("   Logout      ");
        Logout.setFocusable(false);
        Logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Logout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(user)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(164, 164, 164))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(310, 310, 310))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(Hsearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Logout)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hsearch)
                    .addComponent(Logout))
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HsearchActionPerformed
        new HotelSearch().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_HsearchActionPerformed
    public static String getToday(String format){
        Date date = new Date();
        return new SimpleDateFormat(format).format(date);
    }
    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        new CustomerLogin().setVisible(true);
        CustomerLogin.uname=null;
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            
            index=jTable1.getSelectedRow();
            TableModel model=jTable1.getModel();
            BookID=Integer.parseInt(model.getValueAt(index, 5).toString());
            
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today=getToday("yyyy-MM-dd");
            String d1=model.getValueAt(index, 2).toString();
            String d2=model.getValueAt(index, 1).toString();
            Date date1 = myFormat.parse(today);
            Date date2 = myFormat.parse(d1);
            Date date3=myFormat.parse(d2);
            long diff = date2.getTime() - date1.getTime();
            long diff2 = date3.getTime() - date1.getTime();
            int days=Integer.parseInt(""+TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            int days2=Integer.parseInt(""+TimeUnit.DAYS.convert(diff2, TimeUnit.MILLISECONDS));   
            if(days<=0){
                jComboBox1.setVisible(true);
                jButton3.setVisible(true);
            }
            if(days2>3){
                jButton1.setVisible(true);
                jLabel7.setVisible(true);
                jLabel8.setVisible(true);
                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
            }
            if(days2>0)
                jButton2.setVisible(true);
            
        }catch(Exception e){System.out.println("Exception "+e);};        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new HotelSearch().setVisible(true);
        TableModel model=jTable1.getModel();
        HotelSearch.Rooms.setText(model.getValueAt(index,3).toString());
        HotelSearch.Guests.setText(model.getValueAt(index,6).toString());
        HotelSearch.Checkin.setText(jTextField1.getText());
        HotelSearch.Checkout.setText(jTextField2.getText());
        jButton2ActionPerformed(evt);  
        //HotelSearch.JComboBox1.setText(model.getValueAt(index,).toString())
        
        
        
//        TableModel model=jTable1.getModel();
//        String nm=model.getValueAt(index,0).toString();
//        int nbr=Integer.parseInt(model.getValueAt(index,2).toString());
//        
//        String driver="com.mysql.jdbc.Driver";
//        String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
//        String username = "root";
//        String password = "mehul";
//        Class.forName(driver);
//        Connection conn=DriverManager.getConnection(url,username,password);
//        Statement stmt=null;
//        stmt = conn.createStatement();            
//        String sql;
//        sql="INSERT INTO hbsmav.book (Name,Sdate,Edate,Nrb,Wait,Username,ID) VALUES (\"" "
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String username = "root";
            String password = "mehul";
            Class.forName(driver);
            Connection conn=DriverManager.getConnection(url,username,password);
            //System.out.println("Database Connected.");
            //System.out.println("Creating statement...");
                
            Statement stmt=null;
            stmt = conn.createStatement();            
            String sql;
            TableModel model=jTable1.getModel();
            String sdate=model.getValueAt(index,1).toString();
            String edate=model.getValueAt(index,2).toString();
            
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today=getToday("yyyy-MM-dd");
            String d1=model.getValueAt(index, 2).toString();
            Date date1 = myFormat.parse(today);
            Date date2 = myFormat.parse(sdate);
            long diff = date2.getTime() - date1.getTime();
            int days=Integer.parseInt(""+TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));    
            if(days<=3){
                jLabel6.setVisible(true);
                jLabel6.setText("You are still liable to pay 50% ("+(Integer.parseInt(model.getValueAt(index,7).toString()))/2+") of the total cost since less than 3 days are left.");
            }
            else{
                jLabel6.setVisible(true);
                jLabel6.setText("Total Cost ("+Integer.parseInt(model.getValueAt(index,7).toString())+") will be refunded.");
            }
            
            
            
            int wait=Integer.parseInt(model.getValueAt(index, 4).toString());
            sql="DELETE FROM hbsmav.book WHERE BookingID="+BookID+";";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.execute();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.removeRow(index);
            jLabel5.setVisible(true);
            
            sql="SELECT Wait,BookingID FROM hbsmav.book WHERE Sdate<='"+edate+" 23:59:59.000' AND Edate>='"+sdate+" 23:59:59.000';";
            ResultSet rs=stmt.executeQuery(sql);  
            int n=0;
            while(rs.next()){
                System.out.println("While entered");
                n=Integer.parseInt(rs.getString("Wait"));
                System.out.println(n);
                System.out.println(wait);
                int bid=Integer.parseInt(rs.getString("BookingID"));
                if(n>wait && n!=0){
                    sql="UPDATE hbsmav.book SET Wait="+(n-1)+" WHERE BookingID="+bid+";";
                    System.out.println(sql);
                    preparedStmt = conn.prepareStatement(sql);
                    preparedStmt.execute();
                }
                   
            }  
            
            }catch(Exception e){System.out.println(e);}       // TODO add your handling code here:
        jButton1.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);
                jTextField1.setVisible(false);
                jTextField2.setVisible(false);
                jButton2.setVisible(false);
     // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int r=Integer.parseInt(jComboBox1.getSelectedItem().toString());
        try{
        String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String username = "root";
            String password = "mehul";
            Class.forName(driver);
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt=null;
            stmt = conn.createStatement();            
            String sql;
            TableModel model=jTable1.getModel();
            String na=model.getValueAt(index,0).toString();
            sql="SELECT Rating FROM hbsmav.hot WHERE Name=\""+na+"\";";
            //System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            int rat=0;
            while(rs.next()){
                rat=Integer.parseInt(rs.getString("Rating"));
            }
            int rat2=rat%10;
            int rat1=rat/10;
            rat1=rat1+1;
            rat2=(rat2*(rat1-1)+r)/rat1;
            rat=rat1*10+rat2;
            
            sql="UPDATE hbsmav.hot SET Rating="+rat+" WHERE Name=\""+na+"\";";
            //System.out.println(sql);
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.execute();
        }catch(Exception e){System.out.println(e);}
        jButton3.setVisible(false);
        jComboBox1.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyAccount().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hsearch;
    private javax.swing.JButton Logout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToolBar jToolBar2;
    private static javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}