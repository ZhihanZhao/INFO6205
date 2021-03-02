package edu.neu.coe.info6205.union_find;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class UF_HWQUPC_Client {

    public static int[] count(int n){
        int connections = 0;
        int generations = 0;
        int[] result =new int[2];
        UF_HWQUPC ufHwqupc = new UF_HWQUPC(n,false);
        Random random = new Random();

        while (ufHwqupc.components() != 1){
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            generations ++;
            if(!ufHwqupc.connected(i,j)){
                ufHwqupc.connect(i,j);
                connections ++;
            }
        }
        result[0] =connections;
        result[1] = generations;
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input N:");
        int n = input.nextInt();

        int connections= UF_HWQUPC_Client.count(n)[0];
        System.out.printf("There are %d (n) sites, the number of connections is %d",n,connections);

        //analysis
        FileWriter fwriterM = new FileWriter("F:\\Assignment3\\file\\M.txt", true);
        FileWriter fwriterN = new FileWriter("F:\\Assignment3\\file\\N.txt",true);

        for(int i = 1000; i<5000; i++){
            String stringM = UF_HWQUPC_Client.count(i)[1] + ",";
            fwriterM.write(stringM);
            String stringN = i + ",";
            fwriterN.write(stringN);
        }
        fwriterM.close();
        fwriterN.close();


    }

}
