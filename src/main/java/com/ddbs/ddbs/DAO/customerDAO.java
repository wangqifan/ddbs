package com.ddbs.ddbs.DAO;


import com.ddbs.ddbs.Model.customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface customerDAO  {

    String TABLE_NAME = "customer";
    String INSERT_FIELDS = "id,name,phone";
    //String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{id},#{name},#{phone})"})
    int Addcustomer(customer customer);
}
