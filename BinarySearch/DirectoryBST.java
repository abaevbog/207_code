package binarySearch;

/**
 * testing that builds a binary search tree of directory Entries 
 *   with students and faculty
 * and then searches the tree for specific people
 */

import binarySearch.BSTree;
import binarySearch.Entry;
import binarySearch.Student;

public class DirectoryBST <E extends Comparable> {

    public static void main (String [] argv) {
        // test of various methods
        // constructors
        BSTree tree = new BSTree<Entry>();
        
        BSTree tree1 = new BSTree<Entry>();
        
        BSTree tree2 = new BSTree<Entry>();

        Student stu1 = new Student("Terry", "Walker", "walkert@math.grinnell.edu",
                                   1970, "off-campus");
        Student stu2 = new Student("Barbara", "Ellen", "barbara@cs.grinnell.edu",
                                   2002, "12-34-56");
        Student stu3 = new Student("Donna", "Marie", "donna@math.grinnell.edu",
                                   1998, "3.1415926535");
        Student stu4 = new Student("Shamrock", "The Cat", "none",
                                   3000, "varies");
        Student stu5 = new Student("Muffin", "The Cat", "none",
                                   3000, "varies");
        Student stu6 = new Student("Grinnellian", "Proud", "none",
                					2000, "First Year");

        Faculty fac1 = new Faculty("John", "Stone", "stone@cs.grinnell.edu",
                                 "Science 2418", 3181,
                                 "Computer Science", 1983);
        Faculty fac2 = new Faculty("Henry", "Walker", "walker@cs.grinnell.edu",
                                 "Science 2420", 4208, 
                                 "Computer Science", 1973);
        Faculty fac3 = new Faculty("Janet", "Gibson", "gibson@grinnell.edu",
                                 "Science 0420", 3168,
                                 "Psychology", 1989);
        Faculty fac4 = new Faculty("Samuel", "Rebelsky","rebelsky@cs.grinnell.edu",
                                 "Science 2427", 4410,
                                 "Computer Science", 1997);
        Faculty fac5 = new Faculty("Angela", "Gibson","gibsonan@cs.grinnell.edu",
                				 "Science 4427", 4110,
                				 "Computer Science", 1993);
        Faculty fac6 = new Faculty("Jacob", "Sand", "stone@cs.grinnell.edu",
                				 "Science 2418", 3181,
                				 "Computer Science", 1983);

        // insert entries to directory
        tree.insert(stu1);
        tree.insert(fac1);
        tree.insert(stu2);
        tree.insert(fac2);
        tree.insert(stu3);
        tree.insert(fac3);
        tree.insert(stu4);
        tree.insert(fac4);
        tree.insert(stu5);
        tree.insert(fac5);
        
        
        //insert entries into a new directory
        tree1.insert(fac4);
        tree1.insert(fac1);
        tree1.insert(fac2);
        tree1.insert(stu3);
        tree1.insert(fac3);
        tree1.insert(stu6);
        tree1.insert(stu4);
        tree1.insert(fac6);
        
        
        //insert entries into a new directory
        tree2.insert(fac4);
        tree2.insert(fac1);
        tree2.insert(fac2);
        tree2.insert(stu2);

        // print directory
        tree.print();
        
        System.out.println("Height of this tree is " + tree.height());
        
        System.out.println("Height of this tree1 is " + tree1.height());

        /*
        // check lookup
        Entry ent;
        System.out.println ("Searching for Barbara Ellen -- first entry");
        ent = (Entry) tree.lookup(new Entry ("Barbara", "Ellen", ""));
        if (ent == null)
            System.out.println("Barbara Ellen not found");
        else System.out.print(ent);

        System.out.println ("Searching for Terry Walker -- last entry");
        ent = (Entry) tree.lookup(new Entry ("Terry", "Walker", ""));
        if (ent == null)
            System.out.println("Terry Walker not found");
        else System.out.print(ent);

        System.out.println ("Searching for Muffin, The Cat");
        ent = (Entry) tree.lookup(new Entry ("Muffin", "The Cat", ""));
        if (ent == null)
            System.out.println("Muffin, The Cat, not found");
        else System.out.print(ent);

        System.out.println ("Searching for Muffin, The Dog");
        ent = (Entry) tree.lookup(new Entry ("Muffin", "The Dog", ""));
        if (ent == null)
            System.out.println("Muffin, The Dog, not found");
        else System.out.print(ent); */
        
        System.out.println("Node Level of " + stu1 + " is " + tree.nodeLevel(stu1));
        
        System.out.println("Node Level of " + fac1 + " is " + tree.nodeLevel(fac1));
        
        System.out.println("Node Level of " + stu2 + " is " + tree.nodeLevel(stu2));
        
        System.out.println("Node Level of " + stu4 + " is " + tree.nodeLevel(stu4));
        
        System.out.println("Node Level of " + fac3 + " is " + tree.nodeLevel(fac3));
        
        
        System.out.println("The tree is balanced is " + tree1.isBalanced());
        
        System.out.println("The tree is height balanced is " + tree.isHeightBalanced());
        
        System.out.println("The tree1 is height balanced is " + tree1.isHeightBalanced());
        
        System.out.println("The tree2 is height balanced is " + tree2.isHeightBalanced());
        

    }
}