package emailApp;

import java.util.Calendar;
import java.util.Scanner;

public class Email {
   private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "anycompany.com";

    // Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department, return the department
        this.department = setDepartment();
         // Call method for generatePassword
        this.password = randomPassword(defaultPasswordLength);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." +  lastName.toLowerCase() + "@"  + department + "." + companySuffix + "\n";

        //waitMethod();

    }

    // Generate a random Password
    private String randomPassword( int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length;i++){
          int rand =   (int)(Math.random() * passwordSet.length());
          password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    //Change the password
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    //Ask for the department
    public String setDepartment() {
        System.out.println("New worker : " + firstName + ". Department Codes:  \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code : ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice)
        {
            case 1: return "sales";
            case 2 :return "development";
            case 3 :return "accounting";
            default:return "";


        }

    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }


    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }


    // Set the alternate mail.
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String showInfo() {
        return "\nDISPLAY NAME : " + firstName + " " + lastName +
                "\nCOMPANY EMAIL : " + email +
                "\nMAILBOX CAPACITY : " + mailboxCapacity + "mb";
    }



    //TEST If you want your process continue to run until the user terminates it.
    private synchronized void waitMethod() {

        while (true) {
            System.out.println("always running program ==> " + Calendar.getInstance().getTime());
            try {
                this.wait(2000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }
}
