package com.vishnu.gbase;
public class Octal {
private String octString;

public Octal(){
	octString = "51101";
}
public Octal(String oct){
	if(isOctStr(oct))
		this.octString = oct;
	else
		octString = "51101";
}
public static boolean isOctStr(String octal){
	int len = octal.length();
	for(int i=0;i<len;i++)
		if((octal.charAt(i)>='0')&&(octal.charAt(i)<='7'));
		else
			return false;
	return true;
}
public int toDecimal(){
	int Deci=0;
	int len=octString.length();
	for(int i=0;i<len;i++){
		Deci += Integer.parseInt(""+octString.charAt(i))*Math.pow(8, len-i-1);
	}
	return Deci;
}
public String toBinary(){
	String bin="";
	int Deci = toDecimal();
	bin = new Decimal(Deci).toBinary();
	return bin;
}
public String toHex(){
	String hex="";
	int Deci = toDecimal();
	hex = new Decimal(Deci).toHex();
	return hex;
}
public String toString(){
	return octString;
}
}
