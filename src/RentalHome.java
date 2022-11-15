import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RentalHome {

    public static void main(String[] args) {
        System.out.println("Select Tool (CHNS, LADW, JAKD, JAKR): ");
        Scanner input = new Scanner(System.in);

        String tool = input.nextLine();
        while (!InputValidator.validateTool(tool)) {
            System.out.println("Not a Valid Tool.");
            System.out.println("Select Tool (CHNS, LADW, JAKD, JAKR): ");
            tool = input.nextLine();
        }

        System.out.println("Select Rental Days: ");
        int rentalDays = Integer.valueOf(input.nextLine());
        while (!InputValidator.validateRentalDays(rentalDays)) {
            System.out.println("Not a Valid Day.");
            System.out.println("Select Rental Days: ");
            rentalDays = Integer.valueOf(input.nextLine());
        }

        System.out.println("Select Discount Rate (0-100): ");
        int discountRate = Integer.valueOf(input.nextLine());
        while (!InputValidator.validateDiscountRate(discountRate)) {
            System.out.println("Discount Rate not in Range (0-100).");
            System.out.println("Select Discount Rate (0-100): ");
            discountRate = Integer.valueOf(input.nextLine());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("Select Checkout Date (mm/dd/yyyy): ");
        LocalDate checkoutDate = LocalDate.parse(input.nextLine(), formatter);

        RentalAgreement agreement = new RentalAgreement(tool, rentalDays,
                discountRate, checkoutDate);

        System.out.println(agreement.generateRentalAgreement());
    }

}
