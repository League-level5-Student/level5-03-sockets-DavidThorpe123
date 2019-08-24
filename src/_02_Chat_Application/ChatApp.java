package _02_Chat_Application;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ChatApp extends JFrame {
	

	



	
		JButton button = new JButton("CLICK");
		JTextField field = new JTextField();
		Server server;
		Client client;
		
		
		public static void main(String[] args) {
			new ChatApp();
		}
		
		public ChatApp(){
			
			int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Buttons!", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.YES_OPTION){
				server = new Server(8080);
				setTitle("SERVER");
				JOptionPane.showMessageDialog(null, "Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());
				add(field);
			
				button.addActionListener((e)->{
					
					server.sendClick(field.getText());
				});
				add(button);
				button.setSize(100, 100);
				field.setSize(100, 100);
				
				setVisible(true);
				setSize(1000, 1000);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				server.start();
				
			}else{
				setTitle("CLIENT");
				String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
				String prtStr = JOptionPane.showInputDialog("Enter the port number");
				int port = Integer.parseInt(prtStr);
				client = new Client(ipStr, port);
				add(field);
				button.setSize(100, 100);
				field.setSize(100, 100);
				
				button.addActionListener((e)->{
					client.sendClick(field.getText());
				});
				add(button);
				setVisible(true);
				setSize(1000, 1000);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				client.start();
			}
		}
	}


