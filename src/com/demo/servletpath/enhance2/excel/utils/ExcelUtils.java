package com.demo.servletpath.enhance2.excel.utils;

import com.demo.servletpath.enhance2.excel.bean.User;
import com.demo.servletpath.enhance2.excel.service.UserService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 7 on 2016/12/30.
 */
public class ExcelUtils {
	public static void getUserExcel(String fileName) throws IOException {
		WritableWorkbook wwb;
		// 创建可写入的Excel工作簿

		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		//以fileName为文件名来创建一个Workbook
		wwb = Workbook.createWorkbook(file);
		// 创建工作表
		WritableSheet ws = wwb.createSheet("Test Sheet 1", 0);
		//查询数据库中所有的数据
		UserService service = new UserService();
		List<User> list = null;
		try {
			list = service.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {

		}
		//要插入到的Excel表格的行号，默认从0开始
		Label labelId = new Label(0, 0, "编号(id)");//表示第
		Label labelName = new Label(1, 0, "姓名(name)");
		Label labelSex = new Label(2, 0, "性别(sex)");
		Label labelNum = new Label(3, 0, "薪水(num)");
		try {
			ws.addCell(labelId);
			ws.addCell(labelName);
			ws.addCell(labelSex);
			ws.addCell(labelNum);
			for (int i = 0; i < list.size(); i++) {
				Label labelId_i = new Label(0, i + 1, list.get(i).getId() + "");
				Label labelName_i = new Label(1, i + 1, list.get(i).getUsername());
				Label labelSex_i = new Label(2, i + 1, list.get(i).getPassword());
				Label labelNum_i = new Label(3, i + 1, list.get(i).getRole() + "");
				ws.addCell(labelId_i);
				ws.addCell(labelName_i);
				ws.addCell(labelSex_i);
				ws.addCell(labelNum_i);
			}

			//写进文档
			wwb.write();
			// 关闭Excel工作簿对象
			wwb.close();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
