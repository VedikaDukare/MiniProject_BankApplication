package com.techlabs.servlet;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.model.Customer;
import com.techlabs.model.CustomerDao;

@WebServlet("/AddNewController")
public class AddNewController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDao operator = null;

    public AddNewController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate email parameter
        if (email == null || email.isEmpty()) {
            request.setAttribute("errorMessage", "Email cannot be empty.");
            request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
            return;
        }

        // Validate email format
        if (!isValidEmail(email)) {
            request.setAttribute("errorMessage", "Invalid email format.");
            request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
            return;
        }

        // Validate password strength
        if (!isStrongPassword(password)) {
            request.setAttribute("errorMessage", "Password must be at least 8 characters long and contain a mix of letters, numbers, and special characters.");
            request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
            return;
        }

        // Create a new Customer object and attempt to add to the database
        Customer customer = new Customer(firstName, lastName, email, password);
        operator = new CustomerDao();
        boolean isAdded = operator.addCustomer(customer);

        // Handle success or failure
        if (isAdded) {
            request.setAttribute("successMessage", "Customer added successfully.");
        } else {
            request.setAttribute("errorMessage", "Failed to add customer. Please try again.");
        }

        // Forward back to the form page with messages
        request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
    }

    // Validate email format
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    // Validate password strength
    private boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
               password.chars().anyMatch(Character::isLowerCase) &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isDigit) &&
               password.chars().anyMatch(ch -> "!@#$%^&*()_+[]{}|;:',.<>?/`~".indexOf(ch) >= 0);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
