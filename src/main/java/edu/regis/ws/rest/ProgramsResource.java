package edu.regis.ws.rest;

import edu.regis.ws.models.Programs;
import edu.regis.ws.db.ProgramDb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/programs")
public class ProgramsResource {

    /**
     * Get a list of the programs registered in the system.
     *
     * @return a list of all existing Programs
     */
	@GET
    public synchronized Programs getAll() {
        Programs programs = new Programs();
        programs.getPrograms().addAll(ProgramDb.getInstance().getPrograms());
    	System.out.println("Programs: " + programs.getPrograms());
        return programs;
    }

    /**
     * Get a list of the programs matching either a first name or
     * last name based on the query parameter.
     * 
     * @param firstName
     * @param lastName
     * @return a list of Programs
     */
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Programs getPrograms( @QueryParam("school_id") String schoolId ) {
    	Programs programs = new Programs();
    	if( schoolId != null ) {
    	    programs.getPrograms().addAll(ProgramDb.getInstance().findBySchoolId(schoolId));
    	}
    	return programs;
    }
    
    /**
     * Do something with a program that exists in the system. We expect the ID
     * to be supplied on the path. Delegate processing to the ProgramResource object.
     * 
     * @param programid the ID of the Program
     * @return a ProgramResource object that processes the request
     */
    @Path("/id/{id}/")
    public ProgramResource getProgram(@PathParam("id") String id) {
        return new ProgramResource(id);
    }
}
