package Loginfrm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Productos extends JFrame {

	private JPanel contentPane;
	private JTable tblproducto;
	private JTextField nombreP;
	private JTextField marcaP;
	private JTextField categoriap;
	private JTextField precioP;
	private JTextField canitdadP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 513, 230);
		contentPane.add(scrollPane);
		
		tblproducto = new JTable();
		scrollPane.setViewportView(tblproducto);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Agregar productos ITLA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 513, 187);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre P:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 23, 61, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 85, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 142, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(234, 85, 61, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(232, 27, 63, 14);
		panel.add(lblNewLabel_4);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(
		                    "jdbc:mysql://localhost:3306/usuarios","root","123456");
					String query = "INSERT INTO productos (NombreProd, marcaProd,categoriaProd, precioProd, cantidadDisp) VALUES (?,?,?,?,?);"; 
					PreparedStatement ps =con.prepareStatement(query);
					ps.setString(1, nombreP.getText());
					ps.setString(2, marcaP.getText());
					ps.setString(3, categoriap.getText());
					ps.setString(4, precioP.getText());
					ps.setString(5, canitdadP.getText());
					
					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(btnAgregar, i + "  Este producto fue agregado");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAgregar.setBounds(229, 129, 76, 40);
		panel.add(btnAgregar);
		
		nombreP = new JTextField();
		nombreP.setBounds(69, 19, 138, 31);
		panel.add(nombreP);
		nombreP.setColumns(10);
		
		marcaP = new JTextField();
		marcaP.setBounds(69, 77, 138, 31);
		panel.add(marcaP);
		marcaP.setColumns(10);
		
		categoriap = new JTextField();
		categoriap.setColumns(10);
		categoriap.setBounds(66, 134, 138, 31);
		panel.add(categoriap);
		
		precioP = new JTextField();
		precioP.setColumns(10);
		precioP.setBounds(305, 19, 138, 31);
		panel.add(precioP);
		
		canitdadP = new JTextField();
		canitdadP.setColumns(10);
		canitdadP.setBounds(305, 77, 138, 31);
		panel.add(canitdadP);
		
		JButton btnRefrescar = new JButton("Obtener");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(
		                    "jdbc:mysql://localhost:3306/usuarios","root","123456");
					Statement stc = con.createStatement();
					String query ="select * from Productos";
					ResultSet rs= stc.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tblproducto.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i = 0;i < cols;i++)
						colName[i]= rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String NombreProd, marcaProd,categoriaProd, precioProd, cantidadDisp;
					while(rs.next()) {
						NombreProd =rs.getString(1);
						marcaProd = rs.getString(2);
						categoriaProd = rs.getString(3);
						precioProd = rs.getString(4);
						cantidadDisp = rs.getString(5);
						String [] row = {NombreProd, marcaProd,categoriaProd, precioProd, cantidadDisp};
						model.addRow(row);
						
						}
					stc.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefrescar.setBounds(326, 129, 76, 40);
		panel.add(btnRefrescar);
		
		JButton Clear = new JButton("Limpiar");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblproducto.setModel(new DefaultTableModel());
			}
		});
		Clear.setBounds(414, 129, 76, 40);
		panel.add(Clear);
	}
}
