package com.example.nataliaharrow.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityToDoList extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    String messageText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent();
                intent.setClass(ActivityToDoList.this, EditMessageClass.class);
                intent.putExtra(IntentConstants.INTENT_MESSAGE_DATA, arrayList.get(position).toString());
                intent.putExtra(IntentConstants.INTENT_ITEM_POSITION, position);
                startActivityForResult(intent, IntentConstants.INTENT_REQUEST_CODE_TWO);
            }
        });
    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.setClass(ActivityToDoList.this, EditFieldClass.class);
        startActivityForResult(intent, IntentConstants.INTENT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==IntentConstants.INTENT_REQUEST_CODE) {
            messageText = data.getStringExtra(IntentConstants.INTENT_MESSAGE_FIELD);
            arrayList.add(messageText);
            arrayAdapter.notifyDataSetChanged();
        }
        else if (resultCode == IntentConstants.INTENT_REQUEST_CODE_TWO){
            messageText = data.getStringExtra(IntentConstants.INTENT_CHANGED_MESSAGE);
            position = data.getIntExtra(IntentConstants.INTENT_ITEM_POSITION, -1);
            arrayList.remove(position);
            arrayList.add(position, messageText);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
