package PageReplacement;

import java.util.*;
public class mfu {
    public static void main(String[] args) {
        Scanner myinp = new Scanner(System.in);
        int references, frames, fault_count=0, fno, checker=0;


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
            int temp = 0;

            for (int j = 0; j < frames; j++) {
                if (pno[j] == reference_string[i]) {
                    temp = j;        
                } else {
                    temp = -1;
                }
            }
            
            checker = temp;
            
            if (checker == -1) {
                
                int temp1 = 0;

                for (int j = 0; j <= frames; j++) {
                    if (pno[j] == -1) {
                        temp1 = j;
                    } else {
                        temp1 = -1;
                    }
                }

                checker = temp1;

                if (checker == -1) {
                    
                    int temp2 = 0;

                    for (int j = 1; j < frames; j++) {
                        if (frequency[j] > frequency[temp2]) {
                            temp2 = j;
                        }
                    }

                    checker = temp2;

                    fault_count++;
                    pno[checker] = reference_string[i];
                }

            } else {
                
            }
        }
    }
}
