import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class HospitalSystem{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();
        boolean running = true;
        while(running){
            System.out.println("\t\t\t\n\nHospital Management System..");
            System.out.println("");
            System.out.println("1.Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Medical Records");
            System.out.println("5.Exit");
            System.out.print("Enter Option: ");
            String choice = input.nextLine();

                switch(choice){
                    case "1":
                        patientMenu(patients,input);
                    break;
                    case "2":

                    break;
                    case "3":

                    break;
                    case "4":
                        running = false;
                        System.out.println("Closing Program..");
                    break;
                    default:
                        System.out.println("Invalid Option...");
                }
        }
    }
    
        public static void patientMenu(ArrayList<Patient> patients ,Scanner input){
            boolean running = true;
            while(running){
                
            System.out.println("\n\nPATIENT MANAGEMENT");
            System.out.println("");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Display All Patients");
            System.out.println("4. Delete Patient");
            System.out.println("5.Exit");
            System.out.print("Enter option: ");
            String choice = input.nextLine();

            switch(choice){
                case "1":
                    AddPatient(patients,input);
                break;
                case "2":
                    search(patients, input);
                break;
                case "3":
                    DisplayPatients(patients);
                break;
                case "4":
                    delete(patients, input);
                    
                break;
                case "5":
                    running = false;
                break;
                default:
                    System.out.println("Invalid Option...");
            }
            }
        }

        //Add Ptaient

        public static void AddPatient(ArrayList<Patient> patients ,Scanner input){

            String name = " ";
            int id = 0;
            int age = 0;
            String gender = " ";
            int phone = 0;


            System.out.println("\tCreate Patient");
            try{
                
            System.out.print("Enter ID(3 digits): ");
             id = input.nextInt();
            input.nextLine();
            String idStr = String.valueOf(id);
            if(!idStr.matches("\\d{3}")){
                System.out.print("\nInvalid ID length input...");
                return;
            }
            for(Patient s:patients){
                if(id == s.getId()){
                    System.out.println("Id already Exists...");
                    return;
                }
            }

            }catch(InputMismatchException e){
                System.out.print("Invalid Data type input...");
                input.nextLine();
            }


            System.out.print("Enter Name: ");
             name = input.nextLine().trim();
            if(!name.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
                System.out.print("\nInvalid Data type input...");
                return;
            }
           
            System.out.print("Enter Gender: ");
             gender = input.nextLine().trim();
            if(!gender.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
                System.out.print("Invalid Data type input...");
                return;
            }if(!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f"))){
                System.out.println("\nInvalid gender...");
                return;
            }


            try{
                
            System.out.print("Enter Age: ");
             age = input.nextInt();
            input.nextLine();
            String ageStr = String.valueOf(age);
            if(!ageStr.matches("\\d{2}")){
                System.out.print("\nInvalid Age input...");
                return;
            }
            if(age <= 0){
                System.out.println("\nInvalid Age Input...");
                return;
            }
            System.out.print("Enter Phone: ");
            phone = input.nextInt();
            input.nextLine();
            String phStr = String.valueOf(phone);
            if(!phStr.matches("\\d{9}")){
                System.out.print("\nInvalid Phone length input...");
                return;
            }
            }catch(InputMismatchException e){
                System.out.print("\nInvalid Data type input...");
                input.nextLine();
                return;
            }

            Patient patient = new Patient(name, id , age, gender, phone);
            patients.add(patient);
            System.out.println("\nPatient Created...");
        }

        public static void search(ArrayList<Patient> patients ,Scanner input){
            if(patients.isEmpty()){
                System.out.println("No Patients in Database...");
                return;
            }
            int id = 0;
            try{
                
            System.out.println("\n\n\tSearch Patient");
            System.out.print("Enter Patient ID: ");
             id = input.nextInt();
            input.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Invalid Data type...");
                input.nextLine();
            }

            Patient patient = null;
            for(Patient s:patients){
                if(id == s.getId()){
                    patient = s;
                }
            }
            if(patient == null){
                System.out.println("Patient not Found...");
                return;
            }
            System.out.println("\n---------Patient Info-----------");
            System.out.println("NAME: " + patient.getName());
            System.out.println("ID: "+patient.getId());
            System.out.println("AGE: "+ patient.getAge());
            System.out.println("GENDER: "+ patient.getGender());
            System.out.println("PHONE: "+patient.getPhone());

        }

        public static void DisplayPatients(ArrayList<Patient> patients){
            System.out.println("Patient --- Display");
            if(patients.isEmpty()){
                System.out.println("Database is Empty...");
                return;
            }
            int num = 1;
            for(Patient s:patients){
                System.out.println("\t\t\nPatient " + num);
                System.out.println("\nName- "+ s.getName());
                System.out.println("ID- "+ s.getId());
                System.out.println("Age- " + s.getAge());
                System.out.println("Gender- "+ s.getGender());
                System.out.println("Phone- +260"+ s.getPhone());
                num++;
            }
        }
        public static void delete(ArrayList<Patient> patients ,Scanner input){
            System.out.println("\n\nDelete Patient ");
            if(patients.isEmpty()){
                System.out.println("Database is Empty...");
                return;
            }
            int id = 0;
            try{
            System.out.print("Enter Patient ID to Delete: ");
             id = input.nextInt();
            input.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Invalid Data type...");
                input.nextLine();
            }

            Patient patient = null;
            for(Patient s:patients){
                if(id == s.getId()){
                    patient = s;
                }
            }
            if(patient == null){
                System.out.println("Patient not Found...");
                return;
            }
            patients.remove(patient);
            System.out.println("Patient Deleted...");
        }
        

    }
