package matthew;
//developer. Matthew devlin

public class Publication {

    private String title; // 3-20 characters in length
    private String publicationID; // 5 numeric value in length
    private String Price; // double value 4 or 5 in length
    private String Quantity; // 1 or 2 numeric value in length
    private String Frequency; // 5-50 in length

    // getters and setters for the variables within this class.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(String publicationID) {
        this.publicationID = publicationID;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String frequency) {
        Frequency = frequency;
    }

    public Publication(String publicationID, String title, String price, String quantity, String frequency) {
        this.title = title;
        this.publicationID = publicationID;
        Price = price;
        Quantity = quantity;
        Frequency = frequency;
    }

    // empty constructor
    public Publication() {

    }

    // method that will check if validate that the title is valid
    public static boolean validateTitle(String title) throws NewsAgentExceptionHandler {
        // Check if title is empty
        if (title.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid title.");
        }

        // Check if title length is within the valid range (3 to 20 characters)
        if (title.length() < 3 || title.length() > 20) {
            throw new NewsAgentExceptionHandler("The title is invalid. Please enter a title between 3 and 20 characters.");
        }

        // Returning true if the title is within the valid range
        return true;
    }

    // method that will check if validate that the publicationID is valid
    public static boolean validatePublicationID(String publicationID) throws NewsAgentExceptionHandler {
        // Check if publicationID is empty
        if (publicationID.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid publicationID.");
        }

        // Try to parse the publicationID as an integer
        try {
            int publicationIDTest = Integer.parseInt(publicationID);

            // Check if the parsed integer is a 5-digit number
            if (publicationIDTest < 10000 || publicationIDTest > 99999) {
                throw new NewsAgentExceptionHandler("The publication ID is invalid. Please enter a correct 5-digit publication ID.");
            }

        } catch (NumberFormatException e) {
            // Handle the case where publicationID is not a valid integer
            throw new NewsAgentExceptionHandler("The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.");
        }

        // Returning true if the publicationID is within the valid ranges
        return publicationID.length() == 5;
    }

    // method that will check if validate that the Price is valid
    public static boolean validatePrice(String price) throws NewsAgentExceptionHandler {
        // Check if Price is empty
        if (price.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid Price.");
        }

        // Try to parse the Price as a double
        try {
            double priceTest = Double.parseDouble(price);

            // Check if the parsed double is in the valid range
            if (priceTest < 1.00 || priceTest > 99.99) {
                throw new NewsAgentExceptionHandler("The Price is invalid. Please enter a correct Price between 1.00 and 99.99.");
            }

        } catch (NumberFormatException e) {
            // Handle the case where Price is not a valid double
            throw new NewsAgentExceptionHandler("The Price is not a valid double. Please enter a correct Price.");
        }

        // Returning true if the Price is within the valid ranges
        return price.length() == 4 || price.length() == 5;
    }

    // method that will check if validate that the Quantity is valid
    public static boolean validateQuantity(String quantity) throws NewsAgentExceptionHandler {
        // Check if Quantity is empty
        if (quantity.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid Quantity.");
        }

        // Try to parse the Quantity as an integer
        try {
            int quantityTest = Integer.parseInt(quantity);

            // Check if the parsed integer is a 1 or 2-digit number
            if (quantityTest < 1 || quantityTest > 99) {
                throw new NewsAgentExceptionHandler("The Quantity is invalid. Please enter a correct Quantity between 1 and 99.");
            }

        } catch (NumberFormatException e) {
            // Handle the case where Quantity is not a valid integer
            throw new NewsAgentExceptionHandler("The Quantity is not a valid integer. Please enter a correct Quantity.");
        }

        // Returning true if the Quantity is within the valid ranges
        return quantity.length() == 1 || quantity.length() == 2;
    }

    // method that will check if validate that the Frequency is valid
    public static boolean validateFrequency(String frequency) throws NewsAgentExceptionHandler {
        // Check if Frequency is empty
        if (frequency.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid Frequency.");
        }

        // Check if Frequency length is within the valid range (5 to 50 characters)
        if (frequency.length() < 5 || frequency.length() > 50) {
            throw new NewsAgentExceptionHandler("The Frequency is invalid. Please enter a Frequency between 5 and 50 characters.");
        }

        // Returning true if the Frequency is within the valid range
        return true;
    }

}
