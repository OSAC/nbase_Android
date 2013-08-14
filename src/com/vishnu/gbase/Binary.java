package com.vishnu.gbase;

public class Binary {
private String binString;

public Binary(){
	binString="10101111";
}
public Binary(String str){
	if(isBinStr(str))
		this.binString = str;
	else
		binString = "01101";
}
public static boolean isBinStr(String str){
	int len=str.length();
	for(int i=0;i<len;i++)
		if((str.charAt(i)=='1')||(str.charAt(i)=='0'))
		;
		else
			return false;
	return true;
}
public int toDecimal(){
	int Deci=0;
	int len = binString.length();
	for(int i=0;i<len;i++){
		Deci += Integer.parseInt(""+binString.charAt(i))*Math.pow(2, len-i-1);
	}
	return Deci;
}
public String toHex(){
	String hex;
	int num = toDecimal();
	hex = new Decimal(num).toHex();
	return hex;
}
public String toOctal(){
	String oct;
	int num=toDecimal();
	oct = new Decimal(num).toOctal();
	return oct;
}
public String toString(){
	return binString;
}
}
