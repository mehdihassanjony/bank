
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Admin_home extends javax.swing.JFrame {

    /**
     * Creates new form Admin_home
     */
    
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Admin_home() {
        initComponents();
        conn = connect.ConnectDB();
        CurrentDate();
        adminupdate();
        updateTable();
        updatecustomerTable();
        customernull();
        updateloanTable();
        loannull();
        updatestaffTable();
        staffnull();
        request();
    }

    private void request(){
        try{ 
        String sql="select name,email,checkbook,card from customers_info where checkbook = '0'";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_request.setModel(DbUtils.resultSetToTableModel(rs));
            
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from customers_info where card = '0'";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from loan_info where checkbook = '0'";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            loan_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from loan_info where card = '0'";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            loan_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from staff_info where checkbook = '0'";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            staff_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from staff_info where card = '0'";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            staff_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        
    }
    
    private void adminupdate()
    {
        String sql="Select  *   from admin_detail where email = 'shoyshab@gmail.com'";
     
  try{
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    if(rs.next()){
    String name=rs.getString("name");
    admin_name.setText(name);
    String balance=rs.getString("balance");
    admin_balance.setText(balance);
    String sex=rs.getString("sex");
    admin_sex.setSelectedItem(sex);
    String age=rs.getString("age");
    admin_age.setText(age);
    String address=rs.getString("address");
    admin_address.setText(address);
    String city=rs.getString("city");
    admin_city.setText(city);
    String postal=rs.getString("postal");
    admin_postal.setText(postal);
    String phone=rs.getString("phone");
    admin_phone.setText(phone);
    String email=rs.getString("email");
    admin_email.setText(email);
    admin_email.setEditable(false);
    String password=rs.getString("password");
    admin_password.setText(password);
    String acc_type=rs.getString("acc_type");
    admin_acc_type.setSelectedItem(acc_type);
    String nid=rs.getString("nid");
    admin_nid.setText(nid);
    byte[] imagedata =rs.getBytes("image");
    format  = new ImageIcon(imagedata);
    image.setIcon(format);
    }        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
     
  }
  catch(Exception e) {
      
                   }
      } 
    }
    private void updateTable()
    {
                String sql="Select * from admin_tranc";

          try{
            pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            admin_tranc.setModel(DbUtils.resultSetToTableModel(rs));     
            }catch(Exception e)
            {
                   JOptionPane.showMessageDialog(null, e);

            }finally {
        try{
          rs.close();
              pst.close();

          }
          catch(Exception e) {
                           }
      } 
    }
    private void customernull()
    {
        customer_name.setText("");
       customer_balance.setText("");
       customer_sex.setSelectedItem("");
       customer_age.setText("");
       customer_address.setText("");
       customer_city.setText("");
       customer_postal.setText("");
       customer_phone.setText("");
       customer_email.setText("");
       customer_email.setEditable(true);
       //customer_email.setEditable(false);
       customer_password.setText("");
       customer_image_preview.setDisabledIcon(null);
       customer_nid.setText("");
       customer_acc_type.setSelectedItem("");
    }
    private void updatecustomerTable()
    {
        String sql="Select  *   from customers_info";
     
  try{
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    customer_list.setModel(DbUtils.resultSetToTableModel(rs));     
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
     
  }
  catch(Exception e) {
                   }
      } 
    }
    private void loannull()
    {
        loan_name.setText("");
       loan_balance.setText("");
       loan_sex.setSelectedItem("");
       loan_age.setText("");
       loan_address.setText("");
       loan_city.setText("");
       loan_postal.setText("");
       loan_phone.setText("");
       loan_email.setText("");
       loan_email.setEditable(true);
       //loan_email.setEditable(false);
       loan_password.setText("");
       loan_image_preview.setDisabledIcon(null);
       loan_nid.setText("");
       loan_acc_type.setSelectedItem("");
    }
    private void updateloanTable()
    {
        String sql="Select  *   from loan_info";
     
  try{
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    loan_list.setModel(DbUtils.resultSetToTableModel(rs));     
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
     
  }
  catch(Exception e) {
                   }
      } 
    }
    private void updatestaffTable(){
        String sql="Select  *   from staff_info";
     
  try{
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    staff_list.setModel(DbUtils.resultSetToTableModel(rs));     
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
     
  }
  catch(Exception e) {
                   }
      } 
    }
    private void staffnull()
    {
        staff_name.setText("");
       staff_balance.setText("");
       staff_sex.setSelectedItem("");
       staff_age.setText("");
       staff_address.setText("");
       staff_city.setText("");
       staff_postal.setText("");
       staff_phone.setText("");
       staff_email.setText("");
       staff_email.setEditable(true);
       //staff_email.setEditable(false);
       staff_password.setText("");
       staff_image_preview.setDisabledIcon(null);
       staff_nid.setText("");
       staff_acc_type.setSelectedItem("");
    }
    public void close() {
WindowEvent winClosingEvent = new WindowEvent( this, WindowEvent.WINDOW_CLOSING );
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent( winClosingEvent );
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        admin_update_balance = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        admin_edit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        admin_delete = new javax.swing.JButton();
        admin_refresh = new javax.swing.JButton();
        admin_print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        admin_tranc_search = new javax.swing.JTextField();
        admin_search_button = new javax.swing.JButton();
        admin_transaction_type = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        admin_tranc = new javax.swing.JTable();
        admin_image_path = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        admin_name = new javax.swing.JTextField();
        admin_balance = new javax.swing.JTextField();
        admin_sex = new javax.swing.JComboBox<>();
        admin_age = new javax.swing.JTextField();
        admin_address = new javax.swing.JTextField();
        admin_city = new javax.swing.JTextField();
        admin_postal = new javax.swing.JTextField();
        admin_phone = new javax.swing.JTextField();
        admin_email = new javax.swing.JTextField();
        admin_password = new javax.swing.JPasswordField();
        admin_nid = new javax.swing.JTextField();
        admin_acc_type = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        admin_attach = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        image = new javax.swing.JLabel();
        admin_balance_update = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        loan = new javax.swing.JFormattedTextField();
        interest = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        customer_image_preview = new javax.swing.JLabel();
        customer_attach = new javax.swing.JButton();
        customer_image_path = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        customer_add = new javax.swing.JButton();
        customer_update = new javax.swing.JButton();
        customer_delete = new javax.swing.JButton();
        customer_refresh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        customer_search = new javax.swing.JTextField();
        customer_search_button = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        customer_name = new javax.swing.JTextField();
        customer_balance = new javax.swing.JTextField();
        customer_sex = new javax.swing.JComboBox<>();
        customer_age = new javax.swing.JTextField();
        customer_address = new javax.swing.JTextField();
        customer_city = new javax.swing.JTextField();
        customer_postal = new javax.swing.JTextField();
        customer_phone = new javax.swing.JTextField();
        customer_email = new javax.swing.JTextField();
        customer_nid = new javax.swing.JTextField();
        customer_password = new javax.swing.JPasswordField();
        customer_acc_type = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        customer_transaction_type = new javax.swing.JComboBox<>();
        customer_update_amount = new javax.swing.JTextField();
        customer_balance_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        customer_list = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        loan_image_preview = new javax.swing.JLabel();
        loan_attach = new javax.swing.JButton();
        loan_image_path = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        loan_add = new javax.swing.JButton();
        loan_update = new javax.swing.JButton();
        loan_delete = new javax.swing.JButton();
        loan_refresh = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        loan_search = new javax.swing.JTextField();
        loan_search_button = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        loan_name = new javax.swing.JTextField();
        loan_balance = new javax.swing.JTextField();
        loan_age = new javax.swing.JTextField();
        loan_address = new javax.swing.JTextField();
        loan_city = new javax.swing.JTextField();
        loan_postal = new javax.swing.JTextField();
        loan_phone = new javax.swing.JTextField();
        loan_email = new javax.swing.JTextField();
        loan_password = new javax.swing.JPasswordField();
        loan_nid = new javax.swing.JTextField();
        loan_acc_type = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        loan_sex = new javax.swing.JComboBox<>();
        loan_update_amount = new javax.swing.JTextField();
        loan_transaction_type = new javax.swing.JComboBox<>();
        loan_update_balance = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        loan_list = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        staff_image_preview = new javax.swing.JLabel();
        staff_attach = new javax.swing.JButton();
        staff_image_path = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        staff_add = new javax.swing.JButton();
        staff_update = new javax.swing.JButton();
        staff_delete = new javax.swing.JButton();
        staff_refresh = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        staff_search = new javax.swing.JTextField();
        staff_search_button = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        staff_name = new javax.swing.JTextField();
        staff_balance = new javax.swing.JTextField();
        staff_sex = new javax.swing.JComboBox<>();
        staff_age = new javax.swing.JTextField();
        staff_address = new javax.swing.JTextField();
        staff_city = new javax.swing.JTextField();
        staff_postal = new javax.swing.JTextField();
        staff_phone = new javax.swing.JTextField();
        staff_email = new javax.swing.JTextField();
        staff_password = new javax.swing.JPasswordField();
        staff_nid = new javax.swing.JTextField();
        staff_acc_type = new javax.swing.JComboBox<>();
        staff_position = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        staff_update_amount = new javax.swing.JTextField();
        staff_transaction_type = new javax.swing.JComboBox<>();
        staff_update_balance = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        staff_list = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        customer_request_search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        customer_request = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        customer_request1 = new javax.swing.JTable();
        acc_holder = new javax.swing.JTextField();
        acc_email = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        checkbook = new javax.swing.JLabel();
        card = new javax.swing.JLabel();
        loan_request_search = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        loan_request = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        loan_request1 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        staff_request = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        staff_request1 = new javax.swing.JTable();
        staff_request_search = new javax.swing.JTextField();
        admin_signout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Lbl_time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Home", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(901, 500));

        admin_update_balance.setText("Update");
        admin_update_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_update_balanceActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Command", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 204)))); // NOI18N

        admin_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Files-Edit-file-icon (1).png"))); // NOI18N
        admin_edit.setText("Edit");
        admin_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_editActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PDF-download-icon.png"))); // NOI18N
        jButton1.setText("PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        admin_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin-2-icon.png"))); // NOI18N
        admin_delete.setText("Delete");
        admin_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_deleteActionPerformed(evt);
            }
        });

        admin_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Refresh-icon (1).png"))); // NOI18N
        admin_refresh.setText("Refresh");
        admin_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_refreshActionPerformed(evt);
            }
        });

        admin_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print-icon.png"))); // NOI18N
        admin_print.setText("Print");
        admin_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(admin_print, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(admin_refresh)
                            .addComponent(admin_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(admin_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(admin_edit)
                .addGap(18, 18, 18)
                .addComponent(admin_delete)
                .addGap(18, 18, 18)
                .addComponent(admin_print)
                .addGap(26, 26, 26)
                .addComponent(admin_refresh)
                .addGap(27, 27, 27))
        );

        jLabel1.setText("Search:");

        admin_tranc_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                admin_tranc_searchKeyReleased(evt);
            }
        });

        admin_search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Windows-Magnifier-icon.png"))); // NOI18N
        admin_search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin_tranc_search, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(admin_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(admin_tranc_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(admin_search_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        admin_transaction_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Withdraw", "Deposit" }));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Transaction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Anklepants", 1, 18), new java.awt.Color(0, 0, 255))); // NOI18N

        admin_tranc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(admin_tranc);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("C790-Roman-Smc", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        admin_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        admin_acc_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Savings", "Primary" }));

        jLabel3.setText("Name:");

        jLabel4.setText("Balance(initial):");

        jLabel5.setText("Sex:");

        jLabel6.setText("Age:");

        jLabel7.setText("Address:");

        jLabel8.setText("City:");

        jLabel9.setText("Postal Code:");

        jLabel10.setText("Phone:");

        jLabel11.setText("Email:");

        jLabel12.setText("Password:");

        jLabel13.setText("NID");

        jLabel14.setText("Account Type:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin_acc_type, 0, 83, Short.MAX_VALUE)
                    .addComponent(admin_password)
                    .addComponent(admin_nid)
                    .addComponent(admin_email)
                    .addComponent(admin_phone)
                    .addComponent(admin_postal)
                    .addComponent(admin_city)
                    .addComponent(admin_address)
                    .addComponent(admin_age)
                    .addComponent(admin_balance)
                    .addComponent(admin_name)
                    .addComponent(admin_sex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(admin_sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_postal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_nid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_acc_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        admin_attach.setText("Attach");
        admin_attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_attachActionPerformed(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(51, 51, 255));

        jDesktopPane1.setLayer(image, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Loan Interest:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("Savings Interest:");

        loan.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        loan.setText("0.00");

        interest.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        interest.setText("0.00");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel60)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(interest, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(admin_attach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(admin_image_path, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(admin_transaction_type, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(admin_update_balance)
                                    .addComponent(admin_balance_update, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(admin_attach)
                                    .addComponent(admin_image_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(admin_transaction_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(admin_balance_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(admin_update_balance))
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Home", new javax.swing.ImageIcon(getClass().getResource("/images/admin - icon.png")), jPanel1); // NOI18N
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customers' Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15))); // NOI18N

        jDesktopPane2.setBackground(new java.awt.Color(51, 51, 255));

        jDesktopPane2.setLayer(customer_image_preview, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customer_image_preview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customer_image_preview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        customer_attach.setText("Attach");
        customer_attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_attachActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Command", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 204)))); // NOI18N

        customer_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Add-icon.png"))); // NOI18N
        customer_add.setText("Add");
        customer_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_addActionPerformed(evt);
            }
        });

        customer_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Files-Edit-file-icon (1).png"))); // NOI18N
        customer_update.setText("Edit");
        customer_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_updateActionPerformed(evt);
            }
        });

        customer_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin-2-icon.png"))); // NOI18N
        customer_delete.setText("Delete");
        customer_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_deleteActionPerformed(evt);
            }
        });

        customer_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Refresh-icon (1).png"))); // NOI18N
        customer_refresh.setText("Refresh");
        customer_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customer_refresh)
                    .addComponent(customer_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customer_update, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customer_add, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(customer_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(customer_update)
                .addGap(32, 32, 32)
                .addComponent(customer_delete)
                .addGap(37, 37, 37)
                .addComponent(customer_refresh)
                .addGap(27, 27, 27))
        );

        jLabel16.setText("Search:");

        customer_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_searchActionPerformed(evt);
            }
        });
        customer_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customer_searchKeyPressed(evt);
            }
        });

        customer_search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Windows-Magnifier-icon.png"))); // NOI18N
        customer_search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(customer_search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customer_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customer_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customer_search_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("C790-Roman-Smc", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel10.setMaximumSize(new java.awt.Dimension(214, 32767));

        customer_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        customer_acc_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Savings", "Primary" }));

        jLabel17.setText("Name:");

        jLabel18.setText("Balance(initial):");

        jLabel19.setText("Sex:");

        jLabel20.setText("Age:");

        jLabel21.setText("Address:");

        jLabel22.setText("City:");

        jLabel23.setText("Postal Code:");

        jLabel24.setText("Phone:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Email:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Password:");

        jLabel27.setText("NID");

        jLabel28.setText("Account Type:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customer_acc_type, 0, 83, Short.MAX_VALUE)
                    .addComponent(customer_password)
                    .addComponent(customer_nid)
                    .addComponent(customer_email)
                    .addComponent(customer_phone)
                    .addComponent(customer_postal)
                    .addComponent(customer_city)
                    .addComponent(customer_address)
                    .addComponent(customer_age)
                    .addComponent(customer_balance)
                    .addComponent(customer_name)
                    .addComponent(customer_sex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel28)
                    .addContainerGap(122, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(customer_sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_postal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(8, 8, 8)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_nid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customer_acc_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(299, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(17, 17, 17)))
        );

        customer_transaction_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Withdraw", "Deposite" }));
        customer_transaction_type.setToolTipText("");

        customer_balance_update.setText("Update");
        customer_balance_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_balance_updateActionPerformed(evt);
            }
        });

        jPanel7.setPreferredSize(new java.awt.Dimension(1000, 199));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "List of Customers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Anklepants", 1, 18), new java.awt.Color(0, 0, 255))); // NOI18N
        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        customer_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        customer_list.setPreferredSize(new java.awt.Dimension(1000, 64));
        customer_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_listMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(customer_list);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel7);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(customer_attach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customer_image_path, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customer_balance_update)
                            .addComponent(customer_transaction_type, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customer_update_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(customer_attach)
                                    .addComponent(customer_image_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(customer_transaction_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customer_update_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(customer_balance_update)
                                .addContainerGap())))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customers' Account", new javax.swing.ImageIcon(getClass().getResource("/images/customer_icon.jpg")), jPanel2); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loans' Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(51, 0, 204))); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jDesktopPane3.setBackground(new java.awt.Color(51, 51, 255));

        jDesktopPane3.setLayer(loan_image_preview, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addComponent(loan_image_preview, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loan_image_preview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        loan_attach.setText("Attach");
        loan_attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_attachActionPerformed(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Command", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 204)))); // NOI18N

        loan_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Add-icon.png"))); // NOI18N
        loan_add.setText("Add");
        loan_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_addActionPerformed(evt);
            }
        });

        loan_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Files-Edit-file-icon (1).png"))); // NOI18N
        loan_update.setText("Edit");
        loan_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_updateActionPerformed(evt);
            }
        });

        loan_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin-2-icon.png"))); // NOI18N
        loan_delete.setText("Delete");
        loan_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_deleteActionPerformed(evt);
            }
        });

        loan_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Refresh-icon (1).png"))); // NOI18N
        loan_refresh.setText("Refresh");
        loan_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loan_refresh)
                    .addComponent(loan_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loan_update, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loan_add, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(717, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(loan_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(loan_update)
                .addGap(32, 32, 32)
                .addComponent(loan_delete)
                .addGap(37, 37, 37)
                .addComponent(loan_refresh)
                .addGap(27, 27, 27))
        );

        jLabel30.setText("Search:");

        loan_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loan_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loan_searchKeyReleased(evt);
            }
        });

        loan_search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Windows-Magnifier-icon.png"))); // NOI18N
        loan_search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(loan_search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loan_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(loan_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loan_search_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("C790-Roman-Smc", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        loan_acc_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type:", "Home Loan", "Car Loan", "Indutrial Loan" }));

        jLabel31.setText("Name:");

        jLabel32.setText("Balance(initial):");

        jLabel33.setText("Sex:");

        jLabel34.setText("Age:");

        jLabel35.setText("Address:");

        jLabel36.setText("City:");

        jLabel37.setText("Postal Code:");

        jLabel38.setText("Phone:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Email:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Password:");

        jLabel41.setText("NID");

        jLabel42.setText("Account Type:");

        loan_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addGap(26, 26, 26)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loan_acc_type, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loan_password)
                    .addComponent(loan_nid)
                    .addComponent(loan_email)
                    .addComponent(loan_phone)
                    .addComponent(loan_postal)
                    .addComponent(loan_city)
                    .addComponent(loan_address)
                    .addComponent(loan_age)
                    .addComponent(loan_balance)
                    .addComponent(loan_name)
                    .addComponent(loan_sex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_name)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_balance)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(loan_sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_age)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_address)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_city)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_postal)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_phone)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_email)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_password)
                    .addComponent(jLabel40))
                .addGap(8, 8, 8)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_nid)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loan_acc_type)
                    .addComponent(jLabel42))
                .addGap(24, 24, 24))
        );

        loan_transaction_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Withdraw", "Deposite" }));
        loan_transaction_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_transaction_typeActionPerformed(evt);
            }
        });

        loan_update_balance.setText("Update");
        loan_update_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loan_update_balanceActionPerformed(evt);
            }
        });

        jPanel11.setPreferredSize(new java.awt.Dimension(1000, 199));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "List of Loans", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Anklepants", 1, 18), new java.awt.Color(0, 0, 255))); // NOI18N
        jScrollPane4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane4KeyPressed(evt);
            }
        });

        loan_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        loan_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loan_listMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(loan_list);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel11);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(loan_attach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loan_image_path))
                            .addComponent(jDesktopPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(loan_update_balance))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loan_transaction_type, 0, 128, Short.MAX_VALUE)
                                    .addComponent(loan_update_amount))))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDesktopPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(loan_transaction_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loan_update_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(loan_update_balance)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loan_attach)
                            .addComponent(loan_image_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Loans' Accounts", new javax.swing.ImageIcon(getClass().getResource("/images/customer-support-icon-png-28.png")), jPanel3); // NOI18N

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staffs' Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(51, 0, 204))); // NOI18N
        jPanel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jDesktopPane4.setBackground(new java.awt.Color(0, 0, 255));

        jDesktopPane4.setLayer(staff_image_preview, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addComponent(staff_image_preview, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staff_image_preview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        staff_attach.setText("Attach");
        staff_attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_attachActionPerformed(evt);
            }
        });

        staff_image_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_image_pathActionPerformed(evt);
            }
        });

        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Command", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 204)))); // NOI18N

        staff_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Add-icon.png"))); // NOI18N
        staff_add.setText("Add");
        staff_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_addActionPerformed(evt);
            }
        });

        staff_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Files-Edit-file-icon (1).png"))); // NOI18N
        staff_update.setText("Edit");
        staff_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_updateActionPerformed(evt);
            }
        });

        staff_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin-2-icon.png"))); // NOI18N
        staff_delete.setText("Delete");
        staff_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_deleteActionPerformed(evt);
            }
        });

        staff_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Refresh-icon (1).png"))); // NOI18N
        staff_refresh.setText("Refresh");
        staff_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(staff_refresh)
                    .addComponent(staff_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff_update, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff_add, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(staff_add)
                .addGap(44, 44, 44)
                .addComponent(staff_update)
                .addGap(49, 49, 49)
                .addComponent(staff_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(staff_refresh)
                .addGap(43, 43, 43))
        );

        jLabel44.setText("Search:");

        staff_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                staff_searchKeyReleased(evt);
            }
        });

        staff_search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Windows-Magnifier-icon.png"))); // NOI18N
        staff_search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staff_search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(staff_search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(staff_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44))
                    .addComponent(staff_search_button))
                .addGap(18, 18, 18)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("C790-Roman-Smc", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        staff_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        staff_acc_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Savings", "Primary" }));

        staff_position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Cashier", "Accountent", "Security Gaurd", "Cleaner" }));

        jLabel45.setText("Name:");

        jLabel46.setText("Balance(initial):");

        jLabel47.setText("Sex:");

        jLabel48.setText("Age:");

        jLabel49.setText("Address:");

        jLabel50.setText("City:");

        jLabel51.setText("Postal Code:");

        jLabel52.setText("Phone:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Email:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Password:");

        jLabel55.setText("NID");

        jLabel56.setText("Account Type:");

        jLabel57.setText("Position:");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(jLabel55)
                    .addComponent(jLabel52)
                    .addComponent(jLabel51)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49)
                    .addComponent(jLabel48)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staff_position, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_acc_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_password)
                    .addComponent(staff_nid)
                    .addComponent(staff_email)
                    .addComponent(staff_phone)
                    .addComponent(staff_postal)
                    .addComponent(staff_city)
                    .addComponent(staff_address)
                    .addComponent(staff_age)
                    .addComponent(staff_balance)
                    .addComponent(staff_name)
                    .addComponent(staff_sex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(staff_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff_sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_postal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGap(8, 8, 8)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_nid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_acc_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        staff_transaction_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Withdraw", "Deposite" }));

        staff_update_balance.setText("Update");
        staff_update_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_update_balanceActionPerformed(evt);
            }
        });

        jPanel17.setPreferredSize(new java.awt.Dimension(1000, 199));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "List of Staffs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Anklepants", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane5MouseClicked(evt);
            }
        });

        staff_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        staff_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staff_listMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(staff_list);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane7.setViewportView(jPanel17);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(staff_attach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(staff_image_path))
                            .addComponent(jDesktopPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(staff_update_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(staff_transaction_type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staff_update_balance, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(staff_transaction_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(staff_update_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(staff_update_balance)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jDesktopPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(staff_attach)
                                    .addComponent(staff_image_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel19.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("Staffs' Account", new javax.swing.ImageIcon(getClass().getResource("/images/Staff - icon.png")), jPanel18); // NOI18N

        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        customer_request_search.setText("Search...");
        customer_request_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_request_searchActionPerformed(evt);
            }
        });
        customer_request_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customer_request_searchKeyReleased(evt);
            }
        });

        jLabel2.setText("Search:");

        customer_request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        customer_request.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_requestMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(customer_request);

        customer_request1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        customer_request1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_requestMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(customer_request1);

        jButton3.setText("Approved");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Customer Name:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Email Adress:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Checkbook:");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Card:");

        checkbook.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        checkbook.setForeground(new java.awt.Color(255, 0, 0));

        card.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        card.setForeground(new java.awt.Color(255, 0, 0));

        loan_request_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loan_request_searchKeyReleased(evt);
            }
        });

        loan_request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        loan_request.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loan_requestMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(loan_request);

        loan_request1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        loan_request1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loan_requestMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(loan_request1);

        staff_request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        staff_request.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staff_requestMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(staff_request);

        staff_request1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        staff_request1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staff_requestMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(staff_request1);

        staff_request_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                staff_request_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(acc_email)
                                    .addComponent(acc_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(customer_request_search, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(loan_request_search, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202)
                                .addComponent(staff_request_search, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel58))
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(checkbook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(577, 577, 577)
                        .addComponent(jButton3))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customer_request_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addComponent(loan_request_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(staff_request_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(acc_holder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel43))
                    .addComponent(checkbook, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acc_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel58)
                    .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Request", jPanel24);

        admin_signout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SignOut-icon (1).png"))); // NOI18N
        admin_signout.setText("SignOut");
        admin_signout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin_signout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        admin_signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_signoutActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Help");

        jMenuItem1.setText("About us");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);
        jMenu4.add(jSeparator1);

        jMenuItem2.setText("Help Desk");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu3.setForeground(new java.awt.Color(204, 0, 153));
        jMenu3.setText("Date");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu3);

        Lbl_time.setForeground(new java.awt.Color(204, 0, 153));
        Lbl_time.setText("Time");
        Lbl_time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(Lbl_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(admin_signout)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(admin_signout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        About_us p=new About_us();
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try                                      //try statement
        {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\User\\Documents\\NetBeansProjects\\bank\\Ask Frequently Question.pdf");   //open the file chart.pdf

        } catch (Exception e)                    //catch any exceptions here
        {
            JOptionPane.showMessageDialog(null,"Error");  //print the error
        }finally {
            try{
                rs.close();
                pst.close();
                //conn.close();
            }
            catch(Exception e) {
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Calendar cal = new GregorianCalendar();
  int month = cal.get(Calendar.MONTH);
  int year = cal.get(Calendar.YEAR);
  int day = cal.get(Calendar.DAY_OF_MONTH);
  //String date1 = null;
  //jMenu3.setText("                                                                      Date : "   + day + "/" + (month + 1) + "/" + year);
  //System.out.println("Current date : " + day + "/" + (month + 1) + "/" + year);
        try                                      //try statement     
     {   
           
           Document document=new Document();
        PdfWriter.getInstance(document,new FileOutputStream("Admin Details.pdf"));

document.open();
//document.addSubject("hhhhhhhhhhhh");     
   //document.addHeader(date1,"hhii"); 
   //document.addCreationDate();
 Image image1 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\bank\\src\\images\\SECURITY-BANK.png");
 //  image1.scaleAbsolute(300,300);
document.add(image1);



//Image image2 = Image.getInstance(admin_image);
//image2.scaleAbsolute(20,20);
//document.add(image2);
 document.add(new Paragraph((new Chunk("Security Bank                                         "   + day + "/" + (month + 1) + "/" + year, FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD)))));
 document.add(new Paragraph("Secure Bank Management System"));
 document.add(new Paragraph("*************************************************************************************************"));
PdfPTable table=new PdfPTable(2);
PdfPCell cell = new PdfPCell (new Paragraph ("Account Information Details"));
cell.setColspan (8);
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
cell.setBackgroundColor(BaseColor.GREEN);
cell.setPadding (10.0f);
table.addCell (cell);
cell = new PdfPCell (new Paragraph ("FIELD"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
cell.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell.setPadding (10.0f);
table.addCell (cell);
cell = new PdfPCell (new Paragraph ("Details"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
cell.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell.setPadding (10.0f);
table.addCell (cell);
table.addCell("Name");
table.addCell(admin_name.getText());
table.addCell("Balance");
table.addCell(admin_balance.getText());
table.addCell("Sex");
table.addCell(admin_sex.getSelectedItem().toString());
table.addCell("Age");
table.addCell(admin_age.getText());
table.addCell("Address");
table.addCell(admin_address.getText());
table.addCell("City");
table.addCell(admin_city.getText());
table.addCell("Postal Code");
table.addCell(admin_postal.getText());
table.addCell("Phone");
table.addCell(admin_phone.getText());
table.addCell("Email");
table.addCell(admin_email.getText());
table.addCell("National ID");
table.addCell(admin_nid.getText());
table.addCell("Account Type");
table.addCell(admin_acc_type.getSelectedItem().toString());


document.add(table);

        
    document.add(new Paragraph(""));   
document.add(new Paragraph("© 2016-2017 Security Bank. All right reserved."));
  



      //  document.add(new Paragraph(new Date().toString()));
       
document.close(); 
     JOptionPane.showMessageDialog(null, "Report Saved");
     
     } catch (Exception e)                    //catch any exceptions here
       {
            JOptionPane.showMessageDialog(null,"Not Saved");  //print the error
       }
        
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void admin_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_editActionPerformed
        // TODO add your handling code here:

    

String sql="UPDATE admin_detail SET name = ?, balance = ?, sex = ?, age = ?, address = ?, city = ?, postal = ?, phone = ?, password = ?, nid = ?, acc_type = ?, image = ? WHERE  email = ?";
         try{
    pst =conn.prepareStatement(sql);
    pst.setString(1, admin_name.getText());
    pst.setString(2, admin_balance.getText());
    pst.setString(3, admin_sex.getSelectedItem().toString());
    pst.setString(4, admin_age.getText());
     pst.setString(5, admin_address.getText());
    pst.setString(6, admin_city.getText());
    pst.setString(7, admin_postal.getText());
    pst.setString(8, admin_phone.getText());
     pst.setString(9, admin_password.getText());
     pst.setString(10, admin_nid.getText());
     pst.setString(11, admin_acc_type.getSelectedItem().toString());
     pst.setBytes(12, admin_image);
     pst.setString(13, admin_email.getText());
   
   
    
   // rs=pst.executeQuery()txt_dob;
    pst.execute();
    adminupdate();
    JOptionPane.showMessageDialog(null, "Updated");
    //administrator_windows_JForm s = new administrator_windows_JForm();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
               }
    }//GEN-LAST:event_admin_editActionPerformed

    private void admin_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_attachActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        filename=f.getAbsolutePath();
        admin_image_path.setText(filename);
        
        try {
            File image = new File (filename);
            FileInputStream fis=new FileInputStream(image);
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1; ){
                
                bos.write(buf,0,readNum);
            }
            
            admin_image=bos.toByteArray();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, image);
        }
    }//GEN-LAST:event_admin_attachActionPerformed

    private void admin_update_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_update_balanceActionPerformed
        // TODO add your handling code here:
        String transaction = (admin_transaction_type.getSelectedItem().toString());
            //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        try{
                                String sql="Select time, balance  from admin_detail where email = 'shoyshab@gmail.com';";
                              pst =conn.prepareStatement(sql);
                              rs=pst.executeQuery();
                              //pst.execute();
                              if(rs.next()){
                                  double balance =rs.getDouble("balance");
                                  String d0 =rs.getString("time");
                                  loaninterest = Double.parseDouble(loan.getText());
                                  savinginterest = Double.parseDouble(interest.getText());
                                  double rate = savinginterest/100.00;
                              Date d1 = Date.valueOf(d0);
                              Date d2=Date.valueOf(LocalDate.now());
                              //customer_name.setText(name);
                              //System.out.println(balance);
                              try
                                {
                                    double diff = d2.getTime() - d1.getTime();
                                    double diffDays = diff / (24 * 60 * 60 * 1000);
                                    if(rate==0){
                                        finalbalance = balance * (1 + 0.12)*(diffDays/365.0);
                                        
                                    }
                                    else
                                    {
                                    finalbalance = balance * (1 + rate)*(diffDays/365.0);
                                    }
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                              }        
                              }catch(Exception e)
                              {
                                     JOptionPane.showMessageDialog(null, e);

                              }finally {
                          try{
                            rs.close();
                                pst.close();

                            }
                            catch(Exception e) {
                                             }
                                }
                        //interest.setText(" " + Double.toString(finalbalance));
                    
                    if(transaction=="Withdraw") {
                    //String sql="Select  *   from customers_info where email = '"+userid+"';";    
                            
                    try{
                        String admin_balance_update = this.admin_balance_update.getText();
                        finalbalance = finalbalance - Double.valueOf(admin_balance_update);
                        String admin_email = this.admin_email.getText();
                        String sql="UPDATE admin_detail SET balance = '"+Math.round(finalbalance)+"', time=date('now') WHERE  email = '"+admin_email+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            adminupdate();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    try{
                        String sql="INSERT INTO admin_tranc (balance,tranc_type) VALUES (?,?)";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, admin_balance_update.getText());
                           pst.setString(2, transaction);
                            pst.execute();
                            //adminupdate();
                            updateTable();
                            //JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   //JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    }
                    
                    else {
                    try{
                        String admin_balance_update = this.admin_balance_update.getText();
                        finalbalance = finalbalance + Double.valueOf(admin_balance_update);
                        String admin_email = this.admin_email.getText();
                        String sql="UPDATE admin_detail SET balance = '"+Math.round(finalbalance)+"', time=date('now') WHERE  email = '"+admin_email+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            adminupdate();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    try{
                        String sql="INSERT INTO admin_tranc (balance,tranc_type) VALUES (?,?)";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, admin_balance_update.getText());
                           pst.setString(2, transaction);
                            pst.execute();
                            //adminupdate();
                            updateTable();
                            //JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   //JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    }
    }//GEN-LAST:event_admin_update_balanceActionPerformed

    private void admin_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_deleteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_admin_deleteActionPerformed

    private void admin_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_refreshActionPerformed
        // TODO add your handling code here:
        CurrentDate();
        adminupdate();
        updateTable();
    }//GEN-LAST:event_admin_refreshActionPerformed

    private void admin_signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_signoutActionPerformed
        // TODO add your handling code here:
                 try{
                    rs.close();
                        pst.close();
                       conn.close();
                    }
                    catch(Exception e) {
                                     }

                          Login a = new Login();
                      a.setVisible(true);
                      this.dispose();


                     //close();
    }//GEN-LAST:event_admin_signoutActionPerformed

    private void admin_search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_search_buttonActionPerformed
        // TODO add your handling code here:
        try{ 
        String sql="select * from admin_tranc where tranc_type like '%"+admin_tranc_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            admin_tranc.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_admin_search_buttonActionPerformed

    private void admin_tranc_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admin_tranc_searchKeyReleased
        // TODO add your handling code here:
        try{ 
        String sql="select * from admin_tranc where tranc_type like '%"+admin_tranc_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            admin_tranc.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_admin_tranc_searchKeyReleased

    private void staff_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_deleteActionPerformed
        // TODO add your handling code here:
        String sql="delete from staff_info where email=?";
         try{
    pst =conn.prepareStatement(sql);
    pst.setString(1, staff_email.getText());
    
   // rs=pst.executeQuery();
    pst.execute();
    staffnull();
    updatestaffTable();
    JOptionPane.showMessageDialog(null, "Deleted");
    //QueryJFrame s = new QueryJFrame();
    //s.setVisible(true);
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }
    }//GEN-LAST:event_staff_deleteActionPerformed

    private void customer_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_listMouseClicked
        // TODO add your handling code here:
        int row =customer_list.getSelectedRow();
       customer_name.setText(customer_list.getModel().getValueAt(row, 0).toString());
       customer_balance.setText(customer_list.getModel().getValueAt(row, 1).toString());
       customer_sex.setSelectedItem(customer_list.getModel().getValueAt(row, 2).toString());
       customer_age.setText(customer_list.getModel().getValueAt(row, 3).toString());
       customer_address.setText(customer_list.getModel().getValueAt(row, 4).toString());
       customer_city.setText(customer_list.getModel().getValueAt(row, 5).toString());
       customer_postal.setText(customer_list.getModel().getValueAt(row, 6).toString());
       customer_phone.setText(customer_list.getModel().getValueAt(row, 7).toString());
       customer_email.setText(customer_list.getModel().getValueAt(row, 8).toString());
       customer_email.setEditable(false);
       customer_password.setText(customer_list.getModel().getValueAt(row, 9).toString());
       //customer_image_preview.setBytes(customer_list.getModel().getValueAt(row, 11).toString());
       customer_nid.setText(customer_list.getModel().getValueAt(row, 12).toString());
       customer_acc_type.setSelectedItem(customer_list.getModel().getValueAt(row, 13).toString());
       String sql="Select * from customers_info where email = '"+customer_list.getModel().getValueAt(row, 8).toString()+"'";
     
        try{
          pst =conn.prepareStatement(sql);
          rs=pst.executeQuery();
          //pst.execute();
          if(rs.next()){
          byte[] imagedata =rs.getBytes("image");
          format  = new ImageIcon(imagedata);
          customer_image_preview.setIcon(format);
          }
        }
                catch(Exception e)
            {
                   JOptionPane.showMessageDialog(null, e);

            }finally {
        try{
          rs.close();
              pst.close();

          }
          catch(Exception e) {
                           }
              }
       
    }//GEN-LAST:event_customer_listMouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void customer_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_searchKeyPressed
        // TODO add your handling code here:
        try{ 
        String sql="select * from customers_info where name like '%"+customer_search.getText()+"%' or sex like '%"+customer_search.getText()+"%' or acc_type like '%"+customer_search.getText()+"%' or city like '%"+customer_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_list.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_customer_searchKeyPressed

    private void customer_search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_search_buttonActionPerformed
        // TODO add your handling code here:
        try{ 
        String sql="select * from customers_info where name like '%"+customer_search.getText()+"%' or sex like '%"+customer_search.getText()+"%' or acc_type like '%"+customer_search.getText()+"%' or city like '%"+customer_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());



            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_list.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_customer_search_buttonActionPerformed

    private void customer_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_updateActionPerformed
        // TODO add your handling code here:
        String sql="UPDATE customers_info SET name = ?, balance = ?, sex = ?, age = ?, address = ?, city = ?, postal = ?, phone = ?, password = ?, nid = ?, acc_type = ?, image = ? WHERE  email = ?";
         try{
                pst =conn.prepareStatement(sql);
                pst.setString(1, customer_name.getText());
                pst.setString(2, customer_balance.getText());
                pst.setString(3, customer_sex.getSelectedItem().toString());
                pst.setString(4, customer_age.getText());
                 pst.setString(5, customer_address.getText());
                pst.setString(6, customer_city.getText());
                pst.setString(7, customer_postal.getText());
                pst.setString(8, customer_phone.getText());
                 pst.setString(9, customer_password.getText());
                 pst.setString(10, customer_nid.getText());
                 pst.setString(11, customer_acc_type.getSelectedItem().toString());
                 pst.setBytes(12, customer_image);
                 pst.setString(13, customer_email.getText());
                  //updatecustomerTable();
   
    
   // rs=pst.executeQuery()txt_dob;
    pst.execute();
    //adminupdate();
    updatecustomerTable();
    JOptionPane.showMessageDialog(null, "Updated");
    //administrator_windows_JForm s = new administrator_windows_JForm();
    //s.setVisible(true);
    
    customernull();
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
               }
    }//GEN-LAST:event_customer_updateActionPerformed

    private void customer_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_attachActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        filename=f.getAbsolutePath();
        customer_image_path.setText(filename);
        
        try {
            File customer_image_preview = new File (filename);
            FileInputStream fis=new FileInputStream(customer_image_preview);
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1; ){
                
                bos.write(buf,0,readNum);
            }
            
            customer_image=bos.toByteArray();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, customer_image_preview);
        }
    }//GEN-LAST:event_customer_attachActionPerformed

    private void loan_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_attachActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        filename=f.getAbsolutePath();
        loan_image_path.setText(filename);
        
        try {
            File loan_image_preview = new File (filename);
            FileInputStream fis=new FileInputStream(loan_image_preview);
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1; ){
                
                bos.write(buf,0,readNum);
            }
            
            loan_image=bos.toByteArray();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, loan_image_preview);
        }
    }//GEN-LAST:event_loan_attachActionPerformed

    private void staff_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_attachActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        filename=f.getAbsolutePath();
        staff_image_path.setText(filename);
        
        try {
            File staff_image_preview = new File (filename);
            FileInputStream fis=new FileInputStream(staff_image_preview);
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1; ){
                
                bos.write(buf,0,readNum);
            }
            
            staff_image=bos.toByteArray();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, staff_image_preview);
        }
    }//GEN-LAST:event_staff_attachActionPerformed

    private void customer_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_addActionPerformed
        // TODO add your handling code here:
        String sql="INSERT INTO customers_info (name,balance,sex,age,address,city,postal,phone,email,password,nid,acc_type,image,checkbook) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
         try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, customer_name.getText());
            pst.setString(2, customer_balance.getText());
            pst.setString(3, customer_sex.getSelectedItem().toString());
            pst.setString(4, customer_age.getText());
             pst.setString(5, customer_address.getText());
            pst.setString(6, customer_city.getText());
            pst.setString(7, customer_postal.getText());
            pst.setString(8, customer_phone.getText());
            pst.setString(9, customer_email.getText());
             pst.setString(10, customer_password.getText());
             pst.setString(11, customer_nid.getText());
             pst.setString(12, customer_acc_type.getSelectedItem().toString());
             pst.setBytes(13, customer_image);
             //pst.setString(13, customer_email.getText());
                
    
   // rs=pst.executeQuery()txt_dob;
    pst.execute();
    //adminupdate();
    updatecustomerTable();
    customernull();
    JOptionPane.showMessageDialog(null, "Add New Customer");
    //administrator_windows_JForm s = new administrator_windows_JForm();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
            try{
              rs.close();
                  pst.close();
                // conn.close();
              }
              catch(Exception e) {
                               }
               }
    }//GEN-LAST:event_customer_addActionPerformed

    private void customer_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_deleteActionPerformed
        // TODO add your handling code here:
        String sql="delete from customers_info where email=?";
         try{
    pst =conn.prepareStatement(sql);
    pst.setString(1, customer_email.getText());
    
   // rs=pst.executeQuery();
    pst.execute();
    customernull();
    updatecustomerTable();
    JOptionPane.showMessageDialog(null, "Deleted");
    //QueryJFrame s = new QueryJFrame();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }
    }//GEN-LAST:event_customer_deleteActionPerformed

    private void customer_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_refreshActionPerformed
        // TODO add your handling code here:
                updatecustomerTable();
                customernull();
    }//GEN-LAST:event_customer_refreshActionPerformed

    private void customer_balance_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_balance_updateActionPerformed
        // TODO add your handling code here:
        String transaction = (customer_transaction_type.getSelectedItem().toString());

                    try{
                                String sql="Select time, balance  from customers_info where email = '"+customer_email.getText()+"';";
                              pst =conn.prepareStatement(sql);
                              rs=pst.executeQuery();
                              //pst.execute();
                              if(rs.next()){
                                  
                                  double balance =rs.getDouble("balance");
                                  String d0 =rs.getString("time");
                                  loaninterest = Double.parseDouble(loan.getText());
                                  savinginterest = Double.parseDouble(interest.getText());
                                  double rate = savinginterest/100.00;
                              Date d1 = Date.valueOf(d0);
                              Date d2=Date.valueOf(LocalDate.now());
                              //customer_name.setText(name);
                              try
                                {
                                    double diff = d2.getTime() - d1.getTime();
                                    double diffDays = diff / (24 * 60 * 60 * 1000);
                                    if(rate==0){
                                        finalbalance = balance * (1 + 0.12)*(diffDays/365.0);
                                        
                                    }
                                    else
                                    {
                                    finalbalance = balance * (1 + rate)*(diffDays/365.0);
                                    }
                                    
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                              }        
                              }catch(Exception e)
                              {
                                     JOptionPane.showMessageDialog(null, e);

                              }finally {
                          try{
                            rs.close();
                                pst.close();

                            }
                            catch(Exception e) {
                                             }
                                }
                    if(transaction=="Withdraw") {
                    
                    try{
                        String sql="INSERT INTO cus_tranc (username,balance,types) VALUES (?,?,?)";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, customer_email.getText());
                           pst.setString(2, customer_update_amount.getText());
                           pst.setString(3, transaction);
                            pst.execute();
                            //adminupdate();
                            updatecustomerTable();
                            //customernull();
                            //JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    try{
                        String customer_balance_update = customer_update_amount.getText();
                        String customeremail = customer_email.getText();
                        finalbalance = finalbalance - Double.valueOf(customer_balance_update);
                        String sql="UPDATE customers_info SET balance = '"+Math.round(finalbalance)+"', time = date('now') WHERE  email = '"+customeremail+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            updatecustomerTable();
                            customernull();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    }
                    
                    else {
                    
                    try{
                        String sql="INSERT INTO cus_tranc (username,balance,types) VALUES (?,?,?)";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, customer_email.getText());
                           pst.setString(2, customer_update_amount.getText());
                           pst.setString(3, transaction);
                            pst.execute();
                            //adminupdate();
                            updatecustomerTable();
                            //customernull();
                            //JOptionPane.showMessageDialog(null, "Inserted");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    try{
                        String customer_balance_update = customer_update_amount.getText();
                        String customeremail = customer_email.getText();
                        finalbalance = finalbalance + Double.valueOf(customer_balance_update);
                        String sql="UPDATE customers_info SET balance = '"+Math.round(finalbalance)+"', time = date('now') WHERE  email = '"+customeremail+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            updatecustomerTable();
                            customernull();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    }
    }//GEN-LAST:event_customer_balance_updateActionPerformed

    private void loan_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_addActionPerformed
        // TODO add your handling code here:
        String sql="INSERT INTO loan_info (name,loan,sex,age,address,city,postal,phone,email,password,nid,acc_type,image,checkbook) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
         try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, loan_name.getText());
            pst.setString(2, loan_balance.getText());
            pst.setString(3, loan_sex.getSelectedItem().toString());
            pst.setString(4, loan_age.getText());
             pst.setString(5, loan_address.getText());
            pst.setString(6, loan_city.getText());
            pst.setString(7, loan_postal.getText());
            pst.setString(8, loan_phone.getText());
            pst.setString(9, loan_email.getText());
             pst.setString(10, loan_password.getText());
             pst.setString(11, loan_nid.getText());
             pst.setString(12, loan_acc_type.getSelectedItem().toString());
             pst.setBytes(13, loan_image);
             //pst.setString(13, loan_email.getText());
                
    
   // rs=pst.executeQuery()txt_dob;
    pst.execute();
    //adminupdate();
    updateloanTable();
    loannull();
    JOptionPane.showMessageDialog(null, "Add New Customer");
    //administrator_windows_JForm s = new administrator_windows_JForm();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
            try{
              rs.close();
                  pst.close();
                // conn.close();
              }
              catch(Exception e) {
                               }
               }
    }//GEN-LAST:event_loan_addActionPerformed

    private void loan_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loan_listMouseClicked
        // TODO add your handling code here:
        int row =loan_list.getSelectedRow();
       loan_name.setText(loan_list.getModel().getValueAt(row, 0).toString());
       loan_balance.setText(loan_list.getModel().getValueAt(row, 1).toString());
       loan_sex.setSelectedItem(loan_list.getModel().getValueAt(row, 2).toString());
       loan_age.setText(loan_list.getModel().getValueAt(row, 3).toString());
       loan_address.setText(loan_list.getModel().getValueAt(row, 4).toString());
       loan_city.setText(loan_list.getModel().getValueAt(row, 5).toString());
       loan_postal.setText(loan_list.getModel().getValueAt(row, 6).toString());
       loan_phone.setText(loan_list.getModel().getValueAt(row, 7).toString());
       loan_email.setText(loan_list.getModel().getValueAt(row, 8).toString());
       loan_email.setEditable(false);
       loan_password.setText(loan_list.getModel().getValueAt(row, 9).toString());
       //loan_image_preview.setBytes(loan_list.getModel().getValueAt(row, 11).toString());
       loan_nid.setText(loan_list.getModel().getValueAt(row, 12).toString());
       loan_acc_type.setSelectedItem(loan_list.getModel().getValueAt(row, 13).toString());
       String sql="Select * from loan_info where email = '"+loan_list.getModel().getValueAt(row, 8).toString()+"'";
     
        try{
          pst =conn.prepareStatement(sql);
          rs=pst.executeQuery();
          //pst.execute();
          if(rs.next()){
          byte[] imagedata =rs.getBytes("image");
          format  = new ImageIcon(imagedata);
          loan_image_preview.setIcon(format);
          }
        }
                catch(Exception e)
            {
                   JOptionPane.showMessageDialog(null, e);

            }finally {
        try{
          rs.close();
              pst.close();

          }
          catch(Exception e) {
                           }
              }
    }//GEN-LAST:event_loan_listMouseClicked

    private void loan_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loan_searchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_loan_searchKeyPressed

    private void loan_search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_search_buttonActionPerformed
        // TODO add your handling code here:
        try{ 
        String sql="select * from loan_info where name like '%"+loan_search.getText()+"%' or sex like '%"+loan_search.getText()+"%' or acc_type like '%"+loan_search.getText()+"%' or city like '%"+loan_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());



            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            loan_list.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_loan_search_buttonActionPerformed

    private void loan_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_updateActionPerformed
        // TODO add your handling code here:
        String sql="UPDATE loan_info SET name = ?, loan = ?, sex = ?, age = ?, address = ?, city = ?, postal = ?, phone = ?, password = ?, nid = ?, acc_type = ?, image = ? WHERE  email = ?";
         try{
                pst =conn.prepareStatement(sql);
                pst.setString(1, loan_name.getText());
                pst.setString(2, loan_balance.getText());
                pst.setString(3, loan_sex.getSelectedItem().toString());
                pst.setString(4, loan_age.getText());
                 pst.setString(5, loan_address.getText());
                pst.setString(6, loan_city.getText());
                pst.setString(7, loan_postal.getText());
                pst.setString(8, loan_phone.getText());
                 pst.setString(9, loan_password.getText());
                 pst.setString(10, loan_nid.getText());
                 pst.setString(11, loan_acc_type.getSelectedItem().toString());
                 pst.setBytes(12, loan_image);
                 pst.setString(13, loan_email.getText());
                  //updateloanTable();
   
    
   // rs=pst.executeQuery()txt_dob;
    pst.execute();
    //adminupdate();
                updateloanTable();
                loannull();
    JOptionPane.showMessageDialog(null, "Updated");
    //administrator_windows_JForm s = new administrator_windows_JForm();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
            try{
              rs.close();
                  pst.close();
                // conn.close();
              }
              catch(Exception e) {
                               }
               }
    }//GEN-LAST:event_loan_updateActionPerformed

    private void loan_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_deleteActionPerformed
        // TODO add your handling code here:
        String sql="delete from loan_info where email=?";
         try{
    pst =conn.prepareStatement(sql);
    pst.setString(1, loan_email.getText());
    
   // rs=pst.executeQuery();
    pst.execute();
    loannull();
    updateloanTable();
    JOptionPane.showMessageDialog(null, "Deleted");
    //QueryJFrame s = new QueryJFrame();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
        try{
          rs.close();
              pst.close();
             //conn.close();
          }
          catch(Exception e) {
                           }
      }
    }//GEN-LAST:event_loan_deleteActionPerformed

    private void loan_update_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_update_balanceActionPerformed
        // TODO add your handling code here:
        
        String transaction = (loan_transaction_type.getSelectedItem().toString());
                    try{
                                String sql="Select time, loan  from loan_info where email = '"+loan_email.getText()+"';";
                              pst =conn.prepareStatement(sql);
                              rs=pst.executeQuery();
                              //pst.execute();
                              if(rs.next()){
                                  double balance =rs.getDouble("loan");
                                  String d0 =rs.getString("time");
                                  loaninterest = Double.parseDouble(loan.getText());
                                  savinginterest = Double.parseDouble(interest.getText());
                                  double rate = loaninterest/100.00;
                              Date d1 = Date.valueOf(d0);
                              Date d2=Date.valueOf(LocalDate.now());
                              //customer_name.setText(name);
                              try
                                {
                                    double diff = d2.getTime() - d1.getTime();
                                    double diffDays = diff / (24 * 60 * 60 * 1000);
                                    if(rate==0){
                                        if(rate==0){
                                        finalbalance = balance * (1 + 0.25)*(diffDays/365.0);
                                        
                                    }
                                    else
                                    {
                                    finalbalance = balance * (1 + rate)*(diffDays/365.0);
                                    }
                                    }
                                    
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                              }        
                              }catch(Exception e)
                              {
                                     JOptionPane.showMessageDialog(null, e);

                              }finally {
                          try{
                            rs.close();
                                pst.close();

                            }
                            catch(Exception e) {
                                             }
                                }
         
                    if(transaction=="Withdraw") {
                        
                        try{
                        String sql="INSERT INTO loan_tranc (email,balance,types) VALUES (?,?,?)";
                    //INSERT INTO "main"."loan_tranc" ("username","balance","types") VALUES (?1,?2,?3)
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, loan_email.getText());
                           pst.setString(2, loan_update_amount.getText());
                           pst.setString(3, transaction);
                            pst.execute();
                            //adminupdate();
                            updateloanTable();
                            //loannull();
                            //JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                        
                    try{
                        String loan_balance_update = loan_update_amount.getText();
                        String loanemail = loan_email.getText();
                        finalbalance = finalbalance + Double.valueOf(loan_balance_update);
                        String sql="UPDATE loan_info SET loan = '"+Math.round(finalbalance)+"', time = date('now') WHERE  email = '"+loanemail+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            updateloanTable();
                            loannull();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    
                    }
                    
                    else {
                    
                    try{
                        String sql="INSERT INTO loan_tranc (email,balance,types) VALUES (?,?,?)";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, loan_email.getText());
                           pst.setString(2, loan_update_amount.getText());
                           pst.setString(3, transaction);
                            pst.execute();
                            //adminupdate();
                            updateloanTable();
                            loannull();
                            //JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    try{
                        String loan_balance_update = loan_update_amount.getText();
                        String loanemail = loan_email.getText();
                        finalbalance = finalbalance - Double.valueOf(loan_balance_update);
                        String sql="UPDATE loan_info SET loan = '"+Math.round(finalbalance)+"', time = date('now') WHERE  email = '"+loanemail+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            updateloanTable();
                            loannull();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                             // pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    }
    }//GEN-LAST:event_loan_update_balanceActionPerformed

    private void loan_transaction_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_transaction_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loan_transaction_typeActionPerformed

    private void loan_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loan_refreshActionPerformed
        // TODO add your handling code here:
        updateloanTable();
        loannull();
    }//GEN-LAST:event_loan_refreshActionPerformed

    private void jScrollPane4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane4KeyPressed

    private void staff_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_staff_searchKeyReleased
        // TODO add your handling code here:
        try{ 
        String sql="select * from staff_info where name like '%"+staff_search.getText()+"%' or sex like '%"+staff_search.getText()+"%' or acc_type like '%"+staff_search.getText()+"%' or city like '%"+staff_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());



            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            staff_list.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_staff_searchKeyReleased

    private void staff_search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_search_buttonActionPerformed
        // TODO add your handling code here:
        try{ 
        String sql="select * from staff_info where name like '%"+staff_search.getText()+"%' or sex like '%"+staff_search.getText()+"%' or acc_type like '%"+staff_search.getText()+"%' or city like '%"+staff_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());



            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            staff_list.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_staff_search_buttonActionPerformed

    private void staff_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_addActionPerformed
        // TODO add your handling code here:
        String sql="INSERT INTO staff_info (name,balance,sex,age,address,city,postal,phone,email,password,nid,acc_type,image,position,checkbook) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
         try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, staff_name.getText());
            pst.setString(2, staff_balance.getText());
            pst.setString(3, staff_sex.getSelectedItem().toString());
            pst.setString(4, staff_age.getText());
             pst.setString(5, staff_address.getText());
            pst.setString(6, staff_city.getText());
            pst.setString(7, staff_postal.getText());
            pst.setString(8, staff_phone.getText());
            pst.setString(9, staff_email.getText());
             pst.setString(10, staff_password.getText());
             pst.setString(11, staff_nid.getText());
             pst.setString(12, staff_acc_type.getSelectedItem().toString());
             pst.setBytes(13, staff_image);
             pst.setString(14, staff_position.getSelectedItem().toString());
             //pst.setString(13, staff_email.getText());
                
    
   // rs=pst.executeQuery()txt_dob;
    pst.execute();
    //adminupdate();
    updatestaffTable();
    staffnull();
    JOptionPane.showMessageDialog(null, "Add New Customer");
    //administrator_windows_JForm s = new administrator_windows_JForm();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
            try{
              rs.close();
                  pst.close();
                // conn.close();
              }
              catch(Exception e) {
                               }
               }
    }//GEN-LAST:event_staff_addActionPerformed

    private void staff_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_updateActionPerformed
        // TODO add your handling code here:
        String sql="UPDATE staff_info SET name = ?, balance = ?, sex = ?, age = ?, address = ?, city = ?, postal = ?, phone = ?, password = ?, nid = ?, acc_type = ?, image = ?, position = ? WHERE  email = ?";
         try{
                pst =conn.prepareStatement(sql);
                pst.setString(1, staff_name.getText());
                pst.setString(2, staff_balance.getText());
                pst.setString(3, staff_sex.getSelectedItem().toString());
                pst.setString(4, staff_age.getText());
                 pst.setString(5, staff_address.getText());
                pst.setString(6, staff_city.getText());
                pst.setString(7, staff_postal.getText());
                pst.setString(8, staff_phone.getText());
                 pst.setString(9, staff_password.getText());
                 pst.setString(10, staff_nid.getText());
                 pst.setString(11, staff_acc_type.getSelectedItem().toString());
                 pst.setBytes(12, staff_image);
                 pst.setString(13, staff_email.getText());
                 pst.setString(12, staff_position.getSelectedItem().toString());
                  //updatestaffTable();
   
    
   // rs=pst.executeQuery()txt_dob;
    pst.execute();
    //adminupdate();
    updatestaffTable();
    JOptionPane.showMessageDialog(null, "Updated");
    //administrator_windows_JForm s = new administrator_windows_JForm();
    //s.setVisible(true);
    
    staffnull();
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
      pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
               }
    }//GEN-LAST:event_staff_updateActionPerformed

    private void customer_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_searchActionPerformed

    private void staff_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_refreshActionPerformed
        // TODO add your handling code here:
        updatestaffTable();
        staffnull();
    }//GEN-LAST:event_staff_refreshActionPerformed

    private void staff_image_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_image_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staff_image_pathActionPerformed

    private void staff_update_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_update_balanceActionPerformed
        // TODO add your handling code here:
        String transaction = (staff_transaction_type.getSelectedItem().toString());
        
                    try{
                                String sql="Select time, balance  from staff_info where email = '"+staff_email.getText()+"';";
                              pst =conn.prepareStatement(sql);
                              rs=pst.executeQuery();
                              //pst.execute();
                              if(rs.next()){
                                  double balance =rs.getDouble("balance");
                                  String d0 =rs.getString("time");
                                  loaninterest = Double.parseDouble(loan.getText());
                                  savinginterest = Double.parseDouble(interest.getText());
                                  double rate = savinginterest/100.00;
                              Date d1 = Date.valueOf(d0);
                              Date d2=Date.valueOf(LocalDate.now());
                              //customer_name.setText(name);
                              try
                                {
                                    double diff = d2.getTime() - d1.getTime();
                                    double diffDays = diff / (24 * 60 * 60 * 1000);
                                    if(rate==0){
                                        finalbalance = balance * (1 + 0.12)*(diffDays/365.0);
                                        
                                    }
                                    else
                                    {
                                    finalbalance = balance * (1 + rate)*(diffDays/365.0);
                                    }
                                    
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                              }        
                              }catch(Exception e)
                              {
                                     JOptionPane.showMessageDialog(null, e);

                              }finally {
                          try{
                            rs.close();
                                pst.close();

                            }
                            catch(Exception e) {
                                             }
                                }
         
                    if(transaction=="Withdraw") {
                    
                    try{
                        String sql="INSERT INTO staff_tranc (username,balance,types) VALUES (?,?,?)";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, staff_email.getText());
                           pst.setString(2, staff_update_amount.getText());
                           pst.setString(3, transaction);
                            pst.execute();
                            //adminupdate();
                            updatestaffTable();
                            staffnull();
                            //JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   //JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    
                    try{
                        String staff_balance_update = staff_update_amount.getText();
                        String staffemail = staff_email.getText();
                        finalbalance = finalbalance - Double.valueOf(staff_balance_update);
                        String sql="UPDATE staff_info SET balance = '"+Math.round(finalbalance)+"', time = date('now') WHERE  email = '"+staffemail+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            updatestaffTable();
                            //staffnull();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    
                    }
                    
                    else {
                    
                    try{
                        String sql="INSERT INTO staff_tranc (username,balance,types) VALUES (?,?,?)";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                           pst.setString(1, staff_email.getText());
                           pst.setString(2, staff_update_amount.getText());
                           pst.setString(3, transaction);
                            pst.execute();
                            //adminupdate();
                            updatestaffTable();
                            //staffnull();
                            //JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   //JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    try{
                        String staff_balance_update = this.staff_update_amount.getText();
                        String staffemail = this.staff_email.getText();
                        finalbalance = finalbalance + Double.valueOf(staff_balance_update);
                        String sql="UPDATE staff_info SET balance = '"+Math.round(finalbalance)+"', time = date('now') WHERE  email = '"+staffemail+"'";
                    
                           // rs=pst.executeQuery()txt_dob;
                           pst =conn.prepareStatement(sql);
                            pst.execute();
                            updatestaffTable();
                            staffnull();
                            //updateTable();
                            JOptionPane.showMessageDialog(null, "Updated");
                            //administrator_windows_JForm s = new administrator_windows_JForm();
                            //s.setVisible(true);
                            }catch(Exception e)
                            {
                                   JOptionPane.showMessageDialog(null, e);

                            }finally {
                        try{
                          rs.close();
                              pst.close();
                            // conn.close();
                          }
                          catch(Exception e) {
                                           }
                                       }
                    
                    
                    }
    }//GEN-LAST:event_staff_update_balanceActionPerformed

    private void loan_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loan_searchKeyReleased
        // TODO add your handling code here:
        try{ 
        String sql="select * from loan_info where name like '%"+loan_search.getText()+"%' or sex like '%"+loan_search.getText()+"%' or acc_type like '%"+loan_search.getText()+"%' or city like '%"+loan_search.getText()+"%' ";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());



            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            loan_list.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_loan_searchKeyReleased

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane5MouseClicked

    private void staff_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staff_listMouseClicked
        // TODO add your handling code here:
        int row =staff_list.getSelectedRow();
       staff_name.setText(staff_list.getModel().getValueAt(row, 0).toString());
       staff_balance.setText(staff_list.getModel().getValueAt(row, 1).toString());
       staff_sex.setSelectedItem(staff_list.getModel().getValueAt(row, 2).toString());
       staff_age.setText(staff_list.getModel().getValueAt(row, 3).toString());
       staff_address.setText(staff_list.getModel().getValueAt(row, 4).toString());
       staff_city.setText(staff_list.getModel().getValueAt(row, 5).toString());
       staff_postal.setText(staff_list.getModel().getValueAt(row, 6).toString());
       staff_phone.setText(staff_list.getModel().getValueAt(row, 7).toString());
       staff_email.setText(staff_list.getModel().getValueAt(row, 8).toString());
       staff_email.setEditable(false);
       staff_password.setText(staff_list.getModel().getValueAt(row, 9).toString());
       //staff_image_preview.setBytes(staff_list.getModel().getValueAt(row, 11).toString());
       staff_nid.setText(staff_list.getModel().getValueAt(row, 12).toString());
       staff_acc_type.setSelectedItem(staff_list.getModel().getValueAt(row, 13).toString());
       staff_position.setSelectedItem(staff_list.getModel().getValueAt(row, 14).toString());
       String sql="Select * from staff_info where email = '"+staff_list.getModel().getValueAt(row, 8).toString()+"'";
     
        try{
          pst =conn.prepareStatement(sql);
          rs=pst.executeQuery();
          //pst.execute();
          if(rs.next()){
          byte[] imagedata =rs.getBytes("image");
          format  = new ImageIcon(imagedata);
          staff_image_preview.setIcon(format);
          }
        }
                catch(Exception e)
            {
                   JOptionPane.showMessageDialog(null, e);

            }finally {
        try{
          rs.close();
              pst.close();

          }
          catch(Exception e) {
                           }
              }
    }//GEN-LAST:event_staff_listMouseClicked

    private void admin_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_printActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Security Bank");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try {
            admin_tranc.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true, null);
            //table.print(JTable.PrintMode.FIT_WIDTH, header, null);
           // jTable1_pumpdata.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }  finally {
