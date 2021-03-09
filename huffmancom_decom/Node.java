/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.print.DocFlavor;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


// A Tree node
class Node
{
    char ch;
    int freq;
    Node left = null, right = null;

    Node(char ch, int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
    //
    public Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
};

class Huffman
{
    public static String decompressedstring="";
    // traverse the Huffman Tree and store Huffman Codes
    // in a map.
    public static void encode(Node root, String str,
                              Map<Character, String> huffmanCode)
    {
        if (root == null)
            return;

        // found a leaf node
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }


        encode(root.left, str + "0", huffmanCode);
        encode(root.right, str + "1", huffmanCode);
    }


    public static int decode(Node root, int index, String sb)
    {
        if (root == null)
            return index;

        // found a leaf node
        if (root.left == null && root.right == null)
        {

            System.out.print(root.ch);
            decompressedstring=decompressedstring+root.ch;
            return index;
        }


        index++;

        if (sb.charAt(index) == '0')
            index = decode(root.left, index, sb);
        else
            index = decode(root.right, index, sb);

        return index;
    }

    public static void com(String text) throws IOException
    {  // and store it in a map
        long startTime = System.currentTimeMillis();
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0 ; i < text.length(); i++) {
            if (!freq.containsKey(text.charAt(i))) {
                freq.put(text.charAt(i), 0);
            }
            freq.put(text.charAt(i), freq.get(text.charAt(i)) + 1);
        }

