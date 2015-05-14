package com.calculator.ramayana;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Coba extends Activity implements OnClickListener {
	
	public class itemDiscount{
		String itemName;
		String itemDesc;
		String itemDisc;
		String itemPrice;
		int itemImage;
	}
	
	itemDiscountAdapter itemlist;
	public static long hargaTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);
        
        itemlist = new itemDiscountAdapter();
        
        ListView itemListView = (ListView)findViewById(R.id.listView1);
        itemListView.setAdapter(itemlist);
        
        itemListView.setOnItemClickListener(new OnItemClickListener(){
        	@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				itemDiscount chapter = itemlist.getitemDiscount(arg2);
				
				//Toast.makeText(Coba.this, chapter.itemName,Toast.LENGTH_LONG).show();
				Intent i = new Intent(Coba.this, ItemDetail.class);
				i.putExtra("description", chapter.itemDesc);
				i.putExtra("name", chapter.itemName);
				i.putExtra("discount", chapter.itemDisc);
				i.putExtra("price", chapter.itemPrice);
				i.putExtra("image", chapter.itemImage);
				startActivity(i);
			}
        });
        
        TextView total = (TextView)findViewById(R.id.value_total);
        Bundle harga = getIntent().getExtras();
        if(harga!=null){
        	hargaTotal = hargaTotal + Long.parseLong(harga.getString("harga"));
        }
        total.setText(String.valueOf(hargaTotal));
        
        //button menu (baju, celana, dkk) handler
        Button baju = (Button)findViewById(R.id.baju);
        Button celana = (Button)findViewById(R.id.sepatu);
        Button reset = (Button)findViewById(R.id.reset);
        
        baju.setOnClickListener(this);
        celana.setOnClickListener(this);
        reset.setOnClickListener(this);
    }
    
	List<itemDiscount> listItemDiscount = getDataForListItem();
    public class itemDiscountAdapter extends BaseAdapter{
    	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listItemDiscount.size();
		}

		@Override
		public itemDiscount getItem(int arg0) {
			// TODO Auto-generated method stub
			return listItemDiscount.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			if(arg1==null){
				LayoutInflater inflater = (LayoutInflater) Coba.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				arg1 = inflater.inflate(R.layout.listitem, arg2,false);
			}
			
			TextView itemName = (TextView)arg1.findViewById(R.id.textView1);
			TextView itemDesc = (TextView)arg1.findViewById(R.id.nama_text_view);
			TextView itemDisc = (TextView)arg1.findViewById(R.id.textView5);
			ImageView img = (ImageView)arg1.findViewById(R.id.imageView1);
			
			itemDiscount item = listItemDiscount.get(arg0);
			
			itemName.setText(item.itemName);
			itemDesc.setText(item.itemDesc);
			itemDisc.setText(item.itemDisc);
			img.setImageResource(item.itemImage);
			return arg1;
		}
		
		public itemDiscount getitemDiscount(int position){
			return listItemDiscount.get(position);
		}
    }
    
    public List<itemDiscount> getDataForListItem(){
    	List<itemDiscount> listItemDiscount = new ArrayList<itemDiscount>();
    	itemDiscount item = new itemDiscount();
    	item.itemName = "Baju Polo";
    	item.itemDesc = "Baju polo berkerah";
    	item.itemDisc = "50";
    	item.itemPrice = "65000";
    	item.itemImage = R.drawable.b1;
    	listItemDiscount.add(item);
    	
    	itemDiscount item1 = new itemDiscount();
    	item1.itemName = "Baju Oblong";
    	item1.itemDesc = "Cocok untuk santai";
    	item1.itemDisc = "65";
    	item1.itemPrice = "50000";
    	item1.itemImage = R.drawable.b2;
    	listItemDiscount.add(item1);
    	
    	itemDiscount item2 = new itemDiscount();
    	item2.itemName = "Baju Bolong";
    	item2.itemDesc = "Untuk yang butuh";
    	item2.itemDisc = "55";
    	item2.itemPrice = "25000";
    	item2.itemImage = R.drawable.b3;
    	listItemDiscount.add(item2);
    	
    	if (true){
    		itemDiscount item3 = new itemDiscount();
        	item3.itemName = "Baju Batik";
        	item3.itemDesc = "Warisan Indonesia";
        	item3.itemDisc = "70";
        	item3.itemPrice = "200000";
        	item3.itemImage = R.drawable.b4;
        	listItemDiscount.add(item3);
    	}
    	
    	if (true){
    		itemDiscount item3 = new itemDiscount();
        	item3.itemName = "Baju Oblong";
        	item3.itemDesc = "Be Proud of Indonesia";
        	item3.itemDisc = "65";
        	item3.itemPrice = "130000";
        	item3.itemImage = R.drawable.b5;
        	listItemDiscount.add(item3);
    	}
    	
    	if (true){
    		itemDiscount item3 = new itemDiscount();
        	item3.itemName = "Dress Black";
        	item3.itemDesc = "Fluffy's Metalindo Ball";
        	item3.itemDisc = "75";
        	item3.itemPrice = "310000";
        	item3.itemImage = R.drawable.b6;
        	listItemDiscount.add(item3);
    	}
    	
    	if (true){
    		itemDiscount item3 = new itemDiscount();
        	item3.itemName = "Baju Oblong";
        	item3.itemDesc = "Kaos Jackdow";
        	item3.itemDisc = "70";
        	item3.itemPrice = "100000";
        	item3.itemImage = R.drawable.b7;
        	listItemDiscount.add(item3);
    	}
    	
    	if (true){
    		itemDiscount item3 = new itemDiscount();
        	item3.itemName = "Baju Oblong";
        	item3.itemDesc = "Kaos One Piece";
        	item3.itemDisc = "65";
        	item3.itemPrice = "135000";
        	item3.itemImage = R.drawable.b8;
        	listItemDiscount.add(item3);
    	}
    	
    	if (true){
    		itemDiscount item3 = new itemDiscount();
        	item3.itemName = "Hoody";
        	item3.itemDesc = "Grindle Zip";
        	item3.itemDisc = "55";
        	item3.itemPrice = "240000";
        	item3.itemImage = R.drawable.b9;
        	listItemDiscount.add(item3);
    	}
    	return listItemDiscount;	
    }
    
    public List<itemDiscount> getDataForCelanaItem(){
    	List<itemDiscount> listItemDiscount = new ArrayList<itemDiscount>();
    	if(true){
    		itemDiscount item = new itemDiscount();
        	item.itemName = "BeetleBug";
        	item.itemDesc = "Casual Shoes";
        	item.itemDisc = "50";
        	item.itemPrice = "845000";
        	item.itemImage = R.drawable.s1;
        	listItemDiscount.add(item);
    	}
    	
    	if(true){
    		itemDiscount item = new itemDiscount();
        	item.itemName = "Diodora Talio";
        	item.itemDesc = "Men Sneaker";
        	item.itemDisc = "70";
        	item.itemPrice = "280000";
        	item.itemImage = R.drawable.s2;
        	listItemDiscount.add(item);
    	}
    	
    	if(true){
    		itemDiscount item = new itemDiscount();
        	item.itemName = "Giant";
        	item.itemDesc = "Giant Flames Rocked";
        	item.itemDisc = "75";
        	item.itemPrice = "225000";
        	item.itemImage = R.drawable.s3;
        	listItemDiscount.add(item);
    	}
    	
    	if(true){
    		itemDiscount item = new itemDiscount();
        	item.itemName = "Strap Heels";
        	item.itemDesc = "Double Buckle Ankle";
        	item.itemDisc = "55";
        	item.itemPrice = "235000";
        	item.itemImage = R.drawable.s4;
        	listItemDiscount.add(item);
    	}
    	
    	if(true){
    		itemDiscount item = new itemDiscount();
        	item.itemName = "Strappy Heels";
        	item.itemDesc = "For Women";
        	item.itemDisc = "45";
        	item.itemPrice = "195000";
        	item.itemImage = R.drawable.s5;
        	listItemDiscount.add(item);
    	}
    	return listItemDiscount;	
    }
    
    public static String getCommand;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.baju:
				//biar variabel langsung dibuang jadi bisa copas di case lain :3
				if(true){
					listItemDiscount = getDataForListItem();
					itemlist = new itemDiscountAdapter();
			        
			        ListView itemListView = (ListView)findViewById(R.id.listView1);
			        itemListView.setAdapter(itemlist);
			        
			        itemListView.setOnItemClickListener(new OnItemClickListener(){
			        	@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {
							
							itemDiscount chapter = itemlist.getitemDiscount(arg2);
							
							//Toast.makeText(Coba.this, chapter.itemName,Toast.LENGTH_LONG).show();
							Intent i = new Intent(Coba.this, ItemDetail.class);
							i.putExtra("description", chapter.itemDesc);
							i.putExtra("name", chapter.itemName);
							i.putExtra("discount", chapter.itemDisc);
							i.putExtra("price", chapter.itemPrice);
							i.putExtra("image", chapter.itemImage);
							startActivity(i);
						}
			        });
				}
			break;
			case R.id.sepatu:
				//biar variabel langsung dibuang jadi bisa copas di case lain :3
				if(true){
					listItemDiscount = getDataForCelanaItem();
					itemlist = new itemDiscountAdapter();
			        
			        ListView itemListView = (ListView)findViewById(R.id.listView1);
			        itemListView.setAdapter(itemlist);
			        
			        itemListView.setOnItemClickListener(new OnItemClickListener(){
			        	@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {
							
							itemDiscount chapter = itemlist.getitemDiscount(arg2);
							
							//Toast.makeText(Coba.this, chapter.itemName,Toast.LENGTH_LONG).show();
							Intent i = new Intent(Coba.this, ItemDetail.class);
							i.putExtra("description", chapter.itemDesc);
							i.putExtra("name", chapter.itemName);
							i.putExtra("discount", chapter.itemDisc);
							i.putExtra("price", chapter.itemPrice);
							i.putExtra("image", chapter.itemImage);
							startActivity(i);
						}
			        });
				}
			break;
			case R.id.reset:
				hargaTotal = 0;
				TextView total = (TextView)findViewById(R.id.value_total);
		        total.setText(String.valueOf(hargaTotal));
			break;
		}
	}
}
