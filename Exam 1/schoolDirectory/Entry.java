package schoolDirectory;

public class Entry {
    // a generic entry in a directory
    // use "protected" here, so variables may be accessed in subclasses
    protected String firstName;
    protected String lastName;
    protected String eMail;

    public Entry () {
        firstName = "";
        lastName = "";
        eMail = "";
    }
    
    public String getFirstName() {
    	return firstName;
    }

    public Entry (String first, 
    		String last, String eAddress) {
        firstName = first;
        lastName = last;
        eMail = eAddress;
    }

    // equals method for two strings
    public boolean equals (String first, String second) {
        return (firstName.equals(first)
                && lastName.equals(second));
    }

    // equals method for another Entry
    public boolean equals (Entry otherEntry) {
        return (firstName.equals(otherEntry.firstName)
                && lastName.equals(otherEntry.lastName));
    }

    // comesBefore method for two strings
    public boolean comesBefore (String first, String second) {
        if (lastName.equals(second))
            return firstName.compareTo(first) < 0;
        else return lastName.compareTo(second) < 0;
    }

    // comesBefore method for another Entry
    public boolean comesBefore (Entry otherEntry) {
        if (lastName.equals(otherEntry.lastName))
            return firstName.compareTo(otherEntry.firstName) < 0;
        else return lastName.compareTo(otherEntry.lastName) < 0;
    }

    // toString method to yield nicely formatted output string
    public String toString () {
        return "\nName:  " + firstName + " " + lastName
            + "\n   E-mail Address:  " + eMail + "\n";

    }

    public static void main (String [] argv) {
        // set up three objects
        Entry A = new Entry ("Terry", "Walker", "walkert@math.grin.edu");
        Entry B = new Entry ("Henry", "Walker", "walker@cs.grinnell.edu");
        Entry C = new Entry ("Barbara", "Walker", "barbara@cs.grin.edu");

        // print objects
        System.out.println();
        System.out.println ("Person A:" + A);
        System.out.println ("Person B:" + B);
        System.out.println ("Person C:" + C);

        // check comparisons
        System.out.println();
        System.out.println ("Results of equals for entries");
        System.out.println ("\tA\tB\tC");
        System.out.println ("A\t"+A.equals(A)+"\t"+A.equals(B)+"\t"+A.equals(C));
        System.out.println ("B\t"+B.equals(A)+"\t"+B.equals(B)+"\t"+B.equals(C));
        System.out.println ("C\t"+C.equals(A)+"\t"+C.equals(B)+"\t"+C.equals(C));

        System.out.println();
        System.out.println ("Results of equals for two strings");
        System.out.println ("\tA\tB\tC");
        System.out.println ("A\t" + A.equals("Terry", "Walker") + "\t"
                       + A.equals("Henry", "Walker") + "\t"
                       + A.equals("Barbara", "Walker"));
        System.out.println ("B\t" + B.equals("Terry", "Walker") + "\t"
                       + B.equals("Henry", "Walker") + "\t"
                       + B.equals("Barbara", "Walker"));
        System.out.println ("C\t" + C.equals("Terry", "Walker") + "\t"
                       + C.equals("Henry", "Walker") + "\t"
                       + C.equals("Barbara", "Walker"));

        System.out.println();
        System.out.println ("Results of comesBefore for entries");
        System.out.println ("\tA\tB\tC");
        System.out.println ("A\t" + A.comesBefore(A) + "\t"
                       + A.comesBefore(B) + "\t" + A.comesBefore(C));
        System.out.println ("B\t" + B.comesBefore(A) + "\t"
                       + B.comesBefore(B) + "\t"+B.comesBefore(C));
        System.out.println ("C\t" + C.comesBefore(A) + "\t"
                       + C.comesBefore(B) + "\t"+C.comesBefore(C));

        System.out.println();
        System.out.println ("Results of comesBefore for two strings");
        System.out.println ("\tA\tB\tC");
        System.out.println ("A\t" + A.comesBefore("Terry", "Walker") + "\t"
                       + A.comesBefore("Henry", "Walker") + "\t" 
                       + A.comesBefore("Barbara", "Walker"));
        System.out.println ("B\t" + B.comesBefore("Terry", "Walker") + "\t"
                       + B.comesBefore("Henry", "Walker") + "\t"
                       + B.comesBefore("Barbara", "Walker"));
        System.out.println ("C\t" + C.comesBefore("Terry", "Walker") + "\t"
                       + C.comesBefore("Henry", "Walker") + "\t"
                       + C.comesBefore("Barbara", "Walker"));

    } // end of testing in main
}