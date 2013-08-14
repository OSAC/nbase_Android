package com.vishnu.gbase;

import android.app.Activity;
import android.text.ClipboardManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainGBaseActivity extends Activity implements TextWatcher,OnFocusChangeListener,android.view.View.OnClickListener{
	EditText etBinary;
	EditText etDecimal;
	EditText etOctal;
	EditText etHex;
	Button btnClear,btnQuit,btnCopy;
	TextView tvTest;
	String fieldChanged,strBin,strOct,strDec,strHex;
	boolean isUserInput;
	View[] v;
	String curText;
	int curPos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_gbase);
		
		etBinary = (EditText)findViewById(R.id.etBin);
		
		etDecimal = (EditText)findViewById(R.id.etDeci);
		etOctal = (EditText)findViewById(R.id.etOct);
		etHex = (EditText)findViewById(R.id.etHex);
		btnClear = (Button)findViewById(R.id.btnClear);
		btnQuit = (Button)findViewById(R.id.btnQuit);
		btnCopy = (Button)findViewById(R.id.btnCopy);
		
		strBin=strOct=strHex=strDec="";
		curText="";
		curPos=0;
		tvTest = (TextView)findViewById(R.id.tvTest);
		isUserInput=true;
		etBinary.setTag("B");
		etDecimal.setTag("D");
		etOctal.setTag("O");
		etHex.setTag("H");
		
		EditText[] etFields ={etBinary,etDecimal,etOctal,etHex};
		Button[] btns={btnClear,btnQuit,btnCopy};
		
		for(EditText etf : etFields){
		etf.setOnFocusChangeListener(this);
		etf.addTextChangedListener(this);
		}
		
		btnClear.setTag("clear");
		btnQuit.setTag("quit");
		btnCopy.setTag("copy");
		for(Button btn:btns)
		btn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_gbase, menu);
		return true;
	}

	@Override
	public void afterTextChanged(Editable arg0) {
		if(!isUserInput)
			return;
		if(fieldChanged.compareTo("B")==0){
			isUserInput=false;
			curText=etBinary.getText().toString();
			curPos=etBinary.getSelectionStart();
			if(Binary.isBinStr(curText));
			else{
				etBinary.setText(strBin);
				etBinary.setSelection(curPos-1);
				isUserInput=true;
				return;
			}
			Binary bin = new Binary(curText);
			etDecimal.setText(""+bin.toDecimal());
			etOctal.setText(bin.toOctal());
			etHex.setText(bin.toHex());
			isUserInput=true;
		}
		else if(fieldChanged.compareTo("D")==0){
			isUserInput=false;
			curText = etDecimal.getText().toString();
			curPos=etDecimal.getSelectionStart();
			if(Decimal.isDecimalStr(curText));
			else{
				etDecimal.setText(strDec);
				etDecimal.setSelection(curPos-1);
				isUserInput=true;
				return;
			}
			Decimal deci = new Decimal(Integer.parseInt(curText));
			etBinary.setText(deci.toBinary());
			etOctal.setText(deci.toOctal());
			etHex.setText(deci.toHex());
			isUserInput=true;
		}
		else if(fieldChanged.compareTo("O")==0){
			isUserInput=false;
			curText = etOctal.getText().toString();
			curPos = etOctal.getSelectionStart();
			if(Octal.isOctStr(curText));
			else{
				etOctal.setText(strOct);
				etOctal.setSelection(curPos-1);
				isUserInput=true;
				return;
			}
			Octal oct = new Octal(curText);
			etBinary.setText(oct.toBinary());
			etDecimal.setText(""+oct.toDecimal());
			etHex.setText(oct.toHex());
			isUserInput=true;
		}
		else if(fieldChanged.compareTo("H")==0){
			isUserInput=false;
			curText = etHex.getText().toString();
			curPos = etHex.getSelectionStart();
			if(Hex.isHexString(curText));
			else {
				etHex.setText(strHex);
				etHex.setSelection(curPos-1);
				isUserInput=true;
				return;
			}
			Hex hex = new Hex(curText);
			etBinary.setText(hex.toBinary());
			etDecimal.setText(""+hex.toDecimal());
			etOctal.setText(hex.toOctal());
			isUserInput=true;
		}
		strBin=etBinary.getText().toString();
		strOct=etOctal.getText().toString();
		strDec=etDecimal.getText().toString();
		strHex=etHex.getText().toString();
	}

	@Override   //beforeTextChanged(newString, change startindex,change endindex, noofcharchanged);		
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		/*if(!isUserInput)
			return;
		if(fieldChanged.compareTo("B")==0){
				String tstrBin=etBinary.getText().toString();
				if(Binary.isBinStr(tstrBin))
					strBin=tstrBin;
				else{
					isUserInput=false;
					etBinary.setText(strBin);
					isUserInput=true;
					}
		}
		else if(fieldChanged.compareTo("D")==0){
			
		}
return;*/	
	}
	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		//Toast.makeText(getApplicationContext(), "onTextChanged : "+arg0, Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		fieldChanged = v.getTag().toString();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String btn=v.getTag().toString();
		if(btn.compareTo("clear")==0){
		etBinary.setText("");
		etDecimal.setText("");
		etOctal.setText("");
		etHex.setText("");
		}
		else if(btn.compareTo("quit")==0){
			System.exit(0);
		}
		else if(btn.compareTo("copy")==0){	//if copy buttone is clicked
			String cont="";
			if(fieldChanged.compareTo("B")==0)
				cont=etBinary.getText().toString();
			else if(fieldChanged.compareTo("D")==0)
				cont = etDecimal.getText().toString();
			else if(fieldChanged.compareTo("O")==0)
				cont = etOctal.getText().toString();
			else if(fieldChanged.compareTo("H")==0)
				cont = etHex.getText().toString();
//	This new one is new but taht api is not suppported on my GalPop gtS5570.. android.content.ClibboardManager;
/*			ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
			ClipData clip = ClipData.newPlainText(fieldChanged, cont);
			clipboard.setPrimaryClip(clip);
			*/
// Following is depricated ... android.text.ClipboardManager is depricated
		ClipboardManager clipborad = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
		clipborad.setText(cont);
		
			Toast.makeText(getApplicationContext(), "String \""+cont+"\" copied to clipboard.", Toast.LENGTH_SHORT).show();
		}
	}

}
