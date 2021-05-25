package PageReplacement;

import java.util.*;

class node {
    int pno[] = new int[100];
    int frequency[] = new int[100];
}

public class mfu {
    public static void main(String[] args) {
        Scanner myinp = new Scanner(System.in);
        int references, frames, fault_count=0,fno;

        node fn = new node();

        System.out.print("Number of Frames: ");
        frames = myinp.nextInt();

        System.out.print("Number of Reference: ");
        references = myinp.nextInt();
        int reference_string[] = new int[references];
        
        for (int i = 0; i < references; i++) {
            System.out.print("Reference String "+i+": ");
            reference_string[i] = myinp.nextInt();
        }
        
        for (int i = 0; i < frames; i++) {
            fn.pno[i] = -1;
            fn.frequency[i] = 0;
        }

        for (int i = 0; i < reference_string.length; i++) {
            
        }
    }
}
