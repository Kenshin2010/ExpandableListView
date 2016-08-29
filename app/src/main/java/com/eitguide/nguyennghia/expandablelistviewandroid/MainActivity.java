package com.eitguide.nguyennghia.expandablelistviewandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ExpandableListView eplStudent;
    private HashMap<String, List<Student>> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eplStudent = (ExpandableListView) findViewById(R.id.eplChat);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        eplStudent.setIndicatorBounds(width - dp2px(50), width - dp2px(10));

        //prepare data

        //data for header group
        final List<String> listHeader = new ArrayList<>();
        listHeader.add("Xuất sắc");
        listHeader.add("Giỏi");
        listHeader.add("Khá");
        listHeader.add("Trung Bình");
        listHeader.add("Yếu");


        //data for child
        mData = new HashMap<>();
        List<Student> listStudentXs = new ArrayList<>();
        listStudentXs.add(new Student("Tran Phuc", 9.8f));
        listStudentXs.add(new Student("Pham Phu", 9.9f));

        List<Student> listStudentGioi = new ArrayList<>();
        listStudentGioi.add(new Student("Nguyen Nghia", 8.8f));
        listStudentGioi.add(new Student("Nguyen Minh", 8.0f));

        List<Student> listStudentKha = new ArrayList<>();
        listStudentKha.add(new Student("Nguyen Tien", 7.9f));
        listStudentKha.add(new Student("Hoang Son", 7.6f));
        listStudentKha.add(new Student("Tran Tien", 7.9f));
        listStudentKha.add(new Student("Hai Trieu", 7.5f));

        List<Student> listStudentTrungBinh = new ArrayList<>();
        listStudentTrungBinh.add(new Student("Nguyen Ngoc", 5.9f));
        listStudentTrungBinh.add(new Student("Hoang Nam", 6.0f));
        listStudentTrungBinh.add(new Student("Tran Anh", 6.4f));

        List<Student> listStudentYeu = new ArrayList<>();
        listStudentYeu.add(new Student("Nguyen Mai", 4.9f));
        listStudentYeu.add(new Student("Tran Hai", 5.5f));
        listStudentYeu.add(new Student("Duong Phong", 5.1f));


        mData.put(listHeader.get(0), listStudentXs);
        mData.put(listHeader.get(1), listStudentGioi);
        mData.put(listHeader.get(2), listStudentKha);
        mData.put(listHeader.get(3), listStudentTrungBinh);
        mData.put(listHeader.get(4), listStudentYeu);

        //setup adapter for ExpandableListView
        CustomAdapter adapter = new CustomAdapter(this, listHeader, mData);
        eplStudent.setAdapter(adapter);


        eplStudent.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.e(TAG, "onChildClick: " + listHeader.get(groupPosition) + ", " + mData.get(listHeader.get(groupPosition)).get(childPosition).getName());
                return false;
            }
        });

        eplStudent.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.e(TAG, "onGroupClick: " + groupPosition);
                return false;
            }
        });

        eplStudent.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Log.e(TAG, "onGroupCollapse: " + groupPosition);
            }
        });

        eplStudent.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Log.e(TAG, "onGroupExpand: " + groupPosition);
            }
        });

    }


    public int dp2px(float dp) {
        // Get the screen's density scale
        final float density = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * density + 0.5f);
    }
}
