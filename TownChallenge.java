package TownChallenge;

import java.util.Random;
import java.util.Scanner;

public class TownChallenge {

    public static void main(String[] args) {

        // 初始化一个城镇名字的数组
        String[] towns = {"Coleraine", "Belfast", "Banbridge", "Ballymoney",
                          "Newry", "Enniskillen", "Portadown", "Bangor"};

        // 创建随机数对象
        Random random = new Random();
        
        // 初始化主队和客队的得分为0
        int homeScore, awayScore;
        
        // 初始化主队胜、平、客队胜的次数为0
        int homes = 0, draws = 0, aways = 0;
        
        // 创建从键盘读取输入的Scanner对象
        Scanner keyboard = new Scanner(System.in);

        // 循环让用户输入前四个城镇的名字
        for(int i = 0; i < 4; i++) {
            System.out.printf("Enter town %d > ", i+1);
            towns[i] = keyboard.nextLine();
        }

        // 为主队和客队分别生成0-9之间的随机得分
        homeScore = random.nextInt(10);
        awayScore = random.nextInt(10);
        
        // 从前四个城镇中随机选择一个城镇
        int i = random.nextInt(4);
        
        // 打印选定的两个城镇及其得分
        System.out.printf("%s %d %s %d \n", towns[i*2], homeScore, towns[i*2 + 1], awayScore);
        
        // 根据得分判断比赛结果，并更新胜、平、负的次数
        if(homeScore > awayScore) {
            homes++;
        } else if(homeScore == awayScore) {
            draws++;
        } else {
            aways++;
        }

        // 打印主队胜、平、客队胜的次数
        System.out.printf("Homes %d, Draws %d, Aways %d \n", homes, draws, aways);
    }
}

