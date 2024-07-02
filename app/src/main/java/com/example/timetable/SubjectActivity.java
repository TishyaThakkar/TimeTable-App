package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.timetable.Utils.LetterImageView;

public class SubjectActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private String[] subjects;
    public static SharedPreferences subjectPreferences;
    public static String SUB_PREF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarSubject);
        listView = (ListView)findViewById(R.id.lvSubject);
        subjectPreferences = getSharedPreferences("sunjects", MODE_PRIVATE);
    }

    private  void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subject");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
        subjects = getResources().getStringArray(R.array.Subjects);

        SubjectAdapter subjectAdapter = new SubjectAdapter(this, R.layout.subject_single_item, subjects);

        listView.setAdapter(subjectAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        subjectPreferences.edit().putString(SUB_PREF, "ME").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    } case 1:{
                        subjectPreferences.edit().putString(SUB_PREF, "CN").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    } case 2:{
                        subjectPreferences.edit().putString(SUB_PREF, "AI").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    } case 3:{
                        subjectPreferences.edit().putString(SUB_PREF, "ET").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    } case 4:{
                        subjectPreferences.edit().putString(SUB_PREF, "SE").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    } case 5:{
                        subjectPreferences.edit().putString(SUB_PREF, "OOMD").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    } case 6:{
                        subjectPreferences.edit().putString(SUB_PREF, "MAD").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    } case 7:{
                        subjectPreferences.edit().putString(SUB_PREF, "CRY").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }

                }
            }
        });
    }

    public class SubjectAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] subjects = new String[]{};

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.subjects = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource,null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetterSubject);
                holder.tvSubject = (TextView)convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(subjects[position].charAt(0));
            holder.tvSubject.setText(subjects[position]);

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvSubject;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
