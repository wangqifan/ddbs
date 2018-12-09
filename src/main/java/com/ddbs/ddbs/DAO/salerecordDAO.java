package com.ddbs.ddbs.DAO;

import com.ddbs.ddbs.Model.salerecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface salerecordDAO {

    String TABLE_NAME = "salerecord";
    String INSERT_FIELDS = "customerid,staffid,goodsid,count,time";
    //String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{customerid},#{staffid},#{goodsid},#{count},#{time})"})
    int insertsalerecord(salerecord salerecord);
}