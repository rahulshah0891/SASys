package com.attendancesystem.activity;

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

public class AddStudentActivity extends BaseActivity {


    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.etFirstName)
    EditText etFirstName;
    @BindView(R.id.etLastName)
    EditText etLastName;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.cv_add)
    CardView cvAdd;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @Override
    public int getContentView() {
        return R.layout.activity_add_student;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);

    }

    @Override
    public void initViews() {
        tvTitle.setText("Add Student");
        btnSubmit.setOnClickListener(view -> finish());
    }

}
