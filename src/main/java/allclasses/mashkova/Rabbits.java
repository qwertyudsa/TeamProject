package allclasses.mashkova;

import java.util.List;

public class Rabbits {
    String _rabbitName;
    List<String> _rabbitList = List.of("Зайчонок", "Пухляш", "Шерстяной", "Львенок", "Золотой");

    public Rabbits(String rabbitName) {
        _rabbitName = rabbitName;
    }

    public String CheckRabbit() {
        for (String rabbit : _rabbitList) {
            if (_rabbitName.equals(rabbit)) {
                return "Ваш кролик есть в базе данных";
            }
        }
        return "Вашего кролика нет в базе данных";
    }
}
