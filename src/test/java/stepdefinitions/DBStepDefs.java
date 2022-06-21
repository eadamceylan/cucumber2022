package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.sql.SQLException;

public class DBStepDefs {


    @Given("user connects to the database")
    public void user_connects_to_the_database() {

        DBUtils.createConnection();

    }

    @Given("user gets the {string} from {string} table")
    public void user_gets_the_from_table(String column, String table) {
//                      select            from tp_customer
        String query = "Select "+column+" from "+table;
    // execute the query. we are customer
        DBUtils.executeQuery(query);
    }

    @Given("user reads all of the {string} column data")
    public void user_reads_all_of_the_column_data(String column) throws SQLException {
        // go to the next row
        DBUtils.getResultset().next();
        //We are currently on the 1st row
        Object columnData1 = DBUtils.getResultset().getObject(column);
        System.out.println(columnData1);
        // go to the next row
        DBUtils.getResultset().next();
        Object columnData2 = DBUtils.getResultset().getObject(column);
        System.out.println(columnData2);

        // iterate the ssn column
        while (DBUtils.getResultset().next()){
            // keep going to the next line if there is a data in the next line
            Object nextColumnData = DBUtils.getResultset().getObject(column);
            System.out.println(nextColumnData);

        }
    }

    @Then("close the database connection")
    public void close_the_database_connection() {
        DBUtils.closeConnection();
    }



}
