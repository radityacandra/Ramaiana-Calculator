package com.calculator.ramayana;

import java.util.ArrayList;
import java.util.List;

import com.calculator.ramayana.Coba.itemDiscount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ItemDetail extends Activity implements OnClickListener{
	
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
		setContentView(R.layout.activity_item_detail);
		itemDiscount item = new itemDiscount();
		
		//terima intent, masih manual, belum bisa parcelable -_-
		Bundle extras = getIntent().getExtras();
		if (extras!=null){
			item.itemName = extras.getString("name");
			item.itemDesc = extras.getString("description");
			item.itemDisc = extras.getString("discount");
			item.itemPrice = extras.getString("price");
		}
		
		TextView itemName = (TextView)findViewById(R.id.nama_text_view);
		TextView itemDesc = (TextView)findViewById(R.id.deskripsi_text_view);
		TextView itemDisc = (TextView)findViewById(R.id.discount_text_view);
		TextView itemPrice = (TextView)findViewById(R.id.harga_text_view);
		
		itemName.setText(item.itemName);
		itemDesc.setText(item.itemDesc);
		itemDisc.setText(item.itemDisc);
		itemPrice.setText(item.itemPrice);
		itemGlobal = item;
		
		Button btnLanjut = (Button)findViewById(R.id.button2);
		Button btnBack = (Button)findViewById(R.id.cekBtn);
		btnLanjut.setOnClickListener(this);
		btnBack.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
			case (R.id.button2):
				Intent lanjut = new Intent(ItemDetail.this, CalculationDiscount.class);
				lanjut.putExtra("harga", itemGlobal.itemPrice);
				lanjut.putExtra("diskon", itemGlobal.itemDisc);
				lanjut.putExtra("nama", itemGlobal.itemName);
				startActivity(lanjut);
				break;
			case (R.id.cekBtn):
				Intent kembali = new Intent(ItemDetail.this, Coba.class);
				startActivity(kembali);
				break;
		}
	}
}
