package com.vishnu.gbase;

public class Decimal {
private int decimal;
public Decimal(){
	decimal = 9090;
}
public Decimal(int num){
	this.decimal = num;
}
public static boolean isDecimalStr(String deci){
	int len=deci.length();
	char ch;
	for(int i=0;i<len;i++){
		ch=deci.charAt(i);
		if((ch>='0')&&(ch<='9'));
		else
			return false;
	}
	return true;
}
private char decinum2hexnum(int decinum){
	switch(decinum){
	case 0:
	case 1:
	case 2:
	case 3:
	case 4:
	case 5:
	case 6:
	case 7:
	case 8:
	case 9:
		return (char)('0'+decinum);
	case 10:
		return 'A';
	case 11:
		return 'B';
	case 12:
		return 'C';
	case 13:
		return 'D';
	case 14:
		return 'E';
	case 15:
		return 'F';
	default :
		return '0';
	}
}
public String toHex(){
	int tdeci=this.decimal;
	String hex="";
	if(tdeci==0)
		hex="0";
	for(;;){
		if(tdeci==0)
			break;
		hex += decinum2hexnum(tdeci%16);
		tdeci /= 16;
	}
	hex = new StringBuffer(hex).reverse().toString();
	return hex;
}
public String toOctal(){
	int tdeci = this.decimal;
	String oct="";
	if(tdeci==0)
		oct="0";
	for(;;){
		if(tdeci==0)
			break;
		oct += tdeci%8;
		tdeci /= 8;
	}
	oct = new StringBuffer(oct).reverse().toString();
	return oct;
}
public String toBinary(){
	int tdeci = this.decimal;
	String bin="";
	if(tdeci==0)
		bin="0";
	for(;;){
		if(tdeci==0)
			break;
		bin += tdeci%2;
		tdeci /= 2;
	}
	bin = new StringBuffer(bin).reverse().toString();
	return bin;
}
}