try{
  rs.close();
      pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      } 
    }//GEN-LAST:event_admin_printActionPerformed

    private void customer_request_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_request_searchKeyReleased
        // TODO add your handling code here:
        try{ 
        String sql="select name,email,checkbook,card from customers_info where name like '%"+customer_request_search.getText()+"%' or email like '%"+customer_request_search.getText()+"%' and checkbook is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from customers_info where name like '%"+customer_request_search.getText()+"%' or email like '%"+customer_request_search.getText()+"%' and card is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        
        try{ 
        String sql="select name,email,checkbook,card from staff_info where name like '%"+customer_request_search.getText()+"%' or email like '%"+customer_request_search.getText()+"%' and checkbook is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from staff_info where name like '%"+customer_request_search.getText()+"%' or email like '%"+customer_request_search.getText()+"%' and card is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            customer_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_customer_request_searchKeyReleased

    private void customer_request_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_request_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_request_searchActionPerformed

    private void loan_request_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loan_request_searchKeyReleased
        // TODO add your handling code here:
        try{ 
        String sql="select name,email,checkbook,card from loan_info where name like '%"+loan_request_search.getText()+"%' or email like '%"+loan_request_search.getText()+"%' and checkbook is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            loan_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from loan_info where name like '%"+loan_request_search.getText()+"%' or email like '%"+loan_request_search.getText()+"%' and card is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            loan_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_loan_request_searchKeyReleased

    private void staff_request_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_staff_request_searchKeyReleased
        // TODO add your handling code here:
        try{ 
        String sql="select name,email,checkbook,card from staff_info where name like '%"+staff_request_search.getText()+"%' or email like '%"+staff_request_search.getText()+"%' and checkbook is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            staff_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
        try{ 
        String sql="select name,email,checkbook,card from staff_info where name like '%"+staff_request_search.getText()+"%' or email like '%"+staff_request_search.getText()+"%' and card is not null";
   
            pst =conn.prepareStatement(sql);
            //pst.setString(1,admin_tranc_search.getText());
            //pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //pst.execute();
            staff_request.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
                {
                       JOptionPane.showMessageDialog(null, e);

                }finally {
            try{
              rs.close();
                  pst.close();

              }
              catch(Exception e) {
                               }
                  }
    }//GEN-LAST:event_staff_request_searchKeyReleased

    private void customer_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_requestMouseClicked
        // TODO add your handling code here:
        int row =customer_request.getSelectedRow();
       acc_holder.setText(customer_request.getModel().getValueAt(row, 0).toString());
       acc_email.setText(customer_request.getModel().getValueAt(row, 1).toString());
       checkbook.setText(customer_request.getModel().getValueAt(row, 2).toString());
       card.setText(customer_request.getModel().getValueAt(row, 3).toString());
       acc_email.setEditable(false);
    }//GEN-LAST:event_customer_requestMouseClicked

    private void loan_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loan_requestMouseClicked
        // TODO add your handling code here:
        int row =loan_request.getSelectedRow();
       acc_holder.setText(loan_request.getModel().getValueAt(row, 0).toString());
       acc_email.setText(loan_request.getModel().getValueAt(row, 1).toString());
       checkbook.setText(loan_request.getModel().getValueAt(row, 2).toString());
       card.setText(loan_request.getModel().getValueAt(row, 3).toString());
       acc_email.setEditable(false);
    }//GEN-LAST:event_loan_requestMouseClicked

    private void staff_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staff_requestMouseClicked
        // TODO add your handling code here:
        int row =staff_request.getSelectedRow();
       acc_holder.setText(staff_request.getModel().getValueAt(row, 0).toString());
       acc_email.setText(staff_request.getModel().getValueAt(row, 1).toString());
       checkbook.setText(staff_request.getModel().getValueAt(row, 2).toString());
       card.setText(staff_request.getModel().getValueAt(row, 3).toString());
       acc_email.setEditable(false);
    }//GEN-LAST:event_staff_requestMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String sql="UPDATE customers_info SET card = 1,checkbook = 1 WHERE  email = ?";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, acc_email.getText());

            // rs=pst.executeQuery()txt_dob;
            pst.execute();
            request();
            //JOptionPane.showMessageDialog(null, "Updated");
            //administrator_windows_JForm s = new administrator_windows_JForm();
            //s.setVisible(true);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);

        }finally {
            try{
                rs.close();
                pst.close();
                // conn.close();
            }
            catch(Exception e) {
            }
        }
        String sql1="UPDATE loan_info SET card = 1 , checkbook = 1 WHERE  email = ?";
        try{
            pst =conn.prepareStatement(sql1);
            pst.setString(1, acc_email.getText());

            // rs=pst.executeQuery()txt_dob;
            pst.execute();
            request();
            //JOptionPane.showMessageDialog(null, "Updated");
            //administrator_windows_JForm s = new administrator_windows_JForm();
            //s.setVisible(true);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);

        }finally {
            try{
                rs.close();
                pst.close();
                // conn.close();
            }
            catch(Exception e) {
            }
        }
        String sql2="UPDATE staff_info SET card = 1 , checkbook = 1 WHERE  email = ?";
        try{
            pst =conn.prepareStatement(sql2);
            pst.setString(1, acc_email.getText());

            // rs=pst.executeQuery()txt_dob;
            pst.execute();
            request();
            JOptionPane.showMessageDialog(null, "Aproved");
            //administrator_windows_JForm s = new administrator_windows_JForm();
            //s.setVisible(true);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);

        }finally {
            try{
                rs.close();
                pst.close();
                // conn.close();
            }
            catch(Exception e) {
            }
        }
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
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_home().setVisible(true);
            }
        });
    }
    public void CurrentDate(){
  
  Calendar cal = new GregorianCalendar();
  int month = cal.get(Calendar.MONTH);
  int year = cal.get(Calendar.YEAR);
  int day = cal.get(Calendar.DAY_OF_MONTH);
  jMenu3.setText("Current date : "   + day + "/" + (month + 1) + "/" + year);
  //System.out.println("Current date : "  + day + "/" + (month + 1) + "/" + year);
  
     int second = cal.get(Calendar.SECOND);
     int minute = cal.get(Calendar.MINUTE);
     int hour = cal.get(Calendar.HOUR);
 Lbl_time.setText("Current time is  "+hour+" : "+minute+" : "+second);
     
      //System.out.println("Current time is  "+hour+" : "+minute+" : "+second);
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Lbl_time;
    private javax.swing.JTextField acc_email;
    private javax.swing.JTextField acc_holder;
    private javax.swing.JComboBox<String> admin_acc_type;
    private javax.swing.JTextField admin_address;
    private javax.swing.JTextField admin_age;
    private javax.swing.JButton admin_attach;
    private javax.swing.JTextField admin_balance;
    private javax.swing.JTextField admin_balance_update;
    private javax.swing.JTextField admin_city;
    private javax.swing.JButton admin_delete;
    private javax.swing.JButton admin_edit;
    private javax.swing.JTextField admin_email;
    private javax.swing.JTextField admin_image_path;
    private javax.swing.JTextField admin_name;
    private javax.swing.JTextField admin_nid;
    private javax.swing.JPasswordField admin_password;
    private javax.swing.JTextField admin_phone;
    private javax.swing.JTextField admin_postal;
    private javax.swing.JButton admin_print;
    private javax.swing.JButton admin_refresh;
    private javax.swing.JButton admin_search_button;
    private javax.swing.JComboBox<String> admin_sex;
    private javax.swing.JButton admin_signout;
    private javax.swing.JTable admin_tranc;
    private javax.swing.JTextField admin_tranc_search;
    private javax.swing.JComboBox<String> admin_transaction_type;
    private javax.swing.JButton admin_update_balance;
    private javax.swing.JLabel card;
    private javax.swing.JLabel checkbook;
    private javax.swing.JComboBox<String> customer_acc_type;
    private javax.swing.JButton customer_add;
    private javax.swing.JTextField customer_address;
    private javax.swing.JTextField customer_age;
    private javax.swing.JButton customer_attach;
    private javax.swing.JTextField customer_balance;
    private javax.swing.JButton customer_balance_update;
    private javax.swing.JTextField customer_city;
    private javax.swing.JButton customer_delete;
    private javax.swing.JTextField customer_email;
    private javax.swing.JTextField customer_image_path;
    private javax.swing.JLabel customer_image_preview;
    private javax.swing.JTable customer_list;
    private javax.swing.JTextField customer_name;
    private javax.swing.JTextField customer_nid;
    private javax.swing.JPasswordField customer_password;
    private javax.swing.JTextField customer_phone;
    private javax.swing.JTextField customer_postal;
    private javax.swing.JButton customer_refresh;
    private javax.swing.JTable customer_request;
    private javax.swing.JTable customer_request1;
    private javax.swing.JTextField customer_request_search;
    private javax.swing.JTextField customer_search;
    private javax.swing.JButton customer_search_button;
    private javax.swing.JComboBox<String> customer_sex;
    private javax.swing.JComboBox<String> customer_transaction_type;
    private javax.swing.JButton customer_update;
    private javax.swing.JTextField customer_update_amount;
    private javax.swing.JLabel image;
    private javax.swing.JFormattedTextField interest;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JFormattedTextField loan;
    private javax.swing.JComboBox<String> loan_acc_type;
    private javax.swing.JButton loan_add;
    private javax.swing.JTextField loan_address;
    private javax.swing.JTextField loan_age;
    private javax.swing.JButton loan_attach;
    private javax.swing.JTextField loan_balance;
    private javax.swing.JTextField loan_city;
    private javax.swing.JButton loan_delete;
    private javax.swing.JTextField loan_email;
    private javax.swing.JTextField loan_image_path;
    private javax.swing.JLabel loan_image_preview;
    private javax.swing.JTable loan_list;
    private javax.swing.JTextField loan_name;
    private javax.swing.JTextField loan_nid;
    private javax.swing.JPasswordField loan_password;
    private javax.swing.JTextField loan_phone;
    private javax.swing.JTextField loan_postal;
    private javax.swing.JButton loan_refresh;
    private javax.swing.JTable loan_request;
    private javax.swing.JTable loan_request1;
    private javax.swing.JTextField loan_request_search;
    private javax.swing.JTextField loan_search;
    private javax.swing.JButton loan_search_button;
    private javax.swing.JComboBox<String> loan_sex;
    private javax.swing.JComboBox<String> loan_transaction_type;
    private javax.swing.JButton loan_update;
    private javax.swing.JTextField loan_update_amount;
    private javax.swing.JButton loan_update_balance;
    private javax.swing.JComboBox<String> staff_acc_type;
    private javax.swing.JButton staff_add;
    private javax.swing.JTextField staff_address;
    private javax.swing.JTextField staff_age;
    private javax.swing.JButton staff_attach;
    private javax.swing.JTextField staff_balance;
    private javax.swing.JTextField staff_city;
    private javax.swing.JButton staff_delete;
    private javax.swing.JTextField staff_email;
    private javax.swing.JTextField staff_image_path;
    private javax.swing.JLabel staff_image_preview;
    private javax.swing.JTable staff_list;
    private javax.swing.JTextField staff_name;
    private javax.swing.JTextField staff_nid;
    private javax.swing.JPasswordField staff_password;
    private javax.swing.JTextField staff_phone;
    private javax.swing.JComboBox<String> staff_position;
    private javax.swing.JTextField staff_postal;
    private javax.swing.JButton staff_refresh;
    private javax.swing.JTable staff_request;
    private javax.swing.JTable staff_request1;
    private javax.swing.JTextField staff_request_search;
    private javax.swing.JTextField staff_search;
    private javax.swing.JButton staff_search_button;
    private javax.swing.JComboBox<String> staff_sex;
    private javax.swing.JComboBox<String> staff_transaction_type;
    private javax.swing.JButton staff_update;
    private javax.swing.JTextField staff_update_amount;
    private javax.swing.JButton staff_update_balance;
    // End of variables declaration//GEN-END:variables
private ImageIcon format = null;

String filename=null;
int s=0;
byte[] admin_image = null;
byte[] customer_image = null;
byte[] loan_image = null;
byte[] staff_image = null;

double finalbalance;

double loaninterest;
double savinginterest;
double interestrate;

}
