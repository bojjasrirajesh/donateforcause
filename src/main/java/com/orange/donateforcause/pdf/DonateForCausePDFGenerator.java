package com.orange.donateforcause.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.orange.donateforcause.entity.DonationSchemes;
import com.orange.donateforcause.entity.PaymentDetails;
import com.orange.donateforcause.repository.DonorRepository;
import com.orange.donateforcause.util.DonateUtil;

/**
 * Utility class to generate PDF.
 */
@Component
public class DonateForCausePDFGenerator {

	public static final Logger logger = LoggerFactory.getLogger(DonateForCausePDFGenerator.class);

	@Autowired
	private DonorRepository donorRepository;
	
	@Autowired
	private Environment environment;

	/**
	 * Method to generate PDF file.
	 * 
	 * @param paymentDetails
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public String donateForCausePDFGenerator(PaymentDetails paymentDetails) throws IOException, DocumentException {		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());			
		String pdfFileName = environment.getProperty("pdf.file.path")+paymentDetails.getPanCard()+timestamp.getTime()+".pdf";
		OutputStream pdfFileType = new FileOutputStream(new File(pdfFileName));			
		Optional<DonationSchemes> donationSchemes = donorRepository.findById(paymentDetails.getDonationSchemeId());
		if(donationSchemes.isPresent()) {
			Document document = new Document();
			PdfWriter.getInstance(document, pdfFileType);
			PdfPTable table = new PdfPTable(1);
			PdfPCell cell = new PdfPCell(new Paragraph(DonateUtil.DONAR_DETAIL));
			cell.setColspan(1);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(10.f);
			cell.setBackgroundColor(new BaseColor(140, 221, 8));
			table.addCell(cell);
			table.addCell(DonateUtil.DATE					+paymentDetails.getDonationDate());
			table.addCell(DonateUtil.DONAR_NAME				+paymentDetails.getDonorName());
			table.addCell(DonateUtil.DONATION_SCHEMA		+donationSchemes.get().getSchemName());
			table.addCell(DonateUtil.DONATED_AMOUNT			+donationSchemes.get().getDonationAmount() +"Rupees.");
			table.addCell(DonateUtil.TAX_BENEFIT_AMOUNT		+paymentDetails.getTaxBenefitAMount());
			table.addCell(DonateUtil.PAN_NUMBER				+paymentDetails.getPanCard());
			table.addCell(DonateUtil.EMAIL					+paymentDetails.getEmail());
			table.addCell(DonateUtil.CARD_NUMBER			+paymentDetails.getCardNo());
			table.addCell(DonateUtil.CARD_TYPE				+paymentDetails.getCardType());			
			table.setSpacingBefore(20.0f);
			table.setSpacingAfter(20.0f);
			document.open();
			document.add(table);
			document.close();	
		}	
		pdfFileType.close();
		return pdfFileName;
	}
}
