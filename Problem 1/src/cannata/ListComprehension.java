package cannata;

import java.util.*;

public class ListComprehension {
    public static void main(String[] args) {

        ArrayList<List<Object>> emp = new ArrayList<List<Object>>();
        List<Object> e2 = Arrays.asList(1, "Martin", "Carmen", "martincu", "3-Mar-90", "President", 4500, "", 50, 2);
        List<Object> e3 = Arrays.asList(10, "Jackson", "Marta", "jacksomt", "27-Feb-91", "Warehouse Manager", 1507, "", 45, 2);
        List<Object> e4 = Arrays.asList(11, "Henderson", "Colin", "hendersc", "14-May-90", "Sales Representative", 1400, 10, 31, 3);
        List<Object> e5 = Arrays.asList(12, "Gilson", "Sam", "gilsonsj", "18-Jan-92", "Sales Representative", 1490, 12.5, 32, 3);
        List<Object> e6 = Arrays.asList(13, "Sanders", "Jason", "sanderjk", "18-Feb-91", "Sales Representative", 1515, 10, 33, 3);
        List<Object> e7 = Arrays.asList(14, "Dameron", "Andre", "dameroap", "9-Oct-91", "Sales Representative", 1450, 17.5, 35, 3);
        List<Object> e8 = Arrays.asList(15, "Hardwick", "Elaine", "hardwiem", "7-Feb-92", "Stock Clerk", 1400, "", 41, 6);
        List<Object> e9 = Arrays.asList(16, "Brown", "George", "browngw", "8-Mar-90", "Stock Clerk", 940, "", 41, 6);
        List<Object> e10 = Arrays.asList(17, "Washington", "Thomas", "washintl", "9-Feb-91", "Stock Clerk", 1200, "", 42, 7);
        List<Object> e11 = Arrays.asList(18, "Patterson", "Donald", "patterdv", "6-Aug-91", "Stock Clerk", 795, "", 42, 7);
        List<Object> e12 = Arrays.asList(19, "Bell", "Alexander", "bellag", "26-May-91", "Stock Clerk", 850, "", 43, 8);
        List<Object> e13 = Arrays.asList(2, "Smith", "Doris", "smithdj", "8-Mar-90", "VP, Operations", 2450, "", 41, 1);
        List<Object> e14 = Arrays.asList(20, "Gantos", "Eddie", "gantosej", "30-Nov-90", "Stock Clerk", 800, "", 44, 9);
        List<Object> e15 = Arrays.asList(21, "Stephenson", "Blaine", "stephebs", "17-Mar-91", "Stock Clerk", 860, "", 45, 10);
        List<Object> e16 = Arrays.asList(22, "Chester", "Eddie", "chesteek", "30-Nov-90", "Stock Clerk", 800, "", 44, 9);
        List<Object> e17 = Arrays.asList(23, "Pearl", "Roger", "pearlrg", "17-Oct-90", "Stock Clerk", 795, "", 42, 7);
        List<Object> e18 = Arrays.asList(24, "Dancer", "Bonnie", "dancerbw", "17-Mar-91", "Stock Clerk", 860, "", 45, 7);
        List<Object> e19 = Arrays.asList(25, "Schmitt", "Sandra", "schmitss", "9-May-91", "Stock Clerk", 1100, "", 45, 8);
        List<Object> e20 = Arrays.asList(3, "Norton", "Michael", "nortonma", "17-Jun-91", "VP, Sales", 2400, "", 1, 1);
        List<Object> e21 = Arrays.asList(4, "Quentin", "Mark", "quentiml", "7-Apr-90", "VP, Finance", 2450, "", 10, 1);
        List<Object> e22 = Arrays.asList(5, "Roper", "Joseph", "roperjm", "4-Mar-90", "VP, Administration", 2550, "", 50, 1);
        List<Object> e23 = Arrays.asList(6, "Brown", "Molly", "brownmr", "18-Jan-91", "Warehouse Manager", 1600, "", 41, 2);
        List<Object> e24 = Arrays.asList(7, "Hawkins", "Roberta", "hawkinrt", "14-May-90", "Warehouse Manager", 1650, "", 42, 2);
        List<Object> e25 = Arrays.asList(8, "Burns", "Ben", "burnsba", "7-Apr-90", "Warehouse Manager", 1500, "", 43, 2);
        List<Object> e26 = Arrays.asList(9, "Catskill", "Antoinette", "catskiaw", "9-Feb-92", "Warehouse Manager", 1700, "", 44, 2);
        emp.add(e2);
        emp.add(e3);
        emp.add(e4);
        emp.add(e5);
        emp.add(e6);
        emp.add(e7);
        emp.add(e8);
        emp.add(e9);
        emp.add(e10);
        emp.add(e11);
        emp.add(e12);
        emp.add(e13);
        emp.add(e14);
        emp.add(e15);
        emp.add(e16);
        emp.add(e17);
        emp.add(e18);
        emp.add(e19);
        emp.add(e20);
        emp.add(e21);
        emp.add(e22);
        emp.add(e23);
        emp.add(e24);
        emp.add(e25);
        emp.add(e26);

        System.out.println("Select * from emp: ");
        System.out.println();
        emp.stream()
                .forEach(e -> {
                    System.out.println(e); //Print all elements in the list
                });

        System.out.println();
        System.out.println("Select last name, first name, title, salary from emp: ");
        System.out.println();
        emp.stream()
                .forEach(e -> {
                    System.out.print(Arrays.asList(e.get(1) + ", " + e.get(2) + ", " + e.get(5) + ", " + e.get(6)) + "\n"); //Only print last name, first name, title, and salary
                });

        System.out.println();
        System.out.println("Select last name, first name, title, salary where salary > 1500 and dept id > 40: ");
        System.out.println();
        emp.stream()
                .filter(e ->
                        (Integer) e.get(6) > 1500 && (Integer) e.get(8) > 40)//Filter objects with salary greater than 1500 and dept id greater than 40
                .forEach(e -> {
                    System.out.print(Arrays.asList(e.get(1) + ", " + e.get(2) + ", " + e.get(5) + ", " + e.get(6)) + "\n"); //Print last name, first name, title, and salary elements as a list that have been filtered by above operation
                });

        System.out.println();
        System.out.println("Select last name, first name, title, salary where salary > 1500 and dept id > 40 order by last name: ");
        System.out.println();
        emp.stream()
                .filter(e ->
                        (Integer) e.get(6) > 1500 && (Integer) e.get(8) > 40)//Filter objects with salary greater than 1500 and dept id greater than 40
                .sorted((e, e1) -> (((String) e.get(1)).compareTo((String) e1.get(1)))) //Sort by last name
                .map(e -> Arrays.asList(e.get(1) + ", " + e.get(2) + ", " + e.get(5) + ", " + e.get(6)) + "\n")//Turn list into only last name, first name, title, and salary
                .forEach(e -> {
                    System.out.print(e); //Print list after applying the above operations
                });

        System.out.println();
        System.out.println("Select last name, first name, title, salary where salary > 1500 and dept id > 40 order by salary desc: ");
        System.out.println();
        emp.stream()
                .filter(e ->
                        (Integer) e.get(6) > 1500 && (Integer) e.get(8) > 40) //Filter only objects that have salary greater than 1500 and dept id greater than 40
                .sorted((e, e1) -> Integer.compare((Integer)e1.get(6), (Integer)e.get(6))) //Order list by salary descending
                .map(e -> Arrays.asList(e.get(1) + ", " + e.get(2) + ", " + e.get(5) + ", " + e.get(6)) + "\n")//Turn list into only last name, first name, salary, and title
                .forEach(e -> {
                    System.out.print(e); //Print each element after applying the above operations
                });


    }


}