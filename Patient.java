class Patient{
    private String name;
    private int id;
    private int age;
    private String gender;
    private int phone;

    Patient(String name, int id, int age, String gender, int phone){
        this.name = name;
        this.age = age;
        this.id = id;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public String getGender(){
        return gender;
    }
    public int getPhone(){
        return phone;
    }
}