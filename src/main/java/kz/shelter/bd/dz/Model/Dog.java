package kz.shelter.bd.dz.Model;

public class Dog {
    private int id;
    private String nickname;
    private String breed;
    private int age;
    private String owner_name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }


        @Override
        public String toString () {
            return "Имя: " + this.nickname + "; Возраст: " + this.age + "; Порода: " + this.breed + "Имя хозяина: " + this.owner_name;

        }
    }




