package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Asus
 */
public class NewClass {
     public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        DefaultTableModel model = new DefaultTableModel(new String[]{"Column 1", "Column 2", "Column 3"}, 0);
        JTable table = new JTable(model);

        // Sử dụng một TableCellRenderer tùy chỉnh để hiển thị JPanel trong ô thứ 2 hàng 1
        table.getColumnModel().getColumn(1).setCellRenderer(new CustomPanelCellRenderer());
        
        // Sử dụng một TableCellEditor tùy chỉnh để chỉnh sửa ô thứ 2 hàng 1
        table.getColumnModel().getColumn(1).setCellEditor(new CustomPanelCellEditor());

        model.addRow(new Object[]{"Value 1", new JPanel(), "Value 3"});
        model.addRow(new Object[]{"Value 1", new JPanel(), "Value 3"});

        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // TableCellRenderer tùy chỉnh để hiển thị JPanel trong ô
    static class CustomPanelCellRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }

    // TableCellEditor tùy chỉnh để chỉnh sửa JPanel trong ô
    static class CustomPanelCellEditor extends AbstractCellEditor implements TableCellEditor {
        private JPanel panel;
        private JTextField textField;

        public CustomPanelCellEditor() {
            panel = new JPanel();
            textField = new JTextField(10);
            textField.setText("asdasdasdasd");
            panel.setLayout(new BorderLayout());
            panel.add(textField, BorderLayout.CENTER);
            
            JButton btn = new JButton("Nhaans");
            panel.add(btn, BorderLayout.WEST);
        }

        @Override
        public Object getCellEditorValue() {
            return panel;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            textField.setText(""); // Đặt giá trị mặc định cho JTextField
            return panel;
        }
    }
}
