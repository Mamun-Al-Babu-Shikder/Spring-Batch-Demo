package com.mcubes.springbatchdemo.batch;

import com.mcubes.springbatchdemo.entity.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class MyItemProcessor implements ItemProcessor<Student, Student> {

    private static final Map<String, String> deptNames = new HashMap<>();

    public MyItemProcessor(){
        deptNames.put("1","ICT");
        deptNames.put("2","CSE");
        deptNames.put("3","TE");
    }

    @SuppressWarnings("deprecation")
    @Override
    public Student process(Student student) throws Exception {
        String dept = student.getDepartment();
        System.out.println("I : " + student);
        student.setDepartment(deptNames.get(dept));
        student.setModified(new Date().toLocaleString());
        System.out.println("O : " + student);
        return student;
    }
}
