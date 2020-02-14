package com.orange.donateforcause.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.orange.donateforcause.repository.PaymentRepository;
import com.orange.donateforcause.util.DonateUtil;

/**
 * Utility class to generate PDF.
 */
@Component
public class DonateForCausePDFGenerator {

	public static final Logger logger = LoggerFactory.getLogger(DonateForCausePDFGenerator.class);
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	private Environment environment;

	public static void donateForCausePDFGenerator(String[] args) {
		try {

			OutputStream file = new FileOutputStream(new File("C:\\Users\\User1\\Documents\\PdfLocation\\tsS.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			PdfPTable table = new PdfPTable(1);
			PdfPCell cell = new PdfPCell(new Paragraph(DonateUtil.DONAR_DETAIL));
			cell.setColspan(1);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(10.f);
			cell.setBackgroundColor(new BaseColor(140, 221, 8));
			table.addCell(cell);
			table.addCell(DonateUtil.DONAR_NAME);
			table.addCell(DonateUtil.DONATION_SCHEMA);
			table.addCell(DonateUtil.AMOUNT);
			table.addCell(DonateUtil.TAX_BENEFIT_AMOUNT);
			table.addCell(DonateUtil.PAN_NUMBER);
			table.setSpacingBefore(20.0f);
			table.setSpacingAfter(20.0f);
			document.open();
			document.add(table);
			document.close();
			file.close();

		} catch (Exception exception) {
			logger.error("Exception occured while generating PDF.");
		}
	}
}