        // Create a priority queue to store live nodes of Huffman tree
        // Notice that highest priority item has lowest frequency
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (l, r) -> l.freq - r.freq);

        // Create a leaf node for each character and add it
        // to the priority queue.
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // do till there is more than one node in the queue
        while (pq.size() != 1)
        {
            // Remove the two nodes of highest priority
            // (lowest frequency) from the queue
            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new internal node with these two nodes as children
            // and with frequency equal to the sum of the two nodes
            // frequencies. Add the new node to the priority queue.
            int sum = left.freq + right.freq;
            pq.add(new Node('\0', sum, left, right));
        }

        // root stores pointer to root of Huffman Tree
        Node root = pq.peek();

        // traverse the Huffman tree and store the Huffman codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);
        Path path = Paths.get("TERA.txt");
        String Ff="";
        // print the Huffman codes
        FileWriter fg = new FileWriter("TERA.txt");
        BufferedWriter bw = new BufferedWriter(fg);
        System.out.println("\nHuffman Codes are :\n");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet())
        {
            Ff=Ff+entry.getKey()+entry.getValue()+"~";

        }
        System.out.println(Ff);
        bw.write(Ff+" ");
        bw.close();

        System.out.println("\nOriginal string was :\n" + text);

        StringBuilder sb = new StringBuilder();
        String ff;

        for (int i = 0 ; i < text.length(); i++) {
            sb.append(huffmanCode.get(text.charAt(i)));
        }
        ff=sb.toString();
        int ri=0;
        while(ff.charAt(ri)=='0') {
            ri++;}
        String frs=null;
        frs=Integer.toString(ri);
        System.out.println("\nEncoded string is :\n" + sb);
        byte[] bval = new BigInteger(ff, 2).toByteArray();


        try {

            Files.write(path,frs.getBytes(),StandardOpenOption.APPEND);
            Files.write(path,bval, StandardOpenOption.APPEND);


            System.out.println("Successfully written data to the file\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time taken to compress the file is : "+totalTime+"  msec");

    }
    public static void decom() throws IOException{
        long startTime2 = System.currentTimeMillis();
        byte[] fileContent = null;
        String x="";
        int zi = 0;
        File file = new File("TERA.txt");
        try {
            fileContent= Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int kkk=0;
        boolean flag;
        String rr="";
        rr=new String(fileContent);
        int count =0;

        byte[] fileContent1=fileContent ;


        if (rr.charAt(0)==' ')
            flag =true;
        else
            flag =false;
        System.out.println(flag);
        String st1="";
        String st2="";
        String [] gg = rr.split(" ");
        //  if()
        int flagf=0;
        System.out.println(gg.length);
        for (int op =0; op<gg.length;op++)
        {
            System.out.println("yyyyyysysysy"+op);
            if(flag==true&&op==0){
                st1=" "+gg[1];
                op=1;
            }
            else if(op!=0){
                if (gg[op].chars().allMatch(c->c<128) ){
                    flagf=1;
                    st1=st1+" "+gg[op];
                    System.out.println("jrjrjrjrjrjrjr");}
                else{
                    st2=st2+gg[op]+" ";

                }}
            else
                st1=st1+gg[op];

        }
        System.out.println(" St1="+st1);
        System.out.println("ST2="+st2);
        //System.out.println("flag 1"+st1);
        //System.out.println("flag 2"+st2);
        int yy=0;
        String os= st2;
        yy=Integer.parseInt(os.charAt(0)+"");
        System.out.println(yy);
        String iss="";
        for(int i=0;i<yy;i++)
        {
            if(i==0)
                iss="0";
            else
                iss=iss+"0";
        }
        //System.out.println(iss);
        boolean flag1=false;
        count=0;
        x="";
        for (int i=0;i<fileContent.length;i++) {
            if(fileContent[i]==' '&& count<2)
            {
                count++;
                //  System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            }
            else if ((count==1&&flagf==0&&flag==false) ||count>=2){
                if (flag1==false){
                    x=String.format("%8s", Integer.toBinaryString((fileContent[i+1] + 256) % 256)).replace(" ","");
                    x=iss+x;
                    flag1=true;
                    i++;}
                else {
                    x = x + String.format("%8s", Integer.toBinaryString((fileContent[i] + 256) % 256)).replace(' ', '0');
                }  }
            else continue;
        }

        char[] arr;
        System.out.println(x);

        // String str3=st1.replaceAll("[^\\d]"," ");

        /*System.out.println(str3);
        if(str3.charAt(0)==' ')
        { str3=str3.trim();

        }
        System.out.println(str3);*/
        String[] str5 = st1.split("~");
        String[] st6=new String[str5.length];
        for (int i=0;i<str5.length;i++)
        {
            st6[i]=str5[i].charAt(0)+"";
            System.out.println(st6[i]);
        }
        for (int i=0;i<str5.length;i++)
        {
            str5[i]=str5[i].substring(1);
            System.out.println(str5[i]);
        }



        /*String st4=st1.replaceAll("\\d", "9");
        st4=st4.replaceAll("9","");
        System.out.println("St4"+st4);*/

        Map<Character, Integer> freq1 = new HashMap<>();
        for (int i = 0 ; i < str5.length; i++) {
            freq1.put(st6[i].charAt(0),Integer.parseInt(str5[i]));
        }

        PriorityQueue<Node> pq1 = new PriorityQueue<>(
                (l, r) -> l.freq- r.freq);

        for (Map.Entry<Character, Integer> entry : freq1.entrySet()) {
            pq1.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (pq1.size() != 1)
        {
            // Remove the two nodes of highest priority
            // (lowest frequency) from the queue
            Node left1 = pq1.poll();
            Node right1 = pq1.poll();

            // Create a new internal node with these two nodes as children
            // and with frequency equal to the sum of the two nodes
            // frequencies. Add the new node to the priority queue.
            int sum1 = left1.freq + right1.freq;
            pq1.add(new Node('\0', sum1, left1, right1));
        }
        Node root1 = pq1.peek();

        // traverse the Huffman tree and store the Huffman codes in a map
        Map<Character, String> huffmanCode1 = new HashMap<>();
        encode(root1, "", huffmanCode1);
        for (Map.Entry<Character, String> entry : huffmanCode1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
        int index = -1;
        System.out.println("\nDecoded string is: \n");
        while (index < x.length() -2) {
            index = decode(root1, index, x);
        }
        long endTime2   = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("\n");
        System.out.println("Time taken to decompress the file is : "+totalTime2+"  msec");

    }


    public static void compression (String directory){

        byte[] fileContent = null;
        File file = new File(directory);
        try {
            fileContent= Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("file: "+fileContent.length);
        byte[] fileContent2 = null;
        File file2 = new File("TERA.txt");
        try {
            fileContent2= Files.readAllBytes(file2.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("file2: "+fileContent2.length);
        float compressionratio=(float)fileContent2.length/fileContent.length;
        System.out.println("Compression ratio = "+(int)Math.ceil(compressionratio*100)+"%");

    }
    public static void print (String directory) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(directory));
        writer.write(decompressedstring);
        writer.close();

    }


    public static void main(String[] args) throws IOException {  String text = "";
        Scanner sc = null;
        String directory ;

        System.out.println("press 1- compressing\npress 2- decompressing");
        Scanner scan1 = new Scanner(System.in);


        String dirc = scan1.nextLine();
        if(dirc.equals("1")){
            System.out.println("please select file you want to compress");
            Scanner scan = new Scanner(System.in);
            directory = scan.nextLine();
            if (directory.contains(".")) {


                File file = new File(directory);
                try {
                    sc = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (sc.hasNextLine()){
                    text =text+ sc.nextLine()+"\n";
                }
                com(text);
            }
            else {
                try {


                    File f = new File(directory);
                    File[] files = f.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        try {
                            sc = new Scanner(files[i]);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        while (sc.hasNextLine()){
                            text = text + sc.nextLine()+"\n";
                        }
                        text=text+"\n";
                    }
                    com(text);
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }

            }
            compression(directory);
        }
        else{
            System.out.println("please type the file name you want to decompress into");
            Scanner scan = new Scanner(System.in);
            text = scan.nextLine();
            decom();
            print(text);

        }
    }
}
