package com.attendancesystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.attendancesystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rahul on 3/24/2018.
 */

public class AttendanceDetailsActivity extends BaseActivity {


    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.etSubjectName)
    EditText etSubjectName;
    @BindView(R.id.etFacultyName)
    EditText etFacultyName;
    @BindView(R.id.etDate)
    EditText etDate;
    @BindView(R.id.cv_add)
    CardView cvAdd;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @Override
    public int getContentView() {
        return R.layout.activity_attendance_details;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
    }

    @Override
    public void initViews() {
        tvTitle.setText("Attendance Details");

        btnSubmit.setOnClickListener(view -> startActivity(new Intent(AttendanceDetailsActivity.this, AttendanceListActivity.class)));
    }

}
