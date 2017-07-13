package com.mvictorl.main;

import com.mvictorl.entity.Address;
import com.mvictorl.entity.Employee;
import com.mvictorl.entity.Project;
import com.mvictorl.utilities.Util;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mvictorl on 7/13/17.
 */
public class test {
    public static void main(String[] args) {
        Session session = Util.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street 1");
        address.setPostCode(10987);


        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("5678");

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        Util.shutdown();
    }
}
