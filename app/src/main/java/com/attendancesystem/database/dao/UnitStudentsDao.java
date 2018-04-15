package com.attendancesystem.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.attendancesystem.database.entity.UnitStudents;

import java.util.List;

/**
 * Created by Rahul on 4/14/2018.
 */

@Dao
public interface UnitStudentsDao {

    @Insert
    void insert(UnitStudents... unitStudents);

    @Insert
    void insert(UnitStudents unitStudents);

    @Insert
    void insert(List<UnitStudents> unitStudents);

}
