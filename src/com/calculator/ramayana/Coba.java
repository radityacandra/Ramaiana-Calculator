package com.calculator.ramayana;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Coba extends Activity {
	
	public class itemDiscount{
		String itemName;
		String itemDesc;
		String itemDisc;
		String itemPrice;
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
				startActivity(i);
			}
        });
        
        TextView total = (TextView)findViewById(R.id.value_total);
        Bundle harga = getIntent().getExtras();
        if(harga!=null){
        	hargaTotal = hargaTotal + Long.parseLong(harga.getString("harga"));
        }
        //hargaTotal = hargaTotal+1;
        total.setText(String.valueOf(hargaTotal));
    }
    
    public class itemDiscountAdapter extends BaseAdapter{
    	
    	List<itemDiscount> listItemDiscount = getDataForListItem();
    	
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
			
			itemDiscount item = listItemDiscount.get(arg0);
			
			itemName.setText(item.itemName);
			itemDesc.setText(item.itemDesc);
			itemDisc.setText(item.itemDisc);
			
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
    	listItemDiscount.add(item);
    	
    	itemDiscount item1 = new itemDiscount();
    	item1.itemName = "Baju Oblong";
    	item1.itemDesc = "Cocok untuk santai";
    	item1.itemDisc = "65";
    	item1.itemPrice = "50000";
    	listItemDiscount.add(item1);
    	
    	itemDiscount item2 = new itemDiscount();
    	item2.itemName = "Baju Bolong";
    	item2.itemDesc = "Untuk yang butuh";
    	item2.itemDisc = "55";
    	item2.itemPrice = "25000";
    	listItemDiscount.add(item2);
    	
    	return listItemDiscount;	
    }
}
