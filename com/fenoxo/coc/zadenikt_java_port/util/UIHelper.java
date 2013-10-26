package com.fenoxo.coc.zadenikt_java_port.util;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class UIHelper
{
	private static JFileChooser fileChooser = new JFileChooser();

	public static boolean confirm(String title, String message)
	{
		return (JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	public static void error(String title, String message)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}

	public static String input(String title, String message, boolean allowEmpty)
	{
		String result = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

		if (!allowEmpty && (result != null))
		{
			while (result.isEmpty())
			{
				result = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

				if (result == null)
				{
					break;
				}
			}
		}

		return result;
	}

	public static void notify(String title, String message)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static File openFile(FileFilter filter)
	{
		File file = null;

		fileChooser.setFileFilter(filter);

		int opt = fileChooser.showOpenDialog(null);

		if (opt == JFileChooser.APPROVE_OPTION)
		{
			file = fileChooser.getSelectedFile();
		}

		fileChooser.setFileFilter(null);

		return file;
	}

	public static File saveFile(FileFilter filter)
	{
		File file = null;

		fileChooser.setFileFilter(filter);

		int opt = fileChooser.showSaveDialog(null);

		if (opt == JFileChooser.APPROVE_OPTION)
		{
			file = fileChooser.getSelectedFile();
		}

		fileChooser.setFileFilter(null);

		return file;
	}
}
