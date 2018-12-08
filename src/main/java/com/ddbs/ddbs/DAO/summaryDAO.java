package com.ddbs.ddbs.DAO;


import com.ddbs.ddbs.Model.summaryResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface summaryDAO {
    @Select("select barcode ,price ,count(*) as count from goods,salerecord where goods.id=salerecord.goodsid  group by barcode")
    List<summaryResult> summary();
}
