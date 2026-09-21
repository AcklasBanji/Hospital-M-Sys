public class Doctor {
    private String name;
    private int id;
    private String specialisation;
    private String gender;
    private int phone;

    Doctor(String name, int id, String specialisation ,String gender, int phone){
        this.name = name;
        this.id = id;
        this.specialisation = specialisation;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getSpecialisation(){
        return specialisation;
    }
    public String getGender(){
        return gender;
    }
    public int getPhone(){
        return phone;
    }

    }

