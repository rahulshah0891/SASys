package com.attendancesystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.attendancesystem.R;
import com.attendancesystem.adapter.StudentListAdapter;
import com.attendancesystem.bean.StudentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rahul.shah on 3/21/2018.
 */

public class StudentListActivity extends BaseActivity {


    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvStudents)
    RecyclerView rvStudents;
    @BindView(R.id.fabAdd)
    FloatingActionButton fabAdd;
    private ArrayList<StudentBean> arrStudent;
    private StudentListAdapter studentListAdapter;

    @Override
    public int getContentView() {
        return R.layout.activity_student_list;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
    }

    @Override
    public void initViews() {
        tvTitle.setText("Students");

        fabAdd.setOnClickListener(view -> startActivity(new Intent(StudentListActivity.this, AddStudentActivity.class)));

        rvStudents.setHasFixedSize(true);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
    }

    private ArrayList<StudentBean> generateStudentList() {
        arrStudent = new ArrayList<>();
        StudentBean bean;

        for (int i = 0; i <= 20; i++) {
            bean = new StudentBean();
            bean.setRollNumber(i);
            bean.setName("Student " + i);

            arrStudent.add(bean);
        }
        return arrStudent;
    }

    private void initAdapter() {
        studentListAdapter = new StudentListAdapter(generateStudentList());
        studentListAdapter.openLoadAnimation();
        studentListAdapter.isFirstOnly(false);
        studentListAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        rvStudents.setAdapter(studentListAdapter);
    }
}
