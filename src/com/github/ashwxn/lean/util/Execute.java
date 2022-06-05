package com.github.ashwxn.lean.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Execute {
	
	public static boolean isAdmin() {
	    try {
	        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe");
	        Process process = processBuilder.start();
	        PrintStream printStream = new PrintStream(process.getOutputStream(), true);
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(process.getInputStream());
	        printStream.println("@echo off");
	        printStream.println(">nul 2>&1 \"%SYSTEMROOT%\\system32\\cacls.exe\" \"%SYSTEMROOT%\\system32\\config\\system\"");
	        printStream.println("echo %errorlevel%");

	        boolean printedErrorlevel = false;
	        while (true) {
	            String nextLine = scanner.nextLine();
	            if (printedErrorlevel) {
	                int errorlevel = Integer.parseInt(nextLine);
	                return errorlevel == 0;
	            } else if (nextLine.equals("echo %errorlevel%")) {
	                printedErrorlevel = true;
	            }
	        }
	    } catch (IOException e) {
	        return false;
	    }
	}
	
	public void executeCMD(String cmd) {
			try {
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(new JFrame(), "Error while executing command.", "Lean", 2);
			}
	}

}
