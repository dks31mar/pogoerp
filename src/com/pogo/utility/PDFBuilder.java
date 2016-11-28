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
import com.pogo.bean.PrinicipalPoPDFBean;

public class PDFBuilder extends AbstractITextPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String po="SPO/16-17/007";
		String date="27/10/2016";
		String Name="Deepak";
		double totalqty=0.0;
		double totlprice=0.0;
		// get data model which is passed by the Spring container
		Font f3 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f);
		List<PrinicipalPoPDFBean> listBooks = (List<PrinicipalPoPDFBean>) model.get("listBooks");
		List<PrinicipalPoPDFBean> listBooks1 = (List<PrinicipalPoPDFBean>) model.get("listBooks");
		
		for(PrinicipalPoPDFBean data:listBooks1){
			
			po=data.getPorefno();
			date=data.getPorefdate();
			Name=data.getPrincipalname();
			totalqty=data.getTotalQty();
			totlprice=data.getTotalprice();
		}
		
		
		Image img = Image.getInstance(("C:\\Users\\Abc\\Desktop\\pogo_erp_logo.png"));
		img.scaleAbsolute(140f, 80f);
		Chunk chk=new Chunk("Technobridge Innovations PVT. LTD.\n"+
								"5th floor, Mantec Towers C-56/5,\n"+
									"Sector-62 Noida 201 301, (U.P.),\n"+
										"INDIA 91-120-4286134");
		Phrase phra=new Phrase();
		phra.add(chk);
		Paragraph header=new Paragraph("",f3);
		header.add(img);
		header.add(phra);
		header.setAlignment(Element.ALIGN_RIGHT);
		//Paragraph header = new Paragraph(new Chunk("Generate Pdf USing Spring Mvc",FontFactory.getFont(FontFactory.HELVETICA, 30))).setAlignment(Element.ALIGN_RIGHT);;
		/*doc.add(new Paragraph("Recommended books for Spring framework"));*/
		//doc.add(img);
		Paragraph para1=new Paragraph("",f3);
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
		//para1.setFont();
		doc.add(header);
		doc.add(para1);
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(110.0f);
		table.setWidths(new float[] {1.0f, 4.0f, 3.0f, 2.0f, 1.0f,2.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font1 = FontFactory.getFont(FontFactory.TIMES_ROMAN,10);
		font1.setColor(BaseColor.WHITE);
		
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPadding(3);
		
		// write table header 
		cell.setPhrase(new Phrase("Sr.No", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Description", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Part No.", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("TP In JPY", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("QTY", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total JPY", font1));
		table.addCell(cell);
		
		for (PrinicipalPoPDFBean aBook : listBooks) {
			table.addCell(new Phrase(""+Integer.toString(aBook.getPorefentryitemdetailid()),f3));
			table.addCell(new Phrase(""+aBook.getProductdescription(),f3));
			table.addCell(new Phrase(""+aBook.getParticular() ,f3));
			table.addCell(new Phrase(""+aBook.getTpinjpy() ,f3));
			table.addCell(new Phrase(""+Double.toString(aBook.getQty()) ,f3));
			table.addCell(new Phrase(""+Double.toString(aBook.getTotal()) ,f3));
			}
		for(int i=0;i<6;i=i+6){
			table.addCell(" ");
			table.addCell(new Phrase("Total(Qty & Amount)",f3));
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(new Phrase(Double.toString(totalqty),f3));
			table.addCell(new Phrase(Double.toString(totlprice),f3));
			}
		table.addCell("A; Total(Qty & Amount); B; C; D; E");
		Paragraph total=new Paragraph("",f3);
		Paragraph footer=new Paragraph("",f3);
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