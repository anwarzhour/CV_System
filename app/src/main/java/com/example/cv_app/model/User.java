package com.example.cv_app.model;
//model
public class User {
    private String name;
    private String email;
    private String hobbies;
    private String gender;
    private String age;
    private String work;
    private String eduction;
    private String qualifications;
    private String language;
    private String driveLicense;
    private String eductionType;
    // constructor
    public User() {
    }



    // constructor
    public User(String name, String email, String hobbies, String gender, String age) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
        this.gender = gender;
        this.age = age;
    }

    // constructor
    public User(String name, String email, String hobbies, String gender, String age, String driveLicense) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
        this.gender = gender;
        this.age = age;
        this.driveLicense = driveLicense;
    }
    // constructor
    public User(String work, String eduction, String qualifications, String language) {
        this.work = work;
        this.eduction = eduction;
        this.qualifications = qualifications;
        this.language = language;
    }
    // constructor
    public User(String name, String email, String hobbies, String gender, String age, String work, String eduction, String qualifications, String language, String driveLicense) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
        this.gender = gender;
        this.age = age;
        this.work = work;
        this.eduction = eduction;
        this.qualifications = qualifications;
        this.language = language;
        this.driveLicense = driveLicense;
    }
    // constructor
    public User(String name, String email, String hobbies, String gender, String age, String work, String eduction, String qualifications, String language, String driveLicense, String eductionType) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
        this.gender = gender;
        this.age = age;
        this.work = work;
        this.eduction = eduction;
        this.qualifications = qualifications;
        this.language = language;
        this.driveLicense = driveLicense;
        this.eductionType = eductionType;
    }





    public String getEductionType() {
        return eductionType;
    }

    public void setEductionType(String eductionType) {
        this.eductionType = eductionType;
    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense) {
        this.driveLicense = driveLicense;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEduction() {
        return eduction;
    }

    public void setEduction(String eduction) {
        this.eduction = eduction;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
