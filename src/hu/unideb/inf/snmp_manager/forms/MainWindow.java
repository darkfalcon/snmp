package hu.unideb.inf.snmp_manager.forms;

import com.adventnet.snmp.mibs.MibException;
import com.adventnet.snmp.ui.MibTree;
import hu.unideb.inf.snmp_manager.classes.IpAddress;
import hu.unideb.inf.snmp_manager.utils.IPUtil;
import hu.unideb.inf.snmp_manager.utils.InvalidIpAddressException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.snmp4j.Snmp;

/**
 *
 * @author darkfalcon
 */
public class MainWindow extends javax.swing.JFrame {

    Locale locale = null;

    public MainWindow(Locale locale) {

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                setExtendedState(MAXIMIZED_BOTH);
            }
        });

        this.locale = locale;
        System.out.println(locale);
        mibTree = new MibTree();
        snmp = new Snmp();
        addMibFile("mibrepository/RFC1213-MIB");
        addMibFile("mibrepository/RFC1389-MIB");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        addMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        discoverMenuItem = new javax.swing.JMenuItem();
        snmpRequestMenuItem = new javax.swing.JMenuItem();
        snmpRequestAllMenuItem = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        sendRequest = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        try {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(
                new IpAddress("0.0.0.0", "0"));
            ipTree = new javax.swing.JTree(root);
            jPanel4 = new javax.swing.JPanel();
            addressField = new javax.swing.JTextField();
            addButton = new javax.swing.JButton();
            netmaskField = new javax.swing.JTextField();
            slashLabel = new javax.swing.JLabel();
            maskLabel = new javax.swing.JLabel();
            isDevice = new javax.swing.JCheckBox();
            addressLabel = new javax.swing.JLabel();
            jPanel1 = new javax.swing.JPanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTable2 = new javax.swing.JTable();
            jPanel3 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jMenuBar1 = new javax.swing.JMenuBar();
            jMenu1 = new javax.swing.JMenu();
            jMenu2 = new javax.swing.JMenu();
            jMenu3 = new javax.swing.JMenu();
            jMenuItem1 = new javax.swing.JMenuItem();
            jMenuItem2 = new javax.swing.JMenuItem();

            addMenuItem.setText("Add Address");
            addMenuItem.setToolTipText("Add an address to this node");
            jPopupMenu1.add(addMenuItem);

            deleteMenuItem.setMnemonic('D');
            deleteMenuItem.setText("Delete Address");
            deleteMenuItem.setToolTipText("Delete this address from the tree");
            deleteMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    deleteMenuItemMousePressed(evt);
                }
            });
            jPopupMenu1.add(deleteMenuItem);

            discoverMenuItem.setText("Discover Network");
            discoverMenuItem.setToolTipText("Test connectivity of the nodes belongs to this network");
            jPopupMenu1.add(discoverMenuItem);

            snmpRequestMenuItem.setText("Send SNMP Request");
            snmpRequestMenuItem.setToolTipText("Send an SNMP request to this address");
            jPopupMenu1.add(snmpRequestMenuItem);

            snmpRequestAllMenuItem.setText("Request for All Child");
            snmpRequestAllMenuItem.setToolTipText("Send SNMP request for all child of this network");
            jPopupMenu1.add(snmpRequestAllMenuItem);

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setPreferredSize(new java.awt.Dimension(800, 600));
            addWindowFocusListener(new java.awt.event.WindowFocusListener() {
                public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                    formWindowGainedFocus(evt);
                }
                public void windowLostFocus(java.awt.event.WindowEvent evt) {
                }
            });

            jToolBar1.setRollover(true);

            sendRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hu/unideb/inf/snmp_manager/icons/email_go.png"))); // NOI18N
            sendRequest.setToolTipText("Send SNMP request to the selected address");
            sendRequest.setFocusable(false);
            sendRequest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            sendRequest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            sendRequest.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    sendRequestMouseClicked(evt);
                }
            });
            jToolBar1.add(sendRequest);

            jButton1.setText("jButton1");
            jButton1.setFocusable(false);
            jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton1MouseClicked(evt);
                }
            });
            jToolBar1.add(jButton1);

            createNodes(root);
            expandTree(root, 1);
        } catch (InvalidIpAddressException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE,
                null, ex);
        }
        ipTree.setComponentPopupMenu(jPopupMenu1);
        ipTree.setPreferredSize(new java.awt.Dimension(0, 0));
        ipTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ipTreeMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(ipTree);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Add node"));

        addressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressFieldFocusLost(evt);
            }
        });

        addButton.setText("Add");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });

        slashLabel.setText(" /");

        maskLabel.setText("Mask:");

        isDevice.setText("Device");
        isDevice.setToolTipText("If this checked, the address will be added to the root network");
        isDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                isDeviceMouseClicked(evt);
            }
        });

        addressLabel.setText("IP address:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(isDevice)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slashLabel))
                            .addComponent(addressLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maskLabel)
                            .addComponent(netmaskField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maskLabel)
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slashLabel)
                    .addComponent(netmaskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(isDevice))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );

        jPanel1.setFocusable(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name / OID", "Value", "Type", "IP"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Options");

        jMenuItem1.setText("Language...");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Manage MIBs...");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-773)/2, (screenSize.height-589)/2, 773, 589);
    }// </editor-fold>//GEN-END:initComponents

    private void isDeviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isDeviceMouseClicked
        if (isDevice.isSelected()) {
            netmaskField.setText("32");
            netmaskField.setEnabled(false);
        } else {
            netmaskField.setEnabled(true);
            IPUtil util = new IPUtil();
            if (util.checkIP(addressField.getText())) {
                netmaskField.setText(String.valueOf(util.getDefaultMask(
                        netmaskField.getText())));
            } else {
                netmaskField.setText("inv.");
            }
        }
    }//GEN-LAST:event_isDeviceMouseClicked

    private void addressFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFieldFocusLost
        IPUtil util = new IPUtil();
        if (util.checkIP(addressField.getText())) {
            netmaskField.setText(String.valueOf(util.getDefaultMask(
                    addressField.getText())));
        } else {
            netmaskField.setText("inv.");
        }
    }//GEN-LAST:event_addressFieldFocusLost

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        String ip = addressField.getText();
        String netmask = netmaskField.getText();
        try {
            IpAddress address = new IpAddress(ip, netmask);

            if (isDevice.isSelected()) {
                DefaultTreeModel model = (DefaultTreeModel) ipTree.getModel();
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
                model.insertNodeInto(new DefaultMutableTreeNode(
                        address), root, root.getChildCount());
            } else {
                AddNodeDialog dd = new AddNodeDialog(this, true,
                        ipTree, ip, netmask);
                dd.setVisible(true);
            }
        } catch (InvalidIpAddressException ex) {
            JOptionPane.showMessageDialog(rootPane, "Invalid IP address"
                    + " or netmask!", "Error", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(MainWindow.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void sendRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendRequestMouseClicked
        String targetAddress = "127.0.0.1";
        SnmpRequestDialog dialog = new SnmpRequestDialog(this, true, mibTree,
                targetAddress, snmp);
        dialog.setVisible(true);
    }//GEN-LAST:event_sendRequestMouseClicked

    //if right click occurs on a tree node, this code will make it selected
    private void ipTreeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ipTreeMousePressed
        int row = ipTree.getRowForLocation(evt.getX(), evt.getY());
        TreePath path = ipTree.getPathForLocation(evt.getX(), evt.getY());
        if (row != -1) {
            if (evt.getClickCount() == 1
                    && SwingUtilities.isRightMouseButton(evt)) {
                ipTree.setSelectionPath(path);
            }
        }
    }//GEN-LAST:event_ipTreeMousePressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.out.println("delete");
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) ipTree.getLastSelectedPathComponent();
        DefaultTreeModel model = (DefaultTreeModel) ipTree.getModel();
        model.removeNodeFromParent(node);
    }//GEN-LAST:event_jButton1MouseClicked

    private void deleteMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMenuItemMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) ipTree.getLastSelectedPathComponent();
            DefaultTreeModel model = (DefaultTreeModel) ipTree.getModel();
            model.removeNodeFromParent(node);
            IpAddress ip = (IpAddress) node.getUserObject();
            System.out.println(ip.toString());
        }
    }//GEN-LAST:event_deleteMenuItemMousePressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        System.out.println("focus");
        addressField.requestFocus();
    }//GEN-LAST:event_formWindowGainedFocus

    private void addMibFile(String mib) {
        try {
            mibTree.addMib(mib);
        } catch (MibException | IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode network;
        try {
            network = new DefaultMutableTreeNode(
                    new IpAddress("192.168.1.0", "24"));
            top.add(network);
            network.add(new DefaultMutableTreeNode(new IpAddress("192.168.1.1", "24")));
            network.add(new DefaultMutableTreeNode(new IpAddress("192.168.1.2", "24")));
            network.add(new DefaultMutableTreeNode(new IpAddress("192.168.1.3", "24")));
            network = new DefaultMutableTreeNode(new DefaultMutableTreeNode(
                    new IpAddress("172.16.0.0", "16")));
            top.add(network);
            network.add(new DefaultMutableTreeNode(new IpAddress("172.16.0.1", "16")));
            network.add(new DefaultMutableTreeNode(new IpAddress("172.16.23.0", "16")));
            network.add(new DefaultMutableTreeNode(new IpAddress("172.16.12.1", "16")));
        } catch (InvalidIpAddressException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void expandTree(DefaultMutableTreeNode root, int level) {
        DefaultMutableTreeNode currentNode = root.getNextNode();
        do {
            if (currentNode.getLevel() == level) {
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) currentNode.getParent();
                ipTree.expandPath(new TreePath(parent.getPath()));
            }
            currentNode = currentNode.getNextNode();
        } while (currentNode != null);
    }

    /**
     * @param args the command line arguments
     */
    public void lookAndFeel() {
        /*
         * Set the Windows look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException |
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainWindow(locale).setVisible(true);
            }
        });
    }
    private MibTree mibTree;
    private Snmp snmp;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JMenuItem addMenuItem;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenuItem discoverMenuItem;
    private javax.swing.JTree ipTree;
    private javax.swing.JCheckBox isDevice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel maskLabel;
    private javax.swing.JTextField netmaskField;
    private javax.swing.JButton sendRequest;
    private javax.swing.JLabel slashLabel;
    private javax.swing.JMenuItem snmpRequestAllMenuItem;
    private javax.swing.JMenuItem snmpRequestMenuItem;
    // End of variables declaration//GEN-END:variables
}
