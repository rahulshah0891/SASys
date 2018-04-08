package com.attendancesystem.activity;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.attendancesystem.R;
import com.attendancesystem.database.DatabaseMain;
import com.attendancesystem.database.entity.Student;
import com.attendancesystem.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etRollNumber)
    EditText etRollNumber;
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

        btnSubmit.setOnClickListener(view -> {
            if (etRollNumber.getText() != null && etRollNumber.getText().toString().trim().length() > 0) {
                if (etFirstName.getText() != null && etFirstName.getText().toString().trim().length() > 0) {
                    if (etLastName.getText() != null && etLastName.getText().toString().trim().length() > 0) {
                        if (etEmail.getText() != null && etEmail.getText().toString().trim().length() > 0) {
                            if (Utils.isValidEmail(etEmail.getText().toString())) {
                                Completable.fromRunnable(() -> DatabaseMain.getDbInstance(AddStudentActivity.this)
                                        .getStudentDao()
                                        .insert(new Student(etRollNumber.getText().toString(),
                                                etFirstName.getText().toString(),
                                                etLastName.getText().toString(),
                                                etEmail.getText().toString())))
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribeOn(Schedulers.computation()).subscribe(() -> {
                                    Log.e("DB", "inserted");
                                    finish();
                                }, throwable -> {
                                    Toast.makeText(AddStudentActivity.this, "Roll number already exists", Toast.LENGTH_SHORT).show();
                                    Log.e("Error", throwable.getMessage());
                                });
                            } else {
                                Toast.makeText(AddStudentActivity.this, "Please enter valid Email address", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(AddStudentActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(AddStudentActivity.this, "Last Name cannot be empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddStudentActivity.this, "First Name cannot be empty", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(AddStudentActivity.this, "Roll Number cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
