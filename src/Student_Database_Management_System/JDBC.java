package Student_Database_Management_System;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class JDBC extends javax.swing.JFrame {

    Connection datacon;
    PreparedStatement prestm;
    ResultSet result;

    public JDBC() {
        initComponents();
        insert_into_Jtable();

    }

    public void insert_into_Jtable() {
        int J_table;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            datacon = DriverManager.getConnection("jdbc:mysql://localhost/dataInfo", "root", "");

            prestm = datacon.prepareStatement("select * from INFORMATIONS");
            result = prestm.executeQuery();

            ResultSetMetaData rsmd = result.getMetaData();
            J_table = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);

            while (result.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= J_table; i++) {

                    v.add(result.getString("id"));
                    v.add(result.getString("name"));
                    v.add(result.getString("roll"));
                    v.add(result.getString("batch"));
                    v.add(result.getString("department"));

                }
                dtm.addRow(v);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        stbatch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stname = new javax.swing.JTextField();
        stroll = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        stdep = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btninsert = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnreset2 = new javax.swing.JButton();
        btnreset1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Database");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBackground(new java.awt.Color(153, 153, 153));
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDesktopPane1PropertyChange(evt);
            }
        });
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stbatch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDesktopPane1.add(stbatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 320, 35));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 120, 35));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student ID");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 120, 35));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Batch");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 120, 35));

        stname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDesktopPane1.add(stname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 320, 35));

        stroll.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDesktopPane1.add(stroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 320, 35));

        table.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Student ID", "Batch", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jDesktopPane1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 890, 230));

        stdep.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDesktopPane1.add(stdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 320, 35));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department");
        jDesktopPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 120, 35));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninsert.setBackground(new java.awt.Color(204, 204, 204));
        btninsert.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btninsert.setText("Insert");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });
        jPanel1.add(btninsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 180, 35));

        btnupdate.setBackground(new java.awt.Color(204, 204, 204));
        btnupdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 180, 35));

        btndelete.setBackground(new java.awt.Color(204, 204, 204));
        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 180, 35));

        btnreset2.setBackground(new java.awt.Color(204, 204, 204));
        btnreset2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnreset2.setText("Reset");
        btnreset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnreset2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 180, 35));

        btnreset1.setBackground(new java.awt.Color(204, 204, 204));
        btnreset1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnreset1.setText("Exit");
        btnreset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnreset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 180, 35));

        jDesktopPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 300, 260));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Student Database Management System");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 540, -1));
        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, -10, -1, -1));

        jDesktopPane1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 880, 90));

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnreset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset1ActionPerformed

        frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","MySQL Connector",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    {
        System.exit(0);
        }

    }//GEN-LAST:event_btnreset1ActionPerformed

    private void btnreset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset2ActionPerformed
        stname.setText("");
        stroll.setText("");
        stbatch.setText("");
        stdep.setText("");

    }//GEN-LAST:event_btnreset2ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed

        DefaultTableModel update = (DefaultTableModel) table.getModel();
        int selectedindex = table.getSelectedRow();

        int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

        int showresult = JOptionPane.showConfirmDialog(null, "Are you sure to delete it? ? ", "Warning", JOptionPane.YES_NO_OPTION);

        if (showresult == JOptionPane.YES_NO_OPTION) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                datacon = DriverManager.getConnection("jdbc:mysql://localhost/dataInfo", "root", "");
                prestm = datacon.prepareStatement("delete from INFORMATIONS where ID =? ");

                prestm.setInt(1, id);
                prestm.executeUpdate();

                JOptionPane.showMessageDialog(this, "The record has been Deleted");
                insert_into_Jtable();

                stname.setText("");
                stroll.setText("");
                stbatch.setText("");
                stdep.setText("");

                stname.requestFocus();

            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed

        DefaultTableModel update = (DefaultTableModel) table.getModel();
        int selectedindex = table.getSelectedRow();

        int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

        String name, roll, batch, department;

        name = stname.getText();
        roll = stroll.getText();
        batch = stbatch.getText();
        department = stdep.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            datacon = DriverManager.getConnection("jdbc:mysql://localhost/dataInfo", "root", "");

            prestm = datacon.prepareStatement("update INFORMATIONS set Name=?,Roll=?,Batch=?,Department=? where id =? ");
            prestm.setString(1, name);
            prestm.setString(2, roll);
            prestm.setString(3, batch);
            prestm.setString(4, department);

            prestm.setInt(5, id);
            prestm.executeUpdate();

            JOptionPane.showMessageDialog(this, "The record has been Updated");

            stname.setText("");
            stroll.setText("");
            stbatch.setText("");
            stdep.setText("");

            stname.requestFocus();

            insert_into_Jtable();

        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed

        String id, name, roll, batch, department;
        name = stname.getText();
        roll = stroll.getText();
        batch = stbatch.getText();
        department = stdep.getText();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            datacon = DriverManager.getConnection("jdbc:mysql://localhost/dataInfo", "root", "");

            prestm = datacon.prepareStatement("Insert into INFORMATIONS(Name,Roll,Batch,Department)values(?,?,?,?) ");

            prestm.setString(1, name);
            prestm.setString(2, roll);
            prestm.setString(3, batch);
            prestm.setString(4, department);

            prestm.executeUpdate();

            JOptionPane.showMessageDialog(this, "The Record has been Inserted");

            stname.setText("");
            stroll.setText("");
            stbatch.setText("");
            stdep.setText("");

            stname.requestFocus();

            insert_into_Jtable();

        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(this, ex);

        }
    }//GEN-LAST:event_btninsertActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        try {
            DefaultTableModel update = (DefaultTableModel) table.getModel();

            int selectedindex = table.getSelectedRow();

            stname.setText(update.getValueAt(selectedindex, 1).toString());
            stroll.setText(update.getValueAt(selectedindex, 2).toString());
            stbatch.setText(update.getValueAt(selectedindex, 3).toString());
            stdep.setText(update.getValueAt(selectedindex, 4).toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jDesktopPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDesktopPane1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDesktopPane1PropertyChange
private JFrame frame;
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new JDBC().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnreset1;
    private javax.swing.JButton btnreset2;
    private javax.swing.JButton btnupdate;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField stbatch;
    private javax.swing.JTextField stdep;
    private javax.swing.JTextField stname;
    private javax.swing.JTextField stroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
