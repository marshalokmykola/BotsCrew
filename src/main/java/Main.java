import services.University;
import java.util.Scanner;;

public class Main {
    public static void main(String[] args){
        Scanner command = new Scanner(System.in);
        String description="1 - head of department\n";
        description+="2 - show departments\n";
        description+="3 - average salary of department\n";
        description+="4 - count of employee\n";
        description+="5 - search employee\n";
        description+="Enter command (x - for exit):";
        String input="";
    while (!input.toLowerCase().equals("x")){
        System.out.println(description);
        input=command.nextLine();
        switch (input) {
            case "1":
                System.out.println("Enter department:");
                input = command.nextLine();
                University.showHeadDepartament(input);
                break;
            case "2":
                System.out.println("Enter department:");
                University.showDepartaments();
                break;
            case "3":
                System.out.println("Enter department:");
                input = command.nextLine();
                University.showaAverageSalary(input);
                break;
            case "4":
                System.out.println("Enter department:");
                input = command.nextLine();
                University.showCountEmployee(input);
                break;
            case "5":
                System.out.println("Employee name:");
                input = command.nextLine();
                University.search(input);
                break;
        }
      }
        System.out.println("Exit.");
    }

}
