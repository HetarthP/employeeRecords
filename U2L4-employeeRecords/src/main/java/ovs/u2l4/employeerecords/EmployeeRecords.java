
//Name: Hetarth Parikh
//Unit,Lesson,Name of Assignment: Unit 2 Lesson 4, employee Records Assignment
//Date of Completion: September 30th 2024
//Description: this is a program where a user enters different information as an
//employee. The user can then see all their info added in a list and can also 
//find different employees through the list by simply using the find employee feature
//on the bottom as well and sort them alphabetically by first name




package ovs.u2l4.employeerecords;


import javax.swing.*; // For JFrame, JButton, JTextArea, JOptionPane, etc.
import java.awt.*; // For layout managers and other components basically
import java.awt.event.*; // For event handling (ActionListener, etc.)
import java.util.ArrayList; // For using ArrayLists
import javax.swing.event.DocumentEvent;//This is for document event handling
import javax.swing.event.DocumentListener;//to listen to changes in the text field
import javax.swing.border.LineBorder;//to change the border of different parts
import java.time.Year;//to perform date validations and get current year
import javax.swing.JOptionPane;//to show the user message windows 
import java.util.Collections;//For any collections in the program
import java.util.Comparator;//to compare objects based on any criteria
import java.awt.event.WindowAdapter;//to handle window events in this case the X
import java.awt.event.WindowEvent;//to capture any window events such as opening etc.

//This is a class representing an employee with different attributes as listed
 class Employee {
    String id;
    String name;
    String lastName;
    String salary;
    String date;
//This is basically the constructor to initialize the employee object with 
//the given values is what its doing
    public Employee(String id, String name, String lastName, String salary, String date) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.date = date;
        
    }
    //This function is just to keep track of the ID of the employee the user inputs
    //it will be useful for a function later to make sure the user doesnt enter the
    //same employee id for two different people
    public String getId() {
        return id; // returns the ID of the employee
    }
}
    
/**
 *
 * @author user
 */
public class EmployeeRecords extends javax.swing.JFrame {
    private ArrayList<Employee> employeeRecords = new ArrayList<>();
    
