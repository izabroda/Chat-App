package Chat;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame frmChatApp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JButton btnDisconnect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmChatApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public MainWindow() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmChatApp = new JFrame();
		frmChatApp.setTitle("Chat App");
		frmChatApp.setBounds(100, 100, 450, 300);
		frmChatApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Protocole p = new Protocole();
		Socket s=new Socket();
		CallListener c = new CallListener(p.port);
		Thread callthr = new Thread(c);
		Receiver ch = new Receiver(c.getS1());
		Sender snd = new Sender(c.getS1());
		class send implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		JPanel panel = new JPanel();
		frmChatApp.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 229, 152, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("send");
		btnSend.setBounds(192, 228, 65, 23);
		panel.add(btnSend);
		
		textField_1 = new JTextField();
		textField_1.setBounds(28, 22, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(232, 22, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(328, 21, 89, 23);
		panel.add(btnConnect);
		
		btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setBounds(328, 52, 89, 23);
		panel.add(btnDisconnect);
		
		JLabel lblLocLogin = new JLabel("loc login");
		lblLocLogin.setBounds(124, 25, 46, 14);
		panel.add(lblLocLogin);
	}
}
