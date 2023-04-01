// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e){

        if (tr.contains(e)) {
            System.out.println("Duplicate entry found");
        }
        else {
            tr.add(e);
        }

    } // addClass

    // look up the entry of a given day and month
    public String lookupEntry (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        while (iter.hasNext()) {// is used to iterate over the list of Entry objects represented by tr
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                result = current.getEntry();
        }
        return result;// returning
    } // lookupEntry

    public String lookupEntries(int d, int m, int y) {
        List<String> entries = new ArrayList<>();
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                entries.add(current.getEntry());
            }
        }
        if (entries.isEmpty()) {//the matching entries are concatenated into a string separated by newline characters using the String.join() method, and this string is returned
            return "No entries found";//If no matching entries are found, the method will return the string "No entries found".
        } else {
            return String.join("\n", entries);//
        }
    }
    public void removeEntry(String n, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        boolean removed = false;
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                iter.remove();
                System.out.println("Record removed");
                removed = true;// if the statement is true
                break;
            }
        }
        if (!removed) {
            System.out.println("Record not found");// if no record found then print
        }
    }


    // Count the number of entries
    public int getNumberOfEntries(){
        return tr.size();
    }
    // Clear all entries
    public void clearAllEntries(){
        tr.clear();
    }

} // TrainingRecord