package com.crc.tcp.convert;

public class Convert {

    public static String stringToHex(String val) {

        char ch[] = val.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < ch.length; i++) {
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
        }

        return sb.toString();

    }

    public static String[] stringToBinary(String value) {

        String[] binaries = new String[value.length()];

        final byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            binaries[i] = Integer.toBinaryString(bytes[i]);
        }

        return binaries;

    }

    public static String binaryToHex(String binary) {

        StringBuffer sb = new StringBuffer();

        int decimalValue = 0;
        int length = binary.length() - 1;

        for (int j = 0; j < binary.length(); j++) {
            decimalValue += Integer.parseInt(binary.charAt(j) + "") * Math.pow(2, length);
            length--;
        }

        sb.append(decimalToHex(decimalValue));

        return sb.toString();
    }

    private static String decimalToHex(int decimal) {
        String hex = "";
        while (decimal != 0) {
            int hexValue = decimal % 16;
            hex = toHexChar(hexValue) + hex;
            decimal = decimal / 16;
        }
        return hex;
    }

    private static char toHexChar(int hexValue) {
        if (hexValue <= 9 && hexValue >= 0)
            return (char) (hexValue + '0');
        else
            return (char) (hexValue - 10 + 'A');
    }

}
