package com.attendancesystem.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import com.attendancesystem.R;
import com.attendancesystem.database.entity.Unit;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Rahul on 4/15/2018.
 */

public class StudentUnitListAdapter extends BaseQuickAdapter<Unit, BaseViewHolder> {

    public StudentUnitListAdapter(@Nullable List<Unit> data) {
        super(R.layout.row_subjects_students, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Unit item) {
        CheckBox cbSubject = (CheckBox) helper.getView(R.id.cbSubject);

        cbSubject.setText(item.getTitle());

        cbSubject.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                getData().get(helper.getAdapterPosition()).setSelected(true);
            } else {
                getData().get(helper.getAdapterPosition()).setSelected(false);
            }

            getSelectionCount();
        });
    }

    public int getSelectionCount() {
        int count = 0;
        for (int i = 0; i < getData().size(); i++) {
            if(getData().get(i).isSelected()){
                count = count +1;
            }
        }
        Log.e("Count", count+"");
        return count;
    }
}
