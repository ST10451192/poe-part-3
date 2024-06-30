/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class poe333 {
   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userAuthentication;

/**
 *
 * @author RC_Student
 */
    


public class UserAuth {
    String inputUsername;
    String inputPassword;
    String givenName;
    String familyName;
    String userPassword;
    String userUsername;

    public boolean isUsernameValid() {
        boolean isValid = false;
        for (int i = 0; i < userUsername.length(); i++) {
            if (userUsername.length() <= 5) {
                if (userUsername.charAt(i) == '_') {
                    isValid = true;
                }
            }
        }
        return isValid;
    }

    public boolean isPasswordComplex() {
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        if (userPassword.length() >= 8) {
            for (int i = 0; i < userPassword.length(); i++) {
                char ch = userPassword.charAt(i);
                if (Character.isUpperCase(ch)) {
                    hasCapitalLetter = true;
                } else if (Character.isDigit(ch)) {
                    hasNumber = true;
                } else if (!Character.isLetterOrDigit(ch)) {
                    hasSpecialChar = true;
                }
            }
        }
        return hasCapitalLetter && hasNumber && hasSpecialChar;
    }

    public String registerUser() {
        if (isUsernameValid()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your Username contains an underscore and is no more than 5 characters in length.");
        }
        if (isPasswordComplex()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }
        if (isUsernameValid() && isPasswordComplex()) {
            System.out.println("The two above conditions have been met and the user has been registered successfully.");
        } else {
            if (!isPasswordComplex()) {
                System.out.println("The Password does not meet the complexity requirements.");
            }
            if (!isUsernameValid()) {
                System.out.println("The username is incorrectly formatted.");
            }
        }
        return "";
    }

    public boolean loginUser() {
        return userUsername.equals(inputUsername) && userPassword.equals(inputPassword);
    }

    public String returnLoginStatus() {
        if (loginUser()) {
            System.out.println("Successful login");
            System.out.println("Welcome " + givenName + " " + familyName + " it is great to see you again.");
        } else {
            System.out.println("A failed login");
            System.out.println("Username or Password incorrect please try again");
        }
        return "";
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.println("Register..........");
        System.out.println("Enter First Name :");
        auth.givenName = scanner.next();
        System.out.println("Enter Last Name :");
        auth.familyName = scanner.next();
        System.out.println("Enter Username :");
        auth.userUsername = scanner.next();
        System.out.println("Enter Password :");
        auth.userPassword = scanner.next();

        System.out.println(auth.registerUser());
        while (!auth.isUsernameValid() || !auth.isPasswordComplex()) {
            System.out.println("Try to register again!!!!!");
            System.out.println("Enter Username :");
            auth.userUsername = scanner.next();
            System.out.println("Enter Password :");
            auth.userPassword = scanner.next();
            System.out.println(auth.registerUser());
        }

        System.out.println("Login..........");
        System.out.println("Enter Username :");
        auth.inputUsername = scanner.next();
        System.out.println("Enter Password :");
        auth.inputPassword = scanner.next();
        System.out.println(auth.returnLoginStatus());

        while (!auth.loginUser()) {
            System.out.println("Try to Login again ..........");
            System.out.println("Enter Username :");
            auth.inputUsername = scanner.next();
            System.out.println("Enter Password :");
            auth.inputPassword = scanner.next();
            System.out.println(auth.returnLoginStatus());
        }

        if (auth.loginUser()) {
            JOptionPane.showMessageDialog(null, "Welcome To EasyKanban");
            int choice;
            do {
                taskHandler.userInput = JOptionPane.showInputDialog("Choose an option:\n1. Add tasks\n2. Show report\n3. Quit");
                choice = Integer.parseInt(taskHandler.userInput);

                switch (choice) {
                    case 1:
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                        int totalHours = 0;

                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter task name:");
                            String taskDescription = JOptionPane.showInputDialog("Enter task description:");
                            String devFirstName = JOptionPane.showInputDialog("Enter developer's first name:");
                            String devLastName = JOptionPane.showInputDialog("Enter developer's last name:");
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration:"));
                            String taskID = taskHandler.createTaskID(taskName, i, devLastName);
                            String taskStatus = "";

                            int option = Integer.parseInt(JOptionPane.showInputDialog("Please choose the Status of this task from the three options.\n1.To Do\n2.Doing\n3.Done"));
                            switch (option) {
                                case 1:
                                    taskStatus = "To Do";
                                    break;
                                case 2:
                                    taskStatus = "Doing";
                                    break;
                                case 3:
                                    taskStatus = "Done";
                                    break;
                            }

                            
                            JOptionPane.showMessageDialog(null, taskDetails);
                            JOptionPane.showMessageDialog(null, "Task successfully captured."); // Task captured message
                            totalHours += taskDuration;
                        }

                        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
                        break;

                    case 2:
                        int reportChoice;
                        do {
                            reportChoice = Integer.parseInt(JOptionPane.showInputDialog("Show Report Options:\n1. Display all tasks\n2. Display done tasks\n3. Display longest task\n4. Search task by name\n5. Search tasks by developer\n6. Delete task\n7. Go back"));

                            switch (reportChoice) {
                                case 1:
                                    taskHandler.showTaskReport();
                                    break;
                                case 2:
                                    taskHandler.displayDoneTasks();
                                    break;
                                case 3:
                                    taskHandler.displayLongestTask();
                                    break;
                                case 4:
                                    String searchTaskName = JOptionPane.showInputDialog("Enter task name to search:");
                                    taskHandler.searchTaskByName(searchTaskName);
                                    break;
                                case 5:
                                    String searchDeveloper = JOptionPane.showInputDialog("Enter developer name to search tasks:");
                                    taskHandler.searchTasksByDeveloper(searchDeveloper);
                                    break;
                                case 6:
                                    String deleteTaskName = JOptionPane.showInputDialog("Enter task name to delete:");
                                    taskHandler.deleteTask(deleteTaskName);
                                    break;
                                case 7:
                                    JOptionPane.showMessageDialog(null, "Returning to main menu.");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                                    break;
                            }
                        } while (reportChoice != 7);
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting the application.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 3);
        }
    }
}

class TaskHandler {
    String userInput = "";
    private List<String> developers = new ArrayList<>();
    private List<String> taskNames = new ArrayList<>();
    private List<String> taskIDs = new ArrayList<>();
    private List<Integer> taskDurations = new ArrayList<>();
    private List<String> taskStatuses = new ArrayList<>();

    public boolean isTaskDescriptionValid(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    public String createTaskID(String taskName, int taskNumber, String developerLastName) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase();
    }

    public String printTaskDetails(String taskStatus, String devFirstName, String devLastName, int taskNumber, String taskName, String taskDescription, String taskID, int taskDuration) {
        StringBuilder taskDetails = new StringBuilder();
        taskDetails.append("Task Status: ").append(taskStatus).append("\n");
        taskDetails.append("Developer Details: ").append(devFirstName).append(" ").append(devLastName).append("\n");
        taskDetails.append("Task Number: ").append(taskNumber).append("\n");
        taskDetails.append("Task Name: ").append(taskName).append("\n");
        taskDetails.append("Task Description: ").append(taskDescription).append("\n");
        taskDetails.append("Task ID: ").append(taskID).append("\n");
        taskDetails.append("Task Duration: ").append(taskDuration).append(" hours\n");
        return taskDetails.toString();
    }

    public void addTask(String taskName, String taskDescription, String developer, String taskID, int taskDuration, String taskStatus) {
        taskNames.add(taskName);
        developers.add(developer);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
    }

    public void showTaskReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task Name: ").append(taskNames.get(i)).append("\n");
            report.append("Developer: ").append(developers.get(i)).append("\n");
            report.append("Task ID: ").append(taskIDs.get(i)).append("\n");
            report.append("Task Duration: ").append(taskDurations.get(i)).append(" hours\n");
            report.append("Task Status: ").append(taskStatuses.get(i)).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public void displayDoneTasks() {
        StringBuilder doneTasks = new StringBuilder();
        doneTasks.append("Tasks with status 'Done':\n");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskStatuses.get(i).equals("Done")) {
                doneTasks.append("Developer: ").append(developers.get(i)).append(", ");
                doneTasks.append("Task Name: ").append(taskNames.get(i)).append(", ");
                doneTasks.append("Task Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, doneTasks.toString());
    }

    public void displayLongestTask() {
        int maxDuration = 0;
        int maxIndex = 0;
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                maxIndex = i;
            }
        }
        JOptionPane.showMessageDialog(null, "Task with longest duration:\nDeveloper: " + developers.get(maxIndex) + ", Duration: " + maxDuration + " hours");
    }

    public void searchTaskByName(String name) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equals(name)) {
                result.append("Task Name: ").append(taskNames.get(i)).append("\n");
                result.append("Developer: ").append(developers.get(i)).append("\n");
                result.append("Task Status: ").append(taskStatuses.get(i)).append("\n");
                break;
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void searchTasksByDeveloper(String developer) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).contains(developer)) {
                result.append("Task Name: ").append(taskNames.get(i)).append(", ");
                result.append("Task Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void deleteTask(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equals(taskName)) {
                taskNames.remove(i);
                developers.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.");
    }
}
 
}

