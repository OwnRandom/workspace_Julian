package interfazEjercicio5;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.awt.Frame;
import java.awt.event.ActionEvent;

public class Profile extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;
	private JLabel lblUsernamePr;
	private JLabel lblEmailPr;
	private JLabel lblLastLoginPr;
	private JLabel lblCreatedAtPr;
	private JButton btnImport;
	private Frame frame;

	/**
	 * Create the panel.
	 */
	public Profile(App app) {
		this.app = app;
		setLayout(null);

		lblUsernamePr = new JLabel("Username");
		lblUsernamePr.setBounds(50, 102, 230, 14);
		add(lblUsernamePr);

		lblEmailPr = new JLabel("Email");
		lblEmailPr.setBounds(50, 127, 259, 14);
		add(lblEmailPr);

		lblLastLoginPr = new JLabel("LastLogin");
		lblLastLoginPr.setBounds(50, 152, 230, 14);
		add(lblLastLoginPr);

		lblCreatedAtPr = new JLabel("CreatedAt");
		lblCreatedAtPr.setBounds(50, 177, 230, 14);
		add(lblCreatedAtPr);

		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(50, 56, 46, 14);
		add(lblProfile);

		JButton btnChangePassPr = new JButton("Change Password");
		btnChangePassPr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setChangePass();
			}
		});
		btnChangePassPr.setBounds(82, 250, 127, 23);
		add(btnChangePassPr);

		JButton btnCloseSessionPr = new JButton("Close Session");
		btnCloseSessionPr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setLogin();
			}
		});
		btnCloseSessionPr.setBounds(252, 250, 127, 23);
		add(btnCloseSessionPr);

		btnImport = new JButton("Import User");
		btnImport.setBounds(311, 52, 89, 23);
		add(btnImport);

		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.ImportCSV();
			}
		});
	}

	public void setUsernamePr(String username) {
		lblUsernamePr.setText(username);
	}

	public void setEmailPr(String email) {
		lblEmailPr.setText(email);
	}

	public void setLastLoginPr(LocalDate date) {
		lblLastLoginPr.setText(date.toString());
	}

	public void setCreatedAtPr(LocalDate date) {
		lblCreatedAtPr.setText(date.toString());
	}

}
