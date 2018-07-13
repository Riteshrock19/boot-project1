package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsView {
	protected void buildExcelDocument(Map<String, Object> map, Workbook book, HttpServletRequest req, 
			HttpServletResponse res)throws Exception{
		//File Name Setting
		res.addHeader("Content-Disposition", "attachment:filename=\"UOMsData.xlsx\"");
		List<Uom> uomList = (List<Uom>)map.get("uomList");
		Sheet sheet = book.createSheet("UOMs");
		setHead(sheet);
		setBody(sheet, uomList);
	}
	private void setHead(Sheet sheet){
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("UOM ID");
		row.createCell(1).setCellValue("UOM TYPE");
		row.createCell(2).setCellValue("UOM MODEL");
		row.createCell(3).setCellValue("CREATED");
		row.createCell(4).setCellValue("MODIFIED");
		row.createCell(5).setCellValue("NOTES");
	}
	private void setBody(Sheet sheet, List<Uom> uomList){
		int rowNum = 1;
		for(Uom uom:uomList){
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(uom.getUomId());
			row.createCell(1).setCellValue(uom.getUomModel());
			row.createCell(2).setCellValue(uom.getCreatedDate().toString());
			row.createCell(3).setCellValue(uom.getLastModifiedDate()!=null?uom.getLastModifiedDate().
					toString():"-NA-");
			row.createCell(4).setCellValue(uom.getUomType());
			row.createCell(5).setCellValue(uom.getDescription());
		}
	}
}
