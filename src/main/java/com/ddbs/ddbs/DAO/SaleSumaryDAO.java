package com.ddbs.ddbs.DAO;


import com.ddbs.ddbs.Model.headsummary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SaleSumaryDAO {
    String TABLE_NAME = "salesummary";
    String INSERT_FIELDS = "barcode,count,price,starttime";
    //String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{barcode},#{count},#{price},#{starttime})"})
    public int addSummary(headsummary summary);
}
