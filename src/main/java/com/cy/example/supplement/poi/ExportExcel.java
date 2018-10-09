package com.cy.example.supplement.poi;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @description: excel导出工具类
 * @author: chenyang
 * @create: 2018-10-08
 **/
@Data
public class ExportExcel {
    //sheet名
    private String sheetName;
    //表头字体
    private String titleFontType = "微软雅黑";
    //表头背景色
    private String titleBackColor = "00a4ac";
    //表头字号
    private short titleFontSize = 12;
    //添加自动筛选的列 如 A:M
    private String address = "";
    //正文字体
    private String contentFontType = "微软雅黑";
    //正文字号
    private short contentFontSize = 11;
    //Float类型数据小数位
    private String floatDecimal = ".00";
    //Double类型数据小数位
    private String doubleDecimal = ".00";
    //设置列的公式
    private String colFormula[] = null;

    DecimalFormat floatDecimalFormat=new DecimalFormat(floatDecimal);
    DecimalFormat doubleDecimalFormat=new DecimalFormat(doubleDecimal);


    public ExportExcel(String sheetName){
        this.sheetName = sheetName;
    }

    /**
     * 写excel.
     * @param titleColumn  对应bean的属性名
     * @param titleName   excel要导出的表名
     * @param dataList  数据
     */
    public HSSFWorkbook wirteExcel(String titleColumn[], String titleName[], List<?> dataList){
        int titleSize[] = new int[titleColumn.length];
        Arrays.fill(titleSize,titleFontSize);
        return wirteExcel(titleColumn,titleName,titleSize,dataList);
    }

    /**
     * 写excel.
     * @param titleColumn  对应bean的属性名
     * @param titleName   excel要导出的表名
     * @param titleSize   列宽
     * @param dataList  数据
     */
    public HSSFWorkbook wirteExcel(String titleColumn[], String titleName[], int titleSize[], List<?> dataList){

        HSSFWorkbook workbook = new HSSFWorkbook();

        //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
        Sheet sheet = workbook.createSheet(this.sheetName);
        try {

            //写入excel的表头
            Row titleNameRow = workbook.getSheet(sheetName).createRow(0);
            //设置样式
            HSSFCellStyle titleStyle = workbook.createCellStyle();
            titleStyle = (HSSFCellStyle) setFontAndBorder(workbook,titleStyle, titleFontType, (short) titleFontSize,true);
            titleStyle = (HSSFCellStyle) setColor(workbook,titleStyle, titleBackColor, (short)10);

            for(int i = 0;i < titleName.length;i++){
                sheet.setColumnWidth(i, titleSize[i]*256);    //设置宽度
                Cell cell = titleNameRow.createCell(i);
                cell.setCellStyle(titleStyle);
                cell.setCellValue(titleName[i].toString());
            }

            //为表头添加自动筛选
            if(!"".equals(address)){
                CellRangeAddress c = (CellRangeAddress) CellRangeAddress.valueOf(address);
                sheet.setAutoFilter(c);
            }

            //通过反射获取数据并写入到excel中
            if(dataList!=null&&dataList.size()>0){
                //设置样式
                HSSFCellStyle dataStyle = workbook.createCellStyle();
                dataStyle = (HSSFCellStyle) setFontAndBorder(workbook,dataStyle, contentFontType, (short) contentFontSize,false);

                if(titleColumn.length>0){
                    for(int rowIndex = 1;rowIndex<=dataList.size();rowIndex++){
                        Object obj = dataList.get(rowIndex-1);     //获得该对象
                        Class clsss = obj.getClass();     //获得该对对象的class实例
                        Row dataRow = workbook.getSheet(sheetName).createRow(rowIndex);
                        for(int columnIndex = 0;columnIndex<titleColumn.length;columnIndex++){
                            String title = titleColumn[columnIndex].trim();
                            Cell cell = dataRow.createCell(columnIndex);
                            if(!"".equals(title)){  //字段不为空
                                //使首字母大写
                                String UTitle = Character.toUpperCase(title.charAt(0))+ title.substring(1, title.length()); // 使其首字母大写;
                                String methodName  = "get"+UTitle;

                                // 设置要执行的方法
                                Method method = clsss.getDeclaredMethod(methodName);

                                //获取返回类型
                                String returnType = method.getReturnType().getName();

                                String data = method.invoke(obj)==null?"":method.invoke(obj).toString();
                                if(data!=null&&!"".equals(data)){
                                    if("int".equals(returnType)){
                                        cell.setCellValue(Integer.parseInt(data));
                                    }else if("long".equals(returnType)){
                                        cell.setCellValue(Long.parseLong(data));
                                    }else if("float".equals(returnType)){
                                        cell.setCellValue(floatDecimalFormat.format(Float.parseFloat(data)));
                                    }else if("double".equals(returnType)){
                                        cell.setCellValue(doubleDecimalFormat.format(Double.parseDouble(data)));
                                    }else{
                                        cell.setCellValue(data);
                                    }
                                }
                            }else{   //字段为空 检查该列是否是公式
                                if(colFormula!=null){
                                    String sixBuf = colFormula[columnIndex].replace("@", (rowIndex+1)+"");
                                    cell.setCellFormula(sixBuf);
                                }
                            }

                            cell.setCellStyle(dataStyle);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    /**
     * 将16进制的颜色代码写入样式中来设置颜色
     * @param style  保证style统一
     * @param color 颜色：66FFDD
     * @param index 索引 8-64 使用时不可重复
     * @return
     */
    public CellStyle setColor(HSSFWorkbook workbook,CellStyle style, String color, short index){
        if(color!=""&&color!=null){
            //转为RGB码
            int r = Integer.parseInt((color.substring(0,2)),16);   //转为16进制
            int g = Integer.parseInt((color.substring(2,4)),16);
            int b = Integer.parseInt((color.substring(4,6)),16);
            //自定义cell颜色
            HSSFPalette palette = workbook.getCustomPalette();
            palette.setColorAtIndex((short)index, (byte) r, (byte) g, (byte) b);

            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setFillForegroundColor(index);
        }
        return style;
    }

    /**
     * 设置字体并加外边框
     * @param style  样式
     * @param style  字体名
     * @param style  大小
     * @param style  是否加粗
     * @return
     */
    public CellStyle setFontAndBorder(HSSFWorkbook workbook,CellStyle style,String fontName,short size,boolean weight){
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints(size);
        font.setFontName(fontName);
        font.setBold(weight);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框
        return style;
    }
}
