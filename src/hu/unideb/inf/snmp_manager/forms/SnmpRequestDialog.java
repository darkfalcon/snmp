
package hu.unideb.inf.snmp_manager.forms;

import com.adventnet.snmp.mibs.MibNode;
import com.adventnet.snmp.ui.MibTree;
import com.adventnet.snmp.ui.NodeData;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.Position;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.snmp4j.Snmp;

/**
 *
 * @author darkfalcon
 */
public class SnmpRequestDialog extends javax.swing.JDialog {

    /**
     * Creates new form SnmpRequestDialog
     */
    public SnmpRequestDialog(java.awt.Frame parent, boolean modal,
            MibTree mibTree, String targetAddress, Snmp snmp) {
        super(parent, modal);
        this.mibTree = mibTree;
        this.targetAddress = targetAddress;
        this.snmp = snmp;
        oidList = new ArrayList();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        snmpTree = new javax.swing.JTree(mibTree.getTree().getModel());
        jScrollPane3 = new javax.swing.JScrollPane();
        detailsTable = new javax.swing.JTable();
        findOidButton = new javax.swing.JButton();
        findOidField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        oidLabel = new javax.swing.JLabel();
        oidField = new javax.swing.JTextField();
        addVariableButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        variableList = new javax.swing.JList();
        removeVariableButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox();
        versionLabel = new javax.swing.JLabel();
        versionCombo = new javax.swing.JComboBox();
        retriesLabel = new javax.swing.JLabel();
        timeoutLabel = new javax.swing.JLabel();
        maxRepLabel = new javax.swing.JLabel();
        retriesField = new javax.swing.JTextField();
        timeoutField = new javax.swing.JTextField();
        maxRepField = new javax.swing.JTextField();
        nonRepLabel = new javax.swing.JLabel();
        nonRepField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        sendSnmpButton = new javax.swing.JButton();
        informLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 600));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SNMP MIBs"));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 275));

        snmpTree.setCellRenderer(new MyToolTipTreeRenderer());
        javax.swing.ToolTipManager.sharedInstance().registerComponent(snmpTree);
        snmpTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                snmpTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(snmpTree);

        detailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Label", ""},
                {"OID", ""},
                {"Module name", ""},
                {"Syntax", ""},
                {"Access", ""},
                {"Status", ""},
                {"DefVal", ""},
                {"Indexes", ""},
                {"Description", ""}
            },
            new String [] {
                "Properties", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn column = detailsTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(80);
        column = detailsTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(220);
        DefaultTableCellRenderer myCellRenderer1stColumn =
        new DefaultTableCellRenderer();
        myCellRenderer1stColumn.setVerticalAlignment(JLabel.TOP);
        detailsTable.getColumnModel().getColumn(0).setCellRenderer(
            myCellRenderer1stColumn);
        detailsTable.getColumnModel().getColumn(1).setCellRenderer(new
            MyCellRenderer2ndColumn());
        detailsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(detailsTable);

        findOidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hu/unideb/inf/snmp_manager/icons/magnifier.png"))); // NOI18N
        findOidButton.setToolTipText("Find in the MIB tree");
        findOidButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findOidButtonMouseClicked(evt);
            }
        });

        findOidField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        findOidField.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(findOidField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findOidButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findOidButton)
                    .addComponent(findOidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Variables"));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 224));

        oidLabel.setText("OID:");

        oidField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        oidField.setPreferredSize(new java.awt.Dimension(6, 25));

        addVariableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hu/unideb/inf/snmp_manager/icons/add.png"))); // NOI18N
        addVariableButton.setToolTipText("Add a new variable to the request");
        addVariableButton.setPreferredSize(new java.awt.Dimension(25, 25));
        addVariableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addVariableButtonMouseClicked(evt);
            }
        });

        variableListModel = new DefaultListModel();
        variableList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        variableList.setModel(variableListModel);
        jScrollPane2.setViewportView(variableList);

        removeVariableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hu/unideb/inf/snmp_manager/icons/delete.png"))); // NOI18N
        removeVariableButton.setToolTipText("Remove selected variable");
        removeVariableButton.setPreferredSize(new java.awt.Dimension(25, 25));
        removeVariableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeVariableButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(oidLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(oidField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addVariableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeVariableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(oidLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addVariableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(removeVariableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Request Settings"));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 196));

        typeLabel.setText("Type:");

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2c", "Version 3"}));

        versionLabel.setText("Version:");

        versionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Get",
            "GetNext", "GetBulk", "GetSubTree", "Walk", "Set" }));

retriesLabel.setText("SNMP Retries:");

timeoutLabel.setText("Timeout (millisec):");

maxRepLabel.setText("Max Repetitions:");

retriesField.setText("2");

timeoutField.setText("3000");

nonRepLabel.setText("Non Repeaters:");

javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
jPanel3.setLayout(jPanel3Layout);
jPanel3Layout.setHorizontalGroup(
    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maxRepLabel)
                    .addComponent(nonRepLabel))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maxRepField)
                    .addComponent(nonRepField)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retriesLabel)
                    .addComponent(timeoutLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeoutField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(retriesField)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(versionLabel)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(versionCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(typeLabel)
                .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(versionLabel)
                .addComponent(versionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(retriesLabel)
                .addComponent(retriesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(timeoutLabel)
                .addComponent(timeoutField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(6, 6, 6)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(maxRepLabel)
                .addComponent(maxRepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(6, 6, 6)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nonRepLabel)
                .addComponent(nonRepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    cancelButton.setText("Cancel");
    cancelButton.setPreferredSize(new java.awt.Dimension(80, 23));
    cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            cancelButtonMouseClicked(evt);
        }
    });

    sendSnmpButton.setText("Send");
    sendSnmpButton.setPreferredSize(new java.awt.Dimension(80, 23));
    sendSnmpButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            sendSnmpButtonMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(informLabel)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(sendSnmpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(sendSnmpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(informLabel))
            .addContainerGap())
    );

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-703)/2, (screenSize.height-594)/2, 703, 594);
    }// </editor-fold>//GEN-END:initComponents

    private void addVariableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addVariableButtonMouseClicked
        String oid = oidField.getText();
        if (!oid.equals("") && !oid.contains(" ")) {

            variableListModel.addElement(oid + " (" + selectedNode.getLabel()
                    + ")");
            oidList.add(oid);

            if (containDuplicateItem()) {
                informLabel.setText("Duplicated variable!");
                informLabel.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/hu/unideb/inf/snmp_manager/icons/information.png")));
            } else {
                informLabel.setText(null);
                informLabel.setIcon(null);
            }
        } else {
            informLabel.setText("The field is empty!");
            informLabel.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/hu/unideb/inf/snmp_manager/icons/information.png")));
        }
    }//GEN-LAST:event_addVariableButtonMouseClicked

    private void removeVariableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeVariableButtonMouseClicked
        int[] index = variableList.getSelectedIndices();
        if (index != null) {
            for (int i = (index.length - 1); i >= 0; i--) {
                variableListModel.remove(index[i]);
                oidList.remove(index[i]);
            }
            if (!containDuplicateItem()) {
                informLabel.setText(null);
                informLabel.setIcon(null);
            }
        }
    }//GEN-LAST:event_removeVariableButtonMouseClicked

    //Checks whether oidList contains duplicate item
    private boolean containDuplicateItem() {
        for (String s : oidList) {
            int n = 0;
            for (String si : oidList) {
                if (si.equals(s)) {
                    n++;
                }
                if (n > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void findOidButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findOidButtonMouseClicked
        String key = findOidField.getText();

        if (!key.equals("")) {
            TreeModel model = mibTree.getTree().getModel();
            TreePath path = snmpTree.getNextMatch(key, 1, Position.Bias.Forward);
            System.out.println("Path:" + path);
//            if (model != null) {
//                Object root = model.getRoot();
//                System.out.println(root.toString());
//                searchNode(model, root, key);
//            } else {
//                System.out.println("Tree is empty");
//            }
        }
    }//GEN-LAST:event_findOidButtonMouseClicked

    //Recursively traverse the tree to find the key amongs nodes
    public void searchNode(TreeModel model, Object root, String key) {
        int childCount = model.getChildCount(root);
        for (int i = 0; i < childCount; i++) {
            Object child = model.getChild(root, i);
            NodeData data = (NodeData) child;
            if (model.isLeaf(child)) {
                try {

                    MibNode mNode = data.getUserObject();
                    if (mNode.getLabel().equalsIgnoreCase(key)
                            || mNode.getNumberedOIDString().equals(key)) {
                        TreeNode ob = (TreeNode) model.getRoot();
                        System.out.println();
                        System.out.println("Finding successful" + mNode.toTagString());
                    }
                } catch (NullPointerException e) {
                }

            } else {
                try {

                    MibNode mNode = data.getUserObject();
                    if (mNode.getLabel().equalsIgnoreCase(key)
                            || mNode.getNumberedOIDString().equals(key)) {
                        int pos = model.getIndexOfChild(root, child);
                        System.out.println(snmpTree.getComponent(pos));
                        System.out.println("Finding successful" + mNode.toTagString());
                    }
                } catch (NullPointerException e) {
                }
                searchNode(model, child, key);
            }
        }
    }

    private void snmpTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_snmpTreeValueChanged
        NodeData node = (NodeData) snmpTree.getLastSelectedPathComponent();

        try {
            MibNode mNode = node.getUserObject();
            oidField.setText(mNode.getNumberedOIDString());
            selectedNode = mNode;

            if (mNode.getLabel() != null) {
                detailsTable.getModel().setValueAt(mNode.getLabel(), 0, 1);
            } else {
                detailsTable.getModel().setValueAt("", 0, 1);
            }

            if (mNode.getNumberedOIDString() != null) {
                detailsTable.getModel().setValueAt(mNode.getNumberedOIDString(),
                        1, 1);
            } else {
                detailsTable.getModel().setValueAt("", 1, 1);
            }

            if (mNode.getModuleName() != null) {
                detailsTable.getModel().setValueAt(mNode.getModuleName(), 2, 1);
            } else {
                detailsTable.getModel().setValueAt("", 2, 1);
            }

            if (mNode.getSyntax() != null) {
                detailsTable.getModel().setValueAt(mNode.getSyntax(), 3, 1);
            } else {
                detailsTable.getModel().setValueAt("", 3, 1);
            }

            detailsTable.getModel().setValueAt(mNode.getAccess(), 4, 1);

            if (mNode.getStatus() != null) {
                detailsTable.getModel().setValueAt(mNode.getStatus(), 5, 1);
            } else {
                detailsTable.getModel().setValueAt("", 5, 1);
            }

            if (mNode.getDescription() != null) {
                detailsTable.getModel().setValueAt(mNode.getDescription(), 8, 1);
            } else {
                detailsTable.getModel().setValueAt("", 8, 1);
            }

            if (mNode.getDefval() != null) {
                detailsTable.getModel().setValueAt(mNode.getDefval(), 6, 1);
            } else {
                detailsTable.getModel().setValueAt("", 6, 1);
            }

            if (mNode.getIndexNames() != null) {
                detailsTable.getModel().setValueAt(mNode.getIndexNames(), 7, 1);
            } else {
                detailsTable.getModel().setValueAt("", 7, 1);
            }

        } catch (NullPointerException e) {
            for (int i = 0; i <= 8; i++) {
                detailsTable.getModel().setValueAt("", i, 1);
            }
            oidField.setText(null);
        }
    }//GEN-LAST:event_snmpTreeValueChanged

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void sendSnmpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendSnmpButtonMouseClicked
        String type = typeCombo.getSelectedItem().toString();
        String version = versionCombo.getSelectedItem().toString();
        int timeout = 3000;
        int retries = 2;
        int maxRep = 0;
        int nonRep = 0;
        try {
            timeout = Integer.parseInt(timeoutField.getText());
            retries = Integer.parseInt(retriesField.getText());
            maxRep = Integer.parseInt(maxRepField.getText());
            nonRep = Integer.parseInt(nonRepField.getText());
        } catch (NumberFormatException e) {
        }
        System.out.println("type: " + type + "\nversion: " + version +
                "\ntimeout: " + timeout + "\nretries: " + retries + "\nmaxRep: "
                + maxRep + "\nnonRep: " + nonRep);
    }//GEN-LAST:event_sendSnmpButtonMouseClicked

    //Class for add ToopTip to JTree
    private class MyToolTipTreeRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value,
                boolean sel, boolean expanded, boolean leaf, int row,
                boolean hasFocus) {
            final Component component = super.getTreeCellRendererComponent(
                    tree, value, sel, expanded, leaf, row, hasFocus);
            
            NodeData data = (NodeData) value;
            MibNode node = data.getUserObject();
            
            try {
                if (leaf) {
                setIcon(new javax.swing.ImageIcon(getClass().getResource(
                        "/hu/unideb/inf/snmp_manager/icons/green_wormhole.png")));
            } else if (value == snmpTree.getModel().getRoot()) {
                setIcon(new javax.swing.ImageIcon(getClass().getResource(
                        "/hu/unideb/inf/snmp_manager/icons/tree.png")));
            } else if (node.getLabel() != null) {
                setIcon(new javax.swing.ImageIcon(getClass().getResource(
                        "/hu/unideb/inf/snmp_manager/icons/blue-document-node.png")));
            } 
            } catch (NullPointerException e) {
                setIcon(new javax.swing.ImageIcon(getClass().getResource(
                        "/hu/unideb/inf/snmp_manager/icons/folder_vertical_open.png")));
            } 
                 
            String toolTip;
            try {
                toolTip = node.getNumberedOIDString();
                this.setToolTipText(toolTip);
            } catch (NullPointerException e) {
                //System.out.println(e.getMessage());
            }
            return component;
        }   
    }
    
    //Class for rendering the detailTable
    private class MyCellRenderer2ndColumn extends JTextArea implements
            TableCellRenderer {

        public MyCellRenderer2ndColumn() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String text = String.valueOf(value);
            setFont(new Font("Tahoma", Font.PLAIN, 11));
            if (text.equals("null") || value == null) {
                setText("");
            } else {
                setText(text);
            }
            setText(String.valueOf(value));
            setSize(table.getColumnModel().getColumn(column).getWidth(),
                    getPreferredSize().height);

            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            return this;
        }

        //Required to Override for performance reason
        @Override
        public void validate() {
        }

        @Override
        public void revalidate() {
        }

        @Override
        public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        }
    }
    
    
    //Snmp instance
    private Snmp snmp;
    //snmp request will send to this address
    private final String targetAddress;
    //this mibnode is the actually selected
    private MibNode selectedNode;
    //listmodel which holds the oids for the request
    private DefaultListModel variableListModel;
    //tree with contains the parsed mib node
    private MibTree mibTree;
    //list of oids which will be added to the snmp request
    private List<String> oidList;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVariableButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable detailsTable;
    private javax.swing.JButton findOidButton;
    private javax.swing.JTextField findOidField;
    private javax.swing.JLabel informLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField maxRepField;
    private javax.swing.JLabel maxRepLabel;
    private javax.swing.JTextField nonRepField;
    private javax.swing.JLabel nonRepLabel;
    private javax.swing.JTextField oidField;
    private javax.swing.JLabel oidLabel;
    private javax.swing.JButton removeVariableButton;
    private javax.swing.JTextField retriesField;
    private javax.swing.JLabel retriesLabel;
    private javax.swing.JButton sendSnmpButton;
    private javax.swing.JTree snmpTree;
    private javax.swing.JTextField timeoutField;
    private javax.swing.JLabel timeoutLabel;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JList variableList;
    private javax.swing.JComboBox versionCombo;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
}
