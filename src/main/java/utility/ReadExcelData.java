package utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dto.ComboFamilyRegData;
import dto.ComboRegData;
import dto.FamilyRegData;

public class ReadExcelData {

	public static List<ComboRegData> readComboRegData()
	{
		List<ComboRegData> combolist=null;
		try{
			combolist=new ArrayList<ComboRegData>();
			FileInputStream fis=new FileInputStream("D:\\bdtestdata.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("comboregdata");
			int rownum=sh.getLastRowNum();
			ComboRegData regdata;
			for(int i=1;i<=rownum;i++)
			{
				regdata=new ComboRegData();
				regdata.setMsisdn(sh.getRow(i).getCell(0).getStringCellValue());
				regdata.setCustomername(sh.getRow(i).getCell(1).getStringCellValue());
				regdata.setAge(Integer.parseInt(sh.getRow(i).getCell(2).getStringCellValue()));
				regdata.setGender(sh.getRow(i).getCell(3).getStringCellValue());
				regdata.setOfferid(Integer.parseInt(sh.getRow(i).getCell(4).getStringCellValue()));
				regdata.setNomineerelationship(sh.getRow(i).getCell(5).getStringCellValue());
				regdata.setNomineename(sh.getRow(i).getCell(6).getStringCellValue());
				regdata.setNomineemsisdn(sh.getRow(i).getCell(7).getStringCellValue());
				regdata.setHealthtip(Integer.parseInt(sh.getRow(i).getCell(8).getStringCellValue()));
				regdata.setHealthtiplang(sh.getRow(i).getCell(9).getStringCellValue());
				combolist.add(regdata);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return combolist;
	}

	public static List<FamilyRegData> readFamilyRegData()
	{
		List<FamilyRegData> familylist=null;
		try{
			familylist=new ArrayList<FamilyRegData>();
			FileInputStream fis=new FileInputStream("D:\\bdtestdata.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("familyregdata");
			int rownum=sh.getLastRowNum();
			FamilyRegData regdata;
			for(int i=1;i<=rownum;i++)
			{
				regdata=new FamilyRegData();
				regdata.setMsisdn(sh.getRow(i).getCell(0).getStringCellValue());
				regdata.setCustomername(sh.getRow(i).getCell(1).getStringCellValue());
				regdata.setAge(Integer.parseInt(sh.getRow(i).getCell(2).getStringCellValue()));
				regdata.setGender(sh.getRow(i).getCell(3).getStringCellValue());
				regdata.setOfferid(Integer.parseInt(sh.getRow(i).getCell(4).getStringCellValue()));
				regdata.setFirstbeneficiaryrelationship(sh.getRow(i).getCell(5).getStringCellValue());
				regdata.setFirstbeneficiaryname(sh.getRow(i).getCell(6).getStringCellValue());
				regdata.setFirstbeneficiarymsisdn(sh.getRow(i).getCell(7).getStringCellValue());
				regdata.setFirstbeneficiarygender(sh.getRow(i).getCell(8).getStringCellValue());
				regdata.setFirstbeneficiaryage(Integer.parseInt(sh.getRow(i).getCell(9).getStringCellValue()));
				if(!sh.getRow(i).getCell(10).getStringCellValue().equals("null"))
				{
				regdata.setSecondbeneficiaryrelationship(sh.getRow(i).getCell(10).getStringCellValue());
				regdata.setSecondbeneficiaryname(sh.getRow(i).getCell(11).getStringCellValue());
				regdata.setSecondbeneficiarymsisdn(sh.getRow(i).getCell(12).getStringCellValue());
				regdata.setSecondbeneficiarygender(sh.getRow(i).getCell(13).getStringCellValue());
				regdata.setSecondbeneficiaryage(Integer.parseInt(sh.getRow(i).getCell(14).getStringCellValue()));
				}
				regdata.setHealthtip(Integer.parseInt(sh.getRow(i).getCell(15).getStringCellValue()));
				regdata.setHealthtiplang(sh.getRow(i).getCell(16).getStringCellValue());
				familylist.add(regdata);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return familylist;
	}
	
	public static List<ComboFamilyRegData> readComboFamilyRegData()
	{
		List<ComboFamilyRegData> combofamilylist=null;
		try{
			combofamilylist=new ArrayList<ComboFamilyRegData>();
			FileInputStream fis=new FileInputStream("D:\\bdtestdata.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("combofamilyregdata");
			int rownum=sh.getLastRowNum();
			ComboFamilyRegData regdata;
			for(int i=1;i<=rownum;i++)
			{
				regdata=new ComboFamilyRegData();
				regdata.setMsisdn(sh.getRow(i).getCell(0).getStringCellValue());
				regdata.setCustomername(sh.getRow(i).getCell(1).getStringCellValue());
				regdata.setAge(Integer.parseInt(sh.getRow(i).getCell(2).getStringCellValue()));
				regdata.setGender(sh.getRow(i).getCell(3).getStringCellValue());
				regdata.setComboofferid(Integer.parseInt(sh.getRow(i).getCell(4).getStringCellValue()));
				regdata.setFamilyofferid(Integer.parseInt(sh.getRow(i).getCell(5).getStringCellValue()));
				regdata.setNomineerelationship(sh.getRow(i).getCell(6).getStringCellValue());
				regdata.setNomineename(sh.getRow(i).getCell(7).getStringCellValue());
				regdata.setNomineemsisdn(sh.getRow(i).getCell(8).getStringCellValue());
				regdata.setFirstbeneficiaryrelationship(sh.getRow(i).getCell(9).getStringCellValue());
				regdata.setFirstbeneficiaryname(sh.getRow(i).getCell(10).getStringCellValue());
				regdata.setFirstbeneficiarymsisdn(sh.getRow(i).getCell(11).getStringCellValue());
				regdata.setFirstbeneficiarygender(sh.getRow(i).getCell(12).getStringCellValue());
				regdata.setFirstbeneficiaryage(Integer.parseInt(sh.getRow(i).getCell(13).getStringCellValue()));
				if(!sh.getRow(i).getCell(14).getStringCellValue().equals("null"))
				{
				regdata.setSecondbeneficiaryrelationship(sh.getRow(i).getCell(14).getStringCellValue());
				regdata.setSecondbeneficiaryname(sh.getRow(i).getCell(15).getStringCellValue());
				regdata.setSecondbeneficiarymsisdn(sh.getRow(i).getCell(16).getStringCellValue());
				regdata.setSecondbeneficiarygender(sh.getRow(i).getCell(17).getStringCellValue());
				regdata.setSecondbeneficiaryage(Integer.parseInt(sh.getRow(i).getCell(18).getStringCellValue()));
				}
				regdata.setHealthtip(Integer.parseInt(sh.getRow(i).getCell(19).getStringCellValue()));
				regdata.setHealthtiplang(sh.getRow(i).getCell(20).getStringCellValue());
				combofamilylist.add(regdata);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return combofamilylist;
	}

	public static void main(String[]args)
	{
		/*List<ComboRegData> cdatalist= readComboRegData();
		for(ComboRegData cdata: cdatalist)
		{
			System.out.println(cdata.toString());
		}*/
		List<FamilyRegData> fdatalist= readFamilyRegData();
		/*for(FamilyRegData fdata: fdatalist)
		{
			System.out.println(fdata.toString());
		}*/
		List<ComboFamilyRegData> datalist= readComboFamilyRegData();
		for(ComboFamilyRegData data: datalist)
		{
			System.out.println(data.toString());
		}
	}

}
