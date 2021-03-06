package validation;

public class Course {

    private String courseNum;
    private String department;
    private String callNum;
    private String days;
    private String time;
    private String instructor;
    private String roomNum;
    private String building;
    private String enrolledNum;
    private String absence;


    public Course(String courseNum, String department, String callNum, String days, String time,
                  String instructor, String roomNum, String building, String enrolledNum, String absence) {
        setCourseNum(courseNum);
        setDepartment(department);
        setCallNum(callNum);
        setDays(days);
        setTime(time);
        setInstructor(instructor);
        setRoomNum(roomNum);
        setBuilding(building);
        setEnrolledNum(enrolledNum);
        setAbsence(absence);
    }


    public void setCourseNum(String courseNum){
        this.courseNum = courseNum;
    }
    public String getCourseNum(){
        return courseNum;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }
    public String getCallNum() {
        return callNum;
    }
    public void setDays(String days) {
        this.days = days;
    }
    public String getDays() {
        return days;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
    public String getRoomNum() {
        return roomNum;
    }
    public void setBuilding(String building){
        this.building = building;
    }
    public String getBuilding() {
        return building;
    }
    public void setEnrolledNum(String enrolledNum){
        this.enrolledNum = enrolledNum;
    }
    public String getEnrolledNum() {
        return enrolledNum;
    }
    public void setAbsence(String absence){
        this.absence = absence;
    }
    public String getAbsence() {
        return absence;
    }
	
}
