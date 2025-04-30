public class UpdateLocationCommand implements Command {
    private Event event;
    private String oldLocation;
    private String newLocation;

    public UpdateLocationCommand(Event event, String newLocation) {
        this.event = event;
        this.newLocation = newLocation;
        this.oldLocation = event.getLocation();
    }

    @Override
    public void execute() {
        event.setLocation(newLocation);
    }

    @Override
    public void undo() {
        event.setLocation(oldLocation);
    }
}
