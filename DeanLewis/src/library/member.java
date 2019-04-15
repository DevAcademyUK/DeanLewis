package library;

public class member {

    public int memberID;
    public String memberForename;
    public String memberSurname;
    public byte memberAge;

    public member(int ID, String forename, String surname, byte age){
      memberID = ID;
      memberForename = forename;
      this.memberSurname = surname;
      this.memberAge = age;
    }
}

