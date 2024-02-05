package com.mycompany.oopjavaoop;

import java.util.*;
import java.io.*;

public class OopJavaOOP {
    /// Menu ///
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("----------------- Menu -----------------");       
        System.out.println("1: Forms.");
        System.out.println("2: Student.");
        System.out.println("3: Teachers.");
        System.out.println("4: Modules");
        System.out.println("5: Logout");
        System.out.print("Enter what you want : ");
        int menu = scanner.nextInt();

     switch (menu)
    {
    // Forms
    case 1 -> {
        System.out.flush();
        System.out.println("----------------- Forms -----------------");
        System.out.println("1: Add Forms.");
        System.out.println("2: View Forms.");
        System.out.println("3: View Forms with ID."); ///
        System.out.println("4: Delete Forms. ");
        System.out.println("5: Back to menu");
        System.out.print("Enter what you want : ");
        int Froms = scanner.nextInt();
        
        switch (Froms)
        {
            case 1 -> {
                SaveFormsData(args);
                returnmenu(args);
                }
            case 2 -> {
                viewForms(args);
                returnmenu(args);
                }
            case 3 -> {
                scanner.nextLine();

                // View student by ID
                System.out.print("Enter the ID of the Forms: ");
                String idToSearch = scanner.nextLine();
                searchFormsById(idToSearch);
                
                main(args);
                }
            case 4 -> {
                DeleteFormsData();
                returnmenu(args);
                }
            case 5 -> {
                main(args);
                }
            default -> System.out.println("error !! ");
        }
            // Add Stedent Data
            // View Forms Data
             }
    // Students
    case 2 -> {
        System.out.println("----------------- Students -----------------");
        System.out.println("1: Add Student.");
        System.out.println("2: View all Student.");
        System.out.println("3: Search about Students by ID.");
        System.out.println("4: Delete Student.");
        System.out.println("5: Back to menu");
        System.out.println("56: Updated Data Of Student");

        System.out.print("Enter what you want : ");
        int Students = scanner.nextInt();
        
        switch (Students)
        {
            case 1 -> {
                SaveStudentData(args);
                returnmenu(args);
                }
            case 2 -> {
                viewStudentData(args);
                returnmenu(args);
                }
            case 3 -> {
                scanner.nextLine();

                // View student by ID
                System.out.print("Enter the ID of the student: ");
                String idToSearch = scanner.nextLine();
                searchStudentById(idToSearch);
                
                
                main(args);
                }
            case 4 -> {
                DeleteStudentData();
                returnmenu(args);
                }
            case 5 -> {
                main(args);
                }
            case 6 -> {
                UpdatedDataOfStudent(args);
                }
            default -> System.out.println("error !! ");
        }
             }
    // Teachers
    case 3 -> {
        System.out.println("----------------- Teachers -----------------");
        System.out.println("1: Add Teacher.");
        System.out.println("2: View all Teachers.");
        System.out.println("3: Search about Teachers by ID.");
        System.out.println("4: Delete Teachers.");
        System.out.println("5: Back to menu");
        System.out.print("Enter what you want : ");
        int Teachers = scanner.nextInt();
        
        switch (Teachers)
        {
            case 1 -> {
                SaveTeachersData(args);
                returnmenu(args);
                }
            case 2 -> {
                viewTeachersData(args);
                returnmenu(args);
                }
            case 3 -> {
                scanner.nextLine();

                System.out.print("Enter the ID of the Teachers: ");
                String idToSearch = scanner.nextLine();
                searchTeachersById(idToSearch);
                
                returnmenu(args);
                }
            case 4 -> {
                DeleteTeachersData();
                returnmenu(args);
                }
             case 5 -> {
                main(args);
                }
            default -> System.out.println("error !! ");
        }
        break;
             }
    // Modules
    case 4 ->{
        System.out.println("----------------- Modules -----------------");
        System.out.println("1: Add Module.");
        System.out.println("2: View all Modules.");
        System.out.println("3: Search about Modules by ID.");
        System.out.println("3: Delete Module.");
        System.out.println("4: Back to menu");
        System.out.print("Enter what you want : ");
        int Modules = scanner.nextInt();
        
        switch (Modules)
        {
            case 1 -> {
                SaveModulesData();
                returnmenu(args);
                }
            case 2 -> {
                ViewModulesData(args);
                returnmenu(args);
                }
            case 3 -> {
                scanner.nextLine();

                System.out.print("Enter the ID of the Modules: ");
                String idToSearch = scanner.nextLine();
                searchModulesById(idToSearch);
                
                returnmenu(args);
                }
            case 4 -> {
                DeleteModulesData();
                returnmenu(args);
                }
            case 5 -> {
                main(args);
                }
            default -> System.out.println("error !! ");
        }
        break;

    }
    // Logout
    case 5 -> System.out.println("5: Logout");
    // Error !!
    default -> System.out.println("error !! ");

    }
     
    }
 
    /// Forms ///
        // add New Form //
    public static void SaveFormsData(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Add new Form -----------------");
        // name of Form
        System.out.print("Enter name of Form : ");
        String NameOfForm = scanner.nextLine();
        
        // Teacher Of Form 
        System.out.print("Enter Teacher Of Form : ");
        String TeachersOfForm = scanner.nextLine();
        
        // Time of Form
        System.out.print("Enter Time of Form: ");
        int TimeOfForm = scanner.nextInt();
       
        // System of ID, Random ID
        
        int min = 1;
        int max = 9999;
        Random random = new Random();
        int ID = random.nextInt(max - min + 1) + min;
        String NewIDOfForms;
        if(ID <= 9){
            NewIDOfForms = "#000"+ID;
        }else if(ID <= 99){
             NewIDOfForms = "#00"+ID;
        }else if(ID <= 999){
            NewIDOfForms = "#0"+ID;
        }else {
            NewIDOfForms = "#"+ID;
        }
        
        
        // Save Data, name of Form, Teacher Of Form , Time of Form.
        String file = "Forms.txt";
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            // Write the data to the file
            writer.write("ID: " + NewIDOfForms + "\n");
            writer.write("Name Of Forms: " + NameOfForm + "\n");
            writer.write("Teacher: " + TeachersOfForm + "\n");
            writer.write("Time: " + TimeOfForm +"h"+ "\n");
            writer.write("-------------------\n");

            System.out.print("Data has been written to the file successfully!");
        } catch (IOException e) {
            // Handle exceptions
        }
        
    }
        // view Forms //
    public static void viewForms(String[] args) {
        System.out.println("----------------- View Forms -----------------");
        try (BufferedReader reader = new BufferedReader(new FileReader("Forms.txt"))) {
            String line;
            System.out.println("\n\n\n");
            System.out.println("::::::::::::::::::::::::::::::::::::::");
            System.out.println("\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               }
                System.out.println("\n");
                System.out.println("::::::::::::::::::::::::::::::::::::::");
                System.out.println("\n\n\n");
        } catch (IOException e) {

        }
    }
            // View Student with ID: //
    public static void searchFormsById(String idToSearch) {
         String file = "Forms.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToSearch)) {
                    // Display the lines corresponding to the ID
                    System.out.println("Forms with ID " + idToSearch + " found:");
                    System.out.println("-------------------");
                    System.out.println(line);  // Display the first line with ID, Name, and Grade

                    // Display the next 5 lines (assuming each student's data spans 6 lines)
                    for (int i = 0; i < 4 && (line = reader.readLine()) != null; i++) {
                        System.out.println(line);
                    }

                    found = true;
                    break; // Stop reading after finding the student
                }
            }

            if (!found) {
                System.out.println("Forms with ID " + idToSearch + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
        // Delete Data of Forms //
    public static void DeleteFormsData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the student to delete: ");
        String idToDelete = scanner.nextLine();

        // Read all lines from the file
        String file = "Forms.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToDelete)) {
                    // Skip the lines corresponding to the ID to be deleted
                    for (int i = 1; i < 5; i++) {
                        reader.readLine();
                    }
                    found = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(fileContent.toString());
            }

            if (found) {
                System.out.println("Student with ID " + idToDelete + " has been deleted.");
            } else {
                System.out.println("Student with ID " + idToDelete + " not found.");
            }
        } catch (IOException e) {
            // Handle exceptions
        }
    }
    
    /// Students ///
        // Add New Student //
    public static void SaveStudentData(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Add new Student -----------------");
        // variable Firstname
        System.out.print("Enter your Firstname : ");
        String Firstname = scanner.nextLine();
        
        // variable Surname
        System.out.print("Enter you Surname : ");
        String Surname = scanner.nextLine();
        
        // variable Age
        System.out.print("how old are you : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        
        // variable City
        System.out.print("wHere are you from : ");
        String city = scanner.nextLine();
        
        // variable Fields
        System.out.print("Enter Fields of Student : ");
        String Fields = scanner.nextLine();
        
        // System of ID, Random ID
        int min = 1;
        int max = 9999;
        Random random = new Random();
        int ID;
        String NewID;
        boolean idExists;

    do {
        ID = random.nextInt(max - min + 1) + min;
        if (ID <= 9) {
            NewID = "#000" + ID;
        } else if (ID <= 99) {
            NewID = "#00" + ID;
        } else if (ID <= 999) {
            NewID = "#0" + ID;
        } else {
            NewID = "#" + ID;
        }

        // Check if the ID already exists in Data.txt
        idExists = isIDExists(NewID, "Data.txt");
    } while (idExists);

    // Save Data, ID, Name, Last Name, Age.
    String file = "Data.txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        // Write the data to the file
        writer.write("ID: " + NewID + "\n");
        writer.write("Name: " + Firstname + "\n");
        writer.write("Last Name: " + Surname + "\n");
        writer.write("Age: " + age + "\n");
        writer.write("city: " + city + "\n");
        writer.write("Fields: " + Fields + "\n");
        writer.write("-------------------\n");
        
        System.out.print("Data has been written to the file successfully!");
    } catch (IOException e) {
        // Handle exceptions
    }
    
}
        // view all Data of Students //
    public static void viewStudentData(String[] args) {
        System.out.println("----------------- View all Student -----------------");
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            System.out.println("\n\n\n");
            System.out.println("::::::::::::::::::::::::::::::::::::::");
            System.out.println("\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               }
                System.out.println("\n");
                System.out.println("::::::::::::::::::::::::::::::::::::::");
                System.out.println("\n\n\n");
        } catch (IOException e) {
            
        }
    }
        // Search about Students by ID: //
    public static void searchStudentById(String idToSearch) {
         String file = "Data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToSearch)) {
                    // Display the lines corresponding to the ID
                    System.out.println("Student with ID " + idToSearch + " found:");
                    System.out.println("-------------------");
                    System.out.println(line);  // Display the first line with ID, Name, and Grade

                    // Display the next 5 lines (assuming each student's data spans 6 lines)
                    for (int i = 0; i < 5 && (line = reader.readLine()) != null; i++) {
                        System.out.println(line);
                    }

                    found = true;
                    break; // Stop reading after finding the student
                }
            }

            if (!found) {
                System.out.println("Student with ID " + idToSearch + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
        // Delete Data of Students //
    public static void DeleteStudentData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the student to delete: ");
        String idToDelete = scanner.nextLine();

        // Read all lines from the file
        String file = "Data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToDelete)) {
                    // Skip the lines corresponding to the ID to be deleted
                    for (int i = 1; i < 6; i++) {
                        reader.readLine();
                    }
                    found = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(fileContent.toString());
            }

            if (found) {
                System.out.println("Student with ID " + idToDelete + " has been deleted.");
            } else {
                System.out.println("Student with ID " + idToDelete + " not found.");
            }
        } catch (IOException e) {
            // Handle exceptions
        }
    }
        // Updated Data of Students //
     public static void UpdatedDataOfStudent(String[] args) {
        String fileName = "Data.txt";

        // Your variables with updated values
        int newID = 123;
        String firstName = "John";
        String surname = "Doe";
        int age = 30;
        String city = "New York";
        String fields = "Software Development";

        try {
            // Read the original file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder fileContent = new StringBuilder();
            String line;

            // Read each line and update the content
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID:")) {
                    line = "ID: " + newID;
                } else if (line.startsWith("Name:")) {
                    line = "Name: " + firstName;
                } else if (line.startsWith("Last Name:")) {
                    line = "Last Name: " + surname;
                } else if (line.startsWith("Age:")) {
                    line = "Age: " + age;
                } else if (line.startsWith("city:")) {
                    line = "city: " + city;
                } else if (line.startsWith("Fields:")) {
                    line = "Fields: " + fields;
                }
                fileContent.append(line).append("\n");
            }

            // Close the reader
            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileContent.toString());

            // Close the writer
            writer.close();

            System.out.println("File updated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    /// Teachers ///
        // Add New Teacher //  
    public static void SaveTeachersData(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Add new Teacher -----------------");
        // variable Firstname of teacher
        System.out.print("Enter the teacher's First Name : ");
        String Firstnameofteacher = scanner.nextLine();
        
        // variable Surname of teacher
        System.out.print("Enter the teacher's Surname : ");
        String Surnameofteacher = scanner.nextLine();
        
        // variable Age of teacher
        System.out.print("Enter the teacher's age : ");
        int ageofteacher = scanner.nextInt();
       
        // variable City of teacher
        System.out.print("Enter where the teacher was born : ");
        String cityofteacher = scanner.nextLine();
        
        
        // System of ID, Random ID
        int min = 1;
        int max = 9999;
        Random random = new Random();
        int ID;
        String NewID;
        boolean idExists;

    do {
        ID = random.nextInt(max - min + 1) + min;
        if (ID <= 9) {
            NewID = "#000" + ID;
        } else if (ID <= 99) {
            NewID = "#00" + ID;
        } else if (ID <= 999) {
            NewID = "#0" + ID;
        } else {
            NewID = "#" + ID;
        }

        // Check if the ID already exists in Data.txt
        idExists = isIDExists(NewID, "DataOfTeacher.txt");
    } while (idExists);

    // Save Data, ID, Name, Last Name, Age.
    String file = "DataOfTeacher.txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        // Write the data to the file
        writer.write("ID: " + NewID + "\n");
        writer.write("Name: " + Firstnameofteacher + "\n");
        writer.write("Last Name: " + Surnameofteacher + "\n");
        writer.write("Age: " + ageofteacher + "\n");
        writer.write("city: " + cityofteacher + "\n");
        writer.write("-------------------\n");
        
        System.out.print("Data has been written to the file successfully!");
    } catch (IOException e) {
        // Handle exceptions
    }
        
    }
        // View Teachers //
    public static void viewTeachersData(String[] args) {
        System.out.println("----------------- View all Teachers -----------------");
        try (BufferedReader reader = new BufferedReader(new FileReader("DataOfTeacher.txt"))) {
            String line;
            System.out.println("\n\n\n");
            System.out.println("::::::::::::::::::::::::::::::::::::::");
            System.out.println("\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               }
                System.out.println("\n");
                System.out.println("::::::::::::::::::::::::::::::::::::::");
                System.out.println("\n\n\n");
        } catch (IOException e) {
            
        }
    }
        // Search about Teachers by ID //
    public static void searchTeachersById(String idToSearch) {
         String file = "DataOfTeacher.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToSearch)) {
                    // Display the lines corresponding to the ID
                    System.out.println("Teachers with ID " + idToSearch + " found:");
                    System.out.println("-------------------");
                    System.out.println(line);  // Display the first line with ID, Name, and Grade

                    // Display the next 5 lines (assuming each student's data spans 6 lines)
                    for (int i = 0; i < 5 && (line = reader.readLine()) != null; i++) {
                        System.out.println(line);
                    }

                    found = true;
                    break; // Stop reading after finding the student
                }
            }

            if (!found) {
                System.out.println("Teachers with ID " + idToSearch + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
        // Delete Data of Students //
    public static void DeleteTeachersData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the student to delete: ");
        String idToDelete = scanner.nextLine();

        // Read all lines from the file
        String file = "DataOfTeacher.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToDelete)) {
                    // Skip the lines corresponding to the ID to be deleted
                    for (int i = 1; i < 6; i++) {
                        reader.readLine();
                    }
                    found = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(fileContent.toString());
            }

            if (found) {
                System.out.println("Student with ID " + idToDelete + " has been deleted.");
            } else {
                System.out.println("Student with ID " + idToDelete + " not found.");
            }
        } catch (IOException e) {
            // Handle exceptions
        }
    }
    
    /// Modules ///
        // Add New Modules //
    public static void SaveModulesData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Add new Modules -----------------");

        // name of Form
        System.out.print("Enter name of Modules : ");
        String NameOfModules = scanner.nextLine();

        // forms Of Modules
        System.out.print("Enter first Form : ");
        String formsOfModules1 = scanner.nextLine();

        System.out.print("Enter second Form : ");
        String formsOfModules2 = scanner.nextLine();

        System.out.print("Enter Third Form : ");
        String formsOfModules3 = scanner.nextLine();
        
          // System of ID, Random ID
        
        int min = 1;
        int max = 9999;
        Random random = new Random();
        int ID = random.nextInt(max - min + 1) + min;
        String NewIDOfModules;
        if(ID <= 9){
            NewIDOfModules = "#000"+ID;
        }else if(ID <= 99){
             NewIDOfModules = "#00"+ID;
        }else if(ID <= 999){
            NewIDOfModules = "#0"+ID;
        }else {
            NewIDOfModules = "#"+ID;
        }

        String file = "Modules.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            // Write the data to the file
            writer.write("ID: " + NewIDOfModules + "\n");
            writer.write("Name Of Module: " + NameOfModules + "\n");
            writer.write("first Form : " + formsOfModules1 + "\n");
            writer.write("second Form: " + formsOfModules2 + "\n");
            writer.write("Third Form: " + formsOfModules3 + "\n");
            writer.write("-------------------\n");

            System.out.print("Data has been written to the file successfully!");
        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
        // View  Modules //
    public static void ViewModulesData(String[] args){
        System.out.println("----------------- View Modules -----------------");
        try (BufferedReader reader = new BufferedReader(new FileReader("Modules.txt"))) {
            String line;
            System.out.println("\n\n\n");
            System.out.println("::::::::::::::::::::::::::::::::::::::");
            System.out.println("\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               }
                System.out.println("\n");
                System.out.println("::::::::::::::::::::::::::::::::::::::");
                System.out.println("\n\n\n");
        } catch (IOException e) {
            
        }

    }
        // Search about Modules by ID //
    public static void searchModulesById(String idToSearch) {
         String file = "Modules.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                
                if (line.contains("ID: " + idToSearch)) {
                    System.out.println("Modules with ID " + idToSearch + " found:");
                    System.out.println("-------------------");
                    System.out.println(line);  

                    // Display the next 5 lines (assuming each student's data spans 6 lines)
                    for (int i = 0; i < 5 && (line = reader.readLine()) != null; i++) {
                        System.out.println(line);
                    }

                    found = true;
                    break; // Stop reading after finding the student
                }
            }

            if (!found) {
                System.out.println("Modules with ID " + idToSearch + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
        // Delete Data of Students //
    public static void DeleteModulesData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the student to delete: ");
        String idToDelete = scanner.nextLine();

        // Read all lines from the file
        String file = "Modules.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            boolean found = false;

            // Iterate through the file content
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToDelete)) {
                    // Skip the lines corresponding to the ID to be deleted
                    for (int i = 1; i < 6; i++) {
                        reader.readLine();
                    }
                    found = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(fileContent.toString());
            }

            if (found) {
                System.out.println("Student with ID " + idToDelete + " has been deleted.");
            } else {
                System.out.println("Student with ID " + idToDelete + " not found.");
            }
        } catch (IOException e) {
            // Handle exceptions
        }
    }
    
    
    /// Return to menu ///
    public static void returnmenu(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1:menu\n2:Logout");
        System.out.print("Enter what you want : ");
        int AddNewData = scanner.nextInt();
        if(AddNewData == 1){
            main(args);
        }else{
            System.out.println("Exiting program.");
        }     
    }
    
    /// Id ///
    private static boolean isIDExists(String newID, String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().startsWith("ID: " + newID)) {
                return true;
            }
        }
    } catch (IOException e) {
        // Handle exceptions
    }
    return false;
}
    
}
