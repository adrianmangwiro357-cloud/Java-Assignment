class AgeValidationExeption extends Exception{
    public AgeValidationExeption(String message){
        super(message);
    }
}
class VoterRegistration{
    public void Voter(int age)throws AgeValidationExeption{
        if (age<18) {
            throw new AgeValidationExeption("voter must be 18 years old. Provided age: "+ age);
        }
            System.out.println("voter registration successful for age: "+ age);
    }
}
public class exceptionExample {
    public static void main(String[] args) {
        VoterRegistration registration = new VoterRegistration();
        try {
            registration.Voter(16);
        } catch (AgeValidationExeption e){
            System.out.println("registration failed: "+ e.getMessage());
        }
        try {
            registration.Voter(23);
        } catch (AgeValidationExeption e) {
            System.out.println("registration failed: "+ e.getMessage());
        }
    }

}
