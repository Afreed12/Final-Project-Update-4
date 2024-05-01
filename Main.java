import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Date;

public class PersonalFinanceManagerGUI extends Application {

    private Transaction transaction;
    private Budget budget;

    @Override
    public void start(Stage primaryStage) {
        Label lblTransactionID = new Label("Transaction ID:");
        Label lblDate = new Label("Date:");
        Label lblAmount = new Label("Amount:");
        Label lblCategory = new Label("Category:");
        Label lblDescription = new Label("Description:");

        TextField txtTransactionID = new TextField();
        TextField txtDate = new TextField();
        TextField txtAmount = new TextField();
        TextField txtCategory = new TextField();
        TextField txtDescription = new TextField();

        Button btnAddTransaction = new Button("Add Transaction");
        Button btnGenerateReport = new Button("Generate Report");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        gridPane.add(lblTransactionID, 0, 0);
        gridPane.add(txtTransactionID, 1, 0);
        gridPane.add(lblDate, 0, 1);
        gridPane.add(txtDate, 1, 1);
        gridPane.add(lblAmount, 0, 2);
        gridPane.add(txtAmount, 1, 2);
        gridPane.add(lblCategory, 0, 3);
        gridPane.add(txtCategory, 1, 3);
        gridPane.add(lblDescription, 0, 4);
        gridPane.add(txtDescription, 1, 4);
        gridPane.add(btnAddTransaction, 0, 5);
        gridPane.add(btnGenerateReport, 1, 5);

        btnAddTransaction.setOnAction(e -> {
            int transactionID = Integer.parseInt(txtTransactionID.getText());
            Date date = new Date(); 
            double amount = Double.parseDouble(txtAmount.getText());
            String category = txtCategory.getText();
            String description = txtDescription.getText();
            
            transaction = new Transaction(transactionID, date, amount, category, description);
            System.out.println("Transaction added successfully!");
        });

        btnGenerateReport.setOnAction(e -> {
            System.out.println("Report generated successfully!");
            
            budget = new Budget(1, "Groceries", 500.0, new Date(), new Date());
            
            generateReport();
        });

        Scene scene = new Scene(gridPane, 400, 250);

        primaryStage.setTitle("Personal Finance Manager");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void generateReport() {
        System.out.println("Generating report...");
        System.out.println("Transaction ID: " + transaction.getTransactionID());
        System.out.println("Date: " + transaction.getDate());
        System.out.println("Amount: " + transaction.getAmount());
        System.out.println("Category: " + transaction.getCategory());
        System.out.println("Description: " + transaction.getDescription());
        System.out.println("Budget ID: " + budget.getBudgetID());
        System.out.println("Budget Category: " + budget.getCategory());
        System.out.println("Budget Amount: " + budget.getAmount());
        System.out.println("Budget Start Date: " + budget.getStartDate());
        System.out.println("Budget End Date: " + budget.getEndDate());
    }
    public static void main(String[] args) {
        launch(args);
    }
}
