package allclasses.demidova;

public class Meow {
    private String felineType;
    private String name;

    public String getName() { return name; }
    public void setName(String _name) { name = _name; }

    public String getFelineType() { return felineType; }
    public void setFelineType(String _felineType) { felineType = _felineType; }

    public Meow()
    {
        felineType = "рысь";
        name = "Ирис";
    }

    public Meow(String felineType, String name)
    {
        this.name = name;
        this.felineType = felineType;
    }

    public void printInfo() {
        System.out.println("Вид кошачьего: " + felineType);
        System.out.println("Имя: " + name);
    }

    public String miaow() {
        return felineType + " " + name + " мяукает... Миу";
    }

    public String stepMeow(int countSteps) {
        return felineType + " " + name + " идёт...\n" + step(countSteps);
    }

    public String step(int countSteps){
        StringBuilder d= new StringBuilder();
        for(int i=0;i<countSteps;i++){
            d.append("Шаг ").append(i+1).append("\n");
        }
        return d.toString();
    }
}