    /**
     * Creates new form EmployeeRecords
     */
    public EmployeeRecords() {
        initComponents();
        addInputValidation();
         setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        // Add a WindowListener to handle the close event if a user accidnetally clicks the X 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //This will just show the confirmation dialog when user clicks the 'X'
                int response = JOptionPane.showConfirmDialog(
                        EmployeeRecords.this,
                        "Are you sure you want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                // If the user clicks yes, then exit the program
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the program
                }
                // If no, just do nothing and keep the application running the same way
            }
        });
    
        
    }
    //This is a method to find an employee by the ID number
    private Employee findEmployeeById(String id) {
    for (Employee emp : employeeRecords) { //This function basically loops through the list of employees
        if (emp.id.equals(id)) { //This will just compare the IDs 
            return emp; // Return the employee object if found is what its saying
        }
    }
    return null; // Return null if not found
}   //This is for the live input validation which turns it green or red
    private void addInputValidation() {
        //This function here validates the ID field
        textID.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateID();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                validateID();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                validateID();
            }
        });

        //This will validate the first name field
        textName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateFirstName();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                validateFirstName();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                validateFirstName();
            }
        });

        //This just validates the last name field
        textLast.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateLastName();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                validateLastName();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                validateLastName();
            }
        });

        //This will validate the salary field
        textSalary.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateSalary();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                validateSalary();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                validateSalary();
            }
        });

        //Then this will validate the start date field
        textDate.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateStartDate();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                validateStartDate();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                validateStartDate();
            }
        });
    }
    //Now this here will validate the ID input
    private void validateID() {
        String ID = textID.getText();
        if (!ID.matches("\\d*")) { //This just checks for a whole number
            //Then it colors is red if its not a whole number 
            textID.setBorder(new LineBorder(Color.RED, 2));
        } else {
            //makes it green if it is
            textID.setBorder(new LineBorder(Color.GREEN, 2));
        }
    }
    //This validates the first name input
    private void validateFirstName() {
        String firstName = textName.getText();
        if (!firstName.matches("[a-zA-Z]*")) { //checks if its only letters
            //if not then it makes it red
            textName.setBorder(new LineBorder(Color.RED, 2));
        } else {
            //if it is then green
            textName.setBorder(new LineBorder(Color.GREEN, 2));
        }
    }
    //checks the last name input
    private void validateLastName() {
        String lastName = textLast.getText();
        if (!lastName.matches("[a-zA-Z]*")) { //checks if its only letters
            //if not then red
            textLast.setBorder(new LineBorder(Color.RED, 2));
        } else {
            //if it is then green
            textLast.setBorder(new LineBorder(Color.GREEN, 2));
        }
    }
    //checks the salary input
    private void validateSalary() {
        String salary = textSalary.getText();
        if (!salary.matches("\\d*")) { //checks if its only digits
            //if not then red
            textSalary.setBorder(new LineBorder(Color.RED, 2));
        } else {
            //if so then green
            textSalary.setBorder(new LineBorder(Color.GREEN, 2));
        }
    }
    //checks the start date 
    private void validateStartDate() {
        String startDate = textDate.getText().trim(); //this will just trim any extra spaces
    String[] dateParts = startDate.split(" ");//this will split the input string into 
                                              //the parts of the day month and year basically

    // Check if the date is in the correct format (same as before: month, day, and year)
    if (dateParts.length != 3 || //makes sure has those 3 parts only
        !isMonthValid(dateParts[0].toLowerCase()) ||//validates month part and just
                                                    //makes it lowercase
        //then it will just validate the date part
        !isDayValid(dateParts[1].replace(",", "").trim(), dateParts[0].toLowerCase(), dateParts[2]) ||  
        !isYearValid(dateParts[2])) {//this validates the year part
        
        // If invalid,it will set the border to red
        textDate.setBorder(new LineBorder(Color.RED, 2));
        
        
    } else {
        // If valid, set border to green
        textDate.setBorder(new LineBorder(Color.GREEN, 2));
    }
    }
    //method to validate the month properly
    private boolean monthValid(String month) {
        
        return true; // Placeholder
    }
    //method to validate the day properly
    private boolean dayValid(String day) {
        
        return true; // Placeholder
    }
    //method to validate the year properly
    private boolean yearValid(String year) {
        
        return true; // Placeholder
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        textLast = new javax.swing.JTextField();
        textSalary = new javax.swing.JTextField();
        textDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JScrollPane1 = new javax.swing.JScrollPane();
        listThing = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        textResult = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        textNewId = new javax.swing.JTextField();
        btnSort = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Employee Records");

        textID.setBackground(new java.awt.Color(204, 255, 204));

        textName.setBackground(new java.awt.Color(204, 255, 204));

        textLast.setBackground(new java.awt.Color(204, 255, 204));

        textSalary.setBackground(new java.awt.Color(204, 255, 204));

        textDate.setBackground(new java.awt.Color(204, 255, 204));
        textDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDateActionPerformed(evt);
            }
        });

        jLabel2.setText("ID#");

        jLabel3.setText("First Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("Annual Salary");

        jLabel6.setText("Start Date");

        listThing.setEditable(false);
        listThing.setBackground(new java.awt.Color(153, 204, 255));
        listThing.setColumns(20);
        listThing.setRows(5);
        JScrollPane1.setViewportView(listThing);

        jLabel7.setText("To remove an Employee, Enter their ID# and press remove");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Enter ID to find an employee!");

        textResult.setEditable(false);
        textResult.setBackground(new java.awt.Color(153, 204, 255));

        btnCalculate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalculate.setText("Find Employee");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        textNewId.setBackground(new java.awt.Color(153, 204, 255));

        btnSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSort.setText("Sort Employee ");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        jLabel8.setText("E.g. January 30 2024");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textNewId, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalculate)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(textLast)
                                        .addComponent(textSalary)
                                        .addComponent(textDate))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(btnAdd)
                                .addGap(34, 34, 34)
                                .addComponent(btnRemove)
                                .addGap(26, 26, 26)
                                .addComponent(btnList))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(JScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btnSort)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textResult, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd)
                            .addComponent(btnRemove)
                            .addComponent(btnList)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCalculate)
                            .addComponent(textNewId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDateActionPerformed
        // TODO add your handling code here:
        //NA
    }//GEN-LAST:event_textDateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String ID, firstName, lastName, annualSalary, startDate;

            //these functions here just store the textfield values into variables
            ID = textID.getText();
            firstName = textName.getText();
            lastName = textLast.getText();
            annualSalary = textSalary.getText();
            startDate = textDate.getText();
            
            //This here will just chekc for empty fields
            if (ID.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || 
                annualSalary.isEmpty() || startDate.isEmpty()) {
                //if it is, it will show error message to the user
                JOptionPane.showMessageDialog(this, "You must enter all fields before adding. Make sure to also have someone added", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //This part here checks if the ID is already in the list
            for (Employee emp : employeeRecords) {//loops through employees
            if (emp.getId().equals(ID)) {//if it matches, then show user error
            JOptionPane.showMessageDialog(this, "The ID already exists. Please choose a different ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // exits the method if ID is found
            }
            }

            //Then it will validate firstName and lastName to make sure its only letters
            //the char function checks if the character is not a letter and loops through
            //each character
            for (char c : firstName.toCharArray()) {
                if (!Character.isLetter(c)) {
                    //displays error message if any character is not a letter
                    JOptionPane.showMessageDialog(this, "First name must contain only letters.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;//then it exits the method
                }
            }
            //same thing here where it loops through each character in the last name
            for (char c : lastName.toCharArray()) {
                if (!Character.isLetter(c)) {
                    //shows error message if it is not a letter
                    JOptionPane.showMessageDialog(this, "Last name must contain only letters.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;//exits the method after 
                }
            }

            //Now this will validate the ID to make sure its only a whole number
            if (!ID.matches("\\d+")) {
                //if not, shows user error message
                JOptionPane.showMessageDialog(this, "ID must be a whole number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //this will just validate the annualSalary to make sure its only digits
            for (char c : annualSalary.toCharArray()) {
                if (!Character.isDigit(c)) {
                    //if not, it will show an error to the user
                    JOptionPane.showMessageDialog(this, "Annual salary must contain only digits.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            //this will validate the startDate (Month and then Day and then Year format)
            //this will split the input start date into parts based on the spaces is
            //what its doing
            String[] dateParts = startDate.split(" ");
            //then it will check if the dateparts array we added contains only the
            //elements we need which is the month day and year            
            if (dateParts.length != 3 || 
                 //this will then validate the month by converting it to lowercase and
                 //just checking if its valid or not
                !isMonthValid(dateParts[0].toLowerCase()) ||  
                 //this then validates the day using the day validation method
                 //by just passing the day and month and year                    
                !isDayValid(dateParts[1], dateParts[0].toLowerCase(), dateParts[2]) ||
                 //then this validates the year using year validation method
                !isYearValid(dateParts[2])) {
                //then it will show the user an error if the requirements were not there
                //when they were entering it in
                JOptionPane.showMessageDialog(this, "Start date must be in the format 'Month, Day, Year' with valid values (check month day or year input again) (e.g., January 23 2024).", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;//it then exits the method
            }

            //Now if all validations pass,it will then create the Employee object
            Employee c = new Employee(ID, firstName, lastName, annualSalary, startDate);
            //this then adds the employee object to the employee records list
            //it also stores the object in the records
            employeeRecords.add(c);

            // Clear textboxes after adding to the list basically
            textID.setText("");
            textName.setText("");
            textLast.setText("");
            textSalary.setText("");
            textDate.setText("");
            //This calls on the reset border method to reset the text fields colors
            resetBorders();
        }
       

        //this is the method to basically validate the month when your adding
        //an employee
        private boolean isMonthValid(String month) {
        //we will make an array of the valid month names
    String[] months = {"january", "february", "march", "april", "may", "june", 
                       "july", "august", "september", "october", "november", "december"};
    //then loop through each month in the array
    for (String m : months) {
        //this will check if the month the user inputted matches any of the months
        //we said in the array 
        if (m.equals(month.toLowerCase())) {
            return true;//this means a valid month is found 
        }
    }
    return false;//this means it wasnt
}

//this is the method to validate the day while adding employees
private boolean isDayValid(String dayStr, String month, String yearStr) {
    int day;//this is to just hold the parsed day 
    try {
        day = Integer.parseInt(dayStr.replace(",", ""));//This remove the comma and convert to int basically
    } catch (NumberFormatException e) {
        return false;  // this is if its not a valid number
    }
    //this is the vairable to hold the parsed year 
    int year; 
    try {
        year = Integer.parseInt(yearStr);//converts the string to an integer
    } catch (NumberFormatException e) {
        return false;  // this is if its not a valid number for the year
    }

    //the variable to hold the max days in each month
    int maxDays = 31;
    switch (month) {
        case "february"://this is to see if its a leap year or not by adjusting
                        //the months days for feb 
            if (isLeapYear(year)) {
                maxDays = 29;  // Leap year cause 29 days 
            } else {
                maxDays = 28;  // Non-leap year days have 28 
            }
            break;
        case "april":
        case "june":
        case "september":
        case "november":
            maxDays = 30;  // These months have 30 days is what its saying
            break;
    }
    //this essentially checks if the day is within the valid range for the 
    //month basically
    return day >= 1 && day <= maxDays;
}

// this is the method to validate the year
private boolean isYearValid(String yearStr) {
    int year;//this holds the parsed year
    try {
        year = Integer.parseInt(yearStr);//converts the string to an integer
    } catch (NumberFormatException e) {
        return false;  // Not a valid number of the year
    }
    //this function basically updates the program by using the current year
    int currentYear = Year.now().getValue(); 
    return year >= 1500 && year <= currentYear;//this is setting the valid ranges
}

// this is the method to check if a year is a leap year
private boolean isLeapYear(int year) {
    // Leap year logic: divisible by 4, but not by 100 unless also by 400 basically
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}
//This is the method to reset the borders of the text fields 
private void resetBorders() {
    //so using these commands it'll reset each of the textboxes
    //the setborder calls on a specific text field like the ones we're using
    //the other commands such as the UI and getlookandfeel and defaults and border
    //are used to retrieve basically the default border for the text fields and this is
    //from the UI manager. This just makes sure that the text boxes where the users
    //typing has a normal border after they successfully add an employee
    textID.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
    textName.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
    textLast.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
    textSalary.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
    textDate.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));

        
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
      String idToRemove = textID.getText(); // Get ID from the same text field

// Check if the list is empty first
if (employeeRecords.isEmpty()) {
    //if it is then show an error to the user
    JOptionPane.showMessageDialog(this, "Nothing to remove; the list is already empty.", "Removal Error", JOptionPane.ERROR_MESSAGE);
} else {
    boolean found = false;//this is just a flag to make sure if the employee
                          //was found or not

    //This will just iterate through employeeRecords to find the employee with the ID
    for (int i = 0; i < employeeRecords.size(); i++) {
        //this checks if the current employee id matches the id to remove
        if (employeeRecords.get(i).id.equals(idToRemove)) {
            employeeRecords.remove(i); // Remove employee if ID matches
            found = true;
            break; // Exit the loop once the employee is found and removed is what
                   //its doing
        }
    }

    //this will just update the display based on whether the employee was found and removed
    if (found) {
        //shows the user the message saying its all good
        JOptionPane.showMessageDialog(this, "Employee removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        //otherwise an error saying that it was not found  
        JOptionPane.showMessageDialog(this, "Employee not found with ID: " + idToRemove, "Removal Error", JOptionPane.ERROR_MESSAGE);
    }
}

//This will clear the ID input field
textID.setText("");
textResult.setText("");
textNewId.setText("");

//just refreshes the list display
displayEmployeeList();  
    
    }//GEN-LAST:event_btnRemoveActionPerformed
    private void displayEmployeeList() {
    StringBuilder list = new StringBuilder();//this makes a string builder to build
                                             //the employee list string
    //then it'll loop and iterate through each object in the records list
    for (Employee emp : employeeRecords) {
        //the rest of it is just appending the details to the string builder
        list.append("ID: ").append(emp.id)
            .append(", Name: ").append(emp.name).append(" ").append(emp.lastName)
            .append(", Salary: ").append(emp.salary)
            .append(", Start Date: ").append(emp.date).append("\n");
    }
    //this will then set the text of the listthing area to the constructed string basically
    listThing.setText(list.toString());
}
    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
        // Check if the list is empty
        //If the list contains records, it loops through the list and concatenates 
        //the employee details into the variable valid (this can be anything I just chose valid)
        String valid = "";
        if (employeeRecords.isEmpty()) {
            valid = "The list is empty.";
            listThing.setText(valid); // Display the empty message

            // Create a timer to clear the message after 3 seconds (3000 milliseconds)
            new Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listThing.setText(""); //This just clears the message
                    ((Timer)e.getSource()).stop(); //This function here stops the timer
                }
            }).start(); //this just starts the timer
        } else {
            //Then it will loop through the employee records and build the display string
            for (int x = 0; x < employeeRecords.size(); x++) {
                valid += employeeRecords.get(x).id + " "
                        + employeeRecords.get(x).name + " "
                        + employeeRecords.get(x).lastName + " "
                        + employeeRecords.get(x).salary + " "
                        + employeeRecords.get(x).date + "\n";
            }
            listThing.setText(valid); //This will then just update the list
        }
    }//GEN-LAST:event_btnListActionPerformed
    
    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
          String id = textNewId.getText().trim(); // Get the ID from the text field

// This function just checks if the ID field is empty
if (id.isEmpty()) {
    // If it is, then shows an error
    textNewId.setBorder(BorderFactory.createLineBorder(Color.RED, 2)); // Set red border
    JOptionPane.showMessageDialog(this, "Please enter an ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
    return; // Then exits the method
}

// Now check if the input is a valid integer
try {
    Integer.parseInt(id); //This will basically just parse the input as an integer
    textNewId.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1)); //this turns the border green if valid
} catch (NumberFormatException e) {
    // If it's not a valid integer, set the border to red and show an error message
    textNewId.setBorder(BorderFactory.createLineBorder(Color.RED, 2)); // Set red border
    JOptionPane.showMessageDialog(this, "Please enter a valid whole number (integer).", "Input Error", JOptionPane.ERROR_MESSAGE);
    return; //Then exits the method
}

// This will find the employee with the given ID basically 
// Loops through each employee in the list
for (Employee employee : employeeRecords) {
    if (employee.id.equals(id)) { // This uses the employee.id to check 
        // Then it will display the employee's name in the result field
        textResult.setText("Employee Name: " + employee.name + " " + employee.lastName);
        return; // Exit the method after finding the employee
    }
}

// If no employee was found, then show the user this message
JOptionPane.showMessageDialog(this, "No employee found with the given ID.", "Input Error", JOptionPane.ERROR_MESSAGE);  

    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:
        // Check if the employeeRecords list is empty
    if (employeeRecords.isEmpty()) {
        // Show a message to the user if the list is empty saying its empty so 
        //nothing can really be sorted out
        JOptionPane.showMessageDialog(this, "Nothing to sort since the list is empty.", "Info", JOptionPane.INFORMATION_MESSAGE);
        return; //exit the method
    }

    //This calls upon the sorting method under this
    sortEmployeeRecordsByName();

    //This just refreshes the display to show the sorted list out again 
    displayEmployeeList(); 
    }//GEN-LAST:event_btnSortActionPerformed
   //This is the method for sorting the employees alphabetically by first name
    private void sortEmployeeRecordsByName() {
    //the collections here is a utility class in the java collections framework
    //basically it gives you methods for working with collections such as lists
    //in this case. The sort then sorts it into an ascending order which in this 
    //case, the employee records list will be sorted based on the comparator defined
    //within the method to sort it by first name of the employee in the list.
    Collections.sort(employeeRecords, new Comparator<Employee>() {
        @Override
        public int compare(Employee emp1, Employee emp2) {//compares two employee objects
                                                          
            return emp1.name.compareToIgnoreCase(emp2.name); //This will just sort it by first name
        }
    });
}


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea listThing;
    private javax.swing.JTextField textDate;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textLast;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textNewId;
    private javax.swing.JTextField textResult;
    private javax.swing.JTextField textSalary;
    // End of variables declaration//GEN-END:variables
}
