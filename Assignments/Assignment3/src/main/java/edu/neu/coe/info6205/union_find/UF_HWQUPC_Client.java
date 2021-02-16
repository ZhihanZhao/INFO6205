package edu.neu.coe.info6205.union_find;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class UF_HWQUPC_Client {

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
        File M = new File("/M.txt");
        File N = new File("/N.txt");
        FileOutputStream Mos = new FileOutputStream(M);
        FileOutputStream Nos = new FileOutputStream(N);
        OutputStreamWriter oswM = new OutputStreamWriter(Mos);
        OutputStreamWriter oswN = new OutputStreamWriter(Nos);
        BufferedWriter bwM = new BufferedWriter(oswM);
        BufferedWriter bwN = new BufferedWriter(oswN);

        for(int i = 1000; i<5000; i++){
            bwM.write(UF_HWQUPC_Client.count(i)[1]);
            bwN.write(i);
            bwM.newLine();
            bwN.newLine();
        }


    }

}
