package com.company;

//import com.oracle.javafx.jmx.json.JSONReader;

import java.util.Random;

public class Main {
    private static String[][] list = {
        {"1a", "1b", "1c", "1d", "1e", "1f", "1g", "1h", "1i"},
        {"2a", "2b", "2c", "2d", "2e", "2f", "2g", "2h", "2i"},
        {"3a", "3b", "3c", "3d", "3e", "3f", "3g", "3h", "3i"},
        {"4a", "4b", "4c", "4d", "4e", "4f", "4g", "4h", "4i"},
        {"5a", "5b", "5c", "5d", "5e", "5f", "5g", "5h", "5i"},
    };

    private static String[] extra = {
        "6a", "6b", "6c", "6d", "6e", "6f", "6g", "6h", "6i"
    };

    private static String[][][] reRoll = {
        {},
        {},
        {
            {"0", ""},
            {"2", " and "},
        },
        {},
        {},
    };

    /**
     * @param args with extra param will select from extra table
     */
    public static void main(String[] args) {
        int rand;
        int count = 0;
//        JSONReader

        if (args.length > 0 && args[0].equals("extra")) {
            rand = getRand(extra.length);
            System.out.println(extra[rand]);
        } else {
            for (String[] row : list) {
                rand = getRand(count, row.length);

                System.out.print(count);
                System.out.println(row[rand]);

                count++;
            }
        }
    }

    /**
     * @param row
     * @param max
     * @return
     */
    private static Integer getRand(int row, int max)
    {
        int generated = getRand(max);

        for (String[] reRollRule : reRoll[row]) {
            if (Integer.parseInt(reRollRule[0]) == generated) {
                if (!reRollRule[1].isEmpty()) {
                    System.out.print(list[row][generated]);
                    System.out.print(reRollRule[1]);
                }

                generated = getRand(row, max);
            }
        }

        return generated;
    }

    /**
     * @param max
     * @return
     */
    private static Integer getRand(int max)
    {
        Random rand = new Random();

        return rand.nextInt(max -1);
    }
}
