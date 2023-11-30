package com.mycompany.huffmanm;

import java.io.*;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReadDocxFile
{

	public static String readDocxFile(String fileName) {
                String texto="";
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphs = document.getParagraphs();
			System.out.println("Total no of paragraph "+paragraphs.size());
			for (XWPFParagraph para : paragraphs) {
                                texto += para.getText();
                                texto += '\n';
			}
                        texto += " ";
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
                return texto;

	}

}
