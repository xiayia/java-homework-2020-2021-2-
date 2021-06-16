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
            System.out.println("==��ӭ����¼����������Ϣ����ϵͳ��==");
            System.out.println("|        1.����Ա           |");
            System.out.println("|        2.�˶�Ա��½������������|");
            System.out.println("|        3.�˶�Աע�ᡡ����������|");
            System.out.println("|        4.�˳�������������������|");
            System.out.println("==========================");
            System.out.print("��������Ҫ��½����ݣ�");
            String choose = scanner.next();
            if ("1".equals(choose)) {
                if (Database.adminLogin()) {
                    new AdminMenu();
                }
                
            } else if ("2".equals(choose)) {
                Player loggedPlayer = Database.playerLogin();
                // �����½ʧ����ô�᷵��һ��null�û�
                if (loggedPlayer != null) {
                    new PlayerMenu(loggedPlayer);
                }
            } else if ("3".equals(choose)) {
                Database.playerRegister();
            } else if ("4".equals(choose)) {
                break;
            } else {
                System.out.println("���������������������룡");
            }
            Database.save();
        }
        System.out.println("��ӭ���´�ʹ�ã�");
    }
}
