import database.Database;
import domain.Player;
import menu.AdminMenu;
import menu.PlayerMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database.load();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	
            System.out.println("\n\n\n");
            System.out.println("==欢迎您登录马拉松赛信息管理系统！==");
            System.out.println("|        1.管理员           |");
            System.out.println("|        2.运动员登陆　　　　　　|");
            System.out.println("|        3.运动员注册　　　　　　|");
            System.out.println("|        4.退出　　　　　　　　　|");
            System.out.println("==========================");
            System.out.print("请输入您要登陆的身份：");
            String choose = scanner.next();
            if ("1".equals(choose)) {
                if (Database.adminLogin()) {
                    new AdminMenu();
                }
                
            } else if ("2".equals(choose)) {
                Player loggedPlayer = Database.playerLogin();
                // 如果登陆失败那么会返回一个null用户
                if (loggedPlayer != null) {
                    new PlayerMenu(loggedPlayer);
                }
            } else if ("3".equals(choose)) {
                Database.playerRegister();
            } else if ("4".equals(choose)) {
                break;
            } else {
                System.out.println("您的输入有误！请重新输入！");
            }
            Database.save();
        }
        System.out.println("欢迎您下次使用！");
    }
}
