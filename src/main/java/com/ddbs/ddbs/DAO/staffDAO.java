package com.ddbs.ddbs.DAO;

import com.ddbs.ddbs.Model.staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface staffDAO {

    String TABLE_NAME = "staff";
    String INSERT_FIELDS = "name,salary,time";
    //String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{name},#{salary},#{time})"})
    int insertstaff(staff staff);
}