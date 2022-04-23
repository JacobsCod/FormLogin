package Loginfrm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Statement;

import modelo.conection;

import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class Tableform extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textfirstname1;
	private JTextField textlastname1;
	private JTextField textusername1;
	private JTextField textemail1;
	private JTable table;
	private JTable tblUsuarios;
	private JPasswordField passwordField;
	
    


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tableform frame = new Tableform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/*public  DefaultTableModel consultar()  {
        String []  nombresColumnas = {"first_name","last_name","user_name", "password", "email_id"};
        String [] registros = new String[5];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM usuario";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            conection cn1 = new conection();
            
            pst = cn1.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("first_name");
                
                registros[1] = rs.getString("last_name");
                
                registros[2] = rs.getString("user_name");
                
                registros[3] = rs.getString("password");
                
                registros[4] = rs.getString("email_id");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    


	/* void consultar() {
		String sql ="select * from usuario;";
		
		try {
			conet = con1.getConnection();
			stm = conet.createStatement();
			rst = stm.executeQuery(sql);
			Object[] users = new Object[5];
			model = (DefaultTableModel) tblUsuarios.getModel();
			while(rst.next()) {
				users [0] = rst.getString("first_name");
				users [1] = rst.getString("last_name");
				users [2] = rst.getString("user_name");
				users [3] = rst.getString("password");
				users [4] = rst.getString("email_id");
				
				model.addRow(users);
			}
			tblUsuarios.setModel(model);
		}catch(Exception e) {
			System.out.println("NO SE PUDO");
			
		}

	}
	
	*/
	 public Tableform() {
		 
		  
		     
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(450, 190, 1014, 597);
		    setResizable(false);
		    contentPane = new JPanel();
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(null);
		    
		    
		   
		    
		    JPanel Detalle = new JPanel();
		    Detalle.setBounds(10, 11, 961, 223);
		    contentPane.add(Detalle);
		    Detalle.setLayout(null);
		    
		    JLabel lblNewLabel = new JLabel("First Name");
		    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		    lblNewLabel.setBounds(10, 11, 87, 31);
		    Detalle.add(lblNewLabel);
		    
		    JLabel lblNewLabel_1 = new JLabel("Last Name");
		    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		    lblNewLabel_1.setBounds(10, 53, 87, 34);
		    Detalle.add(lblNewLabel_1);
		    
		    JLabel lblNewLabel_2 = new JLabel("Username");
		    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		    lblNewLabel_2.setBounds(10, 110, 75, 14);
		    Detalle.add(lblNewLabel_2);
		    
		    JLabel lblNewLabel_3 = new JLabel("Email");
		    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		    lblNewLabel_3.setBounds(10, 155, 46, 14);
		    Detalle.add(lblNewLabel_3);
		    
		    textfirstname1 = new JTextField();
		    textfirstname1.setBounds(107, 17, 179, 20);
		    Detalle.add(textfirstname1);
		    textfirstname1.setColumns(10);
		    
		    textlastname1 = new JTextField();
		    textlastname1.setBounds(107, 61, 179, 20);
		    Detalle.add(textlastname1);
		    textlastname1.setColumns(10);
		    
		    textusername1 = new JTextField();
		    textusername1.setBounds(107, 108, 179, 20);
		    Detalle.add(textusername1);
		    textusername1.setColumns(10);
		    
		    textemail1 = new JTextField();
		    textemail1.setBounds(107, 153, 179, 20);
		    Detalle.add(textemail1);
		    textemail1.setColumns(10);
		    
		    JPanel panel = new JPanel();
		    panel.setBounds(346, 0, 605, 212);
		    Detalle.add(panel);
		    panel.setLayout(null);
		    
		    JButton btnEliminar = new JButton("Eliminar");
		    btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		    btnEliminar.setBounds(24, 56, 89, 46);
		    panel.add(btnEliminar);
		    
		    JButton btnGuardar = new JButton("Guardar");
		    
		    btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		    btnGuardar.setBounds(24, 11, 89, 34);
		    panel.add(btnGuardar);
		    
		    JButton btnListar = new JButton("Listar");
		    btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		    btnListar.setBounds(24, 113, 89, 41);
		    panel.add(btnListar);
		    
		    JButton btnCerrarSesion = new JButton("Cerrar sesion");
		    btnCerrarSesion.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		System.exit(ABORT);
		    	}
		    });
		    btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		    btnCerrarSesion.setBounds(210, 56, 135, 46);
		    panel.add(btnCerrarSesion);
		    
		    JLabel lblNewLabel_4 = new JLabel("Password");
		    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		    lblNewLabel_4.setBounds(10, 198, 75, 14);
		    Detalle.add(lblNewLabel_4);
		    
		    passwordField = new JPasswordField();
		    passwordField.setBounds(107, 195, 179, 20);
		    Detalle.add(passwordField);
		    
		    JPanel panel_1 = new JPanel();
		    panel_1.setBounds(10, 248, 961, 169);
		    contentPane.add(panel_1);
		    
		    JScrollPane scrollPane_1 = new JScrollPane();
		    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		    gl_panel_1.setHorizontalGroup(
		    	gl_panel_1.createParallelGroup(Alignment.LEADING)
		    		.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
		    );
		    gl_panel_1.setVerticalGroup(
		    	gl_panel_1.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_panel_1.createSequentialGroup()
		    			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
		    			.addContainerGap(113, Short.MAX_VALUE))
		    );
		    
		    tblUsuarios = new JTable();
		    tblUsuarios.setEnabled(false);
		    tblUsuarios.setModel(new DefaultTableModel(
		    	new Object[][] {
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    		{null, null, null, null, null},
		    	},
		    	new String[] {
		    		"first_name", "user_name", "user_name", "password", "email_id"
		    	}
		    ) {
		    	/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
		    		String.class, String.class, String.class, String.class, String.class
		    	};
		    	public Class getColumnClass(int columnIndex) {
		    		return columnTypes[columnIndex];
		    	}
		    });
		    tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
		    tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(74);
		    tblUsuarios.getColumnModel().getColumn(4).setMinWidth(22);
		    scrollPane_1.setViewportView(tblUsuarios);
		    panel_1.setLayout(gl_panel_1);
		    
              //intComponents();
		    
		
		 
	 }


}
