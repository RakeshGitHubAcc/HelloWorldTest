package com.test.myrest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.test.myrestjson.EmployeeService;

public class RestEasyApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
    public RestEasyApplication() {
        singletons.add(new RestEasyServices());
        singletons.add(new EmployeeService());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
