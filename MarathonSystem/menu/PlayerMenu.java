package menu;

import database.Database;
import domain.Player;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerMenu {
    Player player;

    public PlayerMenu(Player player) {
        this.player = player;
        start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n");
            System.out.printf("======欢迎您 %s =====\n", player.getName());
            System.out.println("   [1] 报名参赛      ");
            System.out.println("   [2] 查询自己成绩   ");
            System.out.println("   [3] 查看排行榜     ");
            System.out.println("   [4] 查看通知      ");
            System.out.println("   [5] 退出         ");
            System.out.println("====================");
            System.out.print("请输入您要进行的操作：");
            String choose = scanner.next();
            if ("1".equals(choose)) {
                signup();
            } else if ("2".equals(choose)) {
                watchSelf();
            } else if ("3".equals(choose)) {
                watchRank();
            } else if ("4".equals(choose)) {
                watchNotice();
            } else if ("5".equals(choose)) {
                System.out.println("欢迎您下次使用！");
                break;
            } else {
                System.out.println("您的输入有误！请重新输入！");
            }
            Database.save();
        }
    }

    private void watchNotice() {
        // 检查有无通知,没有通知与有通知的返回结果是不一样的
        if (Database.notice.isEmpty()) {
            System.out.println("当前没有设置任何通知！");
            return;
        }
        System.out.println("当前通知为：");
        System.out.println(Database.notice);
    }

    private void watchRank() {
        // 过滤有成绩的运动员，并按照成绩倒序排序
        List<Player> sortedPlayers = Database.players.stream()
                .filter(Player::isSettled)
                .sorted(Comparator.comparing(Player::getScore).reversed())
                .collect(Collectors.toList());

        // 检查是否有结果
        if (sortedPlayers.isEmpty()) {
            System.out.println("当前没有设置任何成绩！请通知管理员！");
            return;
        }

        // 依次打印
        int rank = 1;
        for (Player p : sortedPlayers) {
            System.out.printf("第 %d 名： %s\t成绩：%d \n", rank, p.getName(), p.getScore());
            rank++;

            // 运动员界面只能查看10个,所以打印10个了就退出
            if (rank > 10) {
                break;
            }
        }
    }

    private void watchSelf() {
        // 前面是一系列状态检查
        if (!player.isSignup()) {
            System.out.println("您还未报名参赛！");
            return;
        }
        if (!player.isPermitted()) {
            System.out.println("您未通过报名审批！");
            return;
        }
        if (!player.isSettled()) {
            System.out.println("您的成绩还未设置！请通知管理员设置！");
            return;
        }

        // 遍历所有运动员看有几个人比当前运动员分数高，默认是第一名，有一个就+1
        int rank = 1;
        for (Player other : Database.players) {
            if (other.isSettled()) {
                if (other.getScore() > player.getScore()) {
                    rank++;
                }
            }
        }
        System.out.printf("您的成绩：%d  您的名次为：第 %d 名\n", player.getScore(), rank);
    }

    private void signup() {
        if (player.isSignup()) {
            System.out.println("您已经报名参赛！请勿重复报名！");
        } else {
            player.setSignup(true);
            System.out.println("报名成功！");
        }
    }


}
