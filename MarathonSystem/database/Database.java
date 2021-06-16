package database;

import domain.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database implements Serializable {
    public static List<Player> players = new ArrayList<>();

    public static boolean canRegister = false;

    public static String notice = "";

    public static Player findPlayer(String username) {
        for (Player player : players) {
            if (username.equals(player.getUsername())) {
                return player;
            }
        }
        return null;
    }

    public static boolean existsPlayer(String username) {
        return findPlayer(username) != null;
    }


    public static void load() {
        try {
            // 从文件中加载数据,依次读入运动员、是否允许注册、公告等
            FileInputStream fileIn = new FileInputStream("data.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            players = (List<Player>) in.readObject();
            canRegister = in.readBoolean();
            notice = (String) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException ignore) {
            // 如果是第一次运行,那么就会没有这个数据文件,这不算错误,所以忽略这个异常
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            // 与读取数据相反,依次将数据写入到文件
            FileOutputStream fileOut = new FileOutputStream("data.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(players);
            out.writeBoolean(canRegister);
            out.writeObject(notice);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player playerLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的用户名：");
        String username = scanner.next();
        System.out.print("请输入您的密码：");
        String password = scanner.next();
        for (Player player : players) {
            // 找到这个运动员
            if (username.equals(player.getUsername()) && password.equals(player.getPassword())) {
                // 依次检查运动员的状态
                if (player.isDisabled()) {
                    System.out.println("您要登录的用户已被管理员禁用！");
                    return null;
                }
                if (!player.isPending()) {
                    System.out.println("您要登录的用户还未通过审批！请通知管理员！");
                    return null;
                }

                // 如果运行到这里了说明状态检查通过,将查到的运动员返回
                return player;
            }
        }
        System.out.println("您的用户名或密码输入错误！");
        return null;
    }

    public static boolean adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的用户名：");
        String username = scanner.next();
        System.out.print("请输入您的密码：");
        String password = scanner.next();

        // 管理员密码写死
        boolean logged = "admin".equals(username) && "admin".equals(password);
        if (!logged) {
            System.out.println("您的用户名或密码输入错误！");
        }
        return logged;
    }

    public static void playerRegister() {
        // 先检查全局状态,如果状态不对则直接返回
        if (!canRegister) {
            System.out.println("当前报名活动未开启！请通知管理员开启！");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的用户名：");
        String username = scanner.next();
        if (existsPlayer(username)) {
            System.out.println("您输入的用户名已存在！");
            return;
        }
        System.out.print("请输入您的密码：");
        String password = scanner.next();

        System.out.print("请输入您的姓名：");
        String name = scanner.next();

        Player player = new Player();
        player.setUsername(username);
        player.setPassword(password);
        player.setName(name);

        player.setDisabled(false);
        player.setPending(false);

        player.setSettled(false);
        player.setPermitted(false);

        // 初始化运动员之后要将运动员加入到序列之中
        players.add(player);
        System.out.println("注册成功！请等待管理员审批！");
    }
}
