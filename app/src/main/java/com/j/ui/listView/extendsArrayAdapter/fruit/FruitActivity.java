package com.j.ui.listView.extendsArrayAdapter.fruit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.j.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/9.
 */
public class FruitActivity extends Activity {
    private ArrayList<Fruit> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit);

        initFruit();
        FruitAdapter adapter = new FruitAdapter(FruitActivity.this, R.layout.fruit_item, list);
        ListView listView = (ListView) findViewById(R.id.fruit_listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FruitActivity.this, list.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        list.add(new Fruit("Apple", R.drawable.fruit1, 11.00));
        list.add(new Fruit("Banana", R.drawable.fruit2, 12.00));
        list.add(new Fruit("Orange", R.drawable.fruit3, 13.00));
        list.add(new Fruit("Watermelon", R.drawable.fruit4, 14.00));
        list.add(new Fruit("Pear", R.drawable.fruit5, 15.00));
        list.add(new Fruit("Grape", R.drawable.fruit6, 16.00));
        list.add(new Fruit("Pineapple", R.drawable.fruit7, 17.00));
        list.add(new Fruit("Strawberry", R.drawable.fruit8, 18.00));
        list.add(new Fruit("Cherry", R.drawable.fruit9, 19.00));
        list.add(new Fruit("Mango", R.drawable.fruit10, 20.00));
    }

}
