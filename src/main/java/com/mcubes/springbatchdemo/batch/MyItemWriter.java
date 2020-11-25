package com.mcubes.springbatchdemo.batch;

import com.mcubes.springbatchdemo.entity.Student;
import com.mcubes.springbatchdemo.repository.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyItemWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void write(List<? extends Student> list) throws Exception {

        System.out.println("Writing...");
        for (Student s : list){
            System.out.println(s);
        }
        studentRepository.saveAll(list);
    }
}
