package com.calculator.ramayana;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculationDiscount extends Activity implements OnClickListener {
	
	public class itemDiscount{
		String itemName;
		String itemDesc;
		String itemDisc;
		String itemPrice;
	}
	itemDiscount itemGlobal = new itemDiscount();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculation_discount);
		TextView namaBarang = (TextView)findViewById(R.id.value_nama_barang);
		TextView hargaSatuan = (TextView)findViewById(R.id.value_harga_satuan);
		TextView hargaSatuan2 = (TextView)findViewById(R.id.value_harga_satuan_2);
		EditText kuantitas = (EditText)findViewById(R.id.value_kuantitas);
		TextView potonganPersen = (TextView)findViewById(R.id.value_persen_diskon);
		TextView potonganHarga = (TextView)findViewById(R.id.value_harga_discount);
		TextView hargaBayar = (TextView)findViewById(R.id.value_harga_total);
		
		Bundle dataBarang = getIntent().getExtras();
		if (dataBarang!=null){
			itemGlobal.itemPrice = dataBarang.getString("harga");
			itemGlobal.itemDisc = dataBarang.getString("diskon");
			itemGlobal.itemName = dataBarang.getString("nama");
		}
		
		//penulisan text view hasil intent
		namaBarang.setText(itemGlobal.itemName);
		hargaSatuan.setText(itemGlobal.itemPrice);
		hargaSatuan2.setText(itemGlobal.itemPrice);
		potonganPersen.setText(itemGlobal.itemDisc);
		
		//pembacaan kuantitas, sekalian kalkulasi awal
		int kuantitas_get = Integer.parseInt(kuantitas.getText().toString());
		int diskon_persen_get = Integer.parseInt(itemGlobal.itemDisc);
		long harga_satuan_get = Long.parseLong(itemGlobal.itemPrice);
		float potonganHarga_calc = (float)diskon_persen_get / 100 * (float)harga_satuan_get * (float)kuantitas_get;
		long hargatotal = (harga_satuan_get * kuantitas_get) - (long)potonganHarga_calc;
		
		
		//set text hasil kalkulasi awal
		potonganHarga.setText(String.valueOf(potonganHarga_calc));
		hargaBayar.setText(String.valueOf(hargatotal));
		
		Button cek = (Button)findViewById(R.id.cekBtn);
		Button beli = (Button)findViewById(R.id.buyBtn);
		
		cek.setOnClickListener(this);
		beli.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case (R.id.cekBtn):
				EditText kuantitas = (EditText)findViewById(R.id.value_kuantitas);
				TextView potonganHarga = (TextView)findViewById(R.id.value_harga_discount);
				TextView hargaBayar = (TextView)findViewById(R.id.value_harga_total);
				
				//pembacaan kuantitas, sekalian kalkulasi lanjut
				int kuantitas_get = Integer.parseInt(kuantitas.getText().toString());
				int diskon_persen_get = Integer.parseInt(itemGlobal.itemDisc);
				long harga_satuan_get = Long.parseLong(itemGlobal.itemPrice);
				float potonganHarga_calc = (float)diskon_persen_get / 100 * (float)harga_satuan_get * (float)kuantitas_get;
				long hargatotal = (harga_satuan_get * kuantitas_get) - (long)potonganHarga_calc;
				
				//set text hasil kalkulasi lanjut
				potonganHarga.setText(String.valueOf(potonganHarga_calc));
				hargaBayar.setText(String.valueOf(hargatotal));
			break;
			case(R.id.buyBtn):
				TextView hargaBayar2 = (TextView)findViewById(R.id.value_harga_total);
				String hargatotal2 = hargaBayar2.getText().toString();
				Intent back = new Intent(CalculationDiscount.this, Coba.class);
				back.putExtra("harga", hargatotal2);
				startActivity(back);
			break;
		}
	}
}
