public class Assignment {
    private String courseCode, courseName, title, dueDate, file, status;
    public Assignment(){
    }   

    public String getStatus() {
    	return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
    
    public String getCourseCode() {
    	return this.courseCode;
    }
    
    public void setCourseCode(String code) {
    	this.courseCode = code;
    }
    
    public String getCourseName() {
    	return this.courseName;
    }
    
    public void setCourseName(String name) {
    	this.courseName = name;
    }
    
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    public String getFileName(){
        return this.file;
    }

    public void setFileName(String fileName){
        this.file = fileName;
    }
}
