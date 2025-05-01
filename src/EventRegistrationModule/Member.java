package EventRegistrationModule;

import interfaces.Observer;

public class Member implements Observer {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" + name + "] Notification: " + message);
    }

    public String getName() {
        return name;
    }
}
