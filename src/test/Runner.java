/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import coposite.EtypeGender;
import coposite.Student;
import coposite.Student.Course;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author JairoArmando
 */
public class Runner {
    public static void main(String[] args) {
        
        Calendar date = new GregorianCalendar( 1996, Calendar.MARCH, 2 );
        
        Student lola = new Student( "53256265", "Lola Becerra", date, EtypeGender.FEMALE );
        
       Student.Course prog_iii = lola.new Course( "6353","Programacion III", (byte) 4 );
       
       Student.Course calc_iv = lola.new Course( "5353","Calculo IV", (byte) 4 );
       
       lola.addCourse( "6353","Programacion III", (byte) 4 );
       
       lola.addCourse( "5353","Calculo IV", (byte) 4 );
       
       for ( Course course : lola.getCourses() ){
           System.out.printf("%s\n", course );
       }
       
       System.out.printf( "%n%s Tiene %d años", lola.getName(), lola.calcAge() );
    }
}
