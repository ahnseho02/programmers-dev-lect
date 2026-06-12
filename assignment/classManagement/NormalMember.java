public class NormalMember extends Member {
    public NormalMember(String name, String email, String phone) {
        super(name, email, phone);   // 부모 생성자에 공통 데이터 위임
    }

    @Override public String getGrade()   { return "일반"; }
    @Override public String getBenefit() { return "기본 서비스"; }
}
