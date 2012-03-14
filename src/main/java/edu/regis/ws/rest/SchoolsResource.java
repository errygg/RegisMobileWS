package edu.regis.ws.rest;

import edu.regis.namespaces.schools.Schools;
import edu.regis.namespaces.schools.School;
import edu.regis.ws.db.SchoolDb;

import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

@Path("schools")
public class SchoolsResource {

    @Context private UriInfo uriInfo;

    /**
     * Get a list of the schools registered in the system.
     *
     * @return a list of Schools
     */
	@GET
    @Produces({"application/xml","application/json"})
    public Schools getAll() {
        Schools schools = new Schools();
        schools.getSchools().addAll(SchoolDb.getInstance().getSchools());
    	System.out.println("Schools: " + schools.getSchools());
        return schools;
    }

    /**
     * Create a new School in the system. This is a POST request since it is not
     * idempotent. We return the URL to the school that was created.
     *
     * @param school the school to create
     * @return a response that contains the URL of the school created. 
     */
    @POST
    @Consumes({"application/xml","application/json"})
    public Response createNewSchool(JAXBElement<School> school) {
        SchoolDb.getInstance().addSchool(school.getValue());
        URI schoolUri = uriInfo.getAbsolutePathBuilder().
                path(school.getValue().getId().toString()).
                build();
        return Response.created(schoolUri).build();
    }


    /**
     * Do something with a school that exists in the system. We expect the ID
     * to be supplied on the path. Delegate processing to the SchoolResource object.
     * 
     * @param schoolid the ID of the School
     * @return a SchoolResource object that processes the request
     */
    @Path("{schoolid}/")
    public SchoolResource getSchool(@PathParam("schoolid") String schoolid) {
        return new SchoolResource(schoolid);
    }
}
