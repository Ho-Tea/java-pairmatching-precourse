package pairmatching.view;

import pairmatching.model.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderView {
    public List<String> read(Course course){
        try {
            return Files.lines(Paths.get("src/main/resources/"+ course.name().toLowerCase() + "-crew.md"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("[ERROR]" + e);
            return read(course);
        }
    }
}
