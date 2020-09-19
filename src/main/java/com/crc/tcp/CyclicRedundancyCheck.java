package com.crc.tcp;


public class CyclicRedundancyCheck {

    private static String substringData(String data, int init, int size){
        return data.substring(init, size);
    }

    public static String calculate(String[] message) {

        String data = String.join("", message).concat("00000000"); //concatenando 8 zeros porque o grau do gerador é 8

        //CRC-8 (Polinomio para CRC de 8 bits = x^8 + X^2 + X^1 + 1, gerador = 100000111
        int polynomial = 8;
        String generator = "100000111";

        int position = polynomial;
        boolean keepRunning = true;

        String dataResult = substringData(data, 0, polynomial);

        do {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < dataResult.length(); i++) {
                sb.append((dataResult.charAt(i) ^ generator.charAt(i)));
            }

            final Integer binary = Integer.parseInt(sb.toString());
            final int length = polynomial - binary.toString().length();

            if(position + length > data.length()){
                dataResult = binary + substringData(data, position, data.length());
                keepRunning = false;
            } else {
                dataResult = binary + substringData(data, position, position + length);
                position += length;
            }

        } while  (keepRunning);

        return dataResult;
    }
}
