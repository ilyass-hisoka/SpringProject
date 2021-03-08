package com.ily.springMvcProject.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;


@Component(value = "xlsView")
public class XlsView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		workbook.createName();
		Sheet sheet = workbook.createSheet("newsheet");
		sheet.setFitToPage(true);
		for (int i = 0; i < 10; i++)
			sheet.createRow(i);
		sheet.forEach(r -> {
		    				for (int j =0; j<10;j++)
		    					{
		    					Cell c = r.createCell(j);
		    					c.setCellValue("column "+model.get("user")+j);
		    					}
					}
				);
		response.setHeader("Content-Disposition", "attachment; filename=forex-rates.xlsx");
	}

	

}
