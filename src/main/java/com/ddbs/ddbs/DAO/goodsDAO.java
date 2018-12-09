package com.ddbs.ddbs.DAO;

import com.ddbs.ddbs.Model.goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface goodsDAO {


    String TABLE_NAME = "goods";
    String INSERT_FIELDS = "name,price,providerid,barcode";
    //String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{name},#{price},#{providerid},#{barcode})"})
    int AddGoods(goods good);
}
