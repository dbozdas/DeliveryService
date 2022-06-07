package com.solvd.deliveryservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat("yyyy-dd-MM").parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd").format(v);
    }

}