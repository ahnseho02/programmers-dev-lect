public class VipMember extends Member {
    public VipMember(String name, String email, String phone) {
        super(name, email, phone);   // 부모 생성자에 공통 데이터 위임
    }

    @Override public String getGrade()   { return "VIP"; }
    @Override public String getBenefit() { return "10% 할인 + 무료배송"; }
}
