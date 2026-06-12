public abstract class Member {
    protected String name, email, phone;

    public Member(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName()  { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public abstract String getGrade();    // 자식이 구현
    public abstract String getBenefit();  // 자식이 구현

    // 추상 메서드를 활용해 공통 출력 — 자식마다 다른 결과가 나옴 (다형성)
    public void printInfo() {
        System.out.println("[" + getGrade() + "] " + name + " / " + email
                           + " / " + phone + " (혜택: " + getBenefit() + ")");
    }

    // 이름·이메일·연락처 한 번에 교체
    public void update(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
