/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clouddrive.parth;

/**
 *
 * @author ravjotsingh
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteToArray {

	public static void writeByteArray(String fileName, byte[] array) {

		BufferedOutputStream bs = null;

		try {

			FileOutputStream fs = new FileOutputStream(new File(fileName));
			bs = new BufferedOutputStream(fs);
			bs.write(array);
			bs.close();
			bs = null;
			System.out.println(new File(fileName).getAbsoluteFile());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (bs != null)
			try {
				bs.close();
			} catch (Exception e) {
			}
	}

	public static byte[] getByteFromFile(File file) {
		byte[] fileBytes = null;
		try {
			FileInputStream fis;

			fis = new FileInputStream(file);

			BufferedInputStream inputStream = new BufferedInputStream(fis);
			fileBytes = new byte[(int) file.length()];
			inputStream.read(fileBytes);
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileBytes;
	}
}
