/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coposite;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author JairoArmando
 */
public class Student {
    private String  code;
    private String name;
    private Calendar dayBirthday;
    private EtypeGender gender;
    private ArrayList< Course > courses;

    public Student(String code, String name, Calendar dayBirthday, EtypeGender gender) {
        this.code = code;
        this.name = name;
        this.dayBirthday = dayBirthday;
        this.gender = gender;
        courses = new ArrayList< >( );
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDayBirthday() {
        return dayBirthday;
    }

    public void setDayBirthday(Calendar dayBirthday) {
        this.dayBirthday = dayBirthday;
    }
    
    public EtypeGender getGender() {
        return gender;
    }

    public void setGender(EtypeGender gender) {
        this.gender = gender;
    }
    
    public int calcAge( ){
        
        Calendar dateNow = Calendar.getInstance( );
        
        int years = dateNow.get( Calendar.YEAR ) - dayBirthday.get( Calendar.YEAR );
        int months = dateNow.get( Calendar.MONTH ) - dayBirthday.get( Calendar.MONTH );
        int days = dateNow.get( Calendar.DAY_OF_MONTH ) - dayBirthday.get( Calendar.DAY_OF_MONTH  );
        
        if ( months < 0 || ( months == 0 && days < 0 ) )
            years--;
        
        return years;
    }

    @Override
    public String toString() {
        return "Student{" + "code=" + code + ", name=" + name + ", dayBirthday=" + dayBirthday + ", gender=" + gender + '}';
    }
    
    public boolean addCourse( String code, String description, byte credits ){
        
        if ( findCourse( code ) == null ){
            
            courses.add( new Course( code, description, credits) );
            return true;
        }
        
        return false;
    }

    private Course findCourse( String code ) {
        
        for ( Course course : courses ){
            if ( course.getCode().equals( code ) ){
                return course;
            }
        }
        
        return null;
    }
    
    public ArrayList< Course > getCourses( ){
        return ( ArrayList< Course > ) courses.clone( );
    }
 
    public class Course{
        private String code;
        private String description;
        private byte credits;

        public Course(String code, String description, byte credits) {
            this.code = code;
            this.description = description;
            this.credits = credits;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public byte getCredits() {
            return credits;
        }

        public void setCredits(byte credits) {
            this.credits = credits;
        }

        @Override
        public String toString() {
            return "Course{" + "code=" + code + ", description=" + description + ", credits=" + credits + '}';
        }
        
        
    }
    
}
