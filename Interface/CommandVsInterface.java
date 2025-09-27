import java.util.*;
interface Command {
    void execute();
}
class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }
    void turnOff() {
        System.out.println("Light is OFF");
    }
}
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}
class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}
class RemoteControl {
    private Queue<Command> commandQueue = new LinkedList<>();
    public void addCommand(Command command) {
        commandQueue.add(command);
    }
    public void runCommands() {
        while (!commandQueue.isEmpty()) {
            commandQueue.poll().execute();
        }
    }
}
public class CommandVsInterface {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();
        remote.addCommand(lightOn);
        remote.addCommand(lightOff);
        remote.addCommand(lightOn);
        System.out.println("Executing queued commands:");
        remote.runCommands();
    }
}
