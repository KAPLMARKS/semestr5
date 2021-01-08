package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.SneakyThrows;
import model.UserData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Date;

public class PdfConverter {

    private final String path;

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 24,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.NORMAL);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public PdfConverter(String path) {
        this.path = path;
    }

    @SneakyThrows
    public void createDocument(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserData userData = objectMapper.readValue(data, UserData.class);

        createHokageDocument(userData);
        createKazekageDocument(userData);
        createMizukageDocument(userData);
        createRaikageDocument(userData);
    }

    private void createHokageDocument(UserData userData) throws DocumentException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(path + "\\" +
                    userData.getSurname() + "_" + "hokage.pdf")));
            document.open();
            addTitle(document, "Hokage");

            addMainText(document, "I'm " + userData.getSurname() + " " + userData.getName() + " " +
                   userData.getAge() + " years old hokage" + " passport" + userData.getPassportNumber() + " " + userData.getIssueDate());
            document.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
    private void createKazekageDocument(UserData userData) throws DocumentException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(path + "\\" +
                    userData.getSurname() + "_" + "kazekage.pdf")));
            document.open();
            addTitle(document, "Kazekage");

            addMainText(document, "I'm " + userData.getSurname() + " " + userData.getName() + " " +
                    userData.getAge() + " years old kazekage" + " passport" + userData.getPassportNumber() + " " + userData.getIssueDate());
            document.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
    private void createMizukageDocument(UserData userData) throws DocumentException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(path + "\\" +
                    userData.getSurname() + "_" + "Mizukage.pdf")));
            document.open();
            addTitle(document, "Mizukage");

            addMainText(document, "I'm " + userData.getSurname() + " " + userData.getName() + " " +
                    userData.getAge() + " years old mizukage" + " passport" + userData.getPassportNumber() + " " + userData.getIssueDate());
            document.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
    private void createRaikageDocument(UserData userData) throws DocumentException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(path + "\\" +
                    userData.getSurname() + "_" + "raikage.pdf")));
            document.open();
            addTitle(document, "Raikage");

            addMainText(document, "I'm " + userData.getSurname() + " " + userData.getName() + " " +
                    userData.getAge() + " years old raikage" + " passport" + userData.getPassportNumber() + " " + userData.getIssueDate());
            document.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }


    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }


    private void addTitle(Document document, String text) throws DocumentException {
        Paragraph preface = new Paragraph(text, titleFont);
        preface.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(preface, 1);
        document.add(preface);
    }

    private void addMainText(Document document, String text) throws DocumentException {
        Paragraph preface = new Paragraph(text, subFont);
        preface.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(preface, 1);
        document.add(preface);
    }

}