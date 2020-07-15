package com.jx.pub.common.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-01-30 18:39
 **/
public class POIUtil {

    /**
     * 注意：关于金额的数据 要转为Double类型
     *
     * @param sheetName   sheet名称
     * @param list        数据
     * @param headersName 行头（数组）
     * @param keys        关键字(对应数据中map的key)
     * @return
     */
    public static SXSSFWorkbook export(String sheetName, List<Map<String, Object>> list, String[] headersName, String[] keys) {
        //创建HSSFWorkbook对象(excel的文档对象)
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        Sheet sheet = sxssfWorkbook.createSheet(sheetName);
        //固定行 不滚动;
        /*  参数说明：
            cellNum:表示要冻结的列数；
            rowNum:表示要冻结的行数；
            firstCellNum:表示被固定列右边第一列的列号；
            firstRollNum :表示被固定行下边第一列的行号;
         */
        sheet.createFreezePane(0, 1, 0, 1);

        /*
           设置表头行的字体
         */
        Font font = sxssfWorkbook.createFont();
        font.setFontName("幼圆");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short) 12);
        CellStyle cellStyle = sxssfWorkbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        /*
         * 创建表头行
         * sheet.createRow(0); 参数为一行中的第几个单元格
         * setHeight((short) (18 * 20)); 设置行高 注意：POI中的行高＝Excel的行高度*20
         * rowHead.createCell(i); 创建列，参数为第几列
         * sheet.setColumnWidth(i, (7 * 256 +184)); 设置列宽,参数：第几列，宽度(实际宽度*256+184)
         */
        Row rowHead = sheet.createRow(0);
        rowHead.setHeight((short) (33 * 20));
        //存放表头信息
        for (int i = 0; i < headersName.length; i++) {
            Cell cellHead = rowHead.createCell(i);
            cellHead.setCellStyle(cellStyle);
            if (i == 0) {
                sheet.setColumnWidth(i, (7 * 256 + 184));
            } else {
                sheet.setColumnWidth(i, 13 * 256 + 184);
            }
            cellHead.setCellValue(headersName[i]);
        }

        DataFormat format = sxssfWorkbook.createDataFormat();
        CellStyle moneyStyle = sxssfWorkbook.createCellStyle();
        moneyStyle.setDataFormat(format.getFormat("#,##0.00"));
        /**
         * 遍历list 集合 并动态创建行
         * Row(0)为表头
         * 创建新的行 起始行为:1 ,结束行为list.size()+1
         */
        for (int i = 0; i < list.size(); i++) {
            Row rowContent = sheet.createRow(i + 1);
            rowContent.setHeight((short) (15 * 20));
            // 设置序号
            rowContent.createCell(0).setCellValue(i + 1);
            //设置内容
            for (int j = 0; j < keys.length; j++) {
                String key = keys[j];
                Object object = list.get(i).get(key);
                //数值类型
                if (null != object && (object instanceof Double)) {
                    Cell cell = rowContent.createCell(j + 1);
                    cell.setCellStyle(moneyStyle);
                    cell.setCellValue((double) object);
                } else { //其他类型
                    if (null == object) {
                        object = "";
                    }
                    rowContent.createCell(j + 1).setCellValue(object.toString());
                }
            }
        }
        return sxssfWorkbook;
    }

    /**
     * 向response写入Excel文件
     *
     * @param fileName
     * @param export
     * @param response
     * @throws IOException
     */
    public static void writeTo(String fileName, SXSSFWorkbook export, HttpServletResponse response) throws IOException {
        response.setHeader("Content-disposition", "attachment; filename=" +
                new String((fileName + ".xlsx").getBytes("UTF-8"), "ISO-8859-1"));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download charset=UTF-8");

        OutputStream outputStream = response.getOutputStream();
        try {
            export.write(outputStream);
            outputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
