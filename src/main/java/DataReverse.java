/*
A stream of data is received and needs to be reversed.

Each segment is 8 bits long, meaning the order of these segments needs to be reversed, for example:

11111111  00000000  00001111  10101010
 (byte1)   (byte2)   (byte3)   (byte4)
should become:

10101010  00001111  00000000  11111111
 (byte4)   (byte3)   (byte2)   (byte1)
The total number of bits will always be a multiple of 8.

The data is given in an array as such:

[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]
 */

import java.util.Arrays;

public class DataReverse {
    public static void main(String[] args) {

        int[] myArray = {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
        DataReverse(myArray);

    }

    public static int[] DataReverse(int[] data) {
        int[] resultArray = new int[data.length];
        int startI = data.length - 8;
        int startJ = 0;


        for (int i = 0; i < (data.length/8); i++) {
            for (int j = 0; j < 8; j++) {
                resultArray[j + startI] = data [j + startJ];
            }
            startI = startI - 8;
            startJ = startJ + 8;

        }
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(resultArray));

        return resultArray;

    }

    public static int[] DataReverse1(int[] data) {
        int[] bytes = new int[data.length];
        for (int i = data.length-8, j=0; i>=0; i-=8, j+=8) {
            System.arraycopy(data, i, bytes, j, 8);
        }
        return bytes;
    }

}
