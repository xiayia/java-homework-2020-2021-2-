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
            // ���ļ��м�������,���ζ����˶�Ա���Ƿ�����ע�ᡢ�����
            FileInputStream fileIn = new FileInputStream("data.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            players = (List<Player>) in.readObject();
            canRegister = in.readBoolean();
            notice = (String) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException ignore) {
            // ����ǵ�һ������,��ô�ͻ�û����������ļ�,�ⲻ�����,���Ժ�������쳣
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            // ���ȡ�����෴,���ν�����д�뵽�ļ�
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
        System.out.print("�����������û�����");
        String username = scanner.next();
        System.out.print("�������������룺");
        String password = scanner.next();
        for (Player player : players) {
            // �ҵ�����˶�Ա
            if (username.equals(player.getUsername()) && password.equals(player.getPassword())) {
                // ���μ���˶�Ա��״̬
                if (player.isDisabled()) {
                    System.out.println("��Ҫ��¼���û��ѱ�����Ա���ã�");
                    return null;
                }
                if (!player.isPending()) {
                    System.out.println("��Ҫ��¼���û���δͨ����������֪ͨ����Ա��");
                    return null;
                }

                // ������е�������˵��״̬���ͨ��,���鵽���˶�Ա����
                return player;
            }
        }
        System.out.println("�����û����������������");
        return null;
    }

    public static boolean adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("�����������û�����");
        String username = scanner.next();
        System.out.print("�������������룺");
        String password = scanner.next();

        // ����Ա����д��
        boolean logged = "admin".equals(username) && "admin".equals(password);
        if (!logged) {
            System.out.println("�����û����������������");
        }
        return logged;
    }

    public static void playerRegister() {
        // �ȼ��ȫ��״̬,���״̬������ֱ�ӷ���
        if (!canRegister) {
            System.out.println("��ǰ�����δ��������֪ͨ����Ա������");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("�����������û�����");
        String username = scanner.next();
        if (existsPlayer(username)) {
            System.out.println("��������û����Ѵ��ڣ�");
            return;
        }
        System.out.print("�������������룺");
        String password = scanner.next();

        System.out.print("����������������");
        String name = scanner.next();

        Player player = new Player();
        player.setUsername(username);
        player.setPassword(password);
        player.setName(name);

        player.setDisabled(false);
        player.setPending(false);

        player.setSettled(false);
        player.setPermitted(false);

        // ��ʼ���˶�Ա֮��Ҫ���˶�Ա���뵽����֮��
        players.add(player);
        System.out.println("ע��ɹ�����ȴ�����Ա������");
    }
}
