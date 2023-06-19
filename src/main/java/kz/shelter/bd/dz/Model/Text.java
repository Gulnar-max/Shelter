package kz.shelter.bd.dz.Model;

public class Text {
    public Text() {
    }

    public static void menu() {
        System.out.println("Меню:");
        System.out.println("1. Ввести данные собаки");
        System.out.println("2. Сделать выборку собак старше определенного возраста");
        System.out.println("3. Удалить собаку по кличке");
        System.out.println("4. Обновить возраст собаки по кличке");
        System.out.println("5. Выход");
        System.out.print("Выберите пункт меню: ");
    }

    public void print(){
        System.out.println("Таблица dogs:");
        System.out.println("ID\tNickname\tBreed\tAge\tOwner Name");
    }

    public void ifDeleted() {
        System.out.println("Собака успешно удалена.");
    }
    public void ifNotFound() {
        System.out.println("Собака с указанным именем не существует.");
    }
    public void ifAgeChanged() {
        System.out.println("Возраст собаки успешно обновлен.");
    }
    public void ifError() {
        System.err.println("Connection failed...");
    }
    public void ifConnectedSuccessfully() {
        System.out.println("Connection to Store DB successful!");
    }
}
