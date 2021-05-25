package PageReplacement;

import java.util.*;

public class lfu {
    public static void main(String[] args) {
        Scanner myinp = new Scanner(System.in);
        int references, frames, hit=0, fault_count=0, least, rp, cnt2=0, bn=0;

        System.out.print("Number of Frames: ");
        frames = myinp.nextInt();

        System.out.print("Number of Reference: ");
        references = myinp.nextInt();
        int reference_string[] = new int [references];
        int page[] = new int[references];
        int cnt[] = new int[references];

        for (int i = 0; i < references; i++) {
            System.out.print("Reference String "+i+": ");
            reference_string[i] = myinp.nextInt();
        }

        for (int i = 0; i < frames; i++) {
            page[i] = 9999;
        }

        for (int i = 0; i < frames; i++) {
            cnt[i] = 0;
        }

        for (int i = 0; i < references; i++) {
            System.out.println();

            hit = 0;
            for (int j = 0; j < frames; j++) {
                if (page[j] == reference_string[i]) {
                    hit = 1;
                    break;
                }
            }

            
            if (hit == 0) {
                int temp=0, index_hit;

                for (int j = 0; j < frames; j++) {
                    if (page[j] == reference_string[i]) {
                        temp = j;
                        break;
                    }
                }

                index_hit = temp;
                cnt[index_hit]++;
                System.out.print(" ");
            } else {
                fault_count++;
                if (bn < frames) {
                    page[bn] = reference_string[i];
                }
            }
        }

    }
}
