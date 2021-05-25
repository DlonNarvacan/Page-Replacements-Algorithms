package PageReplacement;

import java.util.*;
public class mfu {
    public static void main(String[] args) {
        Scanner myinp = new Scanner(System.in);
        int references, frames, fault_count=0, checker=0;


        System.out.print("Number of Frames: ");
        frames = myinp.nextInt();

        System.out.print("Number of Reference: ");
        references = myinp.nextInt();
        int reference_string[] = new int[references];
        int pno[] = new int[references];
        int frequency[] = new int[references];
        
        for (int i = 0; i < references; i++) {
            System.out.print("Reference String "+i+": ");
            reference_string[i] = myinp.nextInt();
        }
        
        for (int i = 0; i < frames; i++) {
            pno[i] = -1;
            frequency[i] = 0;
        }

        for (int i = 0; i < reference_string.length; i++) {
            checker = capture_page(reference_string[i], frames, pno);
            if (checker == -1) {
                checker = fframe(frames, pno);
                if (checker  == -1) {
                    checker = mframe(frames, frequency);
                }

                fault_count++;
                pno[checker] = reference_string[i];
                frequency[checker] = 1;
            } else {
                frequency[checker]++;
            }
        }
        System.out.print("\n===============================");
        System.out.println("\nFault: "+fault_count);

    }

    static int capture_page(int page, int frames, int pno[]){
        for (int i = 0; i < frames; i++) {
            if (pno[i] == page) {
                return i;
            }
        }
        return -1;
    }

    static int fframe(int frames, int pno[]){
        for (int i = 0; i <= frames; i++) {
            if (pno[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    static int mframe(int frames, int frequency[]){
        int short1 = 0;
        for (int i = 1; i < frames; i++) {
            if (frequency[i] > frequency[short1]) {
                short1 = i;
            }
        }
        return short1;
    }
}


