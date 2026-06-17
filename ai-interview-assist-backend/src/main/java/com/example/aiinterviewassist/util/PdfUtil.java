package com.example.aiinterviewassist.util;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class PdfUtil {
    public String extractText(MultipartFile file){
        try{
            PDDocument document= Loader.loadPDF(file.getBytes());
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String content = pdfStripper.getText(document);
            document.close();
            return content;
        }
        catch (Exception e){
            throw new RuntimeException("Failed to extract Pdf");
        }
    }
}
