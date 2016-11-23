package com.pogo.utility;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pogo.bean.Book;

public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String po="SPO/16-17/007";
		String date="27/10/2016";
		String Name="Deepak";
		// get data model which is passed by the Spring container
		
		List<Book> listBooks = (List<Book>) model.get("listBooks");
		Image img = Image.getInstance(("C:\\Users\\Abc\\Desktop\\pogo_erp_logo.png"));
		img.scaleAbsolute(160f, 100f);
		Chunk chk=new Chunk("Technobridge Innovations PVT. LTD.\n"+
 "5th floor, Mantec Towers C-56/5,\n"+
 "Sector-62 Noida 201 301, (U.P.),\n"+
 "INDIA 91-120-4286134");
		Phrase phra=new Phrase();
		phra.add(chk);
		Paragraph header=new Paragraph();
		header.add(img);
		header.add(phra);
		header.setAlignment(Element.ALIGN_RIGHT);
		//Paragraph header = new Paragraph(new Chunk("Generate Pdf USing Spring Mvc",FontFactory.getFont(FontFactory.HELVETICA, 30))).setAlignment(Element.ALIGN_RIGHT);;
		/*doc.add(new Paragraph("Recommended books for Spring framework"));*/
		//doc.add(img);
		Paragraph para1=new Paragraph();
		para1.add("PO Reference No:-\t     "+po);
		para1.add("\nDate:-\t\t\t                              "+date);
		para1.add("\n");
		para1.add("\n");
		para1.add("\nTo,");
		para1.add("\nYMC. Co. Ltd.\n"+
"YMC-KARASUMA-Go-Jo Building\n"+
"284 Da I Go cho\n"+
"Karasuma Nishiliru Go jo dori\n"+
"Shimogyo-ku-Kyoto 600-8106 Japan");
		para1.add("\n");
		para1.add("\n");
		para1.add("\n");
		para1.add("Dear "+Name+",");
		para1.add("\n");
		para1.add("\n");
		para1.add("We are pleased to place the firm order as per below");
		para1.add("\n");
		doc.add(header);
		doc.add(para1);
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPadding(5);
		
		// write table header 
		cell.setPhrase(new Phrase("Sr.No", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Description", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Part No.", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("TP In JPY", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("QTY", font));
		table.addCell(cell);
		
		
		for (Book aBook : listBooks) {
			table.addCell(aBook.getTitle());
			table.addCell(aBook.getAuthor());
			table.addCell(aBook.getIsbn());
			table.addCell(aBook.getPublishedDate());
			table.addCell(String.valueOf(aBook.getPrice()));
		}
		Paragraph total=new Paragraph();
		Paragraph footer=new Paragraph();
		footer.add("\n");
		footer.add("\n");
		footer.add("You are requested to kindly acknowledge the receipt of this order and arrange for a shipment at our Delhi office.");
		
		footer.add("\n");
		footer.add("\n");
		footer.add("\n");
		footer.add("\n");
		footer.add("For YMC India Private Limited");
		footer.add("\n");
		footer.add("\n");
		footer.add("\n");
		footer.add("\n");
		footer.add("Authorized Signatory");
		total.add("Total(Qty & Amount)");
		doc.add(table);
		doc.add(footer);
	}

}