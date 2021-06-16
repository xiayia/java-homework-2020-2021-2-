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
            System.out.println("======��ӭ�� ����Ա ��======");
            System.out.println("      [1] �����û�          ");
            System.out.println("      [2] ��ѯ�û�          ");
            System.out.println("      [3] �����û�          ");
            System.out.println("      [4] �����û�����       ");
            System.out.println("      [5] ��������          ");
            System.out.println("      [6] ֹͣ����          ");
            System.out.println("      [7] ������������       ");
            System.out.println("      [8] �鿴�������       ");
            System.out.println("      [9] ¼������ɼ�       ");
            System.out.println("      [10] ��ѯ�˶�Ա�ɼ�     ");
            System.out.println("      [11] �鿴���а�        ");
            System.out.println("      [12] ����֪ͨ          ");
            System.out.println("      [13] �˳�             ");
            System.out.println("===========================");
            System.out.print("��������Ҫ���еĲ�����");
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
                System.out.println("���������������������룡");
            }
            Database.save();
        }
        System.out.println("��ӭ���ٴ�ʹ�ã�");
    }

    private void releaseNotice() {
        // û�й�����ֱ�ӷ���
        if (Database.notice.isEmpty()) {
            System.out.println("��ǰ����Ϊ��");
            System.out.println(Database.notice);
        }
        System.out.println("�������¹��棺");
        Scanner scanner = new Scanner(System.in);
        Database.notice = scanner.next();
        System.out.println("�����ɹ���");
    }

    private void watchRank() {
        // ���˲�����
        List<Player> sortedPlayers = Database.players.stream()
                .filter(Player::isSettled)
                .sorted(Comparator.comparing(Player::getScore).reversed())
                .collect(Collectors.toList());

        if (sortedPlayers.isEmpty()) {
            System.out.println("��ǰû�������κγɼ�����֪ͨ����Ա��");
            return;
        }

        // ����Ա������Բ鿴������,���Բ������˶�Ա����һ����;�˳�
        int rank = 1;
        for (Player p : sortedPlayers) {
            System.out.printf("�� %d ���� %s\t�ɼ���%d \n", rank, p.getName(), p.getScore());
            rank++;
        }
    }

    private void watchPlayerScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("��������Ҫ�鿴�ɼ����û�����");
        String username = scanner.next();

        // ����û����Ƿ����
        if (!Database.existsPlayer(username)) {
            System.out.println("��������û�������");
            return;
        }

        Player player = Database.findPlayer(username);
        System.out.printf("\t�û�����%s\t������%s\t�ɼ���%s\n", player.getUsername(), player.getName(), player.isSettled() ? String.valueOf(player.getScore()) : "δ����");
    }

    private void importScore() {
        System.out.println("��ǰ�˶�Ա�����");
        for (Player player : Database.players) {
            System.out.printf("\t�û�����%s\t������%s\t�ɼ���%s\n", player.getUsername(), player.getName(), player.isSettled() ? String.valueOf(player.getScore()) : "δ����");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("��������Ҫ���óɼ����û�����");
        String username = scanner.next();

        if (!Database.existsPlayer(username)) {
            System.out.println("��������û�������");
            return;
        }
        Player player = Database.findPlayer(username);
        System.out.printf("��������û��ɼ���");
        int score = scanner.nextInt();

        // ���˶�Ա״̬����Ϊ�Ѿ������˳ɼ�
        player.setSettled(true);
        player.setScore(score);
        System.out.println("���óɹ�!");

    }

    private void watchSignup() {
        // ���˵õ������Ѿ��������û�
        List<Player> signedPlayers = Database.players.stream()
                .filter(Player::isSignup)
                .collect(Collectors.toList());
        if (signedPlayers.isEmpty()) {
            System.out.println("��ǰû�б����û���");
            return;
        }

        System.out.println("����Ϊ�ѱ������û���");
        for (Player player : signedPlayers) {
            System.out.printf("\t�û�����%s\t������%s\n", player.getUsername(), player.getName());
        }
    }

    private void permitPlayer() {
        // ���������Ѿ���������û�����������û�
        List<Player> notPermittedPlayers = Database.players.stream()
                .filter(Player::isSignup)
                .filter(p -> !p.isPermitted())
                .collect(Collectors.toList());

        if (notPermittedPlayers.isEmpty()) {
            System.out.println("��ǰû�д��������û���");
            return;
        }

        System.out.println("����Ϊ���������û���");
        for (Player player : notPermittedPlayers) {
            System.out.printf("\t�û�����%s\t������%s\n", player.getUsername(), player.getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("��������Ҫͨ���������û�����");
        String username = scanner.next();

        for (Player player : notPermittedPlayers) {
            if (username.equals(player.getUsername())) {
                player.setPermitted(true);
                System.out.println("��ͨ��������");
                return;
            }
        }

        System.out.println("��������û����������ͨ�������������²�����");
    }

    private void closeRegister() {
        if (!Database.canRegister) {
            System.out.println("������Ѿ��رգ������ظ��رգ�");
            return;
        }
        Database.canRegister = false;
        System.out.println("�رճɹ���");
    }

    private void openRegister() {
        if (Database.canRegister) {
            System.out.println("������Ѿ������������ظ�������");
            return;
        }
        Database.canRegister = true;
        System.out.println("�����ɹ���");
    }

    private void resetPlayerPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("�������������õ��û�����");
        String username = scanner.next();

        // �Ҳ���ֱ�ӷ���
        if (!Database.existsPlayer(username)) {
            System.out.println("��������û�������");
            return;
        }

        Player player = Database.findPlayer(username);
        System.out.print("��������û������룺");
        String password = scanner.next();
        player.setPassword(password);
        System.out.println("���óɹ�!");
    }

    private void disablePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������������õ��û�����");
        String username = scanner.next();
        if (!Database.existsPlayer(username)) {
            System.out.println("��������û�������");
            return;
        }
        Player player = Database.findPlayer(username);
        if (player.isDisabled()) {
            System.out.println("���û��Ѿ����ã������ظ�������");
            return;
        }
        player.setDisabled(true);
        System.out.println("���óɹ���");
    }

    private void searchPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������������ҵ��û�����");
        String username = scanner.next();
        if (!Database.existsPlayer(username)) {
            System.out.println("��������û�������");
            return;
        }
        Player player = Database.findPlayer(username);
        System.out.printf("�û�����%s\n", player.getUsername());
        System.out.printf("������%s\n", player.getName());
        System.out.printf("�Ƿ�ͨ��������%s\n", player.isPending() ? "��" : "��");
        System.out.printf("�Ƿ���ã�%s\n", player.isDisabled() ? "��" : "��");
        System.out.printf("�Ƿ�����%s\n", player.isSignup() ? "��" : "��");
        if (player.isSignup()) {
            System.out.printf("�Ƿ����ɹ���%s\n", player.isPermitted() ? "��" : "��");
            // �����ɹ��ſ����гɼ�
            if (player.isPermitted()) {
                System.out.printf("�Ƿ����гɼ���%s\n", player.isSettled() ? "��" : "��");
            }
        }
    }

    private void pendPlayer() {
        // �������л�û���������û�
        List<Player> pendingPlayers = Database.players.stream()
                .filter(p -> !p.isPending())
                .collect(Collectors.toList());
        if (pendingPlayers.isEmpty()) {
            System.out.println("��ǰû�п��������û���");
            return;
        }

        System.out.println("����Ϊ���������û���");
        for (Player pendingPlayer : pendingPlayers) {
            System.out.printf("\t�û�����%s\t������%s\n", pendingPlayer.getUsername(), pendingPlayer.getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("��������Ҫͨ���������û�����");
        String username = scanner.next();

        for (Player pendingPlayer : pendingPlayers) {
            if (username.equals(pendingPlayer.getUsername())) {
                pendingPlayer.setPending(true);
                System.out.println("��ͨ��������");
                return;
            }
        }

        System.out.println("��������û����������ͨ�������������²�����");
    }
}
