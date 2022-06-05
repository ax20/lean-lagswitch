package com.github.ashwxn.lean;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(new JFrame(), "<html><font color=#eb34eb>This program is a laggswitch, used to throttle your network, only functional with administrator privileges.<br>(WARNING: This is a soft switch.)</font></html>", "Lean", 2);
					LeanFrame frame = new LeanFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
