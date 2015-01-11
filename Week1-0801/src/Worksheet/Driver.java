package Worksheet;

/**
 * Created by liliya on 10/01/2015.
 */
public class Driver {

    public static void main(String[] args) {

        Storage<BankAccount> aStorage = new Storage<>();
        Storage<String> sStorage = new Storage<>();

        // Class baCls = BankAccount.class; //replacing line - 10
        Class<BankAccount> baCls = BankAccount.class;
        try {
            //  Object myAccount = baCls.newInstance(); //replacing this line- 6
            //   BankAccount myAccount = baCls.newInstance();  //replacing this line -7
            BankAccount myAccount = baCls.newInstance();
            aStorage.setValue(myAccount);
            //Deposit

            myAccount.deposit(15);
            System.out.println(myAccount.showBalance());

        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Object not instantiated or illegally accessed");
            e.printStackTrace();
        }

        System.out.println(aStorage.getValue().showBalance());
        if (aStorage.getClass() == sStorage.getClass()) {
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT EQUAL");
        }
    }

    /*1. What are the reasons of using generics here
        Specify the type of the parameters that Storage can take
        no need to define Storage with two different parameter types, the same
        generic implementation is used

    2. What are the benefits

        Compiler can check correctness of the type at compile time and ensure
        no class cast exceptions will occur

    4. Added code snippet

    5. Analysing compiler output for the snipped specified
    Errors: Java incompatible types-object cannot be converted to BankAccount
            Method deposit(int) cannot be found

    The cause of the problem reported is that we are trying to assign Object
    as a member variable of the Storage type object, when it is expecting a
    BankAccount object type.
    Given that myAccount is seen as type Object, and object does not have a method
    deposit(int), this method will not be recognized

    6. Replaced code snippet

    7. How does the change from 6 affect the compilation process? What is the poblem if any

       The issue is that of incompatible types again baCls.newInstance(); returns
       an Object, which we are trying to assign to a bank account
       this is because newInstance is not aware of the type of Object it is creating at compile time

       is myAccount event created to contain anything?

    8. Add explicit dynamic cast

    9. What does the dynamic cast do here?
       Is it the compiler that performs the cast operation or the JVM runtime env
       Is this code safe?

       The dynamic cast casts an Object into a BankAccount type object
       The casting occurs at runtime, so it it done by the JVM and not the compiler
       The casting is inherently not safe as the compiler has not been able to
       check the types and can result in a class cast exception as it relies
       on the programmer to specify the correct type for downcast


    10. Code change

    11. Explain the compiler output? Reason? Errors? What does it say about the role
    of generics

    The compiler now provides the same output as before, and the cast of newInstance
    into BankAccount has become redundant
    Generics allows for the compiler to check the type at compile time and specify that
    balCs is expecting a class object of type BankAccount

    12. Add code snippet

    13. Runtime output is that the two objects are considered equal
        The reason for this output is that all generic type information is erased
        when the generics using code is compiled, so Storage<String> and Storage<BankAccount>
        refer to the same Class object which is used to create the Storage objects

     */
}
