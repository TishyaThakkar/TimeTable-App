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
import android.widget.TextView;

import com.example.timetable.Utils.LetterImageView;

public class FacultyActivity extends AppCompatActivity {

    private ListView listView;
    private androidx.appcompat.widget.Toolbar toolbar;
    public static SharedPreferences sharedPreferences;
    public static String SEL_FACULTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        setupUIViews();
        initToolbar();
        setupListView();

    }

    private void setupUIViews(){
        toolbar = (Toolbar) findViewById(R.id.ToolbarFaculty);
        listView = (ListView)findViewById(R.id.lvFaculty);
        sharedPreferences = getSharedPreferences("myFaculty", MODE_PRIVATE);
    }

    private  void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        String[] faculty_name = getResources().getStringArray(R.array.faculty_name);

        FacultyAdapter adapter = new FacultyAdapter(this, R.layout.faculty_single_item, faculty_name);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 0).apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 1).apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 2).apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 3).apply();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 4).apply();
                        break;
                    }
                    case 5: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 5).apply();
                        break;
                    }
                    case 6: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 6).apply();
                        break;
                    }
                    case 7: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 7).apply();
                        break;
                    }
                }
            }
        });

    }

    public class FacultyAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] faculty = new String[]{};

        public FacultyAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.faculty = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource,null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetterFaculty);
                holder.tvFaculty = (TextView)convertView.findViewById(R.id.tvFacultyName);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(faculty[position].charAt(6));
            holder.tvFaculty.setText(faculty[position]);

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvFaculty;
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