package com.attendancesystem.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.attendancesystem.R;
import com.attendancesystem.bean.StudentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul.shah on 3/21/2018.
 */

public class StudentListAdapter extends BaseQuickAdapter<StudentBean, BaseViewHolder> {

    public StudentListAdapter(@Nullable ArrayList<StudentBean> data) {
        super(R.layout.row_student_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StudentBean item) {
        ((TextView)helper.getView(R.id.tvRollNumber)).setText(item.getRollNumber()+"");
        ((TextView)helper.getView(R.id.tvName)).setText(item.getName());
    }
}
