package com.attendancesystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.attendancesystem.R;
import com.attendancesystem.adapter.AttendanceListAdapter;
import com.attendancesystem.adapter.StudentListAdapter;
import com.attendancesystem.bean.StudentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rahul on 3/24/2018.
 */

public class AttendanceListActivity extends BaseActivity {


    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvStudents)
    RecyclerView rvStudents;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    private ArrayList<StudentBean> arrStudent;
    private AttendanceListAdapter attendanceListAdapter;

    @Override
    public int getContentView() {
        return R.layout.activity_attendance_list;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
    }

    @Override
    public void initViews() {
        tvTitle.setText("Attendance List");

        rvStudents.setHasFixedSize(true);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();

        btnSubmit.setVisibility(View.VISIBLE);
        btnSubmit.setOnClickListener(view -> {
            Intent i = new Intent(AttendanceListActivity.this, DashboardActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
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
        attendanceListAdapter = new AttendanceListAdapter(generateStudentList());
        attendanceListAdapter.openLoadAnimation();
        attendanceListAdapter.isFirstOnly(false);
        attendanceListAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        rvStudents.setAdapter(attendanceListAdapter);
    }
}
