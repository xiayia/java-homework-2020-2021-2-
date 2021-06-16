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
            System.out.printf("======��ӭ�� %s =====\n", player.getName());
            System.out.println("   [1] ��������      ");
            System.out.println("   [2] ��ѯ�Լ��ɼ�   ");
            System.out.println("   [3] �鿴���а�     ");
            System.out.println("   [4] �鿴֪ͨ      ");
            System.out.println("   [5] �˳�         ");
            System.out.println("====================");
            System.out.print("��������Ҫ���еĲ�����");
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
                System.out.println("��ӭ���´�ʹ�ã�");
                break;
            } else {
                System.out.println("���������������������룡");
            }
            Database.save();
        }
    }

    private void watchNotice() {
        // �������֪ͨ,û��֪ͨ����֪ͨ�ķ��ؽ���ǲ�һ����
        if (Database.notice.isEmpty()) {
            System.out.println("��ǰû�������κ�֪ͨ��");
            return;
        }
        System.out.println("��ǰ֪ͨΪ��");
        System.out.println(Database.notice);
    }

    private void watchRank() {
        // �����гɼ����˶�Ա�������ճɼ���������
        List<Player> sortedPlayers = Database.players.stream()
                .filter(Player::isSettled)
                .sorted(Comparator.comparing(Player::getScore).reversed())
                .collect(Collectors.toList());

        // ����Ƿ��н��
        if (sortedPlayers.isEmpty()) {
            System.out.println("��ǰû�������κγɼ�����֪ͨ����Ա��");
            return;
        }

        // ���δ�ӡ
        int rank = 1;
        for (Player p : sortedPlayers) {
            System.out.printf("�� %d ���� %s\t�ɼ���%d \n", rank, p.getName(), p.getScore());
            rank++;

            // �˶�Ա����ֻ�ܲ鿴10��,���Դ�ӡ10���˾��˳�
            if (rank > 10) {
                break;
            }
        }
    }

    private void watchSelf() {
        // ǰ����һϵ��״̬���
        if (!player.isSignup()) {
            System.out.println("����δ����������");
            return;
        }
        if (!player.isPermitted()) {
            System.out.println("��δͨ������������");
            return;
        }
        if (!player.isSettled()) {
            System.out.println("���ĳɼ���δ���ã���֪ͨ����Ա���ã�");
            return;
        }

        // ���������˶�Ա���м����˱ȵ�ǰ�˶�Ա�����ߣ�Ĭ���ǵ�һ������һ����+1
        int rank = 1;
        for (Player other : Database.players) {
            if (other.isSettled()) {
                if (other.getScore() > player.getScore()) {
                    rank++;
                }
            }
        }
        System.out.printf("���ĳɼ���%d  ��������Ϊ���� %d ��\n", player.getScore(), rank);
    }

    private void signup() {
        if (player.isSignup()) {
            System.out.println("���Ѿ����������������ظ�������");
        } else {
            player.setSignup(true);
            System.out.println("�����ɹ���");
        }
    }


}
