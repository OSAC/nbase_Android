package com.vishnu.gbase;
public class Hex {
private String hexString;
public Hex(){
	hexString = "ffff";
}
public static boolean isHexString(String hex){
	int len = hex.length();
	int c;
	for(int i=0;i<len;i++){
		c = (int)hex.charAt(i);
	if((c>='0'&&c<='9')||(c>='A'&&c<='F')||(c>='a'&&c<='f'));
	else
		return false;
	}
	return true;
}
public Hex(String hex){
	if(isHexString(hex))
		this.hexString = hex;
	else
		//System.out.println("Error Invalid hex intput");
	hexString = "E8808";
}
private int parseInt(char c){
	int num=0;
	switch(c){
	case '1':
	case '2':
	case '3':
	case '4':
	case '5':
	case '6':
	case '7':
	case '8':
	case '9':
		num = Integer.parseInt(""+c);
		break;
	case 'a':
	case 'A':
		num = 10;
		break;
	case 'b':
	case 'B':
		num = 11;
		break;
	case 'c':
	case 'C':
		num = 12;
		break;
	case 'd':
	case 'D':
		num = 13;
		break;
	case 'e':
	case 'E':
		num = 14;
		break;
	case 'f':
	case 'F':
		num = 15;
		break;
	}
	return num;
}
public int toDecimal(){
	int Deci=0;
	int len = hexString.length();
	for(int i=0;i<len;i++){
		int num = parseInt(hexString.charAt(i));
		Deci += num* Math.pow(16, len-i-1);
	}
	return Deci;
}

public String toBinary(){
	String bin="";
	int Deci = this.toDecimal();
	bin = new Decimal(Deci).toBinary();
	return bin;
}
public String toOctal(){
	String oct="";
		int Deci = toDecimal();
		oct = new Decimal(Deci).toOctal();
		return oct;
}
public String toString(){
	return hexString;
}
}
