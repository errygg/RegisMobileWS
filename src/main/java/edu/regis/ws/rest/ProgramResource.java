package edu.regis.ws.rest;

import edu.regis.ws.models.Program;
import edu.regis.ws.db.ProgramDb;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ProgramResource {
    
    private Program program;
    
    public ProgramResource(String id) {
        program = ProgramDb.getInstance().findById(id);
    }

    /**
     * Get a specific program object represented by the ID passed in the constructor.
     *
     * @return the Program object that corresponds to the constructor ID.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public synchronized Program getProgram() {
    	return program;
    }
}
