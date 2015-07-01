package com.techconquerors.slippers.controllers;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

import com.techconquerors.slippers.jpa.User;

public class DynamicReport {

	public static void main(String[] args) {
		JasperReportBuilder report = DynamicReports.report();
		TextFieldBuilder<String> title = DynamicReports.cmp.text("Dynamic Report Testing");
		title.setStyle(DynamicReports.stl.style().setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setBackgroundColor(Color.yellow));
		report.title(title);
		report.columns(Columns.column("Id", "id", DataTypes.longType()),
				Columns.column("UserName", "userName", DataTypes.stringType()));
		
		List<User> users = new ArrayList<User>();
		User u1 = new User();
		User u2 = new User();
		u1.setId(10L);
		u1.setUserName("govind");
		users.add(u1);
		u2.setId(11L);
		u2.setUserName("hanuma");
		users.add(u2);
		
		report.setDataSource(users);
		
		try {
			report.toPdf(new FileOutputStream("/home/dev/reportTest.pdf"));
			report.show();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
