import java.util.Random; // 导入Random类，用于生成随机数
import java.util.Scanner; // 导入Scanner类，用于读取控制台输入
import java.io.File; // 导入File类，用于创建文件对象以读取或写入文件
import java.io.FileWriter; // 导入FileWriter类，用于写入数据到文件中

// 定义一个名为TownChallenge的公共类
public class TownChallenge {

    // main方法，程序执行的入口
    public static void main(String[] args) throws Exception { // 抛出异常，任何IO异常都将被抛出

        String[] towns = new String[8]; // 创建一个长度为8的字符串数组，用于存储城镇名称
        Random random = new Random(); // 创建一个Random对象，用于生成随机数
        Scanner keyboard = new Scanner(System.in); // 创建Scanner对象，用于从控制台读取用户输入
        File fileIn = new File("src/towns.txt"); // 创建一个File对象，指向源文件夹下的towns.txt文件
        Scanner fileInput = new Scanner(fileIn); // 创建一个Scanner对象，用于从文件读取数据
        FileWriter fileOut = new FileWriter("src/results.txt", true); // 创建一个FileWriter对象，用于将结果追加写入到results.txt文件中
        // 初始化比分和结果计数变量
        int homeScore, awayScore, numSetsOfResults;
        int homes = 0, draws = 0, aways = 0;
        int thisTown = 0;

        // 读取文件中的城镇名称，存储到数组中
        while (fileInput.hasNextLine()) {
            towns[thisTown] = fileInput.nextLine();
            thisTown = thisTown + 1;
        }

        // 询问用户想要生成多少组结果，并读取用户输入
        System.out.print("How many sets of results would you like to generate? > ");
        numSetsOfResults = keyboard.nextInt();

        // 根据用户指定的次数，生成比赛结果
        for (int resultSet = 0; resultSet < numSetsOfResults; resultSet++) {

            // 生成4场比赛的结果
            for (int i = 0; i <= 3; i++) {
                homeScore = random.nextInt(10); // 随机生成主队得分
                awayScore = random.nextInt(10); // 随机生成客队得分
                // 打印并写入比赛结果到控制台和文件
                System.out.printf("%-12s %3d    %-12s %3d\n", towns[i * 2], homeScore, towns[i * 2 + 1], awayScore);
                fileOut.write(towns[i*2] +" " + homeScore + " " + towns[i*2 + 1] + " " + awayScore + "\n");
                // 根据得分更新胜平负计数
                if (homeScore > awayScore) homes++;
                if (awayScore > homeScore) aways++;
                if (homeScore == awayScore) draws++;
            }
            // 打印并写入统计结果到控制台和文件
            System.out.printf("Homes %d, Draws %d, Aways %d \n\n", homes, draws, aways);
            fileOut.write("Homes " + homes + ", Draws " + draws + ", Aways " + aways + "\n\n");

        }
        // 完成写入后关闭文件输出流
        fileOut.close();
    }

}
