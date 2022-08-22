package com.bi.entity;
/**
 * @author : coder-zc
 * @date : 2022/8/21 23:52
 */

import lombok.Data;

import java.util.Date;

/**
 * @author coder-zc
 * @date 2022年08月21日 23:52
 */
@Data
public class ClickHouseData {
    public int price;
    public Date date;
    public String postcode1;
    public String Postcode2;
    public String type;
    public int is_new;
    public String duration;
    public String addr1;
    public String addr2;
    public String street;
    public String locality;
    public String town;
    public String district;
    public String county;
    public int category;

}
