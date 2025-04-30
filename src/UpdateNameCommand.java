public class UpdateNameCommand implements Command {
    private Event event;
    private String oldName;
    private String newName;

    public UpdateNameCommand(Event event, String newName) {
        this.event = event;
        this.newName = newName;
        this.oldName = event.getName();
    }

    @Override
    public void execute() {
        event.setName(newName);
    }

    @Override
    public void undo() {
        event.setName(oldName);
    }
}
