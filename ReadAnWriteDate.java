import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAnWriteDate {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream("C:\\student_data.xlsx");
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; // Skip the header row
                }
                String name = row.getCell(0).getStringCellValue();
                String course = row.getCell(1).getStringCellValue();
                String fee = row.getCell(2).getStringCellValue();
                students.add(new Student(name, course, fee));
            }

            for (Student student : students) {
                System.out.println("Name: " + student.getName() + ", Course: " + student.getCourse() + ", Fee: " + student.getFee());
            }

            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Student {
        private String name;
        private String course;
        private String fee;

        public Student(String name, String course, String fee) {
            this.name = name;
            this.course = course;
            this.fee = fee;
        }

        public String getName() {
            return name;
        }

        public String getCourse() {
            return course;
        }

        public String getFee() {
            return fee;
        }
    }
}

