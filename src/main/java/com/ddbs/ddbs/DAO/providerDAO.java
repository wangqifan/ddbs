package com.ddbs.ddbs.DAO;

import com.ddbs.ddbs.Model.provider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface providerDAO {

    String TABLE_NAME = "provider";
    String INSERT_FIELDS = "name,phone";
    //String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{name},#{phone})"})
    int insertprovider(provider provider);
}
