import java.sql.*;
import java.util.*;


public class MainInterface {
    public static void main(String[] args) {
        printMessage();
        Scanner scanchoice = new Scanner(System.in);
        int choice = 100;

        while (choice != 0) {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT r.room_num AS \"Room Number\", p.name AS \"Patient Name\", pa.timestamp AS \"Admitted Date & Time\"\n" +
                                "FROM ROOM r\n" +
                                "LEFT JOIN patient_admitted pa\n" +
                                "ON r.room_id = pa.room_id\n" +
                                "LEFT JOIN patient p\n" +
                                "ON p.patient_id = pa.patient_id;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 2:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT room_num AS \"Unoccupied Rooms\"\n" +
                                        "FROM room r\n" +
                                        "WHERE r.occupied=0;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) );
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;

                case 3:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT r.room_num AS \"Room Number\", p.name AS \"Patient Name\", pa.timestamp AS \"Admitted Date & Time\"\n" +
                                        "FROM ROOM r\n" +
                                        "LEFT JOIN patient_admitted pa\n" +
                                        "ON r.room_id = pa.room_id AND r.occupied=1\n" +
                                        "LEFT JOIN patient p\n" +
                                        "ON p.patient_id = pa.patient_id;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;

                case 4:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT p.name as \"Patient Name\", e.name as \"Emergency Contact Name\", e.phone_number as \"Emergency Contact Phone\", e.relationship as \"Emergency Contact Relationship\"\n" +
                                        "FROM patient p\n" +
                                        "LEFT JOIN Emergency_Contact e\n" +
                                        "ON p.emergency_contact_id = e.emergency_contact_id;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getLong(3) + " | " + rs.getString(4));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;

                case 5:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT p.name as \"Currently Admitted Patient Name\", p.patient_id as \"Patient ID\"\n" +
                                        "FROM ROOM r\n" +
                                        "INNER JOIN patient_admitted pa\n" +
                                        "ON r.room_id = pa.room_id AND r.occupied=1\n" +
                                        "LEFT JOIN patient p\n" +
                                        "ON p.patient_id = pa.patient_id;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getString(1) + " | " + rs.getInt(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 6:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT p.patient_id AS \"Patient ID\", p.name AS \"Patient Name\"\n" +
                                        "FROM Patient_Discharged pd\n" +
                                        "LEFT JOIN Patient p \n" +
                                        "ON pd.patient_id = p.patient_id\n" +
                                        "-- GIVEN DATE RANGE \n" +
                                        "WHERE pd.timestamp BETWEEN '2022-02-01 00:00:00' AND '2022-10-01 00:00:00';");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 7:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT p.patient_id AS \"Patient ID\", p.name AS \"Patient Name\"\n" +
                                        "FROM Patient_Admitted pd\n" +
                                        "LEFT JOIN Patient p \n" +
                                        "ON pd.patient_id = p.patient_id\n" +
                                        "-- GIVEN DATE RANGE \n" +
                                        "WHERE pd.timestamp BETWEEN '2011-01-01 00:00:00' AND '2015-01-01 00:00:00';");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 8:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        System.out.println("Please enter a patient ID number to search by.");
                        Scanner scan2 = new Scanner(System.in);
                        int searchNum = scan2.nextInt();
                        String query = "SELECT pa.timestamp as \"Admitted Timestamp\", pa.diagnosis as \"Diagnosis\" FROM Patient_Admitted pa WHERE pa.patient_id ="
                                + searchNum + ";";
                        ResultSet rs = stmt.executeQuery
                                (query);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getTimestamp(1) + " | " + rs.getString(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 9:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT * \n" +
                                        "FROM administer_treatment t\n" +
                                        "LEFT JOIN Patient_Admitted pa\n" +
                                        "ON t.admit_id = pa.admit_id\n" +
                                        "WHERE pa.patient_id = 1\n" +
                                        "ORDER BY t.admit_id DESC, t.treatment_id ASC;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getTimestamp(2) + " | " + rs.getInt(3) + " | " + rs.getInt(4)  + " | " + rs.getInt(5) + " | " + rs.getInt(6) + " | " + rs.getInt(7) + " | " + rs.getTimestamp(8) + " | " + rs.getInt(9) + " | " + rs.getInt(10)+ " | " + rs.getString(11) + " | " + rs.getInt(12)+ " | " + rs.getInt(13));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 10:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("Select * FROM \n" +
                                        "(SELECT a.patient_id, p.name, a.diagnosis, a.primary_doctor_id as \"Admitting Doctor\", LAG(d.timestamp, 1) OVER (partition by a.patient_id) AS last_discharge_date, a.timestamp AS Admitted_Timestamp\n" +
                                        " FROM patient_admitted a\n" +
                                        "    LEFT JOIN patient_discharged d ON a.admit_id = d.admit_id\n" +
                                        "    LEFT JOIN patient p ON p.patient_id = a.patient_id\n" +
                                        "    LEFT JOIN primary_doctor pd ON pd.primary_doctor_id = a.primary_doctor_id) table1\n" +
                                        "WHERE TIMESTAMPDIFF(DAY, last_discharge_date, Admitted_Timestamp) < 31 AND TIMESTAMPDIFF(DAY, last_discharge_date, Admitted_Timestamp) >0;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4) +  " | " + rs.getTimestamp(5) +  " | " + rs.getTimestamp(6));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 11:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT t1.patient_id, t1.total_admissions, t1.name, t2.shortest_span, t2.longest_span, t2.average_span_between_admissions, t4.average_duration FROM\n" +
                                        "    -- COUNT\n" +
                                        "    (SELECT p.patient_id, p.name, COUNT(p.patient_id) AS total_admissions FROM patient p \n" +
                                        "    LEFT JOIN patient_admitted a ON a.patient_id = p.patient_id\n" +
                                        "    GROUP BY p.patient_id) t1\n" +
                                        "\n" +
                                        "LEFT JOIN\n" +
                                        "    -- SHORTEST/LONGEST/AVERAGE BETWEEN ADMISSIONS \n" +
                                        "    (SELECT MIN(DATEDIFF(DATE(next_date), DATE(timestamp))) AS shortest_span, \n" +
                                        "    MAX(DATEDIFF(DATE(next_date), DATE(timestamp))) AS longest_span, patient_id, \n" +
                                        "    AVG(DATEDIFF(DATE(next_date), DATE(timestamp))) AS average_span_between_admissions \n" +
                                        "    FROM\n" +
                                        "        (SELECT patient_admitted.*, LEAD(timestamp) OVER (PARTITION BY patient_id ORDER BY timestamp) AS next_date\n" +
                                        "\t\tFROM patient_admitted) a\n" +
                                        "\t\tGROUP BY patient_id) t2\n" +
                                        "ON t1.patient_id = t2.patient_id\n" +
                                        "\n" +
                                        "LEFT JOIN\n" +
                                        "    -- AVERAGE LENGTH OF ADMISSION\n" +
                                        "    (SELECT patient_id, AVG(TIMESTAMPDIFF(DAY, admission_time, discharge_time)) AS average_duration FROM \n" +
                                        "     (SELECT p.patient_id, p.name, a.admit_id, a.timestamp AS admission_time, d.timestamp AS discharge_time FROM patient p\n" +
                                        "    LEFT JOIN patient_admitted a ON a.patient_id = p.patient_id\n" +
                                        "    LEFT JOIN patient_discharged d ON d.admit_id = a.admit_id) t3\n" +
                                        "     GROUP BY patient_id) t4\n" +
                                        "ON t2.patient_id = t4.patient_id;\n");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getString(3) + " | " + rs.getInt(4) +  " | " + rs.getInt(5) +  " | " + rs.getInt(6) +  " | " + rs.getInt(7));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 12:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT pa.diagnosis as \"Diagnosis Name\", count(pa.diagnosis) as \"Times Occured\"\n" +
                                        "FROM Patient_Admitted pa\n" +
                                        "WHERE pa.admit_id NOT IN (SELECT admit_id FROM Patient_Discharged)\n" +
                                        "GROUP BY diagnosis\n" +
                                        "ORDER BY count(diagnosis) DESC;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getString(1) + " | " + rs.getInt(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 13:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT pa.diagnosis as \"Diagnosis Name\", count(pa.diagnosis) as \"Times Occured\"\n" +
                                        "FROM Patient_Admitted pa\n" +
                                        "GROUP BY diagnosis\n" +
                                        "ORDER BY count(diagnosis) DESC;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getString(1) + " | " + rs.getInt(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 14:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT pa.treatment_id as \"Treatment ID\", count(pa.treatment_id) as \"Times Administered\"\n" +
                                        "FROM OrderTreatment pa\n" +
                                        "WHERE pa.admit_id NOT IN (SELECT admit_id FROM Patient_Discharged)\n" +
                                        "GROUP BY treatment_id\n" +
                                        "ORDER BY count(treatment_id) DESC;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getInt(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 15:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT pa.patient_id, count(pa.patient_id), pa.diagnosis\n" +
                                        "FROM Patient_Admitted pa\n" +
                                        "GROUP BY pa.patient_id\n" +
                                        "HAVING count(patient_id) >= 2\n" +
                                        "ORDER BY count(pa.patient_id) desc;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getString(3));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 16:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT pa.name AS \"Patient Name\", o.treatment_id AS \"Treatment ID\", o.doctor_id AS \"Doctor who Ordered Treatment (ID)\"\n" +
                                        "FROM OrderTreatment o\n" +
                                        "LEFT JOIN Patient_Admitted p\n" +
                                        "ON o.admit_id = p.admit_id\n" +
                                        "LEFT JOIN Patient pa\n" +
                                        "ON p.patient_id = pa.patient_id");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getString(1) + " | " + rs.getInt(2) + " | " + rs.getInt(3));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 17:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT *, (case\n" +
                                        "when administrator_id != '' then \"Admin\"\n" +
                                        "when doctor_id != '' then \"Doctor\"\n" +
                                        "when nurse_id != '' then \"Nurse\"\n" +
                                        "when technician_id != '' then \"Technician\"\n" +
                                        "else NULL end) as type from\n" +
                                        "employee e\n" +
                                        "LEFT JOIN doctor d on e.employee_id = d.doctor_id\n" +
                                        "LEFT JOIN nurse n on e.employee_id = n.nurse_id\n" +
                                        "LEFT JOIN technician t on e.employee_id = t.technician_id\n" +
                                        "LEFT JOIN administrator a on e.employee_id = a.administrator_id;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3)  + " | " + rs.getInt(4) + " | " + rs.getInt(5) + " | " + rs.getInt(6) + " | " + rs.getString(7));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 18:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT pa.primary_doctor_id as \"Primary Doctor ID\", count(pa.primary_doctor_id) as \"Admissions this Year\"\n" +
                                        "FROM Patient_Admitted pa\n" +
                                        "WHERE (NOW() - pa.timestamp) < 31536000\n" +
                                        "GROUP BY pa.primary_doctor_id\n" +
                                        "HAVING count(pa.primary_doctor_id) >= 4;");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getInt(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 19:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        System.out.println("Please enter a doctor ID number to search by.");
                        Scanner scan2 = new Scanner(System.in);
                        int searchNum = scan2.nextInt();
                        String query = "SELECT pa.diagnosis as \"Dianosis Given\", pa.diagnosis_id as \"Diagnosis ID\", count(pa.diagnosis_id) as \"Times Diagnosed\" FROM Patient_Admitted pa WHERE pa.primary_doctor_id = "
                                + searchNum + " GROUP BY pa.diagnosis_id ORDER BY count(pa.diagnosis_id) DESC;";
                        ResultSet rs = stmt.executeQuery
                                (query);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getString(1) + " | " + rs.getInt(2)+ " | " + rs.getInt(3));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 20:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        System.out.println("Please enter a doctor ID number to search by.");
                        Scanner scan2 = new Scanner(System.in);
                        int searchNum = scan2.nextInt();
                        String query = "SELECT o.treatment_id as \"Treatment ID\", count(o.treatment_id) as \"Times Ordered\" FROM OrderTreatment o WHERE o.doctor_id = "
                                + searchNum + " GROUP BY o.treatment_id ORDER BY count(o.treatment_id) DESC;";
                        ResultSet rs = stmt.executeQuery
                                (query);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getInt(2));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
                case 21:
                    try {
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", "root", "rootpass");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery
                                ("SELECT pa.administrator_id AS \"Administrator\", pa.primary_doctor_id AS \"Primary Doctor ID\", pt.doctor_id as \"Doctor Involved in Treatment ID\"\n" +
                                        "FROM Patient_Admitted pa\n" +
                                        "LEFT JOIN PerformTreatment pt\n" +
                                        "ON pa.admit_id = pt.admit_id\n" +
                                        "LEFT JOIN Administer_Treatment at \n" +
                                        "ON pa.admit_id = at.admit_id\n" +
                                        "WHERE pa.admit_id NOT IN (SELECT admit_id FROM Patient_Discharged)");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        int j = 1;
                        for (int i = 1; i < columnCount; i++ ) {
                            System.out.print(rsmd.getColumnName(i));
                            System.out.print(" | ");
                            j = i+1;
                        }
                        System.out.print(rsmd.getColumnName(j));
                        System.out.println();
                        while (rs.next())
                            System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getInt(3));
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    printMessage();
                    break;
            }
        }

    }
    public static void printMessage() {
        System.out.println("Select a query to execute!");
        System.out.println("Your options are 1-21");
        System.out.println("Enter 0 to exit the program.");
    }
}

