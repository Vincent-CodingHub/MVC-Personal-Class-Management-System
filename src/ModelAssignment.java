import java.util.ArrayList;

public class ModelAssignment {
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	
	public void uploadAssignment(Assignment a) {
	    assignments.add(a);
	}

	public ArrayList<Assignment> getAssignment() {
	    return assignments;
	}

	public ArrayList<Assignment> submitAssignment(String code, String name, String title, String dueDate, String fileName) {
	  for (Assignment assignmentList : assignments) {
	    if (assignmentList.getTitle().equals(title)) {
	      assignmentList.setStatus("Submitted");
	      	return assignments;
	    }
	  }
	  return assignments;
	}
}
