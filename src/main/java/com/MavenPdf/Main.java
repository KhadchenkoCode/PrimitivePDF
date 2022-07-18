package com.MavenPdf;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException {
String txt = "error";
        try {
            txt = ReadPDFFile("G:\\Programs\\CODE\\JAVA\\Literature\\java_biblioteka_professionala_kej_xorstmann.pdf"); //ну вот есть plainText из файла, а дальше что?
        } catch (Exception e) {
            e.printStackTrace();
        }
     //   System.out.println("after method call");
       // System.out.println(txt);
        String path = "G:\\Programs\\CODE\\JAVA\\Literature\\test.txt";
        WriteBuffered(path, txt);
    }

    public static String ReadPDFFile(String path) throws Exception {

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        PDDocument pdfDocument = PDDocument.load(fis);

       // System.out.println("Number of Pages: " +pdfDocument.getPages().getCount());

        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String docText = pdfTextStripper.getText(pdfDocument);

        //System.out.println(docText);

        pdfDocument.close();
        fis.close();

    return docText;
    }
    public static void WriteBuffered(String fileName, String str)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);

        writer.close();
    }
}
