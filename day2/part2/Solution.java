package day2.part2;

import java.io.File;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Integer sumOfPowerOfSets = 0;
        Integer redCubes = 0;
        Integer greenCubes = 0;
        Integer blueCubes = 0;

        try {
            Scanner sc = new Scanner(new File("./day2/part1/input.txt"));
            while(sc.hasNextLine()){
                redCubes = 0;
                greenCubes = 0;
                blueCubes = 0;
                String game = sc.nextLine();
                String[] tokens = game.split(":");
                String actualGame = tokens[1];
                String[] subsets = actualGame.split(";");
                Integer power = 0;

                for(String subset: subsets){
                    String[] draws = subset.split(",");

                    for(String draw: draws){
                        String[] cubesInfo = draw.split(" ");
                        Integer noOfCubes = Integer.parseInt(cubesInfo[1]);
                        String colorOfCube = cubesInfo[2];

                        if(colorOfCube.equals("red")){
                            redCubes = Integer.max(redCubes, noOfCubes);
                            continue;
                        }else if(colorOfCube.equals("green")){
                            greenCubes = Integer.max(greenCubes, noOfCubes);
                            continue;
                        }else if(colorOfCube.equals("blue")){
                            blueCubes = Integer.max(blueCubes, noOfCubes);
                            continue;
                        }else{
                            break;
                        }
                    }
                }
                power = redCubes * greenCubes * blueCubes;
                sumOfPowerOfSets += power;
                power = 0;
            }

            System.out.println("Sum of Power is : " + sumOfPowerOfSets);
            sc.close();
        } catch (Exception e) {
            System.err.println("Error :" + e);
        }
    }
}
