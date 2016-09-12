package com.iven.commonadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.iven.commonadapter.adapter.CommonAdapter;
import com.iven.commonadapter.adapter.ViewHolder;
import com.iven.commonadapter.bean.Person;

import java.util.ArrayList;

/**
 * 封装的ViewHolder和CommonAdapter
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listview);
        for (int i = 0; i < 30; i++) {
            Person p = new Person();
            p.setName("name:" + i);
            p.setSex("性别-" + i + "--");
            p.setAge(i);
            list.add(p);
        }
        listView.setAdapter(new CommonAdapter<Person>(getApplicationContext(),list,R.layout.item) {
            @Override
            public void convert(ViewHolder helper, Person item) {
                helper.setText(R.id.tv_name,item.getName());
                helper.setText(R.id.tv_sex,item.getSex());
                helper.setText(R.id.tv_age,item.getAge()+" 岁");
                helper.setImageResource(R.id.iv,R.mipmap.ic_launcher);
            }
        });
    }
}
