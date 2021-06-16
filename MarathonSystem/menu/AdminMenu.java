package menu;

import database.Database;
import domain.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminMenu {
    public AdminMenu() {
        start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n");
            System.out.println("======欢迎您 管理员 ！======");
            System.out.println("      [1] 审批用户          ");
            System.out.println("      [2] 查询用户          ");
            System.out.println("      [3] 禁用用户          ");
            System.out.println("      [4] 重置用户密码       ");
            System.out.println("      [5] 开启报名          ");
            System.out.println("      [6] 停止报名          ");
            System.out.println("      [7] 审批参赛申请       ");
            System.out.println("      [8] 查看报名情况       ");
            System.out.println("      [9] 录入比赛成绩       ");
            System.out.println("      [10] 查询运动员成绩     ");
            System.out.println("      [11] 查看排行榜        ");
            System.out.println("      [12] 发布通知          ");
            System.out.println("      [13] 退出             ");
            System.out.println("===========================");
            System.out.print("请输入您要进行的操作：");
            String choose = scanner.next();
            if ("1".equals(choose)) {
                pendPlayer();
            } else if ("2".equals(choose)) {
                searchPlayer();
            } else if ("3".equals(choose)) {
                disablePlayer();
            } else if ("4".equals(choose)) {
                resetPlayerPassword();
            } else if ("5".equals(choose)) {
                openRegister();
            } else if ("6".equals(choose)) {
                closeRegister();
            } else if ("7".equals(choose)) {
                permitPlayer();
            } else if ("8".equals(choose)) {
                watchSignup();
            } else if ("9".equals(choose)) {
                importScore();
            } else if ("10".equals(choose)) {
                watchPlayerScore();
            } else if ("11".equals(choose)) {
                watchRank();
            } else if ("12".equals(choose)) {
                releaseNotice();
            } else if ("13".equals(choose)) {
                break;
            } else {
                System.out.println("您的输入有误！请重新输入！");
            }
            Database.save();
        }
        System.out.println("欢迎您再次使用！");
    }

    private void releaseNotice() {
        // 没有公告则直接返回
        if (Database.notice.isEmpty()) {
            System.out.println("当前公告为：");
            System.out.println(Database.notice);
        }
        System.out.println("请输入新公告：");
        Scanner scanner = new Scanner(System.in);
        Database.notice = scanner.next();
        System.out.println("发布成功！");
    }

    private void watchRank() {
        // 过滤并排序
        List<Player> sortedPlayers = Database.players.stream()
                .filter(Player::isSettled)
                .sorted(Comparator.comparing(Player::getScore).reversed())
                .collect(Collectors.toList());

        if (sortedPlayers.isEmpty()) {
            System.out.println("当前没有设置任何成绩！请通知管理员！");
            return;
        }

        // 管理员界面可以查看整个榜单,所以不会像运动员界面一样中途退出
        int rank = 1;
        for (Player p : sortedPlayers) {
            System.out.printf("第 %d 名： %s\t成绩：%d \n", rank, p.getName(), p.getScore());
            rank++;
        }
    }

    private void watchPlayerScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要查看成绩的用户名：");
        String username = scanner.next();

        // 检查用户名是否存在
        if (!Database.existsPlayer(username)) {
            System.out.println("您输入的用户名有误！");
            return;
        }

        Player player = Database.findPlayer(username);
        System.out.printf("\t用户名：%s\t姓名：%s\t成绩：%s\n", player.getUsername(), player.getName(), player.isSettled() ? String.valueOf(player.getScore()) : "未设置");
    }

    private void importScore() {
        System.out.println("当前运动员情况：");
        for (Player player : Database.players) {
            System.out.printf("\t用户名：%s\t姓名：%s\t成绩：%s\n", player.getUsername(), player.getName(), player.isSettled() ? String.valueOf(player.getScore()) : "未设置");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要设置成绩的用户名：");
        String username = scanner.next();

        if (!Database.existsPlayer(username)) {
            System.out.println("您输入的用户名有误！");
            return;
        }
        Player player = Database.findPlayer(username);
        System.out.printf("请输入该用户成绩：");
        int score = scanner.nextInt();

        // 将运动员状态设置为已经设置了成绩
        player.setSettled(true);
        player.setScore(score);
        System.out.println("设置成功!");

    }

    private void watchSignup() {
        // 过滤得到所有已经报名的用户
        List<Player> signedPlayers = Database.players.stream()
                .filter(Player::isSignup)
                .collect(Collectors.toList());
        if (signedPlayers.isEmpty()) {
            System.out.println("当前没有报名用户！");
            return;
        }

        System.out.println("以下为已报名的用户：");
        for (Player player : signedPlayers) {
            System.out.printf("\t用户名：%s\t姓名：%s\n", player.getUsername(), player.getName());
        }
    }

    private void permitPlayer() {
        // 过滤所有已经报名但是没有审批过的用户
        List<Player> notPermittedPlayers = Database.players.stream()
                .filter(Player::isSignup)
                .filter(p -> !p.isPermitted())
                .collect(Collectors.toList());

        if (notPermittedPlayers.isEmpty()) {
            System.out.println("当前没有待审批的用户！");
            return;
        }

        System.out.println("以下为待审批的用户：");
        for (Player player : notPermittedPlayers) {
            System.out.printf("\t用户名：%s\t姓名：%s\n", player.getUsername(), player.getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要通过审批的用户名：");
        String username = scanner.next();

        for (Player player : notPermittedPlayers) {
            if (username.equals(player.getUsername())) {
                player.setPermitted(true);
                System.out.println("已通过审批！");
                return;
            }
        }

        System.out.println("您输入的用户名错误或已通过审批！请重新操作！");
    }

    private void closeRegister() {
        if (!Database.canRegister) {
            System.out.println("报名活动已经关闭！请勿重复关闭！");
            return;
        }
        Database.canRegister = false;
        System.out.println("关闭成功！");
    }

    private void openRegister() {
        if (Database.canRegister) {
            System.out.println("报名活动已经开启！请勿重复开启！");
            return;
        }
        Database.canRegister = true;
        System.out.println("开启成功！");
    }

    private void resetPlayerPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您想重置的用户名：");
        String username = scanner.next();

        // 找不到直接返回
        if (!Database.existsPlayer(username)) {
            System.out.println("您输入的用户名有误！");
            return;
        }

        Player player = Database.findPlayer(username);
        System.out.print("请输入该用户新密码：");
        String password = scanner.next();
        player.setPassword(password);
        System.out.println("重置成功!");
    }

    private void disablePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您想禁用的用户名：");
        String username = scanner.next();
        if (!Database.existsPlayer(username)) {
            System.out.println("您输入的用户名有误！");
            return;
        }
        Player player = Database.findPlayer(username);
        if (player.isDisabled()) {
            System.out.println("该用户已经禁用！请勿重复操作！");
            return;
        }
        player.setDisabled(true);
        System.out.println("禁用成功！");
    }

    private void searchPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您想查找的用户名：");
        String username = scanner.next();
        if (!Database.existsPlayer(username)) {
            System.out.println("您输入的用户名有误！");
            return;
        }
        Player player = Database.findPlayer(username);
        System.out.printf("用户名：%s\n", player.getUsername());
        System.out.printf("姓名：%s\n", player.getName());
        System.out.printf("是否通过审批：%s\n", player.isPending() ? "是" : "否");
        System.out.printf("是否禁用：%s\n", player.isDisabled() ? "是" : "否");
        System.out.printf("是否报名：%s\n", player.isSignup() ? "是" : "否");
        if (player.isSignup()) {
            System.out.printf("是否报名成功：%s\n", player.isPermitted() ? "是" : "否");
            // 报名成功才可能有成绩
            if (player.isPermitted()) {
                System.out.printf("是否已有成绩：%s\n", player.isSettled() ? "是" : "否");
            }
        }
    }

    private void pendPlayer() {
        // 过滤所有还没有审批的用户
        List<Player> pendingPlayers = Database.players.stream()
                .filter(p -> !p.isPending())
                .collect(Collectors.toList());
        if (pendingPlayers.isEmpty()) {
            System.out.println("当前没有可审批的用户！");
            return;
        }

        System.out.println("以下为待审批的用户：");
        for (Player pendingPlayer : pendingPlayers) {
            System.out.printf("\t用户名：%s\t姓名：%s\n", pendingPlayer.getUsername(), pendingPlayer.getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要通过审批的用户名：");
        String username = scanner.next();

        for (Player pendingPlayer : pendingPlayers) {
            if (username.equals(pendingPlayer.getUsername())) {
                pendingPlayer.setPending(true);
                System.out.println("已通过审批！");
                return;
            }
        }

        System.out.println("您输入的用户名错误或已通过审批！请重新操作！");
    }
}
