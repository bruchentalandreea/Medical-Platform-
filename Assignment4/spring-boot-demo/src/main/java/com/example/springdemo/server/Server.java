package com.example.springdemo.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.text.ParseException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Server
{
    @WebMethod
    String[] getActivityData(String activity_name) throws SQLException, ParseException;
}

