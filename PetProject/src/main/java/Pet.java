public class Pet {
    private String name;
    private int happy;
    private int fullness;

    public  Pet(String name){
        this.name =name;
        this.fullness=50;
        this.happy=50;
    }

    /*public void showStatus(){
        System.out.println(name+"의 포만감: "+fullness+" 행복도: "+happy);
    }*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }
}
