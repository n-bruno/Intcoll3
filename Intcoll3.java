//*********************************************************************
// FILE NAME    : Intcoll3.java
// DESCRIPTION  : This file contains the class Intcoll3.
//*********************************************************************

import java.util.*; //unused

public class Intcoll3 {

////////////////////////////////////////////
//  Variables
////////////////////////////////////////////
    private boolean[] c;
    private int how_many = 0;

    /*this creates the array "c" that's private to this class.
     */
////////////////////////////////////////////
//  Constructors
////////////////////////////////////////////
    public Intcoll3() {
        create(500);
    }

    public Intcoll3(int i) {
        create(i);
    }

    private void create(int i) {
        how_many = 0;
        c = new boolean[i + 1];
    }

////////////////////////////////////////////
//  copy
////////////////////////////////////////////
    public void copy(Intcoll3 obj) {
        /*
        First we check if the two objects have the same pointer,
        if they do, they are already equal. If we execute the code we
        will delete the information and copy over a blank array.
         */
        if (this != obj) {
            if (this.how_many != 0 && obj.how_many != 0) {
                c = new boolean[obj.c.length]; //overwrite array c
                for (int j = 0; j < how_many; j++) {
                    c[j] = obj.c[j];
                }
            }
        }
    }

////////////////////////////////////////////
//  Belongs
////////////////////////////////////////////
    public boolean belongs(int i) {
        return ((i > 0) && (c[i]));
        /*
        A much simpler method now that the slot at index i can be true or false
        which makes returning true or false easier as it's already in the array
         */
    }
////////////////////////////////////////////
//  Insert
////////////////////////////////////////////

    public void insert(int integer) {
        if (integer > 0) {
            if (integer + 1  > c.length ) {
                boolean[] newArray = new boolean[integer + 1]; //create new array for temporary storage, see create method for +1 explanation
                for (int i = 1; i < c.length; i++) { //store everything in c in newArray
                    newArray[i] = c[i];
                }

                c = new boolean[integer + 1];              //overwrite c with a larger size
                for (int i = 1; i <= integer; i++) { //store everything from newArray into c
                    c[i] = newArray[i];
                }
                c[integer] = false;
            }
            if (c[integer] == false) {
                c[integer] = true;
                how_many++;
            }
        }
    }
////////////////////////////////////////////
//  Omit
////////////////////////////////////////////

    /*
    In here we set the value c[i] to false if it was true and decrement
    
    Much simpler code for this program overall but not has memory frirndly in
    certain cases
     */
    public void omit(int i) {
        if (how_many > 0){
            if (i > 0) { //if i is positive
                if (c[i] == true) {
                    c[i] = false;
                    how_many--;
                }
            }
        }
    }

////////////////////////////////////////////
//  Howmany
////////////////////////////////////////////
    public int get_howmany() { //We return the variable how_many
        return how_many;
    }

////////////////////////////////////////////
//  Print
////////////////////////////////////////////
    public void print() {
        //This prints all the elements in the object's array with a for loop.
        System.out.println();
        for (int i = 1; i < c.length; i++) {
            if (c[i] == true){ //the value true for an index means it's in the collection...
                System.out.println(i);  //...so we print it
            }
        }
    }

////////////////////////////////////////////
//  Equals
////////////////////////////////////////////
    public boolean equals(Intcoll3 obj) {
        boolean result = true;
        if (this.get_howmany() != obj.get_howmany() && (this != obj)) {
            for (int j = 0; (j < how_many) && result; j++) {
                result = obj.belongs(j);
            }
        } return result;
    }
}
