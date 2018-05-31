package juniu.trade.wholesalestalls;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author juniu
 * @date 18/5/31
 * @description values生成工具类
 */

public class ValuesGenUtil {

    /**
     * 生成不同分辨率的字体文件
     *
     * @param sizeArr      基本的字体大小(values_mdpi)
     * @param curTypeLevel 当前的字体级别
     */
    public static void genFontFile(float[] sizeArr, TypeLevel curTypeLevel) {
        if (sizeArr == null || sizeArr.length == 0) {
            return;
        }

        if (curTypeLevel == null) {
            curTypeLevel = TypeLevel.values_mdpi;
        }

        sizeArr = changeFontSizeArrToBase(sizeArr, curTypeLevel);

        String baseFilePath = "./app/src/main/res/";
        String fileName = "font_size.xml";

//        StringBuilder values = new StringBuilder();
        StringBuilder values_mdpi = new StringBuilder();
        StringBuilder values_hdpi = new StringBuilder();
        StringBuilder values_xhdpi = new StringBuilder();
        StringBuilder values_xxhdpi = new StringBuilder();
        StringBuilder values_xxxhdpi = new StringBuilder();


        String valuesFile = baseFilePath + "values" + "/" + fileName;
        String valuesMdpiFile = baseFilePath + "values-mdpi" + "/" + fileName;
        String valuesHdpiFile = baseFilePath + "values-hdpi" + "/" + fileName;
        String valuesXhdpiFile = baseFilePath + "values-xhdpi" + "/" + fileName;
        String valuesXxhdpiFile = baseFilePath + "values-xxhdpi" + "/" + fileName;
        String valuesXxxhdpiFile = baseFilePath + "values-xxxhdpi" + "/" + fileName;

        try {
            System.out.println("开始生成不同分辨率字体文件...");
            String fileHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<resources>\n";
            String fileFooter = "</resources>";

            values_mdpi.append(fileHeader);
            values_hdpi.append(fileHeader);
            values_xhdpi.append(fileHeader);
            values_xxhdpi.append(fileHeader);
            values_xxxhdpi.append(fileHeader);

            int index = 0;

            for (float fontSize : sizeArr) {
                float fontSizeHdpi = fontSize * 1.5f;
                float fontSizeXhdpi = fontSize * 2.0f;
                float fontSizeXxhdpi = fontSize * 3.0f;
                float fontSizeXxxhdpi = fontSize * 5.0f;

                index++;

                values_mdpi.append(getFontRow(index,fontSize));
                values_hdpi.append(getFontRow(index,fontSizeHdpi));
                values_xhdpi.append(getFontRow(index,fontSizeXhdpi));
                values_xxhdpi.append(getFontRow(index,fontSizeXxhdpi));
                values_xxxhdpi.append(getFontRow(index,fontSizeXxxhdpi));
            }

            values_mdpi.append(fileFooter);
            values_hdpi.append(fileFooter);
            values_xhdpi.append(fileFooter);
            values_xxhdpi.append(fileFooter);
            values_xxxhdpi.append(fileFooter);

            System.out.println("--------values-mdpi---------");
            System.out.println(values_mdpi);

            System.out.println("--------values-hdpi---------");
            System.out.println(values_hdpi);

            System.out.println("--------values-xhdpi---------");
            System.out.println(values_xhdpi);

            System.out.println("--------values-xxhdpi---------");
            System.out.println(values_xxhdpi);

            System.out.println("--------values-xxxhdpi---------");
            System.out.println(values_xxxhdpi);

            writeFile(valuesMdpiFile, values_mdpi.toString());
            writeFile(valuesHdpiFile, values_hdpi.toString());
            writeFile(valuesXhdpiFile, values_xhdpi.toString());
            writeFile(valuesXxhdpiFile, values_xxhdpi.toString());
            writeFile(valuesXxxhdpiFile, values_xxxhdpi.toString());

            System.out.println("不同分辨率字体文件生成成功...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("不同分辨率字体文件生成失败...");
        } finally {
            System.out.println("不同分辨率字体文件生成结束...");
        }

    }

    /**
     * 通过字体获取行
     *
     * @param key      名称(数字叠加)
     * @param fontSize 字体大小
     * @return
     */
    public static String getFontRow(int key, float fontSize) {
        String name = String.valueOf(key).replace(".", "_");
        return "<dimen name=\"font_" + name + "\">" + fontSize + "px</dimen>\n";
    }


    /**
     * 写入方法
     *
     * @param file 文件路径
     * @param text 写入的文本
     */
    public static void writeFile(String file, String text) {

        PrintWriter out = null;

        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 将当前的字体数组转换为基本的字体数组
     *
     * @param fontSizeArr  当前字体大小数组
     * @param curTypeLevel 当前的字体级别
     * @return
     */
    public static float[] changeFontSizeArrToBase(float[] fontSizeArr, TypeLevel curTypeLevel) {
        if (fontSizeArr == null || fontSizeArr.length == 0) {
            return fontSizeArr;
        }
        if (curTypeLevel == null) {
            return fontSizeArr;
        }

        float rate = 1.0f;

        if (curTypeLevel == TypeLevel.values_mdpi) {
            return fontSizeArr;
        } else if (curTypeLevel == TypeLevel.values_hdpi) {
            rate = 1.5f;
        } else if (curTypeLevel == TypeLevel.values_xhdpi) {
            rate = 2.0f;
        } else if (curTypeLevel == TypeLevel.values_xxhdpi) {
            rate = 3.0f;
        } else if (curTypeLevel == TypeLevel.values_xxxhdpi) {
            rate = 5.0f;
        }

        int len = fontSizeArr.length;

        float[] tempFontSizeArr = new float[len];

        for (int i = 0; i < len; i++) {
            tempFontSizeArr[i] = fontSizeArr[i] / rate;
        }

        return tempFontSizeArr;
    }


    /**
     * 当前字体级别
     */
    public enum TypeLevel {
        values_mdpi,
        values_hdpi,
        values_xhdpi,
        values_xxhdpi,
        values_xxxhdpi
    }

}
