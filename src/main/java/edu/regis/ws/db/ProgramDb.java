package edu.regis.ws.db;

import edu.regis.ws.models.Program;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramDb {
	
	private static final ProgramDb instance = new ProgramDb();
	
	private Map<String, Program> programs = new HashMap<String, Program>();
	private int programIdx = 0;
	
	public static ProgramDb getInstance() {
		return instance;
	}
	
	private ProgramDb() {
		
		Program program1 = new Program();
		program1.setName("Software Engineering");
		program1.setSchoolId(0);
		program1.setType("Master");
		addProgram(program1);
		
		Program program2 = new Program();
		program2.setName("Database Technologies");
		program2.setSchoolId(0);
		program2.setType("Master");
		addProgram(program2);
		
	}
	
	public List<Program> getPrograms() {
		return new ArrayList<Program>(programs.values());
	}
	
	public Program findById( String id ) {
		return programs.get(id);
	}
	
	public synchronized void addProgram( Program program ) {
		
		int id = programIdx++;
		programs.put( Integer.toString(id), program );
		program.setId(id);
	
	}
	
	public synchronized void updateProgram( String id, Program program ) {
		programs.put( id, program );
	}
	
	public synchronized void deleteProgram( String id ) {
		programs.remove(id);
	}

	public Collection<? extends Program> findBySchoolId(String schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

}
