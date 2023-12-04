package day2.part1;

import java.io.File;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Integer sumOfPossibleGameIDs = 0;
        Integer redCubes = 12;
        Integer greenCubes = 13;
        Integer blueCubes = 14;

        try {
            Scanner sc = new Scanner(new File("./day2/part1/input.txt"));
            while(sc.hasNextLine()){
                String game = sc.nextLine();
                String[] tokens = game.split(":");
                Integer gameID = Integer.parseInt(tokens[0].split(" ")[1]);
                String actualGame = tokens[1];
                String[] subsets = actualGame.split(";");
                Integer validSubsets = 0;

                for(String subset: subsets){
                    String[] draws = subset.split(",");
                    Integer validDraws = 0;

                    for(String draw: draws){
                        String[] cubesInfo = draw.split(" ");
                        Integer noOfCubes = Integer.parseInt(cubesInfo[1]);
                        String colorOfCube = cubesInfo[2];

                        if(colorOfCube.equals("red") && noOfCubes <= redCubes){
                            validDraws++;
                            continue;
                        }else if(colorOfCube.equals("green") && noOfCubes <= greenCubes){
                            validDraws++;
                            continue;
                        }else if(colorOfCube.equals("blue") && noOfCubes <= blueCubes){
                            validDraws++;
                            continue;
                        }else{
                            break;
                        }
                    }

                    if(validDraws == draws.length){
                        validSubsets++;
                    }
                }

                if(validSubsets == subsets.length){
                    sumOfPossibleGameIDs += gameID;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.err.println("Error :" + e);
        }

        System.out.println(sumOfPossibleGameIDs);
    }
}
