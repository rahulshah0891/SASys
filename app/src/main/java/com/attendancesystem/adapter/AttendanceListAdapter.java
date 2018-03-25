package com.attendancesystem.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.attendancesystem.R;
import com.attendancesystem.bean.StudentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by Rahul on 3/24/2018.
 */

public class AttendanceListAdapter extends BaseQuickAdapter<StudentBean, BaseViewHolder> {

    public AttendanceListAdapter(@Nullable ArrayList<StudentBean> data) {
        super(R.layout.row_attendance_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StudentBean item) {
        ((TextView)helper.getView(R.id.tvRollNumber)).setText(item.getRollNumber()+"");
        ((TextView)helper.getView(R.id.tvName)).setText(item.getName());
    }
}
