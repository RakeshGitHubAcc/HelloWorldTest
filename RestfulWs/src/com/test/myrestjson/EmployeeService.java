package com.test.myrestjson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

@Path("/info")
public class EmployeeService {
	@GET
    @Path("/{id}")
   // @Produces("application/json")
	@Produces("application/xml")
    public Response employeeDetail(@PathParam("id") String id) {
    	Employee employee = getEmployee(id);
        return Response.ok(employee).build();
    }
    @GET
   // @Produces("application/json")
    @Produces("application/xml")
    //@BadgerFish
    public Response employeeDetailPrettyPrint(@PathParam("id") String id) {
    	Employee employee = getEmployee(id);
        return Response.ok(employee).build();
    }
    @GET
    @Path("/prettyprint/{id}")
    @Produces("application/json")
    @Formatted
    public Employee getPrettyPrint(@PathParam("id") String id){
    	Employee employee = getEmployee(id);
    	ObjectMapper mapper = new ObjectMapper();
    	//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value));
    	return employee;
    }
    private Employee getEmployee(String id){
    	Employee employee = new Employee(id,"Arvind Rai","ABC");
    	/*employee.setId(id);
    	employee.setName("Arvind Rai");
    	employee.setCompany("ABC");*/
    	return employee;
    }
}
