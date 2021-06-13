
import java.io.Writer;
import java.util.Scanner;
import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import static java.nio.file.Files.lines;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Catalist {

    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, Exception {

        File inputFile2 = new File("textFiles/inventoryAdd.txt");
        File tempFile2 = new File("myTempFile2.txt");

        boolean loopMain = true;
        boolean loop1 = true;
        boolean purchase = false;
        boolean shipment = false;

        File file2 = new File("textFiles/inventoryAdd.txt");
        File file3 = new File("textFiles/purchaseHold.txt");
        File file4 = new File("textFiles/shipmentHold.txt");
        File file5 = new File("textFiles/recieptRecord.txt");
        File file6 = new File("textFiles/recieptPrint.txt");
        File file7 = new File("textFiles/temporaryTotal.txt");

        Scanner scan2 = new Scanner(file2);
        Scanner scan3 = new Scanner(file3);
        Scanner scan4 = new Scanner(file4);
        Scanner scan6 = new Scanner(file6);
        Scanner scan7 = new Scanner(file7);

        System.out.println("Welcome to the Open Source Inventory ID System");
        System.out.println();

        System.out.println("Would you like to RUN A PURCHASE [1] or SHIPMENT SIDE [2] or EXPLORE THE INVENTORY [3]");
        String mode = wordscan.nextLine();

        if (mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("purchase")) {
            boolean smooth1 = true;
            System.out.println();
            System.out.println("PURCHASE MODE");
            System.out.println();
            BufferedReader br = new BufferedReader(new FileReader(file2));
            File file = new File("textFiles/inventoryAdd.txt");
            Scanner scan = new Scanner(file);
            System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
            System.out.println("               (Kg)   ($)    (Pairs) ");
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            System.out.println();

            System.out.println("Please enter the ID tag (integer) of the item you would like to buy.");
            int n3 = numscan.nextInt();
            String lineSpecific = Files.readAllLines(Paths.get("textFiles/inventoryAdd.txt")).get(n3 - 1);
            try (BufferedReader br8 = new BufferedReader(new FileReader(file2))) {
                String line;
                while ((line = br8.readLine()) != null) {
                    if (lineSpecific.equals(line)) {
                        purchaseMethod(lineSpecific, scan3, scan6, n3, file5, file6, file2, shipment);
                    }
                }
            }

        } else if (mode.equalsIgnoreCase("2") || mode.equalsIgnoreCase("ship")) {

            shipment = true;
            System.out.println();
            System.out.println("SHIPMENT MODE.");
            System.out.println();
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            File file = new File("textFiles/inventoryAdd.txt");
            Scanner scan = new Scanner(file);
            System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
            System.out.println("               (Kg)   ($)    (Pairs) ");
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            System.out.println();
            System.out.println("Please enter the ID tag of the item you would like to ship.");
            int n3 = numscan.nextInt();
            System.out.println();

            String lineSpecific = Files.readAllLines(Paths.get("textFiles/inventoryAdd.txt")).get(n3 - 1);
            try (BufferedReader br4 = new BufferedReader(new FileReader(file2))) {
                String line;
                while ((line = br4.readLine()) != null) {
                    if (lineSpecific.equals(line)) {
                        purchaseMethod(lineSpecific, scan3, scan6, n3, file5, file6, file2, shipment);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e);
            }

        } else if (mode.equalsIgnoreCase("3") || mode.equalsIgnoreCase("explore")) {
            System.out.println();
            System.out.println("EXPLORE MODE");
            System.out.println();
            while (loopMain == true) {
                purchase = false;
                System.out.println("Would you like to SEARCH [Press 1], ADD [Press 2], REMOVE [Press 3], VIEW [Press 4], AMOUNT [Press 5], EXIT [Press 6] from the inventory?");
                System.out.println();
                String ID = wordscan.nextLine();

                if (ID.equalsIgnoreCase("6") || ID.equalsIgnoreCase("exit")) {
                    System.out.println();
                    System.out.println("Thank you for shopping! Please come back another day.");
                    System.out.println();
                    loopMain = false;
                    loop1 = false;
                } else {
                    loop1 = true;
                }

                while (loop1 == true) {
                    //SEARCH
                    if (ID.equalsIgnoreCase("1") || ID.equalsIgnoreCase("SEARCH")) {
                        System.out.println();
                        System.out.println("You have choosen to SEARCH THROUGH THE INVENTORY");
                        System.out.println();
                        BufferedReader br = new BufferedReader(new FileReader(file2));

                        System.out.println("Please enter the ID tag (integer) of the item you would like to find.");
                        int n2 = numscan.nextInt();
                        System.out.println();
                        try {
                            String line = Files.readAllLines(Paths.get("textFiles/inventoryAdd.txt")).get(n2 - 1);
                            searchMethod(line);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                        System.out.println();
                        loop1 = false;
                        //ADD
                    } else if (ID.equalsIgnoreCase("2") || ID.equalsIgnoreCase("ADD")) {
                        System.out.println();
                        System.out.println("You have choosen to ADD ITEMS TO INVENTORY.");
                        System.out.println();
                        File file = new File("textFiles/inventoryAdd.txt");
                        Scanner scan = new Scanner(file);
                        System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
                        System.out.println("               (Kg)   ($)    (Pairs) ");
                        while (scan.hasNextLine()) {
                            System.out.println(scan.nextLine());
                        }
                        System.out.println();
                        System.out.println("How many new items would you like to add to your inventory?");
                        int amountNew = numscan.nextInt();
                        System.out.println();
                        for (int i = 0; i < amountNew; i++) {
                            System.out.println("What is the name of the inventory item you would like to add?");
                            String newItemName = wordscan.nextLine();
                            System.out.println("What is the weight of the inventory item you would like to add in Kg?");
                            String newItemWeight = wordscan.nextLine();
                            System.out.println("What is the price of the inventory item you would like to add in dollars and cents?");
                            String newItemPrice = wordscan.nextLine();
                            System.out.println("What is the total stock of the inventory item?");
                            String newItemAmount = wordscan.nextLine();
                            Writer output2;
                            //Appends
                            output2 = new BufferedWriter(new FileWriter(file2, true));
                            BufferedReader br = new BufferedReader(new FileReader(file2));

                            String lastNum = getLastLine(br);

                            output2.append("[" + newNum(lastNum) + "], " + newItemName + ", " + newItemWeight + ", " + newItemPrice + ", " + newItemAmount + ".0\n");
                            output2.close();
                        }
                        System.out.println();
                        File file00 = new File("textFiles/inventoryAdd.txt");
                        Scanner scan00 = new Scanner(file00);
                        System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
                        System.out.println("               (Kg)   ($)    (Pairs) ");
                        while (scan00.hasNextLine()) {
                            System.out.println(scan00.nextLine());
                        }
                        System.out.println();
                        loop1 = false;

                        //REMOVE    
                    } else if (ID.equalsIgnoreCase("3") || ID.equalsIgnoreCase("REMOVE")) {
                        System.out.println();
                        System.out.println("You have choosen to REMOVE AN ITEM FROM INVENTORY");
                        System.out.println();

                        File file = new File("textFiles/inventoryAdd.txt");
                        Scanner scan = new Scanner(file);
                        System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
                        System.out.println("               (Kg)   ($)    (Pairs) ");
                        while (scan.hasNextLine()) {
                            System.out.println(scan.nextLine());
                        }
                        System.out.println();

                        //Backup
                        String fileContent = "";
                        while (scan2.hasNextLine()) {
                            fileContent = fileContent.concat(scan2.nextLine() + "\n");
                        }
                        FileWriter writer = new FileWriter("textFiles/backupInventory.txt");
                        writer.write(fileContent);
                        writer.close();

                        System.out.println("What is the ID of the item you would like to remove?");
                        int n = numscan.nextInt();
                        System.out.println();
                        try {
                            String line = Files.readAllLines(Paths.get("textFiles/inventoryAdd.txt")).get(n - 1);
                            removeMethod(line, inputFile2, tempFile2);
                        } catch (IOException e) {
                            System.out.println(e);
                        }

                        int lines = 0;
                        BufferedReader reader = new BufferedReader(new FileReader("textFiles/inventoryAdd.txt"));
                        while (reader.readLine() != null) {
                            lines++;
                        }

                        for (int a = 0; a < lines; a++) {
                            String lineSpecific = Files.readAllLines(Paths.get("textFiles/inventoryAdd.txt")).get(a);
                            String[] read = lineSpecific.split(",");
                            String statement = "[" + (a + 1) + "]" + "," + read[1] + "," + read[2] + "," + read[3] + "," + read[4];

                            Writer output3;
                            output3 = new BufferedWriter(new FileWriter("textFiles/temporaryInventory.txt", true));
                            BufferedReader br = new BufferedReader(new FileReader("textFiles/temporaryInventory.txt"));
                            output3.append(statement + "\n");
                            output3.close();
                        }

                        FileWriter fwOb = new FileWriter("textFiles/inventoryAdd.txt", false);
                        PrintWriter pwOb = new PrintWriter(fwOb, false);
                        pwOb.flush();
                        pwOb.close();
                        fwOb.close();

                        // source file
                        File x = new File("textFiles/temporaryInventory.txt");
                        // destination file
                        File y = new File("textFiles/inventoryAdd.txt");

                        copyContent(x, y);

                        FileWriter fwOb2 = new FileWriter("textFiles/temporaryInventory.txt", false);
                        PrintWriter pwOb2 = new PrintWriter(fwOb2, false);
                        pwOb2.flush();
                        pwOb2.close();
                        fwOb2.close();
                        System.out.println();
                        File file00 = new File("textFiles/inventoryAdd.txt");
                        Scanner scan00 = new Scanner(file00);
                        System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
                        System.out.println("               (Kg)   ($)    (Pairs) ");
                        while (scan00.hasNextLine()) {
                            System.out.println(scan00.nextLine());
                        }
                        System.out.println();
                        loop1 = false;

                        //VIEW
                    } else if (ID.equalsIgnoreCase("4") || ID.equalsIgnoreCase("VIEW")) {
                        System.out.println();
                        System.out.println("You have choosen to VIEW INVENTORY");
                        System.out.println();
                        File file = new File("textFiles/inventoryAdd.txt");
                        Scanner scan = new Scanner(file);
                        System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
                        System.out.println("               (Kg)   ($)    (Pairs) ");
                        while (scan.hasNextLine()) {
                            System.out.println(scan.nextLine());
                        }
                        System.out.println();
                        loop1 = false;
                        //TOTAL WORTH
                    } else if (ID.equalsIgnoreCase("5") || ID.equalsIgnoreCase("AMOUNT")) {
                        System.out.println();
                        System.out.println("You have choosen to VIEW INVENTORY WORTH");
                        System.out.println();
                        FileInputStream fstream = new FileInputStream("textFiles/inventoryAdd.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                        String strLine;

                        //counting number of lines in inventoryAdd.txt
                        int lines = 0;
                        BufferedReader reader = new BufferedReader(new FileReader("textFiles/inventoryAdd.txt"));
                        while (reader.readLine() != null) {
                            lines++;
                        }

                        for (int i = 0; i < lines; i++) {
                            String lineSpecific = Files.readAllLines(Paths.get("textFiles/inventoryAdd.txt")).get(i);
                            String[] read = lineSpecific.split(",");
                            double amountInventory = Double.parseDouble(read[4]);
                            double amountPrice = Double.parseDouble(read[3]);
                            double totalInventory = (amountInventory * amountPrice);
                            Writer output5;
                            output5 = new BufferedWriter(new FileWriter(file7, true));
                            output5.append(totalInventory + "\n");
                            output5.close();
                        }

                        System.out.println("Your entire inventory is worth a total of $" + inventoryTotaler(scan7, lines));

                        FileWriter fwOb = new FileWriter("textFiles/temporaryText.txt", false);
                        PrintWriter pwOb = new PrintWriter(fwOb, false);
                        pwOb.flush();
                        pwOb.close();
                        fwOb.close();
                        System.out.println();
                        loop1 = false;

                    } else {
                        System.out.println("Invalid Input. Please try again");
                        System.out.println();
                        loop1 = false;
                        loopMain = false;
                    }
                }//end loop1
            }//end loopMain
        } else {
            System.out.println("Invalid Input. Please try again");
        }

    }//end main

    public static void copyContent(File a, File b) throws Exception {

        FileInputStream in = new FileInputStream(a);
        FileOutputStream out = new FileOutputStream(b);

        try {
            int n;
            // read() function to read the
            // byte of data
            while ((n = in.read()) != -1) {
                // write() function to write
                // the byte of data
                out.write(n);
            }
        } finally {
            if (in != null) {
                // close() function to close the
                // stream
                in.close();
            }
            // close() function to close
            // the stream
            if (out != null) {
                out.close();
            }
        }
    }//end copyContent

    static double inventoryTotaler(Scanner textfile, int count) {
        int i = 0;
        double sum = count;
        while (i < count) {
            double nextInt = textfile.nextDouble();
            sum = sum + nextInt;
            i++;
        }
        return sum;
    }

    static void removeMethod(String line, File inputFile, File tempFile) throws IOException {
        String removeID = line;

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = removeID;
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
        System.out.println(removeID + " has been permanently removed from inventory");
    }//end removeMethod

    static void searchMethod(String line) throws IOException {
        System.out.println(line);
    }//end searchMethod

    static void purchaseMethod(String lineSpecific, Scanner scan3, Scanner scan6, int n3, File file5, File file6, File file2, boolean shipment) throws IOException {
        if (shipment == false) {
            System.out.println("How many would you like to buy?");

            String fileContent = "";
            while (scan3.hasNextLine()) {
                fileContent = fileContent.concat(scan3.nextLine() + "\n");
            }
            FileWriter writer3 = new FileWriter("textFiles/purchaseHold.txt");
            writer3.write(lineSpecific);
            writer3.close();
            String[] read = lineSpecific.split(",");
//            System.out.println(read[0] + "" + read[1] + "" + read[2] + " kg $" + read[3] + " Amount:" + read[4]);

            double amountPurchase = numscan.nextDouble();
            double inventoryMax = Double.parseDouble(read[4]);
            if (inventoryMax <= 0) {
                System.out.println();
                System.out.println("Sorry we do not have stock please come back another day.");
                System.out.println();
            } else if (inventoryMax >= amountPurchase) {

                double priceDouble = Double.parseDouble(read[3]);
                double purchasePrice = priceDouble * amountPurchase;
                String recieptStatement = "You are buying " + amountPurchase + " pairs of" + read[1] + " costing a total of: $" + purchasePrice;
                String purchaseStatement = amountPurchase + " x " + read[1] + " - $" + purchasePrice;
                System.out.println();
                System.out.println(recieptStatement);
                //Appending
                Writer output3;
                output3 = new BufferedWriter(new FileWriter(file5, true));
                BufferedReader br = new BufferedReader(new FileReader(file5));
                output3.append(purchaseStatement + "\n");
                output3.close();
                //Overwriting       
                String fileContent2 = "";
                while (scan6.hasNextLine()) {
                    fileContent2 = fileContent2.concat(scan6.nextLine() + "\n");
                }
                FileWriter writer4 = new FileWriter("textFiles/recieptPrint.txt");
                writer4.write(recieptStatement);
                writer4.close();

                //Permenent inventory amount         
                double currrentAmount = Double.parseDouble(read[4]);
                double inventoryAmount = (currrentAmount - amountPurchase);
                System.out.println("There are " + inventoryAmount + " pairs of" + read[1] + " left.");
                System.out.println();
                String newAmount = String.valueOf(inventoryAmount);
                String file = ("textFiles/inventoryAdd.txt");
                String newLineContent = "[" + n3 + "]," + read[1] + "," + read[2] + "," + read[3] + ", " + newAmount;
                int lineToBeEdited = n3;
                ChangeLineInFile changeFile = new ChangeLineInFile();
                changeFile.changeALineInATextFile(file, newLineContent, lineToBeEdited);
            } else {
                System.out.println();
                System.out.println("Sorry we do not have stock please come back another day.");
                System.out.println();
            }

        } else if (shipment == true) {

            System.out.println("How many would you like to ship?");
            int amountShip = numscan.nextInt();
            System.out.println();
            String fileContent = "";
            while (scan3.hasNextLine()) {
                fileContent = fileContent.concat(scan3.nextLine() + "\n");
            }
            FileWriter writer3 = new FileWriter("textFiles/shipmentHold.txt");
            writer3.write(lineSpecific);
            writer3.close();

            String[] read = lineSpecific.split(",");

            double currentAmount = Double.parseDouble(read[4]);
            double totalShip = currentAmount + amountShip;
            System.out.println("You are shipping " + amountShip + " pairs of" + read[1]);

            //Permenent inventory amount         
            double currrentAmount = Double.parseDouble(read[4]);
            double inventoryAmount = (currrentAmount + amountShip);
            System.out.println("There are " + inventoryAmount + " pairs of" + read[1]);
            String newAmount = String.valueOf(inventoryAmount);
            String file = ("textFiles/inventoryAdd.txt");
            String newLineContent = "[" + n3 + "]," + read[1] + "," + read[2] + "," + read[3] + ", " + newAmount;
            int lineToBeEdited = n3;

            ChangeLineInFile changeFile = new ChangeLineInFile();
            changeFile.changeALineInATextFile(file, newLineContent, lineToBeEdited);

            System.out.println();
            File file00 = new File("textFiles/inventoryAdd.txt");
            Scanner scan00 = new Scanner(file00);
            System.out.println("ID   NAME      WEIGHT PRICE  STOCK");
            System.out.println("               (Kg)   ($)    (Pairs) ");
            while (scan00.hasNextLine()) {
                System.out.println(scan00.nextLine());
            }
            System.out.println();
        }

    }//end purchaseMethod    

    private static String getLastLine(BufferedReader reader) throws IOException {
        String line = null;
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
            line = nextLine;
        }
        return line;
    }//end getLastLine

    private static int newNum(String lastNum) throws IOException {

        FileWriter writer3 = new FileWriter("textFiles/purchaseHold.txt");
        writer3.write(lastNum);
        writer3.close();

        String[] newNum = lastNum.split(",");
        String middleNum = newNum[0];
        String[] midNum = middleNum.split("");
        String finalNum = midNum[1] + midNum[2];
        int ret = Integer.parseInt(finalNum);
        int fin = (ret + 1);
        return fin;

    }//end newNum

    public static class ChangeLineInFile {

        public void changeALineInATextFile(String fileName, String newLine, int lineNumber) {
            String content = new String();
            String editedContent = new String();
            content = readFile(fileName);
            editedContent = editLineInContent(content, newLine, lineNumber);
            writeToFile(fileName, editedContent);

        }

        private static int numberOfLinesInFile(String content) {
            int numberOfLines = 0;
            int index = 0;
            int lastIndex = 0;

            lastIndex = content.length() - 1;
            while (true) {
                if (content.charAt(index) == '\n') {
                    numberOfLines++;
                }
                if (index == lastIndex) {
                    numberOfLines = numberOfLines + 1;
                    break;
                }
                index++;
            }
            return numberOfLines;
        }

        private static String[] turnFileIntoArrayOfStrings(String content, int lines) {
            String[] array = new String[lines];
            int index = 0;
            int tempInt = 0;
            int startIndext = 0;
            int lastIndex = content.length() - 1;

            while (true) {

                if (content.charAt(index) == '\n') {
                    tempInt++;

                    String temp2 = new String();
                    for (int i = 0; i < index - startIndext; i++) {
                        temp2 += content.charAt(startIndext + i);
                    }
                    startIndext = index;
                    array[tempInt - 1] = temp2;

                }

                if (index == lastIndex) {

                    tempInt++;

                    String temp2 = new String();
                    for (int i = 0; i < index - startIndext + 1; i++) {
                        temp2 += content.charAt(startIndext + i);
                    }
                    array[tempInt - 1] = temp2;
                    break;
                }
                index++;
            }

            return array;
        }

        private static String editLineInContent(String content, String newLine, int line) {

            int lineNumber = 0;
            lineNumber = numberOfLinesInFile(content);

            String[] lines = new String[lineNumber];
            lines = turnFileIntoArrayOfStrings(content, lineNumber);

            if (line != 1) {
                lines[line - 1] = "\n" + newLine;
            } else {
                lines[line - 1] = newLine;
            }
            content = new String();

            for (int i = 0; i < lineNumber; i++) {
                content += lines[i];
            }

            return content;
        }

        private static void writeToFile(String file, String content) {

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {
                writer.write(content);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        private static String readFile(String filename) {
            String content = null;
            File file = new File(filename);
            FileReader reader = null;
            try {
                reader = new FileReader(file);
                char[] chars = new char[(int) file.length()];
                reader.read(chars);
                content = new String(chars);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return content;
        }
    }
}//end class
