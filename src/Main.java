import EventRegistrationModule.EventRegistration;
import eventModules.EventCreator;
import eventModules.EventManager;
import eventModules.EventModification;
import eventModules.EventSearchModule;

import java.util.*;


public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        EventManager manager = EventManager.getInstance();

        while(true){

            System.out.println("ÖzDal Event Management System!");
            System.out.println();
            System.out.println();
            System.out.println("1. Create Event");
            System.out.println("2. Modify Event");
            System.out.println("3. Enroll for an Event");
            System.out.println("4. Search Event");
            System.out.println("5. Exit");


            try{
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1:
                        EventCreator creator = manager.getCreator();
                        //Creation operation
                        break;
                    case 2:
                        EventModification modifier = manager.getEventModifier();
                        //Modification operation
                        break;

                    case 3:
                        EventRegistration registrar = manager.getEventRegistrar();
                        //Registration operation
                        break;

                    case 4:
                        EventSearchModule searcher = manager.getEventSearcher();
                        //Search operations
                        break;

                    case 5:
                    scanner.close();
                    return;
                    default:
                        System.out.println("Invalid option, try again.");
                }
            }catch (InputMismatchException e){
                System.out.println("Input must be a number. Try again!");
            }catch(NoSuchElementException e){
                System.out.println("Input cannot be empty. Trey again!");
            }catch(Exception e){
                System.out.println("Something went unexpectedly wrong? Error: ".concat(e.getMessage()));
            }

        }
    }


}