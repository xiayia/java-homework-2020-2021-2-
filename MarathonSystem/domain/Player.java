package domain;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String username;
    private String password;

    // ע������״̬
    private boolean pending;

    // �Ƿ��Ѿ�����ֹ��½
    private boolean disabled;

    // �Ƿ��Ѿ�����
    private boolean signup;

    // �Ƿ��������
    private boolean permitted;

    // �Ƿ��Ѿ����óɼ�
    private boolean settled;

    // �ɼ�
    private int score;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isSignup() {
        return signup;
    }

    public void setSignup(boolean signup) {
        this.signup = signup;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isSettled() {
        return settled;
    }

    public void setSettled(boolean settled) {
        this.settled = settled;
    }

    public boolean isPermitted() {
        return permitted;
    }

    public void setPermitted(boolean permitted) {
        this.permitted = permitted;
    }
}
