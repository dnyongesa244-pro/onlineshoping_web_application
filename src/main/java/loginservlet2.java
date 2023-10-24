import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class loginservlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("txtname");
            String password = request.getParameter("txtpassword");

            // Define your database connection details
            String jdbcUrl = "jdbc:mysql://localhost:3306/eshoping"; // Change to your database URL
            String dbUsername = "root";
            String dbPassword = "";

            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

                String query = "INSERT INTO customerdatails (Email, Password) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    out.println("Data inserted successfully!");
                } else {
                    out.println("Failed to insert data.");
                }

                conn.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}
