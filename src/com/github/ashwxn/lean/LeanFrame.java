package com.github.ashwxn.lean;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.ashwxn.lean.util.Execute;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class LeanFrame extends JFrame implements ActionListener {

	
	JToggleButton toggleBTN;
	private static final long serialVersionUID = -8744107086103829474L;
	private JPanel contentPane;
	
	public LeanFrame() {
		
		setAlwaysOnTop(true);
		setTitle("Lean v1.0 (" + serialVersionUID + ")");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lean");
		lblNewLabel.setBounds(12, 0, 101, 52);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 38));
		lblNewLabel.setForeground(new Color(235, 52, 235));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("by bxq.bo(js)");
		lblNewLabel_1.setBounds(103, 21, 67, 16);
		contentPane.add(lblNewLabel_1);
		
		toggleBTN = new JToggleButton("<html><font color=#eb34eb>Enable</font></html>");
		toggleBTN.addActionListener(this);
		toggleBTN.setToolTipText("");
		toggleBTN.setBounds(12, 52, 158, 26);
		contentPane.add(toggleBTN);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Execute exec = new Execute();
		if (e.getSource() == toggleBTN && Execute.isAdmin()) {
			if (toggleBTN.isSelected()) {
				toggleBTN.setText("Disable Laggswitch");
				System.out.println("Turn On");
				exec.executeCMD("netsh advfirewall set allprofiles firewallpolicy blockinbound,blockoutbound");
			}
			else if (!toggleBTN.isSelected()) {
				toggleBTN.setText("Enable Laggswitch");
				System.out.println("Turn Off");
				exec.executeCMD("netsh advfirewall set allprofiles firewallpolicy blockinbound,allowoutbound");
			}
		} else if (!Execute.isAdmin()) {
			JOptionPane.showMessageDialog(new JFrame(), "<html><font color=#eb34eb>Program is only functional when running with administrator privileges. <br>(right click this file, and select Run as Administrator)</font></html>", "Lean", 2);
			System.exit(0);
			return;
		}
	}
}
