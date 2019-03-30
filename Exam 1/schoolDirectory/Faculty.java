package schoolDirectory;

import schoolDirectory.Entry;

public class Faculty extends Entry {
    // Faculty have four special fields
    private String office;
    private int extension;
    private String dept;
    private int firstYear;

    public Faculty (String first, String last, String addr, String room,
             int ext, String department, int yr) {
        super(first, last, addr);
        office = room;
        extension = ext;
        dept = department;
        firstYear = yr;
    }

    // toString method to yield nicely formatted output string
    public String toString () {
        return super.toString()
            + "   Office:  " + office+ "\tOffice Extenstion:  " + extension
            + "\n   Department:  " + dept
            + "\n   First Year at Grinnell:  " + firstYear + "\n";
    }

    public static void main (String [] argv) {
        // set up four objects
        Faculty A = new Faculty ("Janet", "Gibson", "gibson@grinnell.edu",
                                 "Science 1610", 3168,
                                 "Psychology", 1989);
        Faculty B = new Faculty ("Henry", "Walker", "walker@cs.grinnell.edu",
                                 "Science 3811", 4208, 
                                 "Computer Science", 1973);
        Faculty C = new Faculty ("John", "Stone", "stone@cs.grinnell.edu",
                                 "Science 3829", 3181,
                                 "Computer Science", 1983);
        Faculty D = new Faculty ("Samuel", "Rebelsky", "rebelsky@cs.grinnell.edu",
                                 "Science 3824", 4410,
                                 "Computer Science", 1997);

        // print objects
        System.out.println();
        System.out.println ("Person A:" + A);
        System.out.println ("Person B:" + B);
        System.out.println ("Person C:" + C);
        System.out.println ("Person D:" + D);

        // since methods equals and comesBefore are inherited, 
        //     testing may or may not be done 

        // check comparisons
        // System.out.println();
        // System.out.println ("Results of equals");
        // System.out.println ("\tA\tB\tC");
        // System.out.println ("A\t"+A.equals(A)+"\t"+A.equals(B)+"\t"+A.equals(C));
        // System.out.println ("B\t"+B.equals(A)+"\t"+B.equals(B)+"\t"+B.equals(C));
        // System.out.println ("C\t"+C.equals(A)+"\t"+C.equals(B)+"\t"+C.equals(C));
         
        // System.out.println ("Results of comesBefore");
        // System.out.println ("\tA\tB\tC");
        // System.out.println ("A\t" + A.comesBefore(A) + "\t"
        //                + A.comesBefore(B) + "\t" + A.comesBefore(C));
        // System.out.println ("B\t" + B.comesBefore(A) + "\t"
        //                + B.comesBefore(B) + "\t"+B.comesBefore(C));
        // System.out.println ("C\t" + C.comesBefore(A) + "\t"
        //                + C.comesBefore(B) + "\t"+C.comesBefore(C));
    }
}