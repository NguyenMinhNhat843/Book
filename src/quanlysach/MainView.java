/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlysach;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class MainView extends javax.swing.JFrame {
    private final CardLayout card;
    /**
     * Creates new form GUI_home
     */
    
    public MainView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        card = (CardLayout) pnl_main.getLayout();
        
        
//        resize_pnl_main();
//        pnl_main.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                resize_pnl_main();
//            }
//        });
        
        resize_lbl_logo();
        
        // cart
        
        
    }
   
    
//    public void resize_pnl_main() {
//        ImageIcon background_icon = new ImageIcon(getClass().getResource("/images/login_background.jpg"));
//
//        
//        ImageIcon imageIcon = new ImageIcon(background_icon.getImage().getScaledInstance(pnl_main.getWidth(), pnl_main.getHeight(), Image.SCALE_SMOOTH));
//        
//        lbl_background_main.setIcon(imageIcon);
//    }
    
    public void resize_lbl_logo() {
        ImageIcon lbl_logo_icon = new ImageIcon(getClass().getResource("/images/logo_image.png"));
        
        ImageIcon image_logo = new ImageIcon(lbl_logo_icon.getImage().getScaledInstance(pnl_menu.getWidth(), 200, Image.SCALE_SMOOTH));
        lbl_logo.setIcon(image_logo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_menu = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        btn_cart = new javax.swing.JButton();
        btn_product = new javax.swing.JButton();
        btn_customer = new javax.swing.JButton();
        btn_bill = new javax.swing.JButton();
        btn_staff = new javax.swing.JButton();
        btn_inventory = new javax.swing.JButton();
        btn_anylist = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_help = new javax.swing.JButton();
        pnl_right = new javax.swing.JPanel();
        pnl_header = new javax.swing.JPanel();
        lbl_name_NV = new javax.swing.JLabel();
        lbl_type_NV = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        pnl_main = new javax.swing.JPanel();
        pnl_Home = new javax.swing.JPanel();
        pnl_bill = new javax.swing.JPanel();
        pnl_inventory = new javax.swing.JPanel();
        pnl_anylist = new javax.swing.JPanel();
        pnl_cart = new javax.swing.JPanel();
        pnl_customer = new javax.swing.JPanel();
        pnl_staff = new javax.swing.JPanel();
        pnl_product = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("trang chủ");

        pnl_menu.setBackground(new java.awt.Color(0, 0, 0));
        pnl_menu.setPreferredSize(new java.awt.Dimension(200, 688));
        pnl_menu.setLayout(new javax.swing.BoxLayout(pnl_menu, javax.swing.BoxLayout.Y_AXIS));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        lbl_logo.setMaximumSize(new java.awt.Dimension(200, 200));
        lbl_logo.setPreferredSize(new java.awt.Dimension(200, 200));
        pnl_menu.add(lbl_logo);

        btn_home.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-button.png"))); // NOI18N
        btn_home.setText("Trang chủ");
        btn_home.setIconTextGap(8);
        btn_home.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_home.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_home.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_home);

        btn_cart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trolley.png"))); // NOI18N
        btn_cart.setText("Mua sắm");
        btn_cart.setIconTextGap(8);
        btn_cart.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_cart.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_cart.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cartMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_cart);

        btn_product.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
        btn_product.setText("Sản phẩm");
        btn_product.setIconTextGap(8);
        btn_product.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_product.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_product.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_productMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_product);

        btn_customer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        btn_customer.setText("Khách hàng");
        btn_customer.setIconTextGap(8);
        btn_customer.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_customer.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_customer.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_customerMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_customer);

        btn_bill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        btn_bill.setText("Hóa đơn");
        btn_bill.setIconTextGap(8);
        btn_bill.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_bill.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_bill.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_billMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_bill);

        btn_staff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_staff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/management.png"))); // NOI18N
        btn_staff.setText("Nhân viên");
        btn_staff.setIconTextGap(8);
        btn_staff.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_staff.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_staff.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_staffMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_staff);

        btn_inventory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/import.png"))); // NOI18N
        btn_inventory.setText("Nhập hàng");
        btn_inventory.setIconTextGap(8);
        btn_inventory.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_inventory.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_inventory.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_inventoryMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_inventory);

        btn_anylist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_anylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analysis.png"))); // NOI18N
        btn_anylist.setText("Thống kê");
        btn_anylist.setIconTextGap(8);
        btn_anylist.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_anylist.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_anylist.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_anylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_anylistMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_anylist);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.BorderLayout());
        pnl_menu.add(jPanel1);

        btn_help.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help-web-button.png"))); // NOI18N
        btn_help.setText("Trợ giúp");
        btn_help.setIconTextGap(8);
        btn_help.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btn_help.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_help.setPreferredSize(new java.awt.Dimension(200, 50));
        btn_help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_helpMouseClicked(evt);
            }
        });
        pnl_menu.add(btn_help);

        getContentPane().add(pnl_menu, java.awt.BorderLayout.WEST);

        pnl_right.setLayout(new java.awt.BorderLayout());

        pnl_header.setBackground(new java.awt.Color(255, 255, 153));
        pnl_header.setPreferredSize(new java.awt.Dimension(1366, 50));

        lbl_name_NV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_name_NV.setForeground(new java.awt.Color(0, 0, 0));
        lbl_name_NV.setText("Nguyễn Minh Nhật");

        lbl_type_NV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_type_NV.setForeground(new java.awt.Color(0, 0, 0));
        lbl_type_NV.setText("Nhân viên bán hàng");

        btn_logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_logout.setText("Đăng xuất");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_headerLayout = new javax.swing.GroupLayout(pnl_header);
        pnl_header.setLayout(pnl_headerLayout);
        pnl_headerLayout.setHorizontalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_type_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_name_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_headerLayout.setVerticalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_type_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_name_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_right.add(pnl_header, java.awt.BorderLayout.PAGE_START);

        pnl_main.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main.setLayout(new java.awt.CardLayout());

        pnl_Home.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_Home = new Panel_Home();
        pnl_main.add(pnl_Home, "home");

        pnl_bill.setBackground(new java.awt.Color(255, 255, 255));
        pnl_bill.setLayout(new java.awt.BorderLayout());
        pnl_bill = new Panel_bill();
        pnl_main.add(pnl_bill, "bill");

        pnl_inventory.setLayout(new java.awt.BorderLayout());
        pnl_inventory = new Panel_inventory();
        pnl_main.add(pnl_inventory, "inventory");

        pnl_anylist.setLayout(new java.awt.BorderLayout());
        pnl_anylist = new Panel_anylist();
        pnl_main.add(pnl_anylist, "anylist");

        pnl_cart.setLayout(new java.awt.BorderLayout());
        pnl_cart = new quanlysach.Panel_cart();
        pnl_main.add(pnl_cart, "cart");

        pnl_customer.setLayout(new java.awt.BorderLayout());
        pnl_customer = new Panel_customer();
        pnl_main.add(pnl_customer, "customer");

        pnl_staff.setLayout(new java.awt.BorderLayout());
        pnl_staff = new Panel_staff();
        pnl_main.add(pnl_staff, "staff");

        pnl_product.setLayout(new java.awt.BorderLayout());
        pnl_product = new Panel_Product();
        pnl_main.add(pnl_product, "product");

        pnl_right.add(pnl_main, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnl_right, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        // TODO add your handling code here:
        boolean isLogout = JOptionPane.showConfirmDialog(
                null, 
                "Bạn có chắc chắn muốn thoát không?", 
                "Cảnh báo", 
                JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION;
        if(isLogout) {
            GUI_Login gui_login = new GUI_Login();
            this.setVisible(false);
            gui_login.setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cartMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "cart");
    }//GEN-LAST:event_btn_cartMouseClicked

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "home");
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_billMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_billMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "bill");
    }//GEN-LAST:event_btn_billMouseClicked

    private void btn_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customerMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "customer");
    }//GEN-LAST:event_btn_customerMouseClicked

    private void btn_staffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_staffMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "staff");
    }//GEN-LAST:event_btn_staffMouseClicked

    private void btn_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inventoryMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "inventory");
    }//GEN-LAST:event_btn_inventoryMouseClicked

    private void btn_anylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anylistMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "anylist");
    }//GEN-LAST:event_btn_anylistMouseClicked

    private void btn_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productMouseClicked
        // TODO add your handling code here:
        card.show(pnl_main, "product");
    }//GEN-LAST:event_btn_productMouseClicked

    private void btn_helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_helpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_helpMouseClicked

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anylist;
    private javax.swing.JButton btn_bill;
    private javax.swing.JButton btn_cart;
    private javax.swing.JButton btn_customer;
    private javax.swing.JButton btn_help;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_inventory;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_product;
    private javax.swing.JButton btn_staff;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_name_NV;
    private javax.swing.JLabel lbl_type_NV;
    private javax.swing.JPanel pnl_Home;
    private javax.swing.JPanel pnl_anylist;
    private javax.swing.JPanel pnl_bill;
    private javax.swing.JPanel pnl_cart;
    private javax.swing.JPanel pnl_customer;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_inventory;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_menu;
    private javax.swing.JPanel pnl_product;
    private javax.swing.JPanel pnl_right;
    private javax.swing.JPanel pnl_staff;
    // End of variables declaration//GEN-END:variables
}